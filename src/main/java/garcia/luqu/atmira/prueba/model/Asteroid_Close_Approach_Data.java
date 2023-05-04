package garcia.luqu.atmira.prueba.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/*
    Clase que nos va a permitir recorrer los valores que se encuentran dentro de la propiedad "close_approach_data"
    la cual esta establecida en cada uno de los objetos que almacena el JSON
 */
public class Asteroid_Close_Approach_Data {

    //variable para conseguir la fecha de cierre dentro del array de "close_approach_data"
    private String close_approach_date;

    //variable para conseguir la velocidad relativa del Asteroide dentro del array de "close_approach_data"
    private GetAsteroidVelocity relative_velocity;

    //variable para conseguir el planeta de órbita del Asteroide dentro del array de "close_approach_data"
    private String orbiting_body;


    /*
    * Getter y Setter de cada una de las variables
    * @JsonProperty es utilizado para leer la propiedad específica dentro del JSON
    */
    public GetAsteroidVelocity getRelative_velocity() {
        return relative_velocity;
    }
    @JsonProperty("relative_velocity")
    public void setrelative_velocity(GetAsteroidVelocity relative_velocity) {
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
