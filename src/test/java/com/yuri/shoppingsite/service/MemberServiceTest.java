package com.yuri.shoppingsite.service;

import com.yuri.shoppingsite.Repository.MemberRepository;
import com.yuri.shoppingsite.domain.user.Member;
import com.yuri.shoppingsite.domain.user.MemberFormDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.TestPropertySource;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application-test.properties")
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    private MemberRepository memberRepository;

    public Member createMember(){
        MemberFormDto memberFormDto = new MemberFormDto();
        memberFormDto.setEmail("test@email.com");
        memberFormDto.setName("홍길동");
        memberFormDto.setAddress("서울시 길동구");
        memberFormDto.setNickname("율류리룽구링");
        memberFormDto.setPassword("1234");
        memberFormDto.setBirth("2022-10-30");
        memberFormDto.setPhone("010-1234-5678");
        return Member.createMember(memberFormDto, passwordEncoder);
    }

   @Test
   @DisplayName("회원가입 테스트")
    public void saveMemberTest(){
        Member member = createMember();
        Member savedMember = memberService.saveMember(member);

        assertEquals(member.getEmail(),savedMember.getEmail());
        assertEquals(member.getName(), savedMember.getName());
        assertEquals(member.getAddress(), savedMember.getAddress());
        assertEquals(member.getNickname(), savedMember.getNickname());
        assertEquals(member.getPassword(), savedMember.getPassword());
        assertEquals(member.getBirth(), savedMember.getBirth());
        assertEquals(member.getPhone(), savedMember.getPhone());
        assertEquals(member.getRole(), savedMember.getRole());
   }

    @Test
    @DisplayName("중복 회원 가입 테스트")
    public void saveDuplicateMemberTest(){
        Member member1 = createMember();
        Member member2 = createMember();
        memberService.saveMember(member1);

        Throwable e = assertThrows(IllegalStateException.class, ()->{
            memberService.saveMember(member2);});
        assertEquals("이미 가입된 회원입니다.",e.getMessage());

    }


}