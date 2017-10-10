package juliano.pagetrack.contact;

import juliano.pagetrack.common.domain.Contact;
import juliano.pagetrack.contact.service.ContactRepository;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.messaging.handler.annotation.Payload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class ContactQueueListener {

	private static final Logger logger = LoggerFactory.getLogger(ContactQueueListener.class);

	@Autowired
	private ContactRepository repository;

	@RabbitListener(queues = "contact")
	public void processMessage(@Payload Contact contact) {
		logger.info("processMessage invoked: userId=" + contact.getUserId());
		repository.save(contact);
	}

}
