package com.example.hitalesdemo.api;

import com.example.hitalesdemo.domain.clazz.impl.DemoESImpl;
import com.example.hitalesdemo.domain.redission.RedissionClientTest;
import org.redisson.api.RAtomicLong;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private DemoESImpl demoES;

    @Autowired
    private RedissonClient redissonClient;

    @GetMapping("test")
    public String Test(){
//        demoES.test("");
        RAtomicLong test = redissonClient.getAtomicLong("test");
        long andIncrement = test.getAndIncrement();
        System.out.println(andIncrement);
        return "test";
    }
}
