package juliano.pagetrack.apigw.service;

import juliano.pagetrack.common.domain.Contact;
import juliano.pagetrack.common.domain.PageAccess;

import java.util.List;

public interface APIGWRESTService {

	List<Contact> findContacts();
	List<PageAccess> findPageAccessByUserId(String userId);

}