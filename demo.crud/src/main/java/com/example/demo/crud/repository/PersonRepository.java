package com.example.demo.crud.repository;

import com.example.demo.crud.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
