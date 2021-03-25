package com.boot.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

/**
 * @author leochiu
 */
@Controller
public class RedisController {

    @Autowired
    StringRedisTemplate redisTemplate;

    @ResponseBody
    @RequestMapping("/test")
    public String test(){
        String value = LocalDateTime.now().toString();
        System.out.println("test value "+ LocalDateTime.now());
        String v2="v"+value;
        redisTemplate.opsForValue().set("name",v2);
        String name = redisTemplate.opsForValue().get("name");
        return name;
    }
}
