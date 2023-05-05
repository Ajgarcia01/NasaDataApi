package garcia.luqu.atmira.prueba.interfaces;

import garcia.luqu.atmira.prueba.model.DTO.AsteroidDTO;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.MissingServletRequestParameterException;

import java.util.Date;
import java.util.List;

/**
 * Repo para implementar el metodo en el servicio
 */
@Repository
public interface AsteroidEarthServiceInf {

    public List<AsteroidDTO> getAsteroidesPotentiallyToEarth(Date dateOne, int ndays) throws MissingServletRequestParameterException;

}
