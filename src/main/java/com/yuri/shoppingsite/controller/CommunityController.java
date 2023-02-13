package com.yuri.shoppingsite.controller;

import com.yuri.shoppingsite.domain.AnswerForm;
import com.yuri.shoppingsite.domain.Question;
import com.yuri.shoppingsite.domain.QuestionForm;
import com.yuri.shoppingsite.domain.SiteUser;
import com.yuri.shoppingsite.service.AnswerService;
import com.yuri.shoppingsite.service.NoticeService;
import com.yuri.shoppingsite.service.QuestionService;
import com.yuri.shoppingsite.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class CommunityController {

    @Autowired
    private NoticeService noticeService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private AnswerService answerService;

    @Autowired
    private final UserService userService;
    //community - notice

    //notice 리스트 페이지로 이동
    @GetMapping("community/noticelist")
    public String goNotice(Model model){
        System.out.println("notice 리스트로 이동하기");
        model.addAttribute("list",noticeService.listAll());
    return "community/noticelist";
    }
    //noitce



    //qna 게시판으로 이동
    @GetMapping("community/qna")
    public String goQna(Model model, @RequestParam(value="page", defaultValue = "0") int page){
        Page<Question> paging = this.questionService.getList(page);
        model.addAttribute("paging", paging);
        return "community/qna";
    }
    @PreAuthorize("isAuthenticated()")
    @GetMapping("question/create")
    public String qcreate(QuestionForm questionForm){
        return "community/qnacreate";
    }
    @PreAuthorize("isAuthenticated()")
    @PostMapping("question/create")
    public String qcreatedo(@Valid QuestionForm questionForm, BindingResult bindingResult,
                            Principal principal){

        if(bindingResult.hasErrors()){
            return "community/qnacreate";
        }
        SiteUser siteUser = this.userService.getUser(principal.getName());
        this.questionService.create(questionForm.getSubject(),questionForm.getContent(),siteUser);
        return "redirect:/community/qna";
    }


    @GetMapping("/community/qnadetail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm){
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
    return "community/qnadetail";

    }
    //답글달기
    @PreAuthorize("isAuthenticated()")
    @PostMapping("answer/create/{id}")
    public String createAnswer(Model model,
                               @PathVariable("id") Integer id,
                               @Valid AnswerForm answerForm, BindingResult bindingResult,
                               Principal principal){
    Question question = this.questionService.getQuestion(id);
        SiteUser siteUser = this.userService.getUser(principal.getName());
    if(bindingResult.hasErrors()) {
        model.addAttribute("question", question);
        return "community/qnadetail";
    }
    this.answerService.create(question,answerForm.getContent(),siteUser);
        return String.format("redirect:/community/qnadetail/%s", id);
    }




}
