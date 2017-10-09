package juliano.pagetrack.frontend.service;

import juliano.pagetrack.frontend.domain.Contact;
import juliano.pagetrack.frontend.domain.PageAccess;

import java.util.List;

public interface FrontendRESTService {

	List<Contact> findContacts();
	List<PageAccess> findPageAccessByUserId(String userId);
	void createContact(Contact contact);
	void trackPageAccess(PageAccess pageAccess);

}