package juliano.pagetrack.apigw;

import juliano.pagetrack.apigw.domain.Contact;
import juliano.pagetrack.apigw.domain.PageAccess;
import juliano.pagetrack.apigw.service.APIGWQueueService;
import juliano.pagetrack.apigw.service.APIGWRESTService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class APIGWRESTController {

	@Autowired
	private APIGWQueueService queue;

	@Autowired
	private APIGWRESTService rest;

	@RequestMapping(method = RequestMethod.GET, value = "/contact")
	public List<Contact> findContacts() {
		return this.rest.findContacts();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/contact/{userid}/pageaccess")
	public List<PageAccess> findPageAccessByUserId(@PathVariable("userid") String userId) {
		return this.rest.findPageAccessByUserId(userId);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/contact")
	public void createContact(Contact contact) {
		this.queue.publishNewContact(contact);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/pageaccess")
	public void trackPageAccess(PageAccess pageAccess) {
		this.queue.publishNewPageAccess(pageAccess);
	}


}
