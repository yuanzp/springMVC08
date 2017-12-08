package com.zhangguo.springmvc08.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/users")
public class UsersController {

    @RequestMapping(path = "/{name}",method = RequestMethod.GET)
    public String hello(@PathVariable String name){
        return "Hello "+name;
    }

    @RequestMapping(path = "/stu/{name}",method = RequestMethod.GET)
    public Student student(@PathVariable String name){
        return new Student("Hello "+name);
    }

}

/**学生*/
class Student{
    public Student(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
