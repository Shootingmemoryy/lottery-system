package com.bite.lotterysystem.controller.param;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @Shootingmemory
 * @create 2025-03-15-17:52
 */
@Data
public class UserRegisterParam implements Serializable {

    /**
     * 姓名
     */
    @NotBlank(message = "姓名不能为空！")
    private String name;

    /**
     * 邮箱
     */
    @NotBlank(message = "邮箱不能为空！")
    private String mail;

    /**
     * 电话
     */
    @NotBlank(message = "电话不能为空！")
    private String phoneNumber;

    /**
     * 密码
     */
    private String password;

    /**
     * 身份信息
     */
    @NotBlank(message = "身份信息不能为空！")
    private String identity;

}