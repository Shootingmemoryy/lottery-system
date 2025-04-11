package com.bite.lotterysystem.service.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Shootingmemory
 * @create 2025-03-28-12:49
 */
@Data
public class PrizeDTO {


    private Long prizeId;

    private String name;

    private String imageUrl;

    private BigDecimal price;

    private String description;

}