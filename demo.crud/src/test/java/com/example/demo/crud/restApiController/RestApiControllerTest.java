package com.example.demo.crud.restApiController;

import com.example.demo.crud.model.Person;
import com.example.demo.crud.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RestApiControllerTest {
    private RestApiController restApiController;
    private PersonRepository personRepository;

    @BeforeEach
    public void setUp(){

        restApiController = new RestApiController(personRepository);
    }



}