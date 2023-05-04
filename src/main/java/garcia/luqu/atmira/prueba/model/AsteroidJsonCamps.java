package garcia.luqu.atmira.prueba.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


/*
    Clase que nos va a permitir recorrer los campos principales dentro de cada objeto almacenado en cada fecha
    Esta clase se va a devolver las propiedades del objeto que establezcamos.
    En este caso vamos a referenciar las propiedades de "name", "estimated_diameter", "close_approach_data" y "is_potentially_hazardous_asteroid"
    Algunas de la cuales vamos a mapear internamente en otras clases
 */
public class AsteroidJsonCamps {

    //Variable para recoger el nombre del asteroide
    private String Asteroid_Name;

    //Variable para recoger el diametro del asteroide
    private AsteroidDiameter asteroidDiameter;

    //Variable para recoger si es peligroso el asteroide
    private boolean is_potentially_hazardous_asteroid;

    //Variable para recoger la lista de valores del close_approach_data del asteroide
    private List<Asteroid_Close_Approach_Data> close_approach_data;




    /*
     * Getter y Setter de cada una de las variables
     * @JsonProperty es utilizado para leer la propiedad específica dentro del JSON
     */

    public String getAsteroid_Name() {
        return Asteroid_Name;
    }
    @JsonProperty("name")
    public void setAsteroid_Name(String asteroid_Name) {
        Asteroid_Name = asteroid_Name;
    }
    public List<Asteroid_Close_Approach_Data> getClose_approach_data() {
        return close_approach_data;
    }
    @JsonProperty("close_approach_data")
    public void setCloseApproachData(List<Asteroid_Close_Approach_Data> close_approach_data) {
        this.close_approach_data = close_approach_data;
    }
    public AsteroidDiameter getEstimated_diameter() {
        return asteroidDiameter;
    }
    @JsonProperty("estimated_diameter")
    public void setestimated_diameter(AsteroidDiameter estimated_diameter) {
        this.asteroidDiameter = estimated_diameter;
    }
    public boolean isIs_potentially_hazardous_asteroid() {
        return is_potentially_hazardous_asteroid;
    }
    @JsonProperty("is_potentially_hazardous_asteroid")
    public void is_potentially_hazardous_asteroid(boolean is_potentially_hazardous_asteroid) {
        this.is_potentially_hazardous_asteroid = is_potentially_hazardous_asteroid;
    }
}
