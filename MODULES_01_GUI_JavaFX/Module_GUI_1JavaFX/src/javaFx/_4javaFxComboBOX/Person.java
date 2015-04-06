package javaFx._4javaFxComboBOX;

import java.util.Date;

public class Person {

	//ATTRIBUTES
	private String firstname, lastname;
	private Date birthdate;

	//CONSTRUCTOR
	public Person(String firstname, String lastname, Date birthdate) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthdate = birthdate;
	}

	//GETTERS AND SETTERS
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	
	//TOSTRING
	@Override
	public String toString() {
		return firstname + " - " + lastname;
	}
}
