package com.udacity.jwnd.c1.review.mapper;

import com.udacity.jwnd.c1.review.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

//Just mapping logging, nothing else
//Authentication should be own service.
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM USERS WHERE username = #{username}")
    User getUser(String username);

    @Insert("INSERT INTO USERS(username, salt, password, firstname, lastname)"
            + "VALUES (#{username},#{salt},#{password},#{firstname},#{lastname})")
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    int insert(User user);

}
