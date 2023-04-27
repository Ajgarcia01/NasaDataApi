package garcia.luqu.atmira.prueba;

import garcia.luqu.atmira.prueba.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {


	@Bean
	public MyConfig modelMapper() {
		return new MyConfig();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
