package juliano.pagetrack.frontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class FrontendApplication {

	private static final Logger logger = LoggerFactory.getLogger(FrontendApplication.class);

	public static void main(String[] args) throws Exception {
		logger.info("booting frontend");
		SpringApplication.run(FrontendApplication.class, args);
	}

}
