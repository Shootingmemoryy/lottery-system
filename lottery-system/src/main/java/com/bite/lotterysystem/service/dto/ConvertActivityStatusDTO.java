package com.bite.lotterysystem.service.dto;

import com.bite.lotterysystem.service.enums.ActivityPrizeStatusEnum;
import com.bite.lotterysystem.service.enums.ActivityStatusEnum;
import com.bite.lotterysystem.service.enums.ActivityUserStatusEnum;
import lombok.Data;

import java.util.List;

/**
 * @Shootingmemory
 * @create 2025-03-31-16:19
 */
@Data
public class ConvertActivityStatusDTO {

    /**
     * 活动id
     */
    private Long activityId;

    /**
     * 活动目标状态
     */
    private ActivityStatusEnum targetActivityStatus;

    /**
     * 奖品id
     */
    private Long prizeId;

    /**
     * 奖品目标状态
     */
    private ActivityPrizeStatusEnum targetPrizeStatus;

    /**
     * 人员id列表
     */
    private List<Long> userIds;

    /**
     * 人员目标状态
     */
    private ActivityUserStatusEnum targetUserStatus;

}