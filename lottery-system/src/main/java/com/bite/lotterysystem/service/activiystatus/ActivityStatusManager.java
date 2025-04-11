package com.bite.lotterysystem.service.activiystatus;

import com.bite.lotterysystem.service.dto.ConvertActivityStatusDTO;

/**
 * @Shootingmemory
 * @create 2025-03-31-22:59
 */
public interface ActivityStatusManager {

    /**
     * 处理活动相关状态转换
     *
     * @param convertActivityStatusDTO
     */
    void handlerEvent(ConvertActivityStatusDTO convertActivityStatusDTO);


    /**
     * 回滚处理活动相关状态
     *
     * @param convertActivityStatusDTO
     */
    void rollbackHandlerEvent(ConvertActivityStatusDTO convertActivityStatusDTO);

}