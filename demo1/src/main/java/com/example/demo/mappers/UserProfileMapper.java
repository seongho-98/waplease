package com.example.demo.mappers;

import com.example.demo.models.UserProfile;
import org.apache.ibatis.annotations.*;


import java.util.List;


@Mapper
public interface UserProfileMapper {
    @Select("SELECT * FROM normal_mem WHERE member_id=#{id}")
    UserProfile getUserProfile(@Param("id") String id);

    @Select("SELECT * FROM normal_mem")
    List<UserProfile> getUserProfileList();

    @Insert("INSERT INTO normal_mem VALUES(#{id}. #{name}, #{addr})")
    int insertUserProfile(@Param("id") String id, @Param("name") String name, @Param("addr") String addr);

    @Update("UPDATE normal_mem SET member_name=#{name}, member_addr=#{addr} WHERE member_id=#{id}")
    int updateUserProfile(@Param("id") String id, @Param("name") String name, @Param("addr") String addr);

    @Delete("DELETE FROM normal_mem WHERE member_id=#{id}")
    int deleteProfile(@Param("id") String id);
}
