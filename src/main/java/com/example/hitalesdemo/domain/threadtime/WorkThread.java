package com.example.hitalesdemo.domain.threadtime;

/**
 * 模拟线程的执行时间
 */
public class WorkThread extends Thread {

    @Override
    public void run() {
        try {
            super.run();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
