package com.study.springcloud.repository;

import com.study.springcloud.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by rmcodestar on 2019. 2. 12..
 */
public interface PersonRepository extends MongoRepository<Person, Long> {
}
