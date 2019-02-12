package com.study.springcloud.contoller;

import com.study.springcloud.model.Person;
import com.study.springcloud.service.PersonService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ExampleProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by rmcodestar on 2019. 2. 12..
 */
@RestController
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("/person")
    @ApiOperation(value = "모든 회원 조회")
    public List<Person> findAll() {
        return personService.findAll();
    }

    @GetMapping("/person/{id}")
    @ApiOperation(value = "id로 회원 조회")
    @ApiImplicitParam(name = "id", value = "회원 고유키", required = true, dataType = "long", paramType = "path")
    public Person findById(@PathVariable Long id) {
        return personService.find(id).get();
    }

    @PostMapping("/person")
    @ApiOperation(value = "회원 추가")
    @ApiImplicitParam(name = "person"
            , dataType = "Person"
            , value = "추가할 회원"
            , examples = @io.swagger.annotations.Example(
            value = {
                    @ExampleProperty(value = "{'snapshot'：{'type': 'AAA'}}", mediaType = "application/json")
            }))
    public Person add(@RequestBody Person person) {
        return personService.save(person);
    }

    @PutMapping("/person")
    @ApiOperation(value = "회원 수정")
    public Person modify(@RequestBody Person person) {
        return personService.save(person);
    }

    @DeleteMapping("/person/{id}")
    @ApiOperation(value = "회원 삭제")
    @ApiImplicitParams(@ApiImplicitParam(name = "id", value = "회원 고유키", required = true, dataType = "long", paramType = "path"))
    public void delete(@PathVariable Long id) {
        personService.remove(id);
    }
}
