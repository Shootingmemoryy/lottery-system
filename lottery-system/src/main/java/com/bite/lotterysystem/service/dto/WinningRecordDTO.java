package com.bite.lotterysystem.service.dto;

import com.bite.lotterysystem.service.enums.ActivityPrizeTiersEnum;
import lombok.Data;

import java.util.Date;

/**
 * @Shootingmemory
 * @create 2025-03-31-16:16
 */
@Data
public class WinningRecordDTO {
    /**
     * 中奖者id
     */
    private Long winnerId;

    /**
     * 中奖者姓名
     */
    private String winnerName;

    /**
     * 奖品名
     */
    private String prizeName;

    /**
     * 等级
     */
    private ActivityPrizeTiersEnum prizeTier;

    /**
     * 中奖时间
     */
    private Date winningTime;

}