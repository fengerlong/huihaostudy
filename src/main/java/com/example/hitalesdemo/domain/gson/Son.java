package com.example.hitalesdemo.domain.gson;

import lombok.Data;

@Data
public class Son extends Parent{

    private String hospitalName; // 子类字段

    // Getter 和 Setter
    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }
}
