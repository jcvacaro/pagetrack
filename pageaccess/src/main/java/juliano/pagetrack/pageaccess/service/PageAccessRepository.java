package juliano.pagetrack.pageaccess.service;

import juliano.pagetrack.common.domain.PageAccess;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface PageAccessRepository extends CrudRepository<PageAccess, Long> {

	List<PageAccess> findAll();
	List<PageAccess> findByUserId(String userId);

}
