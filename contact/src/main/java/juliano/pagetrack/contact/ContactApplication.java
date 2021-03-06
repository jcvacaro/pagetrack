package juliano.pagetrack.contact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("juliano.pagetrack.common.domain")
public class ContactApplication {

	@Bean
	public Queue contactQueue() {
		return new Queue("contact");
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ContactApplication.class, args);
	}

}
