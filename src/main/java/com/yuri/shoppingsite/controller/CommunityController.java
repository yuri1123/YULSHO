package com.yuri.shoppingsite.controller;

import com.yuri.shoppingsite.domain.MemberDTO;
import com.yuri.shoppingsite.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommunityController {

    @Autowired
    private NoticeService noticeService;

    //community - notice

    //notice 리스트 페이지로 이동
    @GetMapping("community/noticelist")
    public String goNotice(Model model){
        System.out.println("notice 리스트로 이동하기");
        model.addAttribute("list",noticeService.listAll());
    return "community/noticelist";
    }
    //noitce




}
