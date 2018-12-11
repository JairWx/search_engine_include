package domain;

/**
 * 推送批次记录
 * @author admin
 *
 */
public class CommitBatch {
	private int id;
	private int success;
	private int remain;
	private String notSameSite;
	private String notValid;
	private String searchEngineName;
	private int createDateTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSuccess() {
		return success;
	}
	public void setSuccess(int success) {
		this.success = success;
	}
	public int getRemain() {
		return remain;
	}
	public void setRemain(int remain) {
		this.remain = remain;
	}
	public String getNotSameSite() {
		return notSameSite;
	}
	public void setNotSameSite(String notSameSite) {
		this.notSameSite = notSameSite;
	}
	public String getNotValid() {
		return notValid;
	}
	public void setNotValid(String notValid) {
		this.notValid = notValid;
	}
	public String getSearchEngineName() {
		return searchEngineName;
	}
	public void setSearchEngineName(String searchEngineName) {
		this.searchEngineName = searchEngineName;
	}
	public int getCreateDateTime() {
		return createDateTime;
	}
	public void setCreateDateTime(int createDateTime) {
		this.createDateTime = createDateTime;
	}
	
}
