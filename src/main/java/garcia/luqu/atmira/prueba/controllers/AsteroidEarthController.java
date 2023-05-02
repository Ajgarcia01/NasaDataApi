package garcia.luqu.atmira.prueba.controllers;

import garcia.luqu.atmira.prueba.model.AsteroidDTO;
import garcia.luqu.atmira.prueba.services.AsteroidEarthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/asteroids")
public class AsteroidEarthController {

    @Autowired
    private AsteroidEarthService asteroidEarthService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<AsteroidDTO>> searchAPossibleAsteroid(@RequestParam("days") int ndias)
    {

        List<AsteroidDTO> nasaDTO = asteroidEarthService.getAsteroidesPotentiallyToEarth(new Date(),ndias);

        if(nasaDTO != null)
        {
            return new ResponseEntity<>(nasaDTO, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
