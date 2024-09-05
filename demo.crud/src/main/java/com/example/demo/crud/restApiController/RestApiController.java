package com.example.demo.crud.restApiController;

import com.example.demo.crud.model.Person;
import com.example.demo.crud.repository.PersonRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")

public class RestApiController {
    private final PersonRepository personRepository;

    public RestApiController(PersonRepository personRepository){
        this.personRepository = personRepository;

       this.personRepository.saveAll(List.of(
               new Person("Name1", "Surname1" ),
               new Person("Name2", "Surname2" ),
               new Person("Name3", "Surname3" ),
               new Person("Name4", "Surname4" ),
               new Person("Name5", "Surname5" )


       ));

    }
    @GetMapping
    Iterable<Person>getPerson(){
        return personRepository.findAll();
    }
    @GetMapping("/{id}")
    Optional<Person> getPersonId(@PathVariable Long id){
        return personRepository.findById(id);
    }

    @PostMapping
    Person postPerson(@RequestBody Person person){
        return personRepository.save(person);
    }
    @PutMapping("/{id}")
    ResponseEntity<Person> putPerson(@PathVariable Long id, @RequestBody Person person){
        return (!personRepository.existsById(id))
                ? new ResponseEntity<>(personRepository.save(person), HttpStatus.CREATED)
                : new ResponseEntity<>(personRepository.save(person), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    void deletePerson(@PathVariable Long id){
        personRepository.deleteById(id);
    }





}
