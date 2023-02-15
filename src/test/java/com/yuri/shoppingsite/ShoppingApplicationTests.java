package com.yuri.shoppingsite;

import com.yuri.shoppingsite.Repository.AnswerRepository;
import com.yuri.shoppingsite.Repository.QuestionRepository;
import com.yuri.shoppingsite.service.QuestionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ShoppingsiteTest {

    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionService questionService;

    @Test
    void testJpa() {

//        Optional<Question> oq = this.questionRepository.findById(2);
//        assertTrue(oq.isPresent());
//        Question q = oq.get();
//
//        Answer a = new Answer();
//        a.setContent("네 자동으로 생성됩니다.");
//        a.setQuestion(q);  // 어떤 질문의 답변인지 알기위해서 Question 객체가 필요하다.
//        a.setCreateDate(LocalDateTime.now());
//        this.answerRepository.save(a);

//        for(int i=1; i<=300; i++){
//            String subject = String.format("테스트 데이터입니다:[%03d]",i);
//            String content = "내용없움";
//            this.questionService.create(subject,content);
//        }
    }
}