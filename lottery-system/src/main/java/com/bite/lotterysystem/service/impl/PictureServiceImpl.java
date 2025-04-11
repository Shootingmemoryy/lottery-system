package com.bite.lotterysystem.service.impl;

import com.bite.lotterysystem.common.errorcode.ServiceErrorCodeConstants;
import com.bite.lotterysystem.common.exception.ServiceException;
import com.bite.lotterysystem.service.PictureService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @Shootingmemory
 * @create 2025-03-27-11:43
 */
@Component
public class PictureServiceImpl implements PictureService {
    @Value("${pic.local-path}")
    private String localPath;
    @Override
    public String savePicture(MultipartFile multipartFile) {
        File dir =new File(localPath);
        if(!dir.exists()){
            dir.mkdirs();
        }
        String filename = multipartFile.getOriginalFilename();
        assert filename != null;
        String suffix = filename.substring(
                filename.lastIndexOf("."));
        filename = UUID.randomUUID() + suffix;

        // 图片保存
        try {
            multipartFile.transferTo(new File(localPath + "/" + filename));
        } catch (IOException e) {
            throw new ServiceException(ServiceErrorCodeConstants.PIC_UPLOAD_ERROR);
        }

        return filename;
    }
}