package garcia.luqu.atmira.prueba;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@SpringBootTest
class ApplicationTests {

	@Test
	void contextLoads() {

	}

	public static final String formatFinalDate (LocalDate dateInitial, int ndias) {
		// Parseamos la fecha del dia actual a LocalDate
		LocalDate fecha = LocalDate.parse(formatDate(new Date()), DateTimeFormatter.ofPattern("yyyy-MM-dd"));

		// Limitamos el número de días a 7
		ndias = Math.min(ndias, 7);

		// Sumamos los días a la fecha actual
		LocalDate fechaSumada = fecha.plusDays(ndias);

		// Si la fecha sumada supera el límite de 7 días, se ajusta a ese límite
		if (fechaSumada.isAfter(fecha.plusDays(7))) {
			fechaSumada = fecha.plusDays(7);
		}

		// Devolvemos la fecha resultante en formato yyyy-MM-dd
		return fechaSumada.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}


	protected static final String formatDate (Date dateOne)
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(dateOne);
	}

}
