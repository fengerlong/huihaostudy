package com.example.hitalesdemo.domain.redission;

import org.redisson.api.RAtomicLong;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedissionClientTest {

    @Autowired
    private RedissonClient redissonClient;

    public void test(){
        RAtomicLong test = redissonClient.getAtomicLong("test");
    }
}
