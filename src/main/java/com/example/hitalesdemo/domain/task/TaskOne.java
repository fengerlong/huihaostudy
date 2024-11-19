package com.example.hitalesdemo.domain.task;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TaskOne extends TaskAbs{

    @PostConstruct
    public void init(){
        abs();
    }

    @Override
    protected void doTask() {
        System.out.println("TaskOne");
    }
}
