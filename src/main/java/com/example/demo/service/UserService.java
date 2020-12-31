package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<User> selectByNameAndAge(String name,int age);
    IPage<User> selectPage(Page<User> page);
    List<Map> selectUserRole();

    Page selectPageCondition(Page<User>page, QueryWrapper<User> wrapper);
}
