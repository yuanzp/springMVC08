package com.zhangguo.springmvc08.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.zhangguo.springmvc08.entity.User;
import com.zhangguo.springmvc08.service.UserService;
import com.zhangguo.springmvc08.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.text.SimpleDateFormat;

@Controller  //声明为控制器
@RequestMapping(path = "/user")  //请求映射
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(path = "/index")  //请求映射
    public String index(Model model){
        model.addAttribute("list",userService.queryAllUsers());
        return "user/index";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        userService.deleteUser(id);
        return "redirect:/user/index";
    }

    @RequestMapping("/add")
    public String add(){
        return "user/add";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(User user){
        userService.addUser(user);
        return "redirect:/user/index";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable int id,Model model){
        model.addAttribute("user",userService.getUserById(id));
        return "user/edit";
    }

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String edit(User user){
        userService.editUser(user);
        return "redirect:/user/index";
    }

    @RequestMapping(value = "/users")
    public ModelAndView users(){
        ModelAndView mav=new ModelAndView(new MappingJackson2JsonView());
        mav.addObject(userService.queryAllUsers());
        return mav;
    }

    @RequestMapping(value = "/userJson",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String userJson(){
        return JsonUtil.getJson(userService.queryAllUsers(),"yyyy-MM-dd");
    }

}
