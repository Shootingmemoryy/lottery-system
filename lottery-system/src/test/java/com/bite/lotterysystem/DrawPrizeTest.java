package com.bite.lotterysystem;

import com.bite.lotterysystem.controller.param.DrawPrizeParam;
import com.bite.lotterysystem.controller.param.ShowWinningRecordsParam;
import com.bite.lotterysystem.service.DrawPrizeService;

import com.bite.lotterysystem.service.activiystatus.ActivityStatusManager;
import com.bite.lotterysystem.service.dto.ConvertActivityStatusDTO;
import com.bite.lotterysystem.service.dto.WinningRecordDTO;
import com.bite.lotterysystem.service.enums.ActivityPrizeStatusEnum;
import com.bite.lotterysystem.service.enums.ActivityStatusEnum;
import com.bite.lotterysystem.service.enums.ActivityUserStatusEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Shootingmemory
 * @create 2025-03-31-16:19
 */
@SpringBootTest
public class DrawPrizeTest {

    @Autowired
    private DrawPrizeService drawPrizeService;

    @Autowired
    private ActivityStatusManager activityStatusManager;


    @Test
    void drawPrize() {
//        DrawPrizeParam param = new DrawPrizeParam();
//        param.setActivityId(1L);
//        param.setPrizeId(1L);
//        param.setPrizeTiers("FIRST_PRIZE");
//        param.setWinningTime(new Date());
//        List<DrawPrizeParam.Winner> winnerList = new ArrayList<>();
//        DrawPrizeParam.Winner winner = new DrawPrizeParam.Winner();
//        winner.setUserId(1L);
//        winner.setUserName("xxx");
//        winnerList.add(winner);
//        param.setWinnerList(winnerList);
//        drawPrizeService.drawPrize(param);

        // 1、正向流程
        // 2、处理过程中发生异常：回滚
        // 3、处理过程中发生异常：消息堆积-》处理异常-》消息重发
        DrawPrizeParam param = new DrawPrizeParam();
        param.setActivityId(1L);
        param.setPrizeId(1L);
        param.setWinningTime(new Date());
        List<DrawPrizeParam.Winner> winnerList = new ArrayList<>();
        DrawPrizeParam.Winner winner = new DrawPrizeParam.Winner();
        winner.setUserId(4L);
        winner.setUserName("于浩卓");
        winnerList.add(winner);
        param.setWinnerList(winnerList);
        drawPrizeService.drawPrize(param);

    }

    @Test
    void statusConvert() {

        ConvertActivityStatusDTO convertActivityStatusDTO = new ConvertActivityStatusDTO();
        convertActivityStatusDTO.setActivityId(24L);
        convertActivityStatusDTO.setTargetActivityStatus(ActivityStatusEnum.COMPLETED);
        convertActivityStatusDTO.setPrizeId(19L);
        convertActivityStatusDTO.setTargetPrizeStatus(ActivityPrizeStatusEnum.COMPLETED);
        List<Long> userIds = Arrays.asList(45L);
        convertActivityStatusDTO.setUserIds(userIds);
        convertActivityStatusDTO.setTargetUserStatus(ActivityUserStatusEnum.COMPLETED);
        activityStatusManager.handlerEvent(convertActivityStatusDTO);

    }

    @Test
    void saveWinningRecords(){
        DrawPrizeParam param = new DrawPrizeParam();
        param.setActivityId(24L);
        param.setPrizeId(19L);
        param.setWinningTime(new Date());
        List<DrawPrizeParam.Winner> winnerList = new ArrayList<>();
        DrawPrizeParam.Winner winner = new DrawPrizeParam.Winner();
        winner.setUserId(45L);
        winner.setUserName("杨康");
        winnerList.add(winner);
        param.setWinnerList(winnerList);
        drawPrizeService.saveWinnerRecords(param);
    }


    @Test
    void showWinningRecords() {
        ShowWinningRecordsParam param = new ShowWinningRecordsParam();
        param.setActivityId(1L);
        param.setPrizeId(1L);
        List<WinningRecordDTO> list = drawPrizeService.getRecords(param);
        for (WinningRecordDTO dto : list) {
            // 中奖者_奖品_等级
            System.out.println(dto.getWinnerName()
                    + "_" + dto.getPrizeName()
                    + "_" +dto.getPrizeTier().getMessage());
        }
    }


}