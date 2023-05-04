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
public class AsteroidEarthService implements AsteroidEarthServiceInf {

    /*
        Instanciamos el RestTemplate con el cual vamos a crear la conexion con la API externa y la conexion HTTP
        Para posteriormente recibir la respuesta de la peticion en forma de JSON
        JSON el cual vamos a mapear y modelar en base al modelo que hemos creado
        RestTemplate el cual hemos declarado en MyConfig con las propiedades pertinentes
     */
    @Autowired
    private RestTemplate restTemplate;


    /*
    Instanciamos las variables con las que vamos a concatenar el path que va a realizar la peticion
    Este path cuenta con 3 variables
    El url1 para concatenar la primera parte de path al que le vamos a añadir la fecha de inicio
    El url2 para concatenar la segunda parte de path al que le vamos a añadir la fecha de final
    El url3 para concatenar la ultima parte de path al que le vamos a añadir la apikey de la API
 */

    private final String url1="https://api.nasa.gov/neo/rest/v1/feed?start_date=";

    private final String url2="&end_date=";

    private final String url3="&api_key=zdUP8ElJv1cehFM0rsZVSQN7uBVxlDnu4diHlLSb";



    /*
        Método principal del servicio para realizar la petición a la API
        En el que vamos a mapear el JSON que nos devuelve la petición
     */
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
              Este template se le pasa como parametro el path que hemos concatenado y del tipo de clase que va a ser
             */
            Asteroid_Near_Earth_Objects asteroidNearEarthObjects = restTemplate.getForObject(concatPath.toString(), Asteroid_Near_Earth_Objects.class);

            /*
                Comprobamos que realmente esa peticion para traer el objeto contiene informacion y no son valores nulos
             */
            if(asteroidNearEarthObjects != null)
            {
                /*
                    Una vez traida la información de este objeto padre se mapea con un for
                    Este for va a recorrer todos estos objetos
                    Objetos compuestos de un string con la fecha de ese día y de una lista de campos con los que cuenta cada asteroide de ese día
                    Devolvera una lista de dichos objetos que se encuentren dentro del periodo de fechas establecido
                 */

                for(List<AsteroidJsonCamps> Listasteroides : asteroidNearEarthObjects.getAsteroid_earth_objects().values())
                {
                    /*
                        Una vez obtenida dicha lista se recorre cada objeto por separado para extraer la informacion de los campos que vamos a necesitar
                        Campos previamente definidos en cada entidad del modelo
                     */
                    for(AsteroidJsonCamps asteroid : Listasteroides)
                    {
                        /*
                            Cuando estemos recorriendo los objetos uno a uno comprobamos que sea potencial para la tierra
                            De esta forma descartamos todos aquellos objetos que no sean peligrosos para la tierra
                         */
                        if(asteroid.isIs_potentially_hazardous_asteroid()==true){

                            /*
                                Una vez tenemos los objetos que si son potenciales para la tierra
                                Recorremos dentro de ese objeto la lista de Asteroid_Close_Approach_Data
                                De esta forma accederemos y extraemos la informacion necesaria de esas propiedades del JSON
                             */
                            for(Asteroid_Close_Approach_Data approach : asteroid.getClose_approach_data())
                            {
                                /*
                                    Cuando se tenga dicha información obtenido de cada objeto se genera un DTO
                                    DTO previamente definido en el modelo, objeto el cual vamos a devolver en el JSON
                                    Se podria definir como el objeto resultante que vamos a querer devolver nosotros
                                    Se genera un dto en cada for para generar una lista de AsteroidDTO
                                    En cada DTO seteamos los valores que queramos mostrar, valores los cuales se obtienen del objeto del JSON que estamos recorriendo *asteroid*
                                    Se setan y/o crean todos los campos sean necesarios en el DTO para devolver un objeto u otro segun las necesidades
                                    Una vez modelado el objeto y seteados todos los valores se añaden a una lista que es la que se va a devolver en la peticion
                                    Asi por cada objeto que se encuentre en el mapeo.
                                 */
                                AsteroidDTO asteroidDTO = new AsteroidDTO();

                                //Seteamos el nombre del asteroide
                                asteroidDTO.setAsteroid_Name(asteroid.getAsteroid_Name());
                                //Seteamos el planeta donde orbita dicho planeta (En este caso siempre va a ser la tierra)
                                asteroidDTO.setAsteroid_orbiting(approach.getOrbiting_body());
                                //Seteamos el diametro medio del asteroide
                                asteroidDTO.setAsteroid_Average_Diameter(asteroid.getEstimated_diameter().getKilometers().getAverage());
                                //Seteamos la velocidad del asteroide
                                asteroidDTO.setAsteroid_Velocity(approach.getRelative_velocity().getKilometers_per_hour());
                                //Seteamos la fecha de acercamiento del asteroide
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

        /*
         * Se crea un sort que recibe como parametro la lista y un comparador
         * Este sort nos va a permitir comparar cada objeto de la lista que hemos generado
         * Vamos a comparar el diametro medio de cada asteroide para ordenador de mayor a menor
         */
        Collections.sort(list,new Comparator<AsteroidDTO>() {
            public int compare(AsteroidDTO asteroidDTO1, AsteroidDTO asteroidDTO2) {
                return new Double(asteroidDTO2.getAsteroid_Average_Diameter()).compareTo(new Double(asteroidDTO1.getAsteroid_Average_Diameter()));
            }
        });

        /*
         * Una vez tengamos la lista ordenada de mayor a menor se crea una lista nueva de AsteroidDTO
         * Esta lista va a limitar el numero de elementos a 3 o los objetos que tenga la lista en caso de que sean menor de 3
         * Por lo que se devuelve una lista con x objetos
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

        // Parseamos la fecha del dia actual a LocalDate
        LocalDate fecha = LocalDate.parse(formatDate(new Date()), DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        // Limitamos el número de días a 7
        ndias = Math.min(ndias, 7);

        // Sumamos los días a la fecha actual
        LocalDate fechaSumada = fecha.plusDays(ndias);

        // Si la fecha sumada supera el límite de 7 días, se ajusta a ese límite
        if (fechaSumada.isAfter(fecha.plusDays(7))) {
            fechaSumada = fecha.plusDays(7);
        }

        // Devolvemos la fecha resultante en formato yyyy-MM-dd
        return fechaSumada.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }


    protected static final String formatDate (Date dateOne)
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(dateOne);
    }
}
