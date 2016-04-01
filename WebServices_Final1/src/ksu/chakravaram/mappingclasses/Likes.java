package ksu.chakravaram.mappingclasses;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@Entity

public class Likes {

	public Likes() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue
	private int tlikes;

	private int profile_id;
	private int post_id;
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
	
}
