package com.bite.lotterysystem.service;

import com.bite.lotterysystem.controller.param.CreatePrizeParam;
import com.bite.lotterysystem.controller.param.PageParam;
import com.bite.lotterysystem.service.dto.PageListDTO;
import com.bite.lotterysystem.service.dto.PrizeDTO;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Shootingmemory
 * @create 2025-03-27-17:10
 */
public interface PrizeService {
    Long createPrize(CreatePrizeParam param, MultipartFile picFile);

    PageListDTO<PrizeDTO> findPrizeList(PageParam param);
}
