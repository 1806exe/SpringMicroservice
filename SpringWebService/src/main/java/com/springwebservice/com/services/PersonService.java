package com.springwebservice.com.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springwebservice.com.bean.Person;


@Service
public class PersonService {
	
	List<Person> persons = new ArrayList<>();
	
	public List<Person> getPerson(){
		return persons;
	}
	
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	
	public PersonService() {
		persons.add(new Person(12,  "Innocent", new Date()));
		persons.add(new Person(13,  "Mgubhe", new Date()));
		persons.add(new Person(14,  "Noel", new Date()));
	}
	
	public List<Person> getAllPersons(){
		return persons;
	}
	
	
	public Person getPerson(int personId) {
		for (Person person: persons) {
			if (person.getPersonId() == personId) {
				System.out.println("service" + personId);
				return person;
			}
		}
		return null;
	}
	
	
	public Person addPerson(Person person) {
		int size = persons.size();
		person.setPersonId(++size);
		persons.add(person);
		return person;
	}
	
	
	public Person deletePerson(int personId) {
		Person person = new Person();
		person.setPersonId(personId);
		if (persons.remove(person))
			return person;
		else
			return null;
	}
	
	
	public Person updatePerson(int personId) {
		Person person = new Person();
		if (personId == person.getPersonId()) {
			person.setPersonId(personId);
			person.setName(person.getName());
			person.setBirtdDate(person.getBirtdDate());
			return person;
		}
		return null;
	}
}
