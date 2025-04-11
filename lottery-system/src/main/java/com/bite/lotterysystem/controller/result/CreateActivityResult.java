package com.bite.lotterysystem.controller.result;

import lombok.Data;

import java.io.Serializable;

/**
 * @Shootingmemory
 * @create 2025-03-28-17:02
 */
@Data
public class CreateActivityResult implements Serializable {

    /**
     * 创建的活动id
     */
    private Long activityId;

}