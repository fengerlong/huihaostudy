package com.example.hitalesdemo.domain.huaxi.enums;

import lombok.Getter;

/**
 *
 */
public enum QueryType {
    DAY(1, "天"),
    WEEK(2, "周"),
    MONTH(3, "月"),
    YEAR(4, "年"),
    ;
    @Getter
    private final Integer key;
    @Getter
    private final String desc;

    QueryType(int key, String description) {
        this.key = key;
        this.desc = description;
    }

}
