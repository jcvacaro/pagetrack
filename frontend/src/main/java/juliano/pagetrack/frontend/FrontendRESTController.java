package juliano.pagetrack.frontend;

import juliano.pagetrack.common.domain.Contact;
import juliano.pagetrack.common.domain.PageAccess;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	public @ResponseBody String findContacts() {
		logger.info("findContacts invoked");
		String text = "";
		List<Contact> contacts = this.rest.findContacts();
		if ((contacts != null) && (!contacts.isEmpty())) {
			logger.info("findContacts: contacts=" + contacts.size());
			for (Contact c : contacts) {
				text += "<a href=\"/api/v1/contact/" + c.getUserId() + "/pageaccess\">" + c.getEmail() + "</a><br>";
			}
		}
		logger.info("findContacts: text=" + text);
		return text;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/contact/{userid}/pageaccess")
	public @ResponseBody List<PageAccess> findPageAccessByUserId(@PathVariable("userid") String userId) {
		logger.info("findPageAccessByUserId invoked: userId=" + userId);
		return this.rest.findPageAccessByUserId(userId);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/contact")
	@ResponseStatus(value = HttpStatus.OK)
	public void createContact(@RequestBody Contact contact, HttpServletRequest request, HttpServletResponse response) {
		logger.info("createContact invoked: userId=" + contact.getUserId());
		Cookie c = helper.getCookie(request);
		if (c == null) {
			c = helper.createCookie();
			response.addCookie(c);
			logger.info("createContact: new user detected: " + c.getValue());
		}
		logger.info("createContact: cookie=" + c.getValue());
		contact.setUserId(c.getValue());
		this.rest.createContact(contact);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/pageaccess")
	@ResponseStatus(value = HttpStatus.OK)
	public void trackPageAccess(@RequestBody PageAccess pageAccess, HttpServletRequest request, HttpServletResponse response) {
		logger.info("trackPageAccess invoked: userId=" + pageAccess.getUserId());
		Cookie c = helper.getCookie(request);
		if (c == null) {
			c = helper.createCookie();
			response.addCookie(c);
			logger.info("trackPageAccess: new user detected: " + c.getValue());
		}
		logger.info("trackPageAccess: cookie=" + c.getValue());
		pageAccess.setUserId(c.getValue());
		this.rest.trackPageAccess(pageAccess);
    }

}
