package garcia.luqu.atmira.prueba.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/*
    Clase que nos va a permitir recorrer los campos principales dentro de la propiedad "relative_velocity"
    Esta clase se va a devolver las propiedades con las que cuenta "relative_velocity".
    En este caso vamos a referenciar la propiedade de "kilometers_per_hour", que es la unica que vamos a utilizar
 */
public class GetAsteroidVelocity {

    private Double kilometers_per_hour;


    /*
     * Getter y Setter de cada una de las variables
     * @JsonProperty es utilizado para leer la propiedad específica dentro del JSON
     */


    public Double getKilometers_per_hour() {
        return kilometers_per_hour;
    }
    @JsonProperty("kilometers_per_hour")
    public void setkilometers_per_hour(Double kilometers_per_hour) {
        this.kilometers_per_hour = kilometers_per_hour;
    }

}
