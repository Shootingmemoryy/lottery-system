package com.bite.lotterysystem.service.dto;


import com.bite.lotterysystem.service.enums.UserIdentityEnum;
import lombok.Data;

/**
 * @author: yibo
 */
@Data
public class UserLoginDTO {
    /**
     * JWT 令牌
     */
    private String token;

    /**
     * 登录人员身份
     */
    private UserIdentityEnum identity;
}
