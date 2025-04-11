package com.bite.lotterysystem.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


/**
 * @Shootingmemory
 * @create 2025-03-28-12:37
 */
@Data
@AllArgsConstructor
public class PageListDTO<T> {
    private Integer total;
    private List<T> records;





}
