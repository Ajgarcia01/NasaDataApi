package garcia.luqu.atmira.prueba.model.DTO;

/*
    Clase que nos va a permitir generar un objeto de transferencia de datos
    Esta clase se va a utilizar para devolver el objeto que queremos crear en base al JSON recogido de la peticion

    Vamos a generar un objeto con las propiedad que queremos devolver en el JSON y posteriormente crear una
    instancia del mismo en el servicio e ir seteando los valores que vamos recogiendo
 */
public class AsteroidDTO {

    //Variable para recoger el nombre del asteroide
    private String Asteroid_Name;

    //Variable para recoger la velocidad del asteroide
    private Double Asteroid_Velocity;

    //Variable para recoger el planeta donde orbita el asteroide
    private String Asteroid_orbiting;

    //Variable para recoger la fecha de cierre del asteroide
    private String Asteroid_Approach_Date;

    //Variable para recoger la media de diametro del asteroide
    private Double Asteroid_Average_Diameter;

    public AsteroidDTO(String asteroid_Name, Double asteroid_Velocity, String asteroid_orbiting, String asteroid_Approach_Date, Double asteroid_Average_Diameter) {
        Asteroid_Name = asteroid_Name;
        Asteroid_Velocity = asteroid_Velocity;
        Asteroid_orbiting = asteroid_orbiting;
        Asteroid_Approach_Date = asteroid_Approach_Date;
        Asteroid_Average_Diameter = asteroid_Average_Diameter;
    }

    public AsteroidDTO() {
    }

    /*
     * Getter y Setter de cada una de las variables
     */


    public String getAsteroid_Name() {
        return Asteroid_Name;
    }

    public void setAsteroid_Name(String asteroid_Name) {
        Asteroid_Name = asteroid_Name;
    }

    public Double getAsteroid_Velocity() {
        return Asteroid_Velocity;
    }

    public void setAsteroid_Velocity(Double asteroid_Velocity) {
        Asteroid_Velocity = asteroid_Velocity;
    }

    public String getAsteroid_orbiting() {
        return Asteroid_orbiting;
    }

    public void setAsteroid_orbiting(String asteroid_orbiting) {
        Asteroid_orbiting = asteroid_orbiting;
    }

    public String getAsteroid_Approach_Date() {
        return Asteroid_Approach_Date;
    }

    public void setAsteroid_Approach_Date(String asteroid_Approach_Date) {
        Asteroid_Approach_Date = asteroid_Approach_Date;
    }

    public Double getAsteroid_Average_Diameter() {
        return Asteroid_Average_Diameter;
    }

    public void setAsteroid_Average_Diameter(Double asteroid_Average_Diameter) {
        Asteroid_Average_Diameter = asteroid_Average_Diameter;
    }
}
