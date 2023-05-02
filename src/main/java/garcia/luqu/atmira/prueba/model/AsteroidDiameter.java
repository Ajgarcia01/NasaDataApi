package garcia.luqu.atmira.prueba.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AsteroidDiameter {

    private AsteroidDiameterCalculate kilometers;

    public AsteroidDiameterCalculate getKilometers() {
        return kilometers;
    }
    @JsonProperty("kilometers")
    public void setKilometers(AsteroidDiameterCalculate kilometers) {
        this.kilometers = kilometers;
    }



}
