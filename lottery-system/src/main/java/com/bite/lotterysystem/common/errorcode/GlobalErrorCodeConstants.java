package com.bite.lotterysystem.common.errorcode;

/**
 * @Shootingmemory
 * @create 2025-03-14-17:35
 */
public interface GlobalErrorCodeConstants {

    ErrorCode SUCCESS = new ErrorCode(200, "成功！");

    ErrorCode INTERNAL_SERVER_ERROR = new ErrorCode(500, "系统异常！");

    ErrorCode UNKNOWN = new ErrorCode(999, "未知错误");

}