package com.pana.user.mapper;

import com.pana.thrift.user.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface UserMapper {

    @Select("select id,username, password, realname as realName," +
            "mobile, email from pe_user where id=#{id}")
    UserInfo getUserById(@Param("id")int id);


    @Select("select id,username, password, realname as realName," +
            "mobile, email from pe_user where username=#{username}")
    UserInfo getUserByName(@Param("username")String username);


    @Insert("insert into pe_user (username, password, realname, mobile, email)" +
            "values (#{u.username}, #{u.password}, #{u.realName}, #{u.mobile}, #{u.email})")
    void registerUser(@Param("u") UserInfo userInfo);


    @Select("select u.id,u.username,u.password,u.realname as realName," +
            "u.mobile,u.email,t.intro,t.stars from pe_user u," +
            "pe_teacher t where u.id=#{id} " +
            "and u.id=t.user_id")
    UserInfo getTeacherById(@Param("id")int id);
}
