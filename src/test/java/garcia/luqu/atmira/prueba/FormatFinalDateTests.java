package garcia.luqu.atmira.prueba;

import garcia.luqu.atmira.prueba.model.DTO.AsteroidDTO;
import garcia.luqu.atmira.prueba.services.AsteroidEarthServiceTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class FormatFinalDateTests {


    @Test
    protected void formatDate ()
    {
        Date dateOne= new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        assertEquals("2023-05-05",  dateFormat.format(dateOne));

    }


}
