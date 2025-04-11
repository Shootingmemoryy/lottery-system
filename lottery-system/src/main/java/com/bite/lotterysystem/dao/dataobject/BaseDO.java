package com.bite.lotterysystem.dao.dataobject;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
/**
 * @Shootingmemory
 * @create 2025-03-19-14:14
 */

@Data
public class BaseDO implements Serializable {

    /**
     * 主键
     */
    private Long id;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改时间
     */
    private Date gmtModified;


}