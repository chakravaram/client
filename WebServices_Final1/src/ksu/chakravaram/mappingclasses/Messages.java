package ksu.chakravaram.mappingclasses;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@Entity
public class Messages {

	public Messages() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue
	private int tmsgs;
	private int from_profile_id;
	private String message;
	
	private int to_profile_id;
	private Date time;
	public int getFrom_profile_id() {
		return from_profile_id;
	}
	public void setFrom_profile_id(int from_profile_id) {
		this.from_profile_id = from_profile_id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getTo_profile_id() {
		return to_profile_id;
	}
	public int getTmsgs() {
		return tmsgs;
	}
	public void setTmsgs(int tmsgs) {
		this.tmsgs = tmsgs;
	}
	public void setTo_profile_id(int to_profile_id) {
		this.to_profile_id = to_profile_id;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
	
	
	
}
