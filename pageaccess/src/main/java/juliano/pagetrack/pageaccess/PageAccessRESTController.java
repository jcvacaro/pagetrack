package juliano.pagetrack.pageaccess;

import juliano.pagetrack.pageaccess.domain.PageAccess;
import juliano.pagetrack.pageaccess.service.PageAccessRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PageAccessRESTController {

	@Autowired
	private PageAccessRepository repository;

	@RequestMapping(method = RequestMethod.GET, value = "/pageaccess")
	public List<PageAccess> findAll() {
		return repository.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/pageaccess/{userid}")
	public List<PageAccess> findByUserId(@PathVariable("userid") String userId) {
		return repository.findByUserId(userId);
	}

}
