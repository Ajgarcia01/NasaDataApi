package garcia.luqu.atmira.prueba.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Asteroid_Close_Approach_Data {

    private String close_approach_date;
    private AsteroidVelocity relative_velocity;
    private String orbiting_body;


    public AsteroidVelocity getRelative_velocity() {
        return relative_velocity;
    }
    @JsonProperty("relative_velocity")
    public void setrelative_velocity(AsteroidVelocity relative_velocity) {
        this.relative_velocity = relative_velocity;
    }
    public String getOrbiting_body() {
        return orbiting_body;
    }
    @JsonProperty("orbiting_body")
    public void setorbiting_body(String orbiting_body) {
        this.orbiting_body = orbiting_body;
    }
    public String getClose_approach_date() {
        return close_approach_date;
    }
    @JsonProperty("close_approach_date")
    public void setclose_approach_date(String close_approach_date) {
        this.close_approach_date = close_approach_date;
    }






}
