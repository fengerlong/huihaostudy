package com.example.hitalesdemo.domain.huaxi.res;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 统一返回
 * @param <T>
 */
@Data
@AllArgsConstructor
public class CommonRes<T> {

    private String code;

    private T data;

    public static <T> CommonRes<T> success(T data) {
        return new CommonRes<>("0", data);
    }
}
