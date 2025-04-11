package com.bite.lotterysystem.service.impl;

import com.bite.lotterysystem.controller.param.CreatePrizeParam;
import com.bite.lotterysystem.controller.param.PageParam;
import com.bite.lotterysystem.dao.dataobject.PrizeDO;
import com.bite.lotterysystem.dao.mapper.PrizeMapper;
import com.bite.lotterysystem.service.PictureService;
import com.bite.lotterysystem.service.PrizeService;
import com.bite.lotterysystem.service.dto.PageListDTO;
import com.bite.lotterysystem.service.dto.PrizeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * @Shootingmemory
 * @create 2025-03-27-17:16
 */
@Service

public class PrizeServiceImpl  implements PrizeService {
    @Autowired
    private PictureService pictureService;
    @Autowired
    private PrizeMapper prizeMapper;
    @Override
    public Long createPrize(CreatePrizeParam param, MultipartFile picFile) {
        String filename=pictureService.savePicture(picFile);
        PrizeDO prizeDO = new PrizeDO();
        prizeDO.setName(param.getPrizeName());
        prizeDO.setDescription(param.getDescription());
        prizeDO.setImageUrl(filename);
        prizeDO.setPrice(param.getPrice());
        prizeMapper.insert(prizeDO);
        return prizeDO.getId();
    }

    @Override
    public PageListDTO<PrizeDTO> findPrizeList(PageParam param) {

        int total = prizeMapper.count();

        List<PrizeDTO> prizeDTOList = new ArrayList<>();
        List<PrizeDO> prizeDOList = prizeMapper.selectPrizeList(param.offset(), param.getPageSize());
        for (PrizeDO prizeDO : prizeDOList) {
            PrizeDTO prizeDTO = new PrizeDTO();
            prizeDTO.setPrizeId(prizeDO.getId());
            prizeDTO.setName(prizeDO.getName());
            prizeDTO.setDescription(prizeDO.getDescription());
            prizeDTO.setImageUrl(prizeDO.getImageUrl());
            prizeDTO.setPrice(prizeDO.getPrice());
            prizeDTOList.add(prizeDTO);
        }
        return new PageListDTO<>(total, prizeDTOList);
    }
}