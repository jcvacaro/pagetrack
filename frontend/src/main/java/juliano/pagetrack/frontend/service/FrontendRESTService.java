package juliano.pagetrack.frontend.service;

import juliano.pagetrack.common.domain.Contact;
import juliano.pagetrack.common.domain.PageAccess;

import java.util.List;

public interface FrontendRESTService {

	List<Contact> findContacts();
	List<PageAccess> findPageAccessByUserId(String userId);
	void createContact(Contact contact);
	void trackPageAccess(PageAccess pageAccess);

}