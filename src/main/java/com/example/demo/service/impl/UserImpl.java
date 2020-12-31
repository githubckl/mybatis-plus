package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public List<User> selectByNameAndAge(String name,int age) {
        return userMapper.selectByNameAndAge(name,age);
    }

    @Override
    public IPage<User> selectPage(Page<User> page) {
        return userMapper.selectPage(page,null);
    }

    @Override
    public List<Map> selectUserRole() {
        return userMapper.selectUserRole();
    }

    @Override
    public Page<User> selectPageCondition(Page<User> page, QueryWrapper<User> wrapper) {
        return userMapper.selectPage(page,wrapper);
    }
}
