package garcia.luqu.atmira.prueba.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

/*
    Clase que nos va a permitir recorrer los elementos que se encuentran dentro de la propiedad "near_earth_objects"
    Esta clase se podría considerar como el padre del json, desde la cual vamos ir mapeando de forma "heredada"
    Vamos a recorrer en este caso todas las fechas que el usuario haya introducido por parametro
 */
public class Asteroid_Near_Earth_Objects {
    private Map<String, List<AsteroidJsonCamps>> asteroid_earth_objects;

    /*
     * Getter y Setter de cada una de las variables
     * @JsonProperty es utilizado para leer la propiedad específica dentro del JSON
     */


    public Map<String, List<AsteroidJsonCamps>> getAsteroid_earth_objects() {
        return asteroid_earth_objects;
    }

    @JsonProperty("near_earth_objects")
    public void setAsteroid_earth_objects(Map<String, List<AsteroidJsonCamps>> asteroid_earth_objects) {
        this.asteroid_earth_objects = asteroid_earth_objects;
    }

}
