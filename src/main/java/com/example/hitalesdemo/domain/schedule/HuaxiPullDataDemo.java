package com.example.hitalesdemo.domain.schedule;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 华西拉取数据的模拟效果
 */
@Slf4j
@Component
public class HuaxiPullDataDemo {

    public static final ThreadPoolExecutor threadPoolExecutor =
            new ThreadPoolExecutor(100, 100, 0, TimeUnit.SECONDS
                    , new LinkedBlockingQueue<>(100000));

//    @Scheduled(cron = "#{@huaXiPullDataTimingConfig.huaXiPullDataTiming.taskCron}")
    public void backPullTiming() {
        //模拟华西的24小时内返回的患者数据，现在假设返回了200个患者
        Set<String> admStrList = generateRandomSet(200);
        admStrList.forEach(patientAdmStr -> {
            //开启一个异步线程去获取患者的数据信息
            CompletableFuture.runAsync(() -> {
                //再模拟获取到了这些患者的就诊号
                Set<String> strings = generateRandomSet(1);
                strings.forEach(admstr ->{
                    log.info("开始对{}就诊号进行数据拉取",patientAdmStr);
                    TimeInterval totalTimer = DateUtil.timer();
                    //模拟获取患者的所有的就诊号
                    Set<String> historyVisitIds = generateRandomSet(20);
                    if (CollUtil.isNotEmpty(historyVisitIds)) {
                        CompletableFuture.allOf(historyVisitIds.stream().map(hisId -> singlePullDataAsync(hisId, 9000)).toArray(CompletableFuture[]::new)).thenRunAsync(() ->{
                            log.info("就诊号:{}，就诊号拉取数据累计耗时:{}ms", admstr, totalTimer.intervalMs());
                            totalTimer.clear();
                        });
                    }
                });
            }, threadPoolExecutor).completeOnTimeout(null,9000,TimeUnit.MICROSECONDS);
        });
    }

    private CompletableFuture<Void> singlePullDataAsync(String admStr, Integer timeoOut){
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                TimeInterval currTimer = DateUtil.timer();
                Random random = new Random();
                int i = random.nextInt(15);
                System.out.println("模拟实际处理的时间"+i);
                Thread.sleep(i * 1000L);
                log.info("就诊号:{}，单个就诊号拉取数据总-耗时:{}ms", admStr, currTimer.intervalMs());
                currTimer.clear();
            } catch (Exception exception) {
                log.error("拉取患者数据错误,就诊号:{}", admStr, exception);
            }
        }, threadPoolExecutor);
        if(timeoOut != null){
            future.completeOnTimeout(null, timeoOut, TimeUnit.MICROSECONDS);
            log.error("就诊号{}拉取时间超时", admStr);
        }
        return future;
    }

    public static Set<String> generateRandomSet(int count) {
        Set<String> resultSet = new HashSet<>();
        Random random = new Random();

        while (resultSet.size() < count) {
            // 生成随机字符串
            String randomString = generateRandomString(random, 10); // 长度为10
            resultSet.add(randomString);
        }

        return resultSet;
    }

    private static String generateRandomString(Random random, int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }

        return sb.toString();
    }
}
