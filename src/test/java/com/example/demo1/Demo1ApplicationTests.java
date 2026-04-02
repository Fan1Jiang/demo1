package com.example.demo1;

import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.example.demo1.entity.User;
import com.example.demo1.mapper.UserMapper;
import com.example.demo1.service.UserService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class Demo1ApplicationTests {

    @Resource
    private UserMapper userMapper;
    @Resource
    private UserService userService;

    @Test
    public void contextLoads() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.isTrue(5 == userList.size(), "");
        userList.forEach(System.out::println);
    }
    @Test
    void contextService() {
        List<User>userList = userService.list();
        userList.forEach(System.out::println);
    }

}