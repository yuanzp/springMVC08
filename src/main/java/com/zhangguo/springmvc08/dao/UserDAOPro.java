package com.zhangguo.springmvc08.dao;

import com.zhangguo.springmvc08.entity.User;
import com.zhangguo.springmvc08.utils.JDBCUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("mysql")
public class UserDAOPro implements IUserDAO {
    public List<User> getAll() {
        return JDBCUtil.queryForList("select id,name,birthday,address,phone from user", User.class);
    }

    public User getUserById(int id) {
        return JDBCUtil.queryForObject("select id,name,birthday,address,phone from user where id=?", User.class, id);
    }

    public boolean add(User user) {
        return JDBCUtil.update("insert into user(name,birthday,address,phone) values(?,?,?,?)", user.getName(), user.getBirthday(), user.getAddress(), user.getPhone()) > 0;
    }

    public boolean delete(int id) {
        return JDBCUtil.update("delete from user where id=?", id) > 0;
    }

    public boolean update(User user) {
        return JDBCUtil.update("update user set name=?,birthday=?,address=?,phone=? where id=?", user.getName(), user.getBirthday(), user.getAddress(), user.getPhone(), user.getId()) > 0;
    }
}
