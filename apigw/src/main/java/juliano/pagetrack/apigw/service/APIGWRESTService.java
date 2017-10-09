package juliano.pagetrack.apigw.service;

import juliano.pagetrack.apigw.domain.Contact;
import juliano.pagetrack.apigw.domain.PageAccess;

import java.util.List;

public interface APIGWRESTService {

	List<Contact> findContacts();
	List<PageAccess> findPageAccessByUserId(String userId);

}