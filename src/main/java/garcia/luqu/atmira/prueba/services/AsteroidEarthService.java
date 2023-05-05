package garcia.luqu.atmira.prueba.services;

import garcia.luqu.atmira.prueba.Exceptions.ResourceBadRequestException;
import garcia.luqu.atmira.prueba.Exceptions.ResourceInternalServerErrorException;
import garcia.luqu.atmira.prueba.Exceptions.ResourceNotFoundException;
import garcia.luqu.atmira.prueba.Exceptions.ResourceNullPointException;
import garcia.luqu.atmira.prueba.interfaces.AsteroidEarthServiceInf;
import garcia.luqu.atmira.prueba.model.DTO.AsteroidDTO;
import garcia.luqu.atmira.prueba.model.AsteroidJsonCamps;
import garcia.luqu.atmira.prueba.model.Asteroid_Close_Approach_Data;
import garcia.luqu.atmira.prueba.model.Asteroid_Near_Earth_Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/*
 * Servicio para esteblecer el metodo con el que vamos a recorrer el JSON y crear el modelo que previamente hemos creado
 * Cuenta con el metodo de mapeo, las variables de conexion y los metodos de formateo de la fecha para pasarlas como parametro
 */


@Service
@Component
public class AsteroidEarthService implements AsteroidEarthServiceInf {

    /**
        Instanciamos el RestTemplate con el cual vamos a crear la conexion con la API externa y la conexion HTTP
     */
    @Autowired
    private RestTemplate restTemplate;


    /**
    Instanciamos las variables con las que vamos a concatenar el path que va a realizar la peticion
    */

    private final String url1="https://api.nasa.gov/neo/rest/v1/feed?start_date=";

    private final String url2="&end_date=";

    private final String url3="&api_key=zdUP8ElJv1cehFM0rsZVSQN7uBVxlDnu4diHlLSb";



    /**
     *
     * @param dateOne
     * @param ndays
     * @return una List<AsteroidDTO> en un período de tiempo concreto (max 7 días) ordenado de mayor a menor en diametro
     */
    public List<AsteroidDTO> getAsteroidesPotentiallyToEarth(Date dateOne, int ndays) throws MissingServletRequestParameterException {

        //Creamos un StringBuilder para concatenar el path necesario con las fechas para realizar la petición
        StringBuilder concatPath = new StringBuilder();
        //Instanciamos la lista que vamos a generar con los objetos procedentes del JSON de la petición
        List<AsteroidDTO> list= new ArrayList<>();
        //Concatenamos el path con los datos pasados por parámetro, en este caso la fecha actual y la fecha sumanda en base al numero de días

        if (ndays>0){
            concatPath.append(url1)
                    .append(formatDate(dateOne))
                    .append(url2)
                    .append(formatFinalDate(LocalDate.now(),ndays))
                    .append(url3);
            System.out.println(concatPath);
        }else{
            throw new ResourceInternalServerErrorException("Error de servidor");
        }

        try
        {
            /*
              Instanciamos el objeto padre del JSON que va a ser la conexión con restTemplate para obtener el JSON procedente de la API
             */
            Asteroid_Near_Earth_Objects asteroidNearEarthObjects = restTemplate.getForObject(concatPath.toString(), Asteroid_Near_Earth_Objects.class);

            /*
                Comprobamos que realmente esa peticion para traer el objeto contiene informacion y no son valores nulos
             */
            if(asteroidNearEarthObjects != null)
            {
                /*
                    Una vez traida la información de este objeto padre se mapea con un for
                 */

                for(List<AsteroidJsonCamps> Listasteroides : asteroidNearEarthObjects.getAsteroid_earth_objects().values())
                {

                    for(AsteroidJsonCamps asteroid : Listasteroides)
                    {
                        /*
                            Cuando estemos recorriendo los objetos uno a uno comprobamos que sea potencial para la tierra
                            De esta forma descartamos todos aquellos objetos que no sean peligrosos para la tierra
                         */
                        if(asteroid.isIs_potentially_hazardous_asteroid()==true){

                            /*
                                Una vez tenemos los objetos que si son potenciales para la tierra
                             */
                            for(Asteroid_Close_Approach_Data approach : asteroid.getClose_approach_data())
                            {
                                /*
                                    Cuando se tenga dicha información obtenido de cada objeto se genera un DTO
                                 */
                                AsteroidDTO asteroidDTO = new AsteroidDTO();

                                asteroidDTO.setAsteroid_Name(asteroid.getAsteroid_Name());
                                asteroidDTO.setAsteroid_orbiting(approach.getOrbiting_body());
                                asteroidDTO.setAsteroid_Average_Diameter(asteroid.getEstimated_diameter().getKilometers().getAverage());
                                asteroidDTO.setAsteroid_Velocity(approach.getRelative_velocity().getKilometers_per_hour());
                                asteroidDTO.setAsteroid_Approach_Date(approach.getClose_approach_date());

                                //añadimos dicho objeto a la lista
                                list.add(asteroidDTO);
                            }
                        }
                    }
                }
            }
        }catch (final HttpClientErrorException e)
        {
            System.out.print("Error en la conexion con el cliente (API) " + e);
        }catch (final NullPointerException nullPointerException)
        {
            throw new ResourceNullPointException("No hay resultados para los parámetros establecidos "+nullPointerException);
        }catch(final ResourceNotFoundException NotFound) {

            throw new ResourceNotFoundException("No hay resultados para los parámetros establecidos "+NotFound);

        } catch (final ResourceBadRequestException BadRequest) {

            throw new MissingServletRequestParameterException("error",BadRequest.getMessage());

        } catch (final ResourceInternalServerErrorException resourceInternalServerErrorException){

            throw new ResourceInternalServerErrorException("No se ha podido ejecutar la peticion, error en el servidor" + resourceInternalServerErrorException);
        }

        /**
         * Se crea un sort que recibe como parametro la lista y un comparador
         */
        Collections.sort(list,new Comparator<AsteroidDTO>() {
            public int compare(AsteroidDTO asteroidDTO1, AsteroidDTO asteroidDTO2) {
                return new Double(asteroidDTO2.getAsteroid_Average_Diameter()).compareTo(new Double(asteroidDTO1.getAsteroid_Average_Diameter()));
            }
        });

        /*
         * Una vez tengamos la lista ordenada de mayor a menor se crea una lista nueva de AsteroidDTO
         */

        List<AsteroidDTO> finalListAsteroidbySizeandPaginate;
        if(list.size()<3){
            finalListAsteroidbySizeandPaginate = list.stream().limit(list.size()).collect(Collectors.toList());
        }else{
            finalListAsteroidbySizeandPaginate = list.stream().limit(3).collect(Collectors.toList());
        }
        return finalListAsteroidbySizeandPaginate;
    }

    /**
     * @param dateInitial
     * @param ndias
     * @return devolvemos una fecha formateada sumada en base al numero de dias que se ha introducido por parametro
     */
    public static final String formatFinalDate (LocalDate dateInitial, int ndias) {
        LocalDate fecha = LocalDate.parse(formatDate(new Date()), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        ndias = Math.min(ndias, 7);
        LocalDate fechaSumada = fecha.plusDays(ndias);
        if (fechaSumada.isAfter(fecha.plusDays(7))) {
            fechaSumada = fecha.plusDays(7);
        }
        return fechaSumada.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }


    protected static final String formatDate (Date dateOne)
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(dateOne);
    }
}
