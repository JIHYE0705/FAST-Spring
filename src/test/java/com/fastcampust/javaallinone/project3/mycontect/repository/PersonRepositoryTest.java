package com.fastcampust.javaallinone.project3.mycontect.repository;


import com.fastcampust.javaallinone.project3.mycontect.domain.Person;
import com.fastcampust.javaallinone.project3.mycontect.domain.dto.Birthday;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Transactional
@SpringBootTest

class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test

    void crud(){
          Person person = new Person();
          person.setName("john");
          person.setAge(10);
          person.setBloodType("A");

          personRepository.save(person);


        List<Person> result = personRepository.findByName("john");

        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getName()).isEqualTo("john");
        assertThat(result.get(0).getAge()).isEqualTo(10);
        assertThat(result.get(0).getBloodType()).isEqualTo("A");


    }


   private void givenPerson(String name, int age, String bloodType){
        givenPerson(name,age,bloodType,null);
   }

    private void givenPerson(String name, int age, String bloodType, LocalDate birthday) {
        Person person = new Person(name, age, bloodType);
        person.setBirthday(new Birthday(birthday));

        personRepository.save(person);
    }

    @Test
    void findByBloodType(){

        List<Person> result = personRepository.findByBloodType("A");

        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getName()).isEqualTo("martin");
        assertThat(result.get(0).getName()).isEqualTo("benny");

    }

    @Test
    void findByBirthdayBetween() {

     List<Person> result = personRepository.findByMonthOfBirthday(8);

     assertThat(result.size()).isEqualTo(2);
     assertThat(result.get(0).getName()).isEqualTo("martin");
     assertThat(result.get(1).getName()).isEqualTo("sophia");

    }

}