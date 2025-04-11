package com.bite.lotterysystem.dao.dataobject;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Shootingmemory
 * @create 2025-03-19-14:13
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserDO extends BaseDO {
    /**
     * 用户名
     */
    private String userName;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机号
     */
    private Encrypt phoneNumber;
    /**
     * 密码
     */
    private String password;
    /**
     * 身份信息
     */
    private String identity;
}