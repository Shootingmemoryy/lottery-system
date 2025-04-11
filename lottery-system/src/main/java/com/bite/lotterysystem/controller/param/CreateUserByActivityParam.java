package com.bite.lotterysystem.controller.param;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Shootingmemory
 * @create 2025-03-28-16:36
 */
@Data
public class CreateUserByActivityParam implements Serializable {

    /**
     * 活动关联的人员id
     */
    @NotNull(message = "活动关联的人员id不能为空！")
    private Long userId;
    /**
     * 姓名
     */
    @NotBlank(message = "姓名不能为空！")
    private String userName;

}