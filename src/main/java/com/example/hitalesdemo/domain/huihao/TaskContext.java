package com.example.hitalesdemo.domain.huihao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskContext {

    private List<Voice> voices;
    private MedicalCategory category;
    private String visitId;
    private Integer userId;
    private String docId;
    private Long startTime;
    private Integer windowValue;
    private TimeUnit windowValueUnit;
    private Integer templateId;
    private String doctorDepartmentName;
    private String patientDepartmentName;
    private Long beginTime;
    private Integer queueId;
    private String uuid;

    private List<String> examineReports;
    private List<String> laboratoryReports;

    @Data
    public static class Voice{
        private String fileKey;
        private String text;
        private String source;
    }
}
