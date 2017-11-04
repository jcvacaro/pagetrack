package juliano.pagetrack.common.domain;

import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ContactView implements Serializable {

	private static final long serialVersionUID = 1L;

	private String userId;
	private String email;
	private List<PageAccess> pages;

	protected ContactView() {
	}

	public ContactView(String userId, String email, List<PageAccess> pages) {
		this.userId = userId;
		this.email = email;
		this.pages = pages;
	}

	public List<PageAccess> getPages() {
		return this.pages;
	}

	public String getUserId() {
		return this.userId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setPages(List<PageAccess> pages) {
		this.pages = pages;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
