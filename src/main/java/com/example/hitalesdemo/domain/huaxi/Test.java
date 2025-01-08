package com.example.hitalesdemo.domain.huaxi;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Test {

    public static final ThreadPoolExecutor threadPoolExecutor =
            new ThreadPoolExecutor(100, 200, 0, TimeUnit.SECONDS
                    , new LinkedBlockingQueue<>(100000));

    public static void main(String[] args) throws InterruptedException {
        test();
    }

    public static void test(){
        ArrayList<Integer> admStrList = new ArrayList(){{add(1);}};
        if (CollUtil.isNotEmpty(admStrList)) {
            CompletableFuture.allOf(
                            admStrList.stream()
                                    .map(patientAdmStr -> CompletableFuture.runAsync(Test::test1,threadPoolExecutor))
                                    .toArray(CompletableFuture[]::new))
                    .thenRunAsync(() -> System.out.println("执行完毕"));
        }
    }

    public static void test1(){
        for (int i = 0; i < 5000; i++) {
            singlePullDataAsync(i);
        }
    }

    private static CompletableFuture<Void> singlePullDataAsync(int i){
        return CompletableFuture.runAsync(() -> {
            TimeInterval currTimer = DateUtil.timer();
            try {
                System.out.println("活跃线程数量"+threadPoolExecutor.getActiveCount());
                System.out.println("队列大小"+threadPoolExecutor.getQueue().size());
                log.info(String.valueOf(i));
                System.out.println(i);
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            currTimer.clear();
        },threadPoolExecutor);
    }
}
