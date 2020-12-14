package  com.docker.restful.demo.entities;

import java.io.Serializable;

public class User implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	private String lastName;
	private String firstName;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
}
