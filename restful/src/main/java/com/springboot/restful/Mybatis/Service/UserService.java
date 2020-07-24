package com.springboot.restful.Mybatis.Service;

import com.springboot.restful.Mybatis.Bean.User;
import com.springboot.restful.Mybatis.DAO.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    //根据name查找用户
    public User findUserByName(String name){
        return userDao.findUserByName(name);
    }
    //查找所有用户
    public List<User> findAllUsers(){
        return userDao.findAllUser();
    }
    //插入用户
    public void insertService() {
        userDao.InsertUserInfo("SnailClimb", 22, 3000.0);
        userDao.InsertUserInfo("Daisy", 19, 3000.0);
    }
    //更新用户
    public User updateUser(String name,int id){
        return userDao.updateUserNameById(name,id);
    }
    //删除用户
    public void deleteUser(int id){
        userDao.deleteUserById(id);
    }
    //模拟事物,加上了注解的话，如果失败了，则不会改变任何数据
    @Transactional
    public void transferMoney(){
        userDao.updateUserNameById("yingjie",1);

    }
}
