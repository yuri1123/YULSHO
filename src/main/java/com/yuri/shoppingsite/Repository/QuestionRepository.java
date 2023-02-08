package com.yuri.shoppingsite.Repository;


import com.yuri.shoppingsite.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Integer> {

}
