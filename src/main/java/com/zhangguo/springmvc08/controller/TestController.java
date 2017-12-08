package com.zhangguo.springmvc08.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhangguo.springmvc08.entity.User;
import com.zhangguo.springmvc08.service.UserService;
import jdk.nashorn.internal.parser.JSONParser;
import org.apache.taglibs.standard.lang.jstl.BooleanLiteral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  //声明为控制器
@RequestMapping(path = "/test")  //请求映射
public class TestController {

    @Autowired
    UserService userService;

    @RequestMapping(path = "/")
    public List<User> index(){
        return userService.queryAllUsers();
    }

    @RequestMapping(path = "/{id}")
    public User index(@PathVariable int id){
        return userService.getUserById(id);
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public boolean add(@RequestBody User user){
        return userService.addUser(user);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public boolean delete(@PathVariable int id){
       return userService.deleteUser(id);
    }

    @RequestMapping(value = "/",method = RequestMethod.PUT)
    public boolean edit(@RequestBody User user){
        return userService.editUser(user);
    }

}
