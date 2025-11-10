package iuh.fit.se;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestApiDemoApplication {

	private final static Logger logger = LoggerFactory.getLogger(RestApiDemoApplication.class.getName());

	public static void main(String[] args) {

		SpringApplication.run(RestApiDemoApplication.class, args);
		logger.info("RestApiDemoApplication Start");
	}

	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
}
