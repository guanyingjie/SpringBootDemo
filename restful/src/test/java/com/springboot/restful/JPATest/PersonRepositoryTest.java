package com.springboot.restful.JPATest;

import com.springboot.restful.Domain.Entity.Person;
import com.springboot.restful.Domain.Repository.PersonRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PersonRepositoryTest {
    @Autowired
    private PersonRepository personRepository;
    private Long id;

    @Before
    private void setUp(){
        assertNotNull(personRepository);
        Person person = new Person();
        Person savedperson = personRepository.saveAndFlush(person);
        savedperson.setName("updateName");
        personRepository.save(savedperson);
        id = savedperson.getId();
    }

    @Test
    public void should_return_person(){
        Optional<Person>person = personRepository.findById(id);
        assertTrue(person.isPresent());
        assertEquals("Angie",person.get().getName());
        assertEquals(Integer.valueOf(22),person.get().getAge());

        List<Person> personList = personRepository.findByAgeGreaterThan(18);
        assertEquals(1,personList.size());
        personRepository.deleteAll();
    }

    @Test
    public void test_person_through(){
        Optional<Person>person = personRepository.findByNameQuery("Angie");
        assertTrue(person.isPresent());
        assertEquals("Angie",person.get().getName());
        assertEquals("22",person.get().getAge());
        System.out.println(id);
        personRepository.updatePersonNameById("yingjie",id);
        Optional<Person>update = personRepository.findByNameQuery("yingjie");
        assertTrue(update.isPresent());
        personRepository.deleteAll();

    }



}
