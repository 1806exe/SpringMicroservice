package com.springwebservice.com.bean;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "persons_tz")
public class Person {

	@Id
	private int personId;
	private String name;
	@Column
	private Date birtdDate;


	public Person() {
		super();
	}


	public Person(int personId, String name, Date birtdDate) {
		super();
		this.personId = personId;
		this.name = name;
		this.birtdDate = birtdDate;
	}
	

	public int getPersonId() {
		return personId;
	}


	public void setPersonId(int personId) {
		this.personId = personId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}



	public Date getBirtdDate() {
		return birtdDate;
	}


	public void setBirtdDate(Date birtdDate) {
		this.birtdDate = birtdDate;
	}

	
	
	@Override
	public String toString() {
		return "Person [personId=" + personId + ", name=" + name + ", birtdDate=" + birtdDate + "]";
	}


//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + personId;
//		return result;
//	}
	
	
//	@Override
//	public boolean equal(Object obj) {
//		Person person = (Person) obj;
//		if ()
//	}
//	

}
