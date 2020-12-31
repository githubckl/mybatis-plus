package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserMapper extends BaseMapper<User> {
    @Select("select * from user where name like #{name} and age < #{age}")
    List<User> selectByNameAndAge(@Param("name") String name, @Param("age") int age);

    @Select("SELECT\n" +
            "\t*\n" +
            "\t\n" +
            "FROM\n" +
            "\tUSER LEFT JOIN user_role on user.id=user_role.user_id\n" +
            "\tleft JOIN role on role.role_id=user_role.role_id")
    List<Map> selectUserRole();
}
