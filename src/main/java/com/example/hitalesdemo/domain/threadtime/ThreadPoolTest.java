package com.example.hitalesdemo.domain.threadtime;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        int taskCount = 10;
        CountDownLatch latch = new CountDownLatch(taskCount);
        long startTime = System.currentTimeMillis();

        // 提交任务
        for (int i = 0; i < taskCount; i++) {
            threadPool.execute(() -> {
                try {
                    TimeInterval currTimer = DateUtil.timer();
                    // 模拟任务执行
                    Thread.sleep((long) (Math.random() * 1000));
                    System.out.println(Thread.currentThread().getName() + " 完成任务,任务耗时" + currTimer.intervalMs());
                    currTimer.clear();
                    latch.countDown();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        // 异步监控任务完成
        new Thread(() -> {
            try {
                latch.await(); // 等待任务完成
                long endTime = System.currentTimeMillis();
                System.out.println("所有任务完成，总耗时：" + (endTime - startTime) + "ms");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();

        System.out.println("主线程继续运行，不阻塞...");
        threadPool.shutdown();
    }
}
