package com.bite.lotterysystem.controller.param;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Shootingmemory
 * @create 2025-03-31-16:17
 */
@Data
public class ShowWinningRecordsParam implements Serializable {

    /**
     * 活动id
     */
    @NotNull(message = "活动id不能为空！")
    private Long activityId;

    /**
     * 奖品id
     */
    private Long prizeId;
}