package com.QuizBackend.Quiz.service;

import com.QuizBackend.Quiz.DAO.QuestionDao;
import com.QuizBackend.Quiz.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public List<Question> getAllQuestions() {
        return questionDao.findAll();
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionDao.findByCategory(category);
    }

    public String AddQuestion(@RequestBody Question question) {
        questionDao.save(question);
        return "Success";
    }

    public void clearAllQuestions() {
        questionDao.deleteAll();
    }
}
