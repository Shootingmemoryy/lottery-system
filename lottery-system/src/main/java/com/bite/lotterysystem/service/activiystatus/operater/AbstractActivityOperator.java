package com.bite.lotterysystem.service.activiystatus.operater;

import com.bite.lotterysystem.service.dto.ConvertActivityStatusDTO;

/**
 * @Shootingmemory
 * @create 2025-03-31-22:59
 */
public abstract class AbstractActivityOperator {

    /**
     * 控制处理顺序
     *
     * @return
     */
    public abstract Integer sequence();

    /**
     * 是否需要转换
     *
     * @param convertActivityStatusDTO
     * @return
     */
    public abstract Boolean needConvert(ConvertActivityStatusDTO convertActivityStatusDTO);

    /**
     * 转换方法
     *
     * @param convertActivityStatusDTO
     * @return
     */
    public abstract Boolean convert(ConvertActivityStatusDTO convertActivityStatusDTO);

}