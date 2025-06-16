package com.QuizBackend.Quiz.service;

import com.QuizBackend.Quiz.DAO.QuestionDao;
import com.QuizBackend.Quiz.DAO.QuizDao;
import com.QuizBackend.Quiz.model.Question;
import com.QuizBackend.Quiz.model.QuestionWrapper;
import com.QuizBackend.Quiz.model.Quiz;
import com.QuizBackend.Quiz.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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


    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Question> questionsFromDB = quiz.get().getQuestions();
        List<QuestionWrapper> questionForUser = new ArrayList<>();
        for(Question q: questionsFromDB){
            QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestion(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionForUser.add(qw);
        }
        return new ResponseEntity<>(questionForUser,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Quiz quiz = quizDao.findById(id).get();
        List<Question> questions = quiz.getQuestions();

        int rightAnswer = 0 ;
        int i = 0;
        for(Response response: responses){
            if(response.getResponse().equals(questions.get(i).getRight_answer()))
                rightAnswer++;
            i++;
        }
        return new ResponseEntity<>(rightAnswer,HttpStatus.OK);

    }
}
