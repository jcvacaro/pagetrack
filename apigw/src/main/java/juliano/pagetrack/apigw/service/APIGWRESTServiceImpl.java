package juliano.pagetrack.apigw.service;

import juliano.pagetrack.apigw.domain.Contact;
import juliano.pagetrack.apigw.domain.PageAccess;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpMethod;
import org.springframework.core.ParameterizedTypeReference;

@Component
public class APIGWRESTServiceImpl implements APIGWRESTService {

	private static final String CONTACT_SERVICE = "http://contactservice:8080/api/v1/contact/";
	private static final String PAGEACCESS_SERVICE = "http://pageaccessservice:8080/api/v1/pageaccess/";

	public List<Contact> findContacts() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<Contact>> resp = restTemplate.exchange(CONTACT_SERVICE, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Contact>>() {
				});
		return resp.getBody();
	}

	public List<PageAccess> findPageAccessByUserId(String userId) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<PageAccess>> resp = restTemplate.exchange(PAGEACCESS_SERVICE+userId, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<PageAccess>>() {
				});
		return resp.getBody();
	}

}
