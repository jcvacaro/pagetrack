package juliano.pagetrack.common.domain;

import java.io.Serializable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class PageAccess implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String userId;

	@Column(nullable = false)
	private String url;

	@Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar timestamp;

	protected PageAccess() {
	}

	public PageAccess(String userId, String url, Calendar timestamp) {
		this.userId = userId;
		this.url = url;
		this.timestamp = timestamp;
	}

	public String getUserId() {
		return this.userId;
	}

	public String getUrl() {
		return this.url;
	}

	public Calendar getTimestamp() {
		return this.timestamp;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setTimestamp(Calendar timestamp) {
		this.timestamp = timestamp;
	}

}
