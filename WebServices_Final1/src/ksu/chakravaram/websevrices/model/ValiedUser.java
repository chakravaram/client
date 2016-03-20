package ksu.chakravaram.websevrices.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ValiedUser {

	public ValiedUser() {
		// TODO Auto-generated constructor stub
	}

	private int flag;
	private int profile_id;
	
	public ValiedUser(int flag,int profile_id)
	{
		this.flag = flag;
		this.profile_id = profile_id;
	}
	
	
	
	
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getProfile_id() {
		return profile_id;
	}
	public void setProfile_id(int profile_id) {
		this.profile_id = profile_id;
	}
}
