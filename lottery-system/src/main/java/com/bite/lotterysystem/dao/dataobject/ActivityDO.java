package com.bite.lotterysystem.dao.dataobject;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Shootingmemory
 * @create 2025-03-28-18:37
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ActivityDO extends BaseDO {

    private String activityName;

    private String description;

    private String status;


}