package com.bite.lotterysystem.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Shootingmemory
 * @create 2025-03-27-11:39
 */

public interface PictureService {
    /**
     * 根据图片id获取图片
     * @param multipartFile: 上传文件的工具类
     * @return 图片
     */
    String savePicture(MultipartFile multipartFile);
}
