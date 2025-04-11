package com.bite.lotterysystem.service.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Shootingmemory
 * @create 2025-03-28-19:10
 */
@AllArgsConstructor
@Getter
public enum ActivityPrizeTiersEnum {

    FIRST_PRIZE(1, "一等奖"),

    SECOND_PRIZE(2, "二等奖"),

    THIRD_PRIZE(3, "三等奖");

    private final Integer code;

    private final String message;

    public static ActivityPrizeTiersEnum forName(String name) {
        for (ActivityPrizeTiersEnum activityPrizeTiersEnum : ActivityPrizeTiersEnum.values()) {
            if (activityPrizeTiersEnum.name().equalsIgnoreCase(name)) {
                return activityPrizeTiersEnum;
            }
        }
        return null;
    }

}