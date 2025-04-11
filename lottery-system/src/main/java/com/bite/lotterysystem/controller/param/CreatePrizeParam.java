package com.bite.lotterysystem.controller.param;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Shootingmemory
 * @create 2025-03-27-16:56
 */
@Data
public class CreatePrizeParam {
    @NotBlank(message = "奖品名称不能为空")
    private String prizeName;
    @NotBlank(message = "奖品描述不能为空")
    private String description;
    @NotNull(message = "奖品价格不能为空")
    private BigDecimal price;
}
