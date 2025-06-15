package com.QuizBackend.Quiz.controller;

import com.QuizBackend.Quiz.entity.Question;
import com.QuizBackend.Quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("AllQuestions")
    public List<Question> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public List<Question> getAllQuestionsByCategory(@PathVariable("category") String category){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("add")
    public String AddQuestion(@RequestBody Question question){
        return questionService.AddQuestion(question);
    }

    @DeleteMapping("DeleteAll")
    public String DeleteAllQuestions(){
        questionService.clearAllQuestions();
        return "Success";

    }

}
