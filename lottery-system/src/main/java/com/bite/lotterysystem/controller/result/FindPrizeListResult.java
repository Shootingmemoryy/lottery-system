package com.bite.lotterysystem.controller.result;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Shootingmemory
 * @create 2025-03-28-12:29
 */
@Data
public class FindPrizeListResult implements Serializable {

    /**
     * 总量
     */
    private Integer total;

    /**
     * 当前列表
     */
    private List<PrizeInfo> records;

    @Data
    public static class PrizeInfo implements Serializable {

        private Long prizeId;

        private String prizeName;

        private String description;

        private BigDecimal price;

        private String imageUrl;

    }

}