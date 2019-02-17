package com.study.springcloud.service;

import com.study.springcloud.model.Person;
import com.study.springcloud.repository.PersonRepository;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by rmcodestar on 2019. 2. 12..
 */
@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> findAll() {
        return (List<Person>) personRepository.findAll();
    }

    @Override
    public Optional<Person> find(long id) {
        Counter clickCounter = Metrics.counter("person.find.click");
        clickCounter.increment();
        return personRepository.findById(id);
    }

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }

    @Override
    public void remove(long id) {
        personRepository.deleteById(id);
    }
}
