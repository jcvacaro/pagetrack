package juliano.pagetrack.apigw.service;

import juliano.pagetrack.apigw.domain.Contact;
import juliano.pagetrack.apigw.domain.PageAccess;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.messaging.handler.annotation.Payload;

@Component
public class APIGWQueueServiceImpl implements APIGWQueueService {

	private static final String CONTACT_QUEUE = "contact";
	private static final String PAGEACCESS_QUEUE = "pageaccess";

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void publishNewContact(Contact contact) {
		this.rabbitTemplate.convertAndSend(CONTACT_QUEUE, contact);
	}

	public void publishNewPageAccess(PageAccess pageAccess) {
		this.rabbitTemplate.convertAndSend(PAGEACCESS_QUEUE, pageAccess);
	}

}
