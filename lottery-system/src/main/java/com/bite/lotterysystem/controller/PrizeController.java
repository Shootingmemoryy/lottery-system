package com.bite.lotterysystem.controller;

import com.bite.lotterysystem.common.errorcode.ControllerErrorCodeConstants;
import com.bite.lotterysystem.common.exception.ControllerException;
import com.bite.lotterysystem.common.pojo.CommonResult;
import com.bite.lotterysystem.common.utils.JacksonUtil;
import com.bite.lotterysystem.controller.param.CreatePrizeParam;
import com.bite.lotterysystem.controller.param.PageParam;
import com.bite.lotterysystem.controller.result.FindPrizeListResult;
import com.bite.lotterysystem.service.PictureService;
import com.bite.lotterysystem.service.PrizeService;
import com.bite.lotterysystem.service.dto.PageListDTO;
import com.bite.lotterysystem.service.dto.PrizeDTO;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.stream.Collectors;

/**
 * @Shootingmemory
 * @create 2025-03-27-16:29
 */
@RestController
public class PrizeController {
    private  static  final Logger logger = LoggerFactory.getLogger(PrizeController.class);
    @Autowired
    private PictureService pictureService;
    @Autowired
    private PrizeService prizeService;
    @RequestMapping("/pic/upload")
    public String uploadPic(MultipartFile file) {
        return pictureService.savePicture(file);
    }
    @RequestMapping("/prize/create")
    public CommonResult<Long> createPrize(@Valid @RequestPart("param") CreatePrizeParam param,
                                          @RequestPart("prizePic") MultipartFile picFile) {
        logger.info("createPrize CreatePrizeParam:{}",
                JacksonUtil.writeValueAsString(param));
        return CommonResult.success(
                prizeService.createPrize(param, picFile));
    }
    @RequestMapping("/prize/find-list")
    public CommonResult<FindPrizeListResult> findPrizeList(PageParam param) {
        logger.info("findPrizeList PageParam:{}",
                JacksonUtil.writeValueAsString(param));
        PageListDTO<PrizeDTO> pageListDTO = prizeService.findPrizeList(param);
        return CommonResult.success(convertToFindPrizeListResult(pageListDTO));

    }
    private FindPrizeListResult convertToFindPrizeListResult(PageListDTO<PrizeDTO> pageListDTO) {
        if (null == pageListDTO) {
            throw new ControllerException(ControllerErrorCodeConstants.FIND_PRIZE_LIST_ERROR);
        }

        FindPrizeListResult result = new FindPrizeListResult();
        result.setTotal(pageListDTO.getTotal());
        result.setRecords(
                pageListDTO.getRecords().stream()
                        .map(prizeDTO -> {
                            FindPrizeListResult.PrizeInfo prizeInfo = new FindPrizeListResult.PrizeInfo();
                            prizeInfo.setPrizeId(prizeDTO.getPrizeId());
                            prizeInfo.setPrizeName(prizeDTO.getName());
                            prizeInfo.setDescription(prizeDTO.getDescription());
                            prizeInfo.setImageUrl(prizeDTO.getImageUrl());
                            prizeInfo.setPrice(prizeDTO.getPrice());
                            return prizeInfo;
                        }).collect(Collectors.toList())
        );
        return result;
    }
}
