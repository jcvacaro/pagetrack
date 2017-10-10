package juliano.pagetrack.contact;

import juliano.pagetrack.contact.domain.Contact;
import juliano.pagetrack.contact.service.ContactRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/v1")
public class ContactRESTController {

	private static final Logger logger = LoggerFactory.getLogger(ContactRESTController.class);

	@Autowired
	private ContactRepository repository;

	@RequestMapping(method = RequestMethod.GET, value = "/contact")
	public List<Contact> findAll() {
		logger.info("findAll invoked");
		return repository.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/contact/{userid}")
	public Contact findByUserId(@PathVariable("userid") String userId) {
		logger.info("findByUserId invoked: userId=" + userId);
		return repository.findByUserId(userId);
	}

}
