package com.study.springcloud.service;

import com.study.springcloud.model.Person;

import java.util.List;
import java.util.Optional;

/**
 * Created by rmcodestar on 2019. 2. 12..
 */
public interface PersonService {
    List<Person> findAll();

    Optional<Person> find(long id);

    Person save(Person person);

    void remove(long id);
}
