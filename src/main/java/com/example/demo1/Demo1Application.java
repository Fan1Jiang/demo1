package com.example.demo1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@SpringBootApplication
@RestController
@RequestMapping("/index")
@MapperScan("com.example.demo1.mapper")
public class Demo1Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }
    /**
     * hello
     * @return
     */
    @RequestMapping("/hello")
    public String hello(){
        return "Hello World";
    }


    @PostMapping
    public String post(@RequestBody Map<String, String>map) {
        System.out.printf(map.toString());
        return "POST请求接受成功";
    }
    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @RequestBody Map<String, String> map) {
        System.out.printf("ID=%s, name=%s\n", id, map);
        return "PUT请求接受成功";
    }









}


