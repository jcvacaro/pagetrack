package juliano.pagetrack.apigw.service;

import juliano.pagetrack.apigw.domain.Contact;
import juliano.pagetrack.apigw.domain.PageAccess;

public interface APIGWQueueService {

	void publishNewContact(Contact contact);
	void publishNewPageAccess(PageAccess pageAccess);

}