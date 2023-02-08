package com.yuri.shoppingsite.service;

import com.yuri.shoppingsite.Repository.AnswerRepository;
import com.yuri.shoppingsite.domain.Answer;
import com.yuri.shoppingsite.domain.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class AnswerService {

       private final AnswerRepository answerRepository;

        public void create(Question question, String content){
            Answer answer = new Answer();
            answer.setContent(content);
            answer.setCreateDate(LocalDateTime.now());
            answer.setQuestion(question);
            this.answerRepository.save(answer);
        }

}
