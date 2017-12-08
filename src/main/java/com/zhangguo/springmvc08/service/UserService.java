package com.zhangguo.springmvc08.service;

import com.zhangguo.springmvc08.dao.IUserDAO;
import com.zhangguo.springmvc08.dao.UserDAO;
import com.zhangguo.springmvc08.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**用户业务*/
@Service
public class UserService {

    @Resource(name="mysql")
    IUserDAO userdao;

    public List<User> queryAllUsers(){
        return userdao.getAll();
    }

    public User getUserById(int id){
        return userdao.getUserById(id);
    }

    public boolean deleteUser(int id){
        return userdao.delete(id);
    }

    public  boolean addUser(User user){
        return userdao.add(user);
    }

    public boolean editUser(User user){
        return userdao.update(user);
    }

}
