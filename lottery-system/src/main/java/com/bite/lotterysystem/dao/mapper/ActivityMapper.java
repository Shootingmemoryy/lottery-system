package com.bite.lotterysystem.dao.mapper;

import com.bite.lotterysystem.dao.dataobject.ActivityDO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Shootingmemory
 * @create 2025-03-28-18:35
 */
@Mapper
public interface ActivityMapper {

    @Insert("insert into activity (activity_name, description, status)" +
            " values (#{activityName}, #{description}, #{status})")
    @Options(useGeneratedKeys = true, keyProperty ="id", keyColumn ="id")
    int insert(ActivityDO activityDO);


    @Select("select count(1) from activity")
    int count();

    @Select("select * from activity order by id desc limit #{offset}, #{pageSize}")
    List<ActivityDO> selectActivityList(@Param("offset") Integer offset,
                                        @Param("pageSize") Integer pageSize);

    @Select("select * from activity where id = #{id}")
    ActivityDO selectById(@Param("id") Long id);

    @Update("update activity set status = #{status} where id = #{id}")
    void updateStatus(@Param("id") Long id, @Param("status") String status);
}