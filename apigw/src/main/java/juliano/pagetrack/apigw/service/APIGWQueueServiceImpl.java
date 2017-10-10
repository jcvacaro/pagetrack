package juliano.pagetrack.apigw.service;

import juliano.pagetrack.common.domain.Contact;
import juliano.pagetrack.common.domain.PageAccess;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.messaging.handler.annotation.Payload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class APIGWQueueServiceImpl implements APIGWQueueService {

	private static final Logger logger = LoggerFactory.getLogger(APIGWQueueServiceImpl.class);

	private static final String CONTACT_QUEUE = "contact";
	private static final String PAGEACCESS_QUEUE = "pageaccess";

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void publishNewContact(Contact contact) {
		logger.info("publishNewContact invoked: userId=" + contact.getUserId());
		this.rabbitTemplate.convertAndSend(CONTACT_QUEUE, contact);
	}

	public void publishNewPageAccess(PageAccess pageAccess) {
		logger.info("publishNewPageAccess invoked: userId=" + pageAccess.getUserId());
		this.rabbitTemplate.convertAndSend(PAGEACCESS_QUEUE, pageAccess);
	}

}
