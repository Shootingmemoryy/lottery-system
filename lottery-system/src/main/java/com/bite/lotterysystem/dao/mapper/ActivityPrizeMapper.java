package com.bite.lotterysystem.dao.mapper;

import com.bite.lotterysystem.dao.dataobject.ActivityPrizeDO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Shootingmemory
 * @create 2025-03-28-19:19
 */
@Mapper
public interface ActivityPrizeMapper {

    @Insert("<script>" +
            " insert into activity_prize (activity_id, prize_id, prize_amount, prize_tiers, status)" +
            " values <foreach collection = 'items' item='item' index='index' separator=','>" +
            " (#{item.activityId}, #{item.prizeId}, #{item.prizeAmount}, #{item.prizeTiers}, #{item.status})" +
            " </foreach>" +
            " </script>")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int batchInsert(@Param("items") List<ActivityPrizeDO> activityPrizeDOList);

    @Select("select * from activity_prize where activity_id = #{activityId}")
    List<ActivityPrizeDO> selectByActivityId(@Param("activityId") Long activityId);

    @Select("select * from activity_prize where activity_id = #{activityId} and prize_id = #{prizeId}")
    ActivityPrizeDO selectByAPId(@Param("activityId") Long activityId,
                                 @Param("prizeId") Long prizeId);

    @Select("select count(1) from activity_prize where activity_id = #{activityId} and status = #{status}")
    int countPrize(@Param("activityId") Long activityId,
                   @Param("status") String status);

    @Update("update activity_prize set status = #{status} where activity_id = #{activityId} and prize_id = #{prizeId}")
    void updateStatus(@Param("activityId") Long activityId,
                      @Param("prizeId") Long prizeId,
                      @Param("status") String status);
}