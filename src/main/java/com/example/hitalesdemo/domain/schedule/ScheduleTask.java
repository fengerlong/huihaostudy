package com.example.hitalesdemo.domain.schedule;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.*;

@Data
@Component
public class ScheduleTask {

    public static final ThreadPoolExecutor threadPoolExecutor =
            new ThreadPoolExecutor(100, 100, 0, TimeUnit.SECONDS
                    , new LinkedBlockingQueue<>(100000));

//    @PostConstruct
//    @Scheduled(cron = "#{@scheduleTask.cronExpression}")
    public void executeTask() {
        System.out.println("Task executed at: " + System.currentTimeMillis());

        Future<?> future = threadPoolExecutor.submit(() -> {
            try {
                Random random = new Random();
                int i = random.nextInt(15);
                System.out.println(i);
                Thread.sleep(i * 1000L);
                System.out.println("Task completed successfully!");
            } catch (InterruptedException e) {
                System.out.println("Task was interrupted!");
            }
        });

        // 超时检查逻辑
        try {
            long timeToMidnight = calculateTimeToMidnight();
            future.get(timeToMidnight, TimeUnit.MILLISECONDS); // 等待任务完成或超时
        } catch (TimeoutException e) {
            System.out.println("Timeout reached before task completed.");
            future.cancel(true); // 超时中断任务
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Task ended at: " + System.currentTimeMillis());
        }
    }

    // 计算距离午夜的时间（毫秒）
    private long calculateTimeToMidnight() {
//        long currentMillis = System.currentTimeMillis();
//        long midnightMillis = currentMillis - (currentMillis % (24 * 60 * 60 * 1000)) + (6 * 60 * 60 * 1000);
//        return midnightMillis - currentMillis;
        return 9000L;
    }
}
