package com.example.hitalesdemo.domain.task;

public abstract class TaskAbs {

    protected final void abs(){
        System.out.println("开始前");
        doTask();
        System.out.println(this.getClass().getSimpleName());
        System.out.println("结束");
    }

    protected abstract void doTask();
}
