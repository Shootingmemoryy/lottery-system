package com.bite.lotterysystem.dao.dataobject;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Shootingmemory
 * @create 2025-03-28-19:30
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ActivityUserDO extends BaseDO {

    /**
     * 关联的活动id
     */
    private Long activityId;

    /**
     * 关联的人员id
     */
    private Long userId;

    /**
     * 姓名
     */
    private String userName;

    /**
     * 关联的人员状态
     */
    private String status;


}