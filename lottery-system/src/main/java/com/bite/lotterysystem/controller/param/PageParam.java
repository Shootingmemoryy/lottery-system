package com.bite.lotterysystem.controller.param;

import lombok.Data;

import java.io.Serializable;

/**
 * @Shootingmemory
 * @create 2025-03-28-12:25
 */
@Data
public class PageParam implements Serializable {

    private Integer currentPage = 1;

    private Integer pageSize = 10;

    public Integer offset() {
        return (currentPage-1) * pageSize;
    }


}