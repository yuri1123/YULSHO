package com.yuri.shoppingsite.service;

import com.yuri.shoppingsite.domain.user.MemberDTO;
import com.yuri.shoppingsite.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MemberService {
    @Autowired
    private MemberMapper memberMapper;

    //전체보기
    public List<MemberDTO> listAll(){
       return memberMapper.listAll();
    }
    //선택보기
    public MemberDTO selectOne(int uno){
        return memberMapper.selectOne(uno);
    }
    //등록하기
    public int register(MemberDTO memberDTO){
        return memberMapper.register(memberDTO);
    }
    //수정하기
    public int update(MemberDTO memberDTO){
        return memberMapper.update(memberDTO);
    }
    //삭제하기
    public int delete(int uno){
        return memberMapper.delete(uno);
    }
}
