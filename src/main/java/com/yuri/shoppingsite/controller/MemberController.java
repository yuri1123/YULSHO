package com.yuri.shoppingsite.controller;

import com.yuri.shoppingsite.domain.user.UserCreateForm;
import com.yuri.shoppingsite.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
    @Autowired
    private MemberService memberService;

    //로그인페이지로 이동
    @GetMapping("member/login")
    public void gologin(){
    }
//
//    @PostMapping("member/login")
//    public String login(Model model){
////    model.addAttribute("login",)
//        return "redirect:/";
//    }

    //회원가입페이지로 이동
    @GetMapping("member/signup")
    public String gosignup(UserCreateForm userCreateForm){
        return "member/signup";
    }

//    //회원가입하기
//    @PostMapping("member/signup")
//    public String signup(MemberDTO memberDto){
//        memberService.register(memberDto);
//        return "member/login";
//    }




}
