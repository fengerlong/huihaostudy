package com.example.hitalesdemo.domain.huihao;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.BeanUtils;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Demo2 {

    public static void main(String[] args) throws JsonProcessingException {
        // 构造 Voice 列表
        CreateMedicalRequest.Voice voice1 = new CreateMedicalRequest.Voice();
        voice1.setFileKey("fileKey1");
        voice1.setText("患者主诉有咳嗽和发热");
        voice1.setSource("医生录音");

        CreateMedicalRequest.Voice voice2 = new CreateMedicalRequest.Voice();
        voice2.setFileKey("fileKey2");
        voice2.setText("患者既往病史无明显异常");
        voice2.setSource("医生录音");

        List<CreateMedicalRequest.Voice> voices = Arrays.asList(voice1, voice2);

        // 构造 MedicalCategory 示例
        MedicalCategory category = MedicalCategory.ANALYZE_REPORT;

        // 构造 CreateMedicalRequest
        CreateMedicalRequest request = new CreateMedicalRequest();
        request.setVoices(voices);
        request.setCategory(category);
        request.setVisitId("VISIT12345");
        request.setTemplateId(1001);
        request.setWindowValue(5);
        request.setWindowValueUnit(TimeUnit.MINUTES);
        request.setDepartmentName("内科");
        request.setPatientDepartmentName("呼吸科");
        TaskContext taskContext = JSON.parseObject(JSON.toJSONString(request), TaskContext.class);
        System.out.println(taskContext);
    }

    @Data
    @EqualsAndHashCode(callSuper=false)
    public static class CreateMedicalRequest{
        private List<Voice> voices;
        private MedicalCategory category;
        private String visitId;
        private Integer templateId;
        private Integer windowValue;
        private TimeUnit windowValueUnit;
        private String departmentName;
        private String patientDepartmentName;

        @Data
        public static class Voice {
            private String fileKey;
            private String text;
            private String source;
        }
    }
}
