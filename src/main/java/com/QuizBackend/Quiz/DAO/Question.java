package com.QuizBackend.Quiz.DAO;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String Question;
    private String Option1;
    private String Option2;
    private String Option3;
    private String Option4;
    private String Right_answer;
    private String Difficulty_level;
    private String Category;
}
