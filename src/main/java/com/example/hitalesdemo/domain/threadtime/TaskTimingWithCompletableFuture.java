package com.example.hitalesdemo.domain.threadtime;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TaskTimingWithCompletableFuture {

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        int taskCount = 10;
        TimeInterval totalTime = DateUtil.timer();

        // 等待所有任务完成
        CompletableFuture.allOf(IntStream.range(0, taskCount)
                .mapToObj(i -> CompletableFuture.runAsync(() -> {
                    try {
                        TimeInterval currTimer = DateUtil.timer();
                        Thread.sleep((long) (Math.random() * 1000));
                        System.out.println(Thread.currentThread().getName() + " 完成任务,任务耗时" + currTimer.intervalMs());
                        currTimer.clear();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }, threadPool)).toArray(CompletableFuture[]::new)).thenRunAsync(() -> {
            System.out.println("所有任务完成，总耗时：" + totalTime.intervalMs());
            totalTime.clear();
        });

        System.out.println("主线程继续运行，不阻塞...");
    }
}
