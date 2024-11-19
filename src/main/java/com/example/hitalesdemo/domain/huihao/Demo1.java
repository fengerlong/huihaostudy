package com.example.hitalesdemo.domain.huihao;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;

public class Demo1 {

    public static void main(String[] args) {
        TimeInterval timer = DateUtil.timer();
        System.out.println(timer.intervalMs());
    }
}
