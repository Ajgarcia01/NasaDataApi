package garcia.luqu.atmira.prueba.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AsteroidDiameterCalculate {

    private String estimated_diameter_min;
    private String estimated_diameter_max;

    private String average;


    @JsonProperty("estimated_diameter_min")
    public void setestimated_diameter_min(String estimated_diameter_min) {
        this.estimated_diameter_min = estimated_diameter_min;
    }


    @JsonProperty("estimated_diameter_max")
    public void setestimated_diameter_max(String estimated_diameter_max) {
        this.estimated_diameter_max = estimated_diameter_max;
    }

    public String getAverage() {
        double num1 = Double.parseDouble(estimated_diameter_min);
        double num2 = Double.parseDouble(estimated_diameter_max);
        double media = (num1 + num2) / 2;
        String resultado = String.valueOf(media);
        return average=resultado;
    }


}
