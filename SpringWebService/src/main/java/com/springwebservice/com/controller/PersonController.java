//package com.springwebservice.com.controller;
//
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.hateoas.EntityModel;
//import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.springwebservice.com.bean.Person;
//import com.springwebservice.com.myexceptions.PersonNotFoundException;
//import com.springwebservice.com.services.PersonService;
//
//@RestController
//public class PersonController {
//
//	@Autowired
//	PersonService personService;
//
//	@GetMapping(value = "/persons-service")
//	public List<Person> getPersons(){
//		return personService.getAllPersons();
//	}
//
//
//
//	@PostMapping(value = "/persons-service")
//	public Person addPersonService(@RequestBody Person person) {
//		Person person1 = personService.addPerson(person);
//		return person1;
//	}
//
//	@GetMapping(value = "persons-service/personId/{personId}")
//	public String addPersonService_param(@PathVariable("personId") int personId) {
//		return "Welcome = " + personId;
//
//	}
//
////	@GetMapping(value = "/persons-service/{personId}")
////	public Person getPerson(@PathVariable int personId) {
////		System.out.println("controller" + personId);
////		Person person = personService.getPerson(personId);
////		return person;
////	}
//
//	@GetMapping(value = "/persons-service/id/{personId}")
//	public Person getPerson(@PathVariable int personId) {
//		System.out.println("controller" + personId);
//		Person person = personService.getPerson(personId);
//		if (person == null)
//			throw new PersonNotFoundException("Person with id = " + personId + " does not exist");
//		return person;
//	}
//
//
//	@DeleteMapping(value = "/persons-service/{personId}")
//	public Person deletePersonService(@PathVariable int personId) {
//		return personService.deletePerson(personId);
//	}
//
//
//	@PutMapping(value = "persons-service/{personId}")
//	public Person updatePersonService(@PathVariable int personId) {
//		return personService.updatePerson(personId);
//	}
//
//
//
//	@GetMapping(value = "/persons-service/{personId}")
//	public EntityModel<Person> getPerson_id(@PathVariable int personId){
//		System.out.println("controller" + personId);
//		Person person = personService.getPerson(personId);
//		if (person == null)
//			throw new PersonNotFoundException("Person with " + personId + " doesn't exist");
//		EntityModel<Person> resource = new EntityModel<Person>(person);
//		ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getPersons());
//		resource.add(linkTo.withRel("all-users"));
//		return resource;
//	}
//
//}
