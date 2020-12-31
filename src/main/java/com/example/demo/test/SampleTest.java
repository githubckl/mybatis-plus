package com.example.demo.test;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectAll() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }
    @Test
    public void testSave() {
        User user=new User();
        user.setId(6l);
        user.setAge(25);
        int insert = userMapper.insert(user);

    }
    @Test
    public void testUpdate() {
        User user=new User();
        user.setId(6l);
        user.setAge(27);
        int insert = userMapper.updateById(user);

    }@Test
    public void testDelete() {

        int insert = userMapper.deleteById(6l);

    }

}