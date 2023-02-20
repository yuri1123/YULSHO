package com.yuri.shoppingsite.controller;

import com.yuri.shoppingsite.domain.user.MemberFormDto;
import com.yuri.shoppingsite.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/member")
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

//    로그인페이지로 이동
    @GetMapping("/login")
    public void gologin(){
    }

    @GetMapping("/signup")
    public String memberForm(Model model){
        model.addAttribute("memberFormDto", new MemberFormDto());
        return "member/signup";
    }

}
