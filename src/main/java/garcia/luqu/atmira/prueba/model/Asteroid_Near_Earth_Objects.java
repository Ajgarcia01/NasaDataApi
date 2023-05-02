package garcia.luqu.atmira.prueba.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class Asteroid_Near_Earth_Objects {
    private Map<String, List<AsteroidJsonCamps>> near_earth_objects;

    public Map<String, List<AsteroidJsonCamps>> getNear_earth_objects() {
        return near_earth_objects;
    }
    @JsonProperty("near_earth_objects")
    public void setNear_earth_objects(Map<String, List<AsteroidJsonCamps>> near_earth_objects) {
        this.near_earth_objects = near_earth_objects;
    }
}
