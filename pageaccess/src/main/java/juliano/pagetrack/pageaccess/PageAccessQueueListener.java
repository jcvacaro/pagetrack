package juliano.pagetrack.pageaccess;

import juliano.pagetrack.pageaccess.domain.PageAccess;
import juliano.pagetrack.pageaccess.service.PageAccessRepository;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.messaging.handler.annotation.Payload;

@Component
public class PageAccessQueueListener {

	@Autowired
	private PageAccessRepository repository;

	@RabbitListener(queues = "pageaccess")
	public void processMessage(@Payload PageAccess pageaccess) {
		repository.save(pageaccess);
	}

}