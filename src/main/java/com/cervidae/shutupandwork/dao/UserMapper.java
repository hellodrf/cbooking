package com.cervidae.shutupandwork.dao;

import com.cervidae.shutupandwork.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository("UserMapper")
public interface UserMapper {

    @Select("SELECT * FROM USER " +
            "WHERE username=#{username}")
    User findByUsername(@Param("username") String username);

    @Select("SELECT * FROM USER " +
            "WHERE id=#{id}")
    User findByID(@Param("id") long id);

    @Insert("INSERT INTO USER " +
            "VALUES (NULL, #{username}, #{score}, NULL)")
    boolean add(@Param("username") String username, @Param("score") int score);

    @Update("UPDATE USER " +
            "SET score=#{score} " +
            "WHERE username=#{username}")
    boolean update(@Param("username") String username, @Param("score") int score);
}