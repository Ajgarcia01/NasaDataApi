package garcia.luqu.atmira.prueba.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AsteroidVelocity {

    private String kilometers_per_hour;

    public String getKilometers_per_hour() {
        return kilometers_per_hour;
    }
    @JsonProperty("kilometers_per_hour")
    public void setkilometers_per_hour(String kilometers_per_hour) {
        this.kilometers_per_hour = kilometers_per_hour;
    }

}
