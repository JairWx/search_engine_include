package domain;

import javafx.animation.Animation.Status;

/**
 * 推送的链接
 * @author admin
 *
 */
public class BlogUrl {
	private String url;
	private long createDateTime;
	private int status;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public long getCreateDateTime() {
		return createDateTime;
	}
	public void setCreateDateTime(long createDateTime) {
		this.createDateTime = createDateTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
