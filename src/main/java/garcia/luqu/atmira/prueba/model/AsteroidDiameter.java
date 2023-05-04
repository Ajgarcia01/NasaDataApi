package garcia.luqu.atmira.prueba.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/*
    Clase que nos va a permitir recorrer los elementos que se encuentran dentro de la propiedad "estimated_diameter"
    Esta clase se va a utilizar para calcular el diametro medio del asteroide
    Nos va a permitir poder filtar asteroides por su tamañano, en funcion de si los queremos mas o menos grandes.
    Vamos a recorrer en este caso la propiedad kilometers, ya que queremos solo la estimación en kilometros
 */
public class AsteroidDiameter {

    private AsteroidDiameterCalculate kilometers;

    /*
     * Getter y Setter de cada una de las variables
     * @JsonProperty es utilizado para leer la propiedad específica dentro del JSON
     */

    public AsteroidDiameterCalculate getKilometers() {
        return kilometers;
    }
    @JsonProperty("kilometers")
    public void setKilometers(AsteroidDiameterCalculate kilometers) {
        this.kilometers = kilometers;
    }



}
