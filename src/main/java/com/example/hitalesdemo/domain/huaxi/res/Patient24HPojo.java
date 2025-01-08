package com.example.hitalesdemo.domain.huaxi.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient24HPojo {

    private String id;//编号
    private String customerId;//医院组织机构代码
    private String empid;//患者主索引
    private String patientGuid;//患者ID	是
    private String serialNumber;//住院号	是(可以作为就诊号)
    private String motherNo;//母亲编号
    private String idCard;//身份证
    private String otherDocuments;//其他证件号
    private String insuranceCardId;//医保号
    private String insuranceType;//医保类型	是	ID类型选择：1城镇职工基本医疗保险、2新型农村合作医疗、3城镇居民基本医疗保险、4无 5 公疗医照
    private String patientName;//患者名字	是
    private String patientAge;//患者年龄	是
    private String patientAgeType;//年龄单位	是
    private String patientBirthDate;//出生日期	是
    private String patientNationality;//国籍
    private String patientNation;//民族
    private String patientGender;//性别	是	1.男，0.女
    private String Marital;//婚姻状态	是	0.未婚。1.已婚。3.离异。4.丧偶。9.其他
    private String pregnancy;//怀孕状态		0.未怀孕 。1.怀孕
    private String birthPlace;//籍贯
    private String presentPlace;//现住地
    private String Profession;//职业
    private String phone;//电话
    private String inHospital;//状态		0:出院，1:在院
    private String birthPlaceProvince;//出生地（省\直辖市）
    private String birthPlaceCity;//出生地（市）
    private String domicilePlaceProvince;//户口所在地（省\直辖市）
    private String domicilePlaceCity;//户口所在地（市）
    private String workUnitName;//现工作单位名称
    private String workAddress;//现工作地址
    private String workPhone;//现在工作单位联系方式（电话）
    private String contactsName;//联系人姓名
    private String contactsRelationship;//联系人关系
    private String contactsAddress;//	联系人地址
    private String contactsPhone;//	联系人电话
    private String recordTime;//	记录时间
    private String recordModifyTime;//修改时间
    private String Sourcetype;
    private String state;
    private String patNo;//登记号


}
