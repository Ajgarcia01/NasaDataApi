package garcia.luqu.atmira.prueba.services;

import garcia.luqu.atmira.prueba.Exceptions.ResourceNullPointException;
import garcia.luqu.atmira.prueba.controllers.AsteroidEarthController;

import garcia.luqu.atmira.prueba.interfaces.AsteroidEarthServiceInf;
import garcia.luqu.atmira.prueba.model.DTO.AsteroidDTO;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyList;


import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.matchers.Null;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.*;
import org.springframework.web.bind.MissingServletRequestParameterException;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.lang.reflect.Executable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@SpringBootTest
@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
@ExtendWith(MockitoExtension.class)
public class AsteroidEarthServiceTest {



    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }






   @Test
    public void getDataOfDTO(){
        AsteroidDTO asteroidDTO = new AsteroidDTO();
        AsteroidDTO asteroidDTO2 = new AsteroidDTO();
        List<AsteroidDTO> list = new ArrayList<>();

        asteroidDTO.setAsteroid_Name("Pueba");
        asteroidDTO.setAsteroid_orbiting("Tierra");
        asteroidDTO.setAsteroid_Approach_Date("2025-05-06");
        asteroidDTO.setAsteroid_Velocity(20.00);
        asteroidDTO.setAsteroid_Average_Diameter(500.00);

        asteroidDTO2.setAsteroid_Name("ETO839");
        asteroidDTO2.setAsteroid_orbiting("Tierra");
        asteroidDTO2.setAsteroid_Approach_Date("2025-05-06");
        asteroidDTO2.setAsteroid_Velocity(20.00);
        asteroidDTO2.setAsteroid_Average_Diameter(500.00);

        list.add(asteroidDTO);
        list.add(asteroidDTO2);

        //Test

        assertEquals(20.00,list.get(1).getAsteroid_Velocity());

        assertEquals(list.get(0).getAsteroid_Average_Diameter(),list.get(1).getAsteroid_Average_Diameter());
        assertNotEquals(list.get(0).getAsteroid_Name(),list.get(1).getAsteroid_Name());

    }




    @Test
    void Prueba() throws MissingServletRequestParameterException {
        AsteroidEarthServiceInf asteroidEarthServiceInf= mock(AsteroidEarthServiceInf.class);

        when(asteroidEarthServiceInf.getAsteroidesPotentiallyToEarth(new Date(),3)).thenThrow(new NullPointerException("Asteroid not found"));

        AsteroidEarthService asteroidEarthService = new AsteroidEarthService();

        // Verificamos que se lance la excepción EntityNotFoundException al llamar al método getAsteroidById
        assertThrows(ResourceNullPointException.class, () -> {
            asteroidEarthService.getAsteroidesPotentiallyToEarth(new Date(),3);
        });



    }


}
