package garcia.luqu.atmira.prueba.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/*
    Clase que nos va a permitir recorrer los elementos que se encuentran dentro de la propiedad "kilometers"
    Esta clase se va a utilizar para calcular el diametro medio del asteroide
    Vamos a recorrer en este caso las propiedades  del valor minimo y maximo y calculando la media dentro de "kilometers"
 */
public class AsteroidDiameterCalculate {

    //variable que indica el diametro minimo del asteroide en kilometros
    private Double estimated_diameter_min;

    //variable que indica el diametro maximo del asteroide en kilometros
    private Double estimated_diameter_max;

    //variable que indica la media del asteroide (recogida entre el valor minimo y maximo)
    private Double average;


    /*
     * Getter y Setter de cada una de las variables
     * @JsonProperty es utilizado para leer la propiedad específica dentro del JSON
     */


    @JsonProperty("estimated_diameter_min")
    public void setestimated_diameter_min(Double estimated_diameter_min) {
        this.estimated_diameter_min = estimated_diameter_min;
    }


    @JsonProperty("estimated_diameter_max")
    public void setestimated_diameter_max(Double estimated_diameter_max) {
        this.estimated_diameter_max = estimated_diameter_max;
    }

    /*
        Esta funcion nos va a permitir coger los dos valores, el minimo y el maximo
        Con esos dos valores vamos a calcular la media del diametro
        Se castea ya que los valores del JSON se recogen en String y para realizar la media
        es necesario que sea un numero, en este caso un Double.
     */
    public Double getAverage() {
        double media = ((estimated_diameter_min + estimated_diameter_max) / 2);
        return average=media;
    }


}
