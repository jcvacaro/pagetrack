package juliano.pagetrack.frontend.service;

import juliano.pagetrack.frontend.domain.Contact;
import juliano.pagetrack.frontend.domain.PageAccess;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpMethod;
import org.springframework.core.ParameterizedTypeReference;

@Component
public class FrontendRESTServiceImpl implements FrontendRESTService {

	private static final String CONTACT_URL = "http://apigwservice:8080/api/v1/contact/";
	private static final String PAGEACCESS_URL = "http://apigwservice:8080/api/v1/pageaccess/";

	public List<Contact> findContacts() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<Contact>> resp = restTemplate.exchange(CONTACT_URL, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Contact>>() {
				});
		return resp.getBody();
	}

	public List<PageAccess> findPageAccessByUserId(String userId) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<PageAccess>> resp = restTemplate.exchange(getPageAccessURL(userId), HttpMethod.GET, null,
				new ParameterizedTypeReference<List<PageAccess>>() {
				});
		return resp.getBody();
	}

	private String getPageAccessURL(String userId) {
		return CONTACT_URL + userId + "/pageaccess";
	}

	public void createContact(Contact contact) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject(CONTACT_URL, contact, Void.class);
	}

	public void trackPageAccess(PageAccess pageAccess) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject(PAGEACCESS_URL, pageAccess, Void.class);
	}

}
