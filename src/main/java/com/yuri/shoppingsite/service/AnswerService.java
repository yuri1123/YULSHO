package com.yuri.shoppingsite.service;

import com.yuri.shoppingsite.Repository.AnswerRepository;
import com.yuri.shoppingsite.domain.Answer;
import com.yuri.shoppingsite.domain.Question;
import com.yuri.shoppingsite.domain.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class AnswerService {

       private final AnswerRepository answerRepository;

        public void create(Question question, String content, SiteUser author){
            Answer answer = new Answer();
            answer.setContent(content);
            answer.setCreateDate(LocalDateTime.now());
            answer.setQuestion(question);
            answer.setAuthor(author);
            this.answerRepository.save(answer);
        }

}
