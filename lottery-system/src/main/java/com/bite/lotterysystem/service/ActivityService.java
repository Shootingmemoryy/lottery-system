package com.bite.lotterysystem.service;

import com.bite.lotterysystem.controller.param.CreateActivityParam;
import com.bite.lotterysystem.controller.param.PageParam;
import com.bite.lotterysystem.service.dto.ActivityDTO;
import com.bite.lotterysystem.service.dto.ActivityDetailDTO;
import com.bite.lotterysystem.service.dto.CreateActivityDTO;
import com.bite.lotterysystem.service.dto.PageListDTO;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Shootingmemory
 * @create 2025-03-28-16:56
 */
@RestController
public interface ActivityService {

    /**
     * 创建活动
     *
     * @param param
     * @return
     */
    CreateActivityDTO createActivity(CreateActivityParam param);

    /**
     * 翻页查询活动(摘要)列表
     *
     * @param param
     * @return
     */
    PageListDTO<ActivityDTO> findActivityList(PageParam param);

    /**
     * 获取活动详细属性
     *
     * @param activityId
     * @return
     */
    ActivityDetailDTO getActivityDetail(Long activityId);

    /**
     * 缓存活动详细信息（读取表数据 在缓存）
     *
     * @param activityId
     */
    void cacheActivity(Long activityId);
}