package com.fastcampust.javaallinone.project3.mycontect.service;

import com.fastcampust.javaallinone.project3.mycontect.repository.BlockRepository;
import com.fastcampust.javaallinone.project3.mycontect.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private BlockRepository blockRepository;

    @Test
    void getPeopleExcludeBlocks() {

    }

}