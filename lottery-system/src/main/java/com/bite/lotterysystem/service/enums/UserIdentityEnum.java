package com.bite.lotterysystem.service.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Shootingmemory
 * @create 2025-03-19-23:55
 */
@Getter
@AllArgsConstructor
public enum UserIdentityEnum  {
    ADMIN("管理员"),
    NORMAL("普通用户");

    private final String massage;
     
    public static UserIdentityEnum forName(String name){
        for (UserIdentityEnum userIdentityEnum : UserIdentityEnum.values()) {
            if(userIdentityEnum.name().equalsIgnoreCase(name)){
                return userIdentityEnum;
            }
        }
        return null;
    }
}
