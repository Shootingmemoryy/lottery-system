package com.bite.lotterysystem.service.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Shootingmemory
 * @create 2025-03-28-19:08
 */
@AllArgsConstructor
@Getter
public enum ActivityUserStatusEnum {

    INIT(1, "初始化"),

    COMPLETED(2, "已被抽取");


    private final Integer code;

    private final String message;

    public static ActivityUserStatusEnum forName(String name) {
        for (ActivityUserStatusEnum activityUserStatusEnum : ActivityUserStatusEnum.values()) {
            if (activityUserStatusEnum.name().equalsIgnoreCase(name)) {
                return activityUserStatusEnum;
            }
        }
        return null;
    }


}