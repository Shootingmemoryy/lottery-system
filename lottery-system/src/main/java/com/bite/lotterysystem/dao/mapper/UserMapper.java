package com.bite.lotterysystem.dao.mapper;

import com.bite.lotterysystem.dao.dataobject.Encrypt;
import com.bite.lotterysystem.dao.dataobject.UserDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

import org.apache.ibatis.annotations.*;


/**
 * @Shootingmemory
 * @create 2025-03-19-14:12
 */
@Mapper
public interface UserMapper {

    /**
     * 查询邮箱绑定的人数
     *
     * @param email
     * @return
     */
    @Select("select count(*) from user where email = #{email}")
    int countByMail(@Param("email") String email);

    @Select("select count(*) from user where phone_number = #{phoneNumber}")
    int countByPhone(@Param("phoneNumber") Encrypt phoneNumber);

    @Insert("insert into user (user_name, email, phone_number, password, identity)" +
            " values (#{userName}, #{email}, #{phoneNumber}, #{password}, #{identity})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insert(UserDO userDO);

    @Select("select * from user where email = #{email}")
    UserDO selectByMail(@Param("email") String email);

    @Select("select * from user where phone_number = #{phoneNumber}")
    UserDO selectByPhoneNumber(@Param("phoneNumber") Encrypt phoneNumber);

    @Select("<script>" +
            " select * from user" +
            " <if test=\"identity!=null\">" +
            "    where identity = #{identity}" +
            " </if>" +
            " order by id desc" +
            " </script>")
    List<UserDO> selectUserListByIdentity(@Param("identity")String identity);

    @Select("<script>" +
            " select id from user" +
            " where id in" +
            " <foreach item='item' collection='items' open='(' separator=',' close=')'>" +
            " #{item}" +
            " </foreach>" +
            " </script>")
    List<Long> selectExistByIds(@Param("items") List<Long> ids);

    @Select("<script>" +
            " select * from user" +
            " where id in" +
            " <foreach item='item' collection='items' open='(' separator=',' close=')'>" +
            " #{item}" +
            " </foreach>" +
            " </script>")
    List<UserDO> batchSelectByIds(@Param("items") List<Long> ids);
}