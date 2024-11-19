package com.example.hitalesdemo.domain.huaxi.pojo;

import lombok.Data;

@Data
public class OtPatientPojo {

    private String id;//编号
    private String customerId;//医院组织机构代码
    private String empid;//患者主索引
    private String patientGuid;//患者编号	是
    private String serialNumber;//就诊号	是
    private String visitTimes;//	就诊次	是
    private String patientName;//	姓名	是
    private String patientGender;//性别	是	0.女。1.男。2.其他
    private String patientAge;//年龄	是
    private String patientBirthDate;//出生日期	是
    private String patientIdCard;//身份证号
    private String marital;//婚姻状态		0.未婚。1.已婚。3.离异。4.丧偶。9.其他
    private String profession;//职业
    private String phone;//电话
    private String birthPlace;//	籍贯
    private String workUnitName;//	工作单位
    private String wpresentPlace;//	家庭住址
    private String seeNo;//看诊序号	是
    private String regDatetime;//挂号时间	是
    private String regDeptCode;//挂号科室代码	是
    private String regDeptName;//挂号科室名称	是
    private String visitFlag;//	初复诊标志	是	0 初诊  1 复诊
    private String regType;//挂号类别	是	1.普通门诊。2.专家门诊。3.专科门诊，4.传染病门诊。5.急诊. 6其他
    private String feeType;//费用类别	是	1.城镇职工。2.城镇居民。3.新农合。4.贫困救助。5.商业保险。6.全公费。7.全自费。8.其他社会保险。9.其他
    private String regStatus;//挂号状态		1.已预约。2.已挂号。3.已签到。4.已就诊。5.已退号
    private String regSource;//	挂号来源	是	0.预约，1普通
    private String regFlag;//	门急诊标志   	是	0门诊  1急诊
    private String patNo;//登记号
}
