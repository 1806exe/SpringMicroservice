package com.springwebservice.com.controller;

import com.springwebservice.com.bean.Person;
import com.springwebservice.com.data.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController_Controller {

    @Autowired
    PersonRepository personRepository;

    @PostMapping("/persons-data")
    public Person addPersonData(@RequestBody Person person){
        Person person1 = personRepository.save(person);
        return person1;
    }

    @PostMapping("/person-data-status")
    public ResponseEntity<Person> addPerson1(@RequestBody Person person){
        Person person1 = personRepository.save(person);
        return new ResponseEntity<>(person1, HttpStatus.OK);
    }

    @GetMapping("/persons-data-all")
    public List<Person> getPersonData(){
        return personRepository.findAll();
    }


    @GetMapping("/persons-data-entity/{personId}")
    public ResponseEntity<Person> findById(@PathVariable int personId){
        Optional<Person> optional = personRepository.findById(personId);
        if(!personRepository.findById(personId).isPresent()){
            System.out.println("no person");
            return new ResponseEntity("Person with ID " + personId + " not found", HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<Person>(optional.get(), HttpStatus.OK);
        }
    }

    @DeleteMapping("/persons -entity-header/{personId}")
    public ResponseEntity<Person> deletePerson1(@PathVariable int personId){
        Person person1 = new Person();
        person1.setPersonId(personId);
        personRepository.delete(person1);

        return new ResponseEntity<>(person1, HttpStatus.NO_CONTENT);
    }

//    @PutMapping("update-person-data/{personId}")
//    public ResponseEntity<Person> updatePerson1(@PathVariable int personId){
//        Optional<Person> optional = personRepository.findById(personId);
//
//
//    }

}
