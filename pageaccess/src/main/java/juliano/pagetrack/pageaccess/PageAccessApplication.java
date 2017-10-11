package juliano.pagetrack.pageaccess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("juliano.pagetrack.common.domain")
public class PageAccessApplication {

	@Bean
	public Queue pageAccessQueue() {
		return new Queue("pageaccess");
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(PageAccessApplication.class, args);
	}

}
