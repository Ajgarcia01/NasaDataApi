package garcia.luqu.atmira.prueba.services;

import garcia.luqu.atmira.prueba.model.AsteroidDTO;
import garcia.luqu.atmira.prueba.model.AsteroidJsonCamps;
import garcia.luqu.atmira.prueba.model.Asteroid_Close_Approach_Data;
import garcia.luqu.atmira.prueba.model.Asteroid_Near_Earth_Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AsteroidEarthService {

    @Autowired
    private RestTemplate restTemplate;

    private String url="https://api.nasa.gov/neo/rest/v1/feed?start_date=2021-12-09&end_date=2021-12-12&api_key=zdUP8ElJv1cehFM0rsZVSQN7uBVxlDnu4diHlLSb";

    private  String url1="https://api.nasa.gov/neo/rest/v1/feed?start_date=";

    private String url2="&end_date=";

    private String url3="&api_key=zdUP8ElJv1cehFM0rsZVSQN7uBVxlDnu4diHlLSb";

    public List<AsteroidDTO> getAsteroidesPotentiallyToEarth(Date dateOne, int ndias) {

        StringBuilder stringBuilder = new StringBuilder();
        List<AsteroidDTO> list= new ArrayList<>();
        stringBuilder.append(url1).append(convertDate(dateOne)).append(url2).append(convertFinalDate(LocalDate.now(),ndias)).append(url3);

        try
        {
            System.out.print(stringBuilder.toString());

            Asteroid_Near_Earth_Objects nasaEarthObjects = restTemplate.getForObject(stringBuilder.toString(), Asteroid_Near_Earth_Objects.class);

            if(nasaEarthObjects != null)
            {
                for(List<AsteroidJsonCamps> nasaFields : nasaEarthObjects.getNear_earth_objects().values())
                {
                    for(AsteroidJsonCamps fields : nasaFields)
                    {
                        if(fields.isIs_potentially_hazardous_asteroid()==true){

                            for(Asteroid_Close_Approach_Data approach : fields.getClose_approach_data())
                            {
                                AsteroidDTO nasaDTO = new AsteroidDTO();

                                nasaDTO.setAsteroid_Name(fields.getAsteroid_Name());
                                nasaDTO.setAsteroid_Velocity(approach.getRelative_velocity().getKilometers_per_hour());
                                nasaDTO.setAsteroid_orbiting(approach.getOrbiting_body());
                                nasaDTO.setAsteroid_Average_Diameter(fields.getEstimated_diameter().getKilometers().getAverage());
                                nasaDTO.setAsteroid_Approach_Date(approach.getClose_approach_date());

                                list.add(nasaDTO);
                            }
                        }
                    }
                }
            }


        }catch (final HttpClientErrorException e)
        {
            System.out.print("Failed to connect in nasa API " + e);

        }
        return list;
    }


    public static final String convertFinalDate (LocalDate dateInitial, int ndias) {

        // Parseamos la fecha actual a LocalDate
        LocalDate fecha = LocalDate.parse(convertDate(new Date()), DateTimeFormatter.ofPattern("yyyy-MM-dd"));

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



    protected static final String convertDate (Date date)
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }
}
