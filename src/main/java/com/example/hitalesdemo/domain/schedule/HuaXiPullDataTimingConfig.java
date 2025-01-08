package com.example.hitalesdemo.domain.schedule;

import lombok.Data;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@EnableConfigurationProperties(HuaXiPullDataTiming.class)
public class HuaXiPullDataTimingConfig {

    private final HuaXiPullDataTiming huaXiPullDataTiming;

    public HuaXiPullDataTimingConfig(HuaXiPullDataTiming huaXiPullDataTiming) {
        this.huaXiPullDataTiming = huaXiPullDataTiming;
    }
}
