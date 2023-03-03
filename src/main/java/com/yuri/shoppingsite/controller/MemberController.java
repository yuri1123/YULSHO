package com.yuri.shoppingsite.controller;

import com.yuri.shoppingsite.domain.user.Member;
import com.yuri.shoppingsite.domain.user.MemberFormDto;
import com.yuri.shoppingsite.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping("/member")
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    //회원가입 페이지로 이동
    @GetMapping("/signup")
    public String memberForm(Model model){
        model.addAttribute("memberFormDto", new MemberFormDto());
        return "member/signup";
    }

    //회원가입
    @PostMapping("/signup")
    public String signup(@Valid MemberFormDto memberFormDto, BindingResult bindingResult,
                         Model model){

        if(bindingResult.hasErrors()){
            return "member/signup";
        }

        try {
            Member member = Member.createMember(memberFormDto,passwordEncoder);
            memberService.saveMember(member);
        } catch(IllegalStateException e){
            model.addAttribute("errorMessage",e.getMessage());
            System.out.println(e.getMessage());
            return "member/signup";
        }

        return "redirect:/";
    }

    //    로그인페이지로 이동
    @GetMapping("/login")
    public String gologin(){




        return "member/login";
    }

    // 로그인 페이지 오류 메시지 전달
    @GetMapping("/login/error")
    public String loginError(Model model){
        model.addAttribute("loginErrorMsg", "아이디 또는 비밀번호를 확인해주세요");
        return "member/login";
    }

    //마이페이지로 이동
    @GetMapping("/mypage")
    public String mypage(Model model){

        return "member/mypage";
    }

    //회원정보 페이지로 이동
    @GetMapping("/personalinfo")
    public String personalInfo(Model model){
        return "member/personalinfo";
    }

}
