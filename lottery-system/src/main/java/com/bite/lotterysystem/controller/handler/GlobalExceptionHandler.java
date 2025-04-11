package com.bite.lotterysystem.controller.handler;

import com.bite.lotterysystem.common.errorcode.GlobalErrorCodeConstants;
import com.bite.lotterysystem.common.exception.ControllerException;
import com.bite.lotterysystem.common.exception.ServiceException;
import com.bite.lotterysystem.common.pojo.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Shootingmemory
 * @create 2025-03-20-20:02
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
        private final static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(value = ServiceException.class)
        public CommonResult<?> serviceException(ServiceException e) {
            logger.error("ServiceException:{}", e.getMessage());
            return CommonResult.error(
                    GlobalErrorCodeConstants.INTERNAL_SERVER_ERROR.getCode(), e.getMessage());
        }
    public CommonResult<?> ControllerException(ControllerException e) {
        logger.error("ControllerException:{}", e.getMessage());
        return CommonResult.error(
                GlobalErrorCodeConstants.INTERNAL_SERVER_ERROR.getCode(), e.getMessage());
    }
    public CommonResult<?> Exception(Exception e) {
        logger.error("Exception:{} ", e.getMessage());
        return CommonResult.error(
                GlobalErrorCodeConstants.INTERNAL_SERVER_ERROR.getCode(), e.getMessage());
    }
}
