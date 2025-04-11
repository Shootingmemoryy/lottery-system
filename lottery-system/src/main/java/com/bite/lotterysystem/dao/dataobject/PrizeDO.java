package com.bite.lotterysystem.dao.dataobject;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * @Shootingmemory
 * @create 2025-03-27-17:19
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PrizeDO extends BaseDO{
    private String name;
    private String imageUrl;
    private BigDecimal price;
    private String description;
}
