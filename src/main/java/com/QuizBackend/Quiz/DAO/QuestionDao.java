package com.QuizBackend.Quiz.DAO;

import com.QuizBackend.Quiz.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionDao  extends JpaRepository<Question, Integer> {

}
