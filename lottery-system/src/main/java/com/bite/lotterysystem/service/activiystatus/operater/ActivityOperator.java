package com.bite.lotterysystem.service.activiystatus.operater;

import com.bite.lotterysystem.dao.dataobject.ActivityDO;
import com.bite.lotterysystem.dao.mapper.ActivityMapper;
import com.bite.lotterysystem.dao.mapper.ActivityPrizeMapper;
import com.bite.lotterysystem.service.dto.ConvertActivityStatusDTO;
import com.bite.lotterysystem.service.enums.ActivityPrizeStatusEnum;
import com.bite.lotterysystem.service.enums.ActivityStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Shootingmemory
 * @create 2025-03-31-23:00
 */
@Component
public class ActivityOperator extends AbstractActivityOperator {

    @Autowired
    private ActivityMapper activityMapper;
    @Autowired
    private ActivityPrizeMapper activityPrizeMapper;

    @Override
    public Integer sequence() {
        return 2;
    }

    @Override
    public Boolean needConvert(ConvertActivityStatusDTO convertActivityStatusDTO) {
        Long activityId = convertActivityStatusDTO.getActivityId();
        ActivityStatusEnum targetStatus = convertActivityStatusDTO.getTargetActivityStatus();
        if (null == activityId
                || null == targetStatus) {
            return false;
        }

        ActivityDO activityDO = activityMapper.selectById(activityId);
        if (null == activityDO) {
            return false;
        }

        // 当前活动状态与传入的状态一致，不处理
        if (targetStatus.name().equalsIgnoreCase(activityDO.getStatus())) {
            return false;
        }

        // 需要判断奖品是否全部抽完
        // 查询 INIT 状态的奖品个数
        int count = activityPrizeMapper.countPrize(activityId, ActivityPrizeStatusEnum.INIT.name());
        if (count > 0) {
            return false;
        }

        return true;
    }

    @Override
    public Boolean convert(ConvertActivityStatusDTO convertActivityStatusDTO) {
        try {
            activityMapper.updateStatus(convertActivityStatusDTO.getActivityId(),
                    convertActivityStatusDTO.getTargetActivityStatus().name());
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}