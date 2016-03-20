package ksu.chakravaram.mappingclasses;


public class Comments {

	public Comments() {
		// TODO Auto-generated constructor stub
	}

	
	private int profile_id;
	private int post_id;
	private String cmt;
	public int getProfile_id() {
		return profile_id;
	}
	public void setProfile_id(int profile_id) {
		this.profile_id = profile_id;
	}
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public String getCmt() {
		return cmt;
	}
	public void setCmt(String cmt) {
		this.cmt = cmt;
	}
}
