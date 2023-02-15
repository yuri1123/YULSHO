package com.yuri.shoppingsite.mapper;

import com.yuri.shoppingsite.domain.user.MemberDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MemberMapper {

    @Select("select * from member order by uno desc")
    public List<MemberDTO> listAll();

    @Select("select * from member where uno =#{uno}")
    public MemberDTO selectOne(int uno);

    @Insert("insert into member (userId,userPassword,userName,userBirth,userPhone,userEmail) values (#{userId},#{userPassword},#{userName},#{userBirth},#{userPhone},#{userEmail})")
    public int register(MemberDTO memberDTO);

    @Update("update board set userBirth=#{userBirth}, userPhone=#{userPhone}, userEmail=#{userEmail} " +
            "where uno = #{uno}")
    public int update(MemberDTO memberDTO);

    @Delete("delete from  where uno =#{uno}")
    public int delete(int uno);

}
