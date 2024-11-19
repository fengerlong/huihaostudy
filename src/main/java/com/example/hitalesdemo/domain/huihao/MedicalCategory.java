package com.example.hitalesdemo.domain.huihao;

import lombok.Getter;

public enum MedicalCategory {
    OUT_PATIENT(1,"门诊记录"),
    INITIAL(2,"首次病程记录",3),
    IN_PATIENT_IN(3,"入院记录",2),
    DAIL_COURSE (4,"日常病程记录"),
    OPERATIVE (5,"手术记录"),
    SPECIAL_COURSE (6,"特殊病程记录"),
    IN_PATIENT_OUT (7,"出院小结"),
    DEATH (8,"死亡记录"),
    MULTIPLE_ADMISSIONS (9,"再次或多次入院记录"),
    WARD_ROUNDS (10,"上级医生查房记录"),
    SHIFT_HANDOVER (11,"交接班记录"),
    TRANSFER (12,"转科记录"),
    STAGE_SUMMARY (13,"阶段小结记录"),
    RESCUE (14,"抢救记录"),
    TREATMENT_OPERATION (15,"有创诊疗操作记录"),
    PREOPERATIVE_SUMMARY (17,"术前小结"),
    DIFFICULT_DISCUSSION (18,"疑难病历讨论记录"),
    CONSULTATION (19,"会诊记录"),
    EMERGENCY_AMBULANCE (20,"急诊救护车"),
    DIALOGUE(60, "对话"),
    OCR_LABORATORY(61, "检验OCR"),
    OCR_EXAMINE(62, "检查OCR"),
    ADD_HEALTH_RECORD(63, "新增健康记录"),
    ANALYZE_REPORT(64, "分析报告"),
    HEALTH_ASSESSMENT(65, "健康评估"),
    DEEP_SEARCH(66, "深度搜索"),
    OCR(67, "OCR"),

    STOP_SSE(999, "sse终止")
    ;
    @Getter
    private Integer key;
    @Getter
    private String desc;
    @Getter
    private Integer sort;

    MedicalCategory(int key, String description) {
        this(key,description,key);
    }
    MedicalCategory(int key, String description,Integer sort) {
        this.key = key;
        this.desc = description;
        this.sort = sort;
    }

}
