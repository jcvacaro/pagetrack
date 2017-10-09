package juliano.pagetrack.contact;

import juliano.pagetrack.contact.domain.Contact;
import juliano.pagetrack.contact.service.ContactRepository;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.messaging.handler.annotation.Payload;

@Component
public class ContactQueueListener {

	@Autowired
	private ContactRepository repository;

	@RabbitListener(queues = "contact")
	public void processMessage(@Payload Contact contact) {
		repository.save(contact);
	}

}
