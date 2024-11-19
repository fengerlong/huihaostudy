package com.example.hitalesdemo.domain.gson;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class Main {

    public static void main(String[] args) {
        Gson gson = new Gson();
        Son child = new Son();

        // 设置字段
        child.setHospitalName("Test Hospital");

        // 尝试序列化
        String jsonString = gson.toJson(child);
        System.out.println("Serialized JSON: " + jsonString);

        // 尝试反序列化
        String jsonInput = "{\"hospitalName\": \"Test Hospital\"}";

        try {
            Son deserializedChild = gson.fromJson(jsonInput, Son.class);
            System.out.println("Deserialized hospitalName: " + deserializedChild.getHospitalName());
        } catch (JsonSyntaxException e) {
            e.printStackTrace(); // 处理反序列化异常
        }
    }
}
