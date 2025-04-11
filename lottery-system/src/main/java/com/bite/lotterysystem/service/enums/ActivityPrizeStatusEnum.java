package com.bite.lotterysystem.service.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Shootingmemory
 * @create 2025-03-28-19:09
 */
@AllArgsConstructor
@Getter
public enum ActivityPrizeStatusEnum {
    INIT(1, "初始化"),

    COMPLETED(2, "已被抽取");


    private final Integer code;

    private final String message;

    public static ActivityPrizeStatusEnum forName(String name) {
        for (ActivityPrizeStatusEnum activityPrizeStatusEnum : ActivityPrizeStatusEnum.values()) {
            if (activityPrizeStatusEnum.name().equalsIgnoreCase(name)) {
                return activityPrizeStatusEnum;
            }
        }
        return null;
    }
}