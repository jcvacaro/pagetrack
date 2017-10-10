package juliano.pagetrack.contact.service;

import juliano.pagetrack.common.domain.Contact;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, Long> {

	List<Contact> findAll();
	Contact findByUserId(String userId);

}
