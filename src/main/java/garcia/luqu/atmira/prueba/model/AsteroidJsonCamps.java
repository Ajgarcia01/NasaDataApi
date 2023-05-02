package garcia.luqu.atmira.prueba.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AsteroidJsonCamps {

    private String Asteroid_Name;

    private AsteroidDiameter asteroidDiameter;
    private boolean is_potentially_hazardous_asteroid;
    private List<Asteroid_Close_Approach_Data> close_approach_data;


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
