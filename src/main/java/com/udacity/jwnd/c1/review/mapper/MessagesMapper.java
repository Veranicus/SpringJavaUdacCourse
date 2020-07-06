package com.udacity.jwnd.c1.review.mapper;

import com.udacity.jwnd.c1.review.controller.ChatMessages;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MessagesMapper {

    @Select("SELECT * FROM MESSAGES")
    List<ChatMessages> getAllMessages();

    @Insert("INSERT INTO MESSAGES (username, messagetext)"
            + " VALUES (#{username}, #{messageText})")
    @Options(useGeneratedKeys = true, keyProperty = "messageid")
    int insert(ChatMessages chatMessages);
}
