package com.bite.lotterysystem.controller.param;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Shootingmemory
 * @create 2025-03-28-16:35
 */
@Data
public class CreatePrizeByActivityParam implements Serializable {

    /**
     * 活动关联的奖品id
     */
    @NotNull(message = "活动关联的奖品id不能为空！")
    private Long prizeId;
    /**
     * 奖品数量
     */
    @NotNull(message = "奖品数量不能为空！")
    private Long prizeAmount;
    /**
     * 奖品等奖
     */
    @NotBlank(message = "奖品等奖不能为空！")
    private String prizeTiers;


}