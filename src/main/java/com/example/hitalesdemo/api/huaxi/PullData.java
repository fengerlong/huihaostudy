package com.example.hitalesdemo.api.huaxi;

import com.example.hitalesdemo.domain.huaxi.res.PullDataStatePojo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/huaxi/operation")
public class PullData {


    /**
     * 拉取24小内在院患者信息
     *
     * @param admStr 就诊号
     */
    @GetMapping("/pullData")
    public void pullData(@RequestParam("admStr") String admStr) throws InterruptedException {
    }

    /**
     * 查询处理状态的接口
     *
     * @param admStr 就诊号
     * @return PullDataStatePojo.PullDataState
     */
    @GetMapping("/getPullDataState")
    public PullDataStatePojo.PullDataState getPullDataState(@RequestParam("admStr") String admStr) {
        return new PullDataStatePojo.PullDataState(0);
    }
}