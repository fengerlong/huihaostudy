package com.example.hitalesdemo.api.huaxi;

import com.example.hitalesdemo.domain.huaxi.pojo.OtPatientPojo;
import com.example.hitalesdemo.domain.huaxi.res.CommonRes;
import com.example.hitalesdemo.domain.huaxi.res.HistoryRes;
import com.example.hitalesdemo.domain.huaxi.res.Patient24HPojo;
import com.example.hitalesdemo.domain.huaxi.res.PatientAdmissionRecordPojo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;

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
        for (int i = 1; i <= 5000; i++) {
            String value = String.format("%04d", i); // 格式化数字为4位，前面补零
            historyRes.add(new HistoryRes(value));
            System.out.println(value);// 将新的 HistoryRes 对象添加到集合中
        }
        return CommonRes.success(historyRes);
    }

    /**
     * 获取24小时内的患者数据
     */
    @GetMapping("hisMtPatientInfo")
    public CommonRes<List<Patient24HPojo>> getHisAllAdmDr(){
        List<Patient24HPojo> mockData = Arrays.asList(
                new Patient24HPojo(
                        "1", "H001", "E001", "PG001", "S001", "M001",
                        "123456789012345678", "OD001", "IC001", "1",
                        "张三", "30", "岁", "1993-01-01", "中国", "汉族", "1",
                        "1", "否", "北京市", "上海市", "工程师", "13800138000",
                        "1", "北京市", "北京市", "上海市", "上海市", "某科技公司",
                        "上海市浦东新区张江高科技园", "021-12345678", "李四", "朋友",
                        "上海市浦东新区", "13812345678", "2024-11-18 12:00:00",
                        "2024-11-18 15:00:00", "ES", "有效", "DN001"
                ),
                new Patient24HPojo(
                        "2", "H002", "E002", "PG002", "S002", "M002",
                        "987654321098765432", "OD002", "IC002", "2",
                        "李四", "25", "岁", "1998-05-10", "中国", "壮族", "0",
                        "0", "是", "广西", "深圳市", "教师", "13888888888",
                        "1", "广西", "南宁市", "广东省", "深圳市", "某教育机构",
                        "深圳市南山区科技园", "0755-87654321", "王五", "亲属",
                        "深圳市南山区", "13999999999", "2024-11-17 08:30:00",
                        "2024-11-18 09:45:00", "DB", "有效", "DN002"
                )
        );
        return CommonRes.success(mockData);
    }

    /**
     * 获取患者的入院信息
     */
    @GetMapping("getHisPatientAdmissionRecord")
    public CommonRes<List<PatientAdmissionRecordPojo>> getPatientAdmissionRecordPojo(){
        List<PatientAdmissionRecordPojo> mockAdmissionRecords = Arrays.asList(
                new PatientAdmissionRecordPojo(
                        "101", "H001", "E001", "PG001", "INP20241234", "C001",
                        "1", "D001", "呼吸内科", "A001", "第一病区", "病房1",
                        "W001", "门诊", "B001", "C001", "轻", "1", "肺炎",
                        "2024-11-10 08:00:00", "2024-11-10 09:00:00", "1",
                        "2024-11-18 12:00:00", "2024-11-18 15:00:00", "1"
                ),
                new PatientAdmissionRecordPojo(
                        "102", "H002", "E002", "PG002", "INP20241234", "C002",
                        "2", "D002", "呼吸内科", "A002", "第二病区", "病房2",
                        "W002", "急诊", "B002", "C002", "重", "2", "骨折",
                        "2024-11-12 14:30:00", "2024-11-12 15:00:00", "2",
                        "2024-11-18 08:30:00", "2024-11-18 09:45:00", "1"
                )
        );
        return CommonRes.success(mockAdmissionRecords);
    }


    /**
     * 24小时入院
     * @param admstr
     * @return
     */
    @GetMapping("getHisMtPatientInfoFix")
    public CommonRes<List<Patient24HPojo>> getHisMtPatientInfoFix(@RequestParam String admstr){
        List<Patient24HPojo> result = new ArrayList<>();
        Patient24HPojo patient = new Patient24HPojo();
        // 基本信息
        patient.setId(UUID.randomUUID().toString());
        patient.setCustomerId("HOSP123456");
        patient.setEmpid("EMP987654");
        patient.setPatientGuid(UUID.randomUUID().toString());
        patient.setSerialNumber("INP20241234");
        patient.setMotherNo("MOM567890");
        patient.setIdCard("123456199001015678");
        patient.setOtherDocuments("DOC99887766");
        patient.setInsuranceCardId("INS3456789");
        patient.setInsuranceType("1"); // 城镇职工基本医疗保险

        // 患者信息
        patient.setPatientName("张三");
        patient.setPatientAge("34");
        patient.setPatientAgeType("岁");
        patient.setPatientBirthDate("1990-01-01");
        patient.setPatientNationality("中国");
        patient.setPatientNation("汉族");
        patient.setPatientGender("1"); // 男
        patient.setMarital("1"); // 已婚
        patient.setPregnancy("0"); // 未怀孕
        patient.setBirthPlace("北京市");
        patient.setPresentPlace("北京市朝阳区");
        patient.setProfession("工程师");
        patient.setPhone("13800138000");

        // 状态信息
        patient.setInHospital("1"); // 在院
        patient.setBirthPlaceProvince("北京市");
        patient.setBirthPlaceCity("北京市");
        patient.setDomicilePlaceProvince("北京市");
        patient.setDomicilePlaceCity("北京市");

        // 工作信息
        patient.setWorkUnitName("某科技公司");
        patient.setWorkAddress("北京市海淀区中关村");
        patient.setWorkPhone("010-12345678");

        // 联系人信息
        patient.setContactsName("李四");
        patient.setContactsRelationship("兄弟");
        patient.setContactsAddress("北京市丰台区");
        patient.setContactsPhone("13800138111");

        // 记录信息
        String currentTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        patient.setRecordTime(currentTime);
        patient.setRecordModifyTime(currentTime);

        // 其他信息
        patient.setSourcetype("系统录入");
        patient.setState("有效");
        patient.setPatNo("REG2024123456");

        // 打印患者信息
        result.add(patient);

        return CommonRes.success(result);
    }

    @GetMapping("getHisOtPatientReg")
    public CommonRes<List<OtPatientPojo>> getHisOtPatientReg(@RequestParam String admstr){
        if("111".equals(admstr)){
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
            record.setRegDatetime("2021-11-18 10:30:00");
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
        return CommonRes.success(Collections.EMPTY_LIST);
    }
}
