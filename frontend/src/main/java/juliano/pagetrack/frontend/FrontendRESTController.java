package juliano.pagetrack.frontend;

import juliano.pagetrack.frontend.domain.Contact;
import juliano.pagetrack.frontend.domain.PageAccess;
import juliano.pagetrack.frontend.service.FrontendRESTService;
import juliano.pagetrack.frontend.util.CookieHelper;

import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/v1")
public class FrontendRESTController {

	private static final Logger logger = LoggerFactory.getLogger(FrontendRESTController.class);
	private CookieHelper helper = new CookieHelper();

	@Autowired
	private FrontendRESTService rest;

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
		this.rest.createContact(contact);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/pageaccess")
	public ResponseEntity<PageAccess> trackPageAccess(@RequestBody PageAccess pageAccess, HttpServletRequest request, HttpServletResponse response) {
		logger.info("trackPageAccess invoked");
		Cookie c = helper.getCookie(request);
		if (c == null) {
			c = helper.createCookie();
			response.addCookie(c);
		}
		pageAccess.setUserId(c.toString());
		this.rest.trackPageAccess(pageAccess);
		return new ResponseEntity<PageAccess>(pageAccess, HttpStatus.OK);
    }

}
