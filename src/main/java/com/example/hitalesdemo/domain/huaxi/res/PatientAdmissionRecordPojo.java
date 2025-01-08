package com.example.hitalesdemo.domain.huaxi.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientAdmissionRecordPojo {

    private String id;//	编号
    private String customerId;//医院组织机构代码
    private String empid;//患者主索引
    private String patientGuid;//	患者ID	是
    private String serialNumber;//	住院号	是
    private String caseNo;//病案号
    private String admissionCount;//住院次数
    private String admissionDepartmentCode;//入院科室代码	是
    private String admissionDepartment;//入院科室	是
    private String admissionAreaCode;//入院病区代码
    private String admissionArea;//入院病区名称
    private String admissionWard;//入院病房
    private String admissionWardCode;//入院病房代码
    private String admissionWay;//入院途径	是
    private String admissionBedCode;//入院床号		入院时床号
    private String currentBedCode;//当前床号		目前所在床号
    private String admissionCondition;//入院时病情	是
    private String admissionComplexion;//	入院情况		1.一般 2.紧急 3.危重 4.疑难。
    private String admissionDisease;//入院诊断	是
    private String admissionTime;//入院时间	是
    private String admissionDepartmentTime;//入科时间
    private String feeType;//	患者医疗付费方式	是	1.城镇职工 2.城镇居民 3.新农合 4.贫困救助 5.商业保险 6.全公费 7.全自费 8.其他社会保险 9.其他
    private String recordTime;//创建时间
    private String recordModifyTime;//	修改时间
    private String state;//状态		0.作废 1.有效


}
