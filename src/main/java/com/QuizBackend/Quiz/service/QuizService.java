package com.QuizBackend.Quiz.service;

import com.QuizBackend.Quiz.DAO.QuestionDao;
import com.QuizBackend.Quiz.DAO.QuizDao;
import com.QuizBackend.Quiz.entity.Question;
import com.QuizBackend.Quiz.entity.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    private QuizDao quizDao;
    @Autowired
    private QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<Question> questions = questionDao.findRandomQuestionsByCategory(category, numQ );

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("Success",  HttpStatus.OK);
    }
}
