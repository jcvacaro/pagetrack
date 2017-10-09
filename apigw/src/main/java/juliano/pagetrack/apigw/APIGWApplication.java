package juliano.pagetrack.apigw;

import juliano.pagetrack.apigw.service.APIGWQueueService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class APIGWApplication {

	@Bean
	public Queue contactQueue() {
		return new Queue(APIGWQueueService.CONTACT_QUEUE_NAME);
	}

	@Bean
	public Queue pageAccessQueue() {
		return new Queue(APIGWQueueService.PAGEACCESS_QUEUE_NAME);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(APIGWApplication.class, args);
	}

}
