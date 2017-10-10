package juliano.pagetrack.contact;

import juliano.pagetrack.common.domain.Contact;
import juliano.pagetrack.contact.service.ContactRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	public @ResponseBody List<Contact> findAll() {
		logger.info("findAll invoked");
		return repository.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/contact/{userid}")
	public @ResponseBody Contact findByUserId(@PathVariable("userid") String userId) {
		logger.info("findByUserId invoked: userId=" + userId);
		return repository.findByUserId(userId);
	}

}
