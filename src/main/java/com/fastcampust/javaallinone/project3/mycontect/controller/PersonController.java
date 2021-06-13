package com.fastcampust.javaallinone.project3.mycontect.controller;

import com.fastcampust.javaallinone.project3.mycontect.domain.Person;
import com.fastcampust.javaallinone.project3.mycontect.repository.PersonRepository;
import com.fastcampust.javaallinone.project3.mycontect.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/api/person")
@RestController
@Slf4j
public class PersonController {

    @Autowired
    private PersonService personService;
    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    @RequestMapping(value = "/{id}")
    public Person getPerson(@PathVariable Long id) {
        return personService.getPerson(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void postPerson(@RequestBody Person person) {

        personService.put(person);

        log.info("person -> {}", personRepository.findAll());

    }

}
