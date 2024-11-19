package com.example.hitalesdemo.domain.task;

import org.springframework.stereotype.Component;

@Component
public class TaskTwo extends TaskAbs{

    @Override
    protected void doTask() {
        System.out.println("TaskTwo");
    }
}
