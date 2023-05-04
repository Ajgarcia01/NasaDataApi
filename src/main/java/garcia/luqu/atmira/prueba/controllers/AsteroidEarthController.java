package garcia.luqu.atmira.prueba.controllers;

import garcia.luqu.atmira.prueba.Exceptions.ResourceBadRequestException;
import garcia.luqu.atmira.prueba.Exceptions.ResourceInternalServerErrorException;
import garcia.luqu.atmira.prueba.Exceptions.ResourceNotFoundException;
import garcia.luqu.atmira.prueba.model.DTO.AsteroidDTO;
import garcia.luqu.atmira.prueba.services.AsteroidEarthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/asteroids")
public class AsteroidEarthController {

    @Autowired
    private AsteroidEarthService asteroidEarthService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<AsteroidDTO>> searchAPossibleAsteroid(@RequestParam("days") int ndays) throws MissingServletRequestParameterException {
        try {
            List<AsteroidDTO> nasaDTO = asteroidEarthService.getAsteroidesPotentiallyToEarth(new Date(), ndays);
                if (nasaDTO != null) {
                    return new ResponseEntity<>(nasaDTO, HttpStatus.OK);
                }else{
                    return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
                }

        }catch(ResourceNotFoundException NotFound) {
            throw new ResourceNotFoundException("No hay resultados para los parámetros establecidos "+NotFound);

        } catch (ResourceBadRequestException BadRequest) {
            throw new MissingServletRequestParameterException("error",BadRequest.getMessage());

        } catch (ResourceInternalServerErrorException resourceInternalServerErrorException){
            throw new ResourceInternalServerErrorException("No se ha podido ejecutar la peticion, error en el servidor" + resourceInternalServerErrorException);
        }

    }
}
