package com.bite.lotterysystem.common.errorcode;
import lombok.Data;

/**
 * @Shootingmemory
 * @create 2025-03-14-17:35
 */

@Data
public class ErrorCode {

    private final Integer code;

    private final String msg;

    public ErrorCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}