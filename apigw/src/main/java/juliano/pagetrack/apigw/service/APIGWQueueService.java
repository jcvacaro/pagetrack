package juliano.pagetrack.apigw.service;

import juliano.pagetrack.apigw.domain.Contact;
import juliano.pagetrack.apigw.domain.PageAccess;

public interface APIGWQueueService {

	static final String CONTACT_QUEUE_NAME = "contact";
	static final String PAGEACCESS_QUEUE_NAME = "pageaccess";

	void publishNewContact(Contact contact);
	void publishNewPageAccess(PageAccess pageAccess);

}
