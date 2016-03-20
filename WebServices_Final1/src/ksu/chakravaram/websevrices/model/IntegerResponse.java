package ksu.chakravaram.websevrices.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class IntegerResponse {

	public IntegerResponse() {
		// TODO Auto-generated constructor stub
	}

	public IntegerResponse(int i) {
		this.i = i;
		
	}
private int i;
public int getI() {
	return i;
}
public void setI(int i) {
	this.i = i;
}

}
