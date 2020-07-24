package com.springboot.restful.Mybatis.DAO;

import com.springboot.restful.Mybatis.Bean.User;
import org.apache.ibatis.annotations.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserDao {
    @Select("SELECT * FROM user WHERE name = #{name}")
    User findUserByName(@Param("name") String name);

    @Select("SELECT * FROM user")
    List<User> findAllUser();

    //插入
    @Insert("INSERT INTO user(name,age,money) VALUES(#{name},#{age},#{money})" )
    void InsertUserInfo(@Param("name") String name,@Param("age") int age,@Param("money") double money);

    //根据id更新
    @Update("UPDATE user SET name  = #{name} WHERE id = #{id}")
    User updateUserNameById(@Param("name") String name,@Param("id") int id);
    //根据id 删除
    @Delete("DELETE FROM user WHERE id = #{id}")
    void deleteUserById(@Param("id") int id);

}
