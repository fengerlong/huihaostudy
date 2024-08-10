package com.example.hitalesdemo.api;

import com.example.hitalesdemo.domain.clazz.impl.DemoESImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private DemoESImpl demoES;

    @GetMapping("test")
    public String Test(){
        demoES.test("");
        return "test";
    }
}
