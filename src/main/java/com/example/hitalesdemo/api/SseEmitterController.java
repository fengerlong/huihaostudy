package com.example.hitalesdemo.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
public class SseEmitterController {

    @GetMapping("/streamsse")
    public SseEmitter streamSse() {
        SseEmitter emitter = new SseEmitter();

        // 异步推送数据
        new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    emitter.send("Message " + i);
                    Thread.sleep(1000); // 模拟延迟
                }
                emitter.complete(); // 完成后关闭连接
            } catch (Exception e) {
                emitter.completeWithError(e);
            }
        }).start();

        return emitter;
    }

}
