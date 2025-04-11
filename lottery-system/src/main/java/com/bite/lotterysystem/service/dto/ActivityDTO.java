package com.bite.lotterysystem.service.dto;

import com.bite.lotterysystem.service.enums.ActivityStatusEnum;
import lombok.Data;

/**
 * @Shootingmemory
 * @create 2025-03-29-15:48
 */
@Data
public class ActivityDTO {
    /**
     * 活动id
     */
    private Long activityId;

    /**
     * 活动名称
     */
    private String activityName;

    /**
     * 活动描述
     */
    private String description;

    /**
     * 活动状态
     */
    private ActivityStatusEnum status;

    /**
     * 活动是否有效
     *
     * @return
     */
    public Boolean valid() {
        return status.equals(ActivityStatusEnum.RUNNING);
    }
}