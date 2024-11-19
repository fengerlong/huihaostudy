package com.example.hitalesdemo.api.huaxi;

import com.example.hitalesdemo.domain.huaxi.pojo.OtPatientPojo;
import com.example.hitalesdemo.domain.huaxi.res.CommonRes;
import com.example.hitalesdemo.domain.huaxi.res.HistoryRes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 模拟华西的请求并创建mock数据
 */
@RestController
@RequestMapping("/huaxiapi/api/")
public class HuaXiDemoController {

    /**
     * 根据患者的就诊号获取所有的历史就诊号
     * @param admdr 患者的就诊号
     */
    @GetMapping("getHisAllAdmDr")
    public CommonRes<List<HistoryRes>> getHisAllAdmDr(@RequestParam(required = false) String admdr){
        ArrayList<HistoryRes> historyRes = new ArrayList<>();
        historyRes.add(new HistoryRes("1111"));
        historyRes.add(new HistoryRes("2222"));
        historyRes.add(new HistoryRes("3333"));
        return CommonRes.success(historyRes);
    }

    @GetMapping("getHisOtPatientReg")
    public CommonRes<List<OtPatientPojo>> getHisOtPatientReg(@RequestParam String admdr){
        List<OtPatientPojo> results = new ArrayList<>();
        OtPatientPojo record = new OtPatientPojo();
        results.add(record);
        record.setId(UUID.randomUUID().toString());
        record.setCustomerId("CUST12345");
        record.setEmpid("EMP123456");
        record.setPatientGuid(UUID.randomUUID().toString());
        record.setSerialNumber("SN123456");
        record.setVisitTimes("1");
        record.setPatientName("张三");
        record.setPatientGender("1"); // 男
        record.setPatientAge("30");
        record.setPatientBirthDate("1993-01-01");
        record.setPatientIdCard("123456789012345678");
        record.setMarital("1"); // 已婚
        record.setProfession("程序员");
        record.setPhone("12345678901");
        record.setBirthPlace("北京市");
        record.setWorkUnitName("某科技公司");
        record.setWpresentPlace("北京市朝阳区某小区");
        record.setSeeNo("10");
        record.setRegDatetime("2024-11-18 10:30:00");
        record.setRegDeptCode("DEPT001");
        record.setRegDeptName("内科");
        record.setVisitFlag("0"); // 初诊
        record.setRegType("1"); // 普通门诊
        record.setFeeType("1"); // 城镇职工
        record.setRegStatus("2"); // 已挂号
        record.setRegSource("0"); // 预约
        record.setRegFlag("0"); // 门诊
        record.setPatNo("PAT001");
        return CommonRes.success(results);
    }
}
