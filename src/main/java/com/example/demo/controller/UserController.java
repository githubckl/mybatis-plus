package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.User;
import com.example.demo.service.impl.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserImpl userimpl;

    @RequestMapping("selectByNameAndAge")
    List<User> selectByNameAndAge(String name, int age) {
        return userimpl.selectByNameAndAge("%" + name + "%", age);
    }

    @RequestMapping("selectPageVo")
    IPage<User> selectPageVo(int current, int size) {
        Page<User> page = new Page<User>(current, size);
        return userimpl.selectPage(page);
    }

    @RequestMapping("selectPageCondition")
//    select * from user where age <=21 order by id asc limit current,size
    Page<User> selectPageCondition(int current, int size) {
        Page<User> page = new Page<User>(current, size);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        return  userimpl.selectPageCondition(page,queryWrapper.le("age", 21).orderBy(true, false ,"id"));
    }
    @RequestMapping("selectUserRole")
    List<Map> selectUserRole(){
        return userimpl.selectUserRole();
    }

}
