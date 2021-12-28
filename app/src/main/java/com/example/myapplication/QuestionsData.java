package com.example.myapplication;

import java.util.ArrayList;

public class QuestionsData {

    String task;
    String answer;
    String[] questions;
    String selectedAnswer;

    public QuestionsData (
            String task,
            String answer,
            String[] questions,
            String selectedAnswer){

        this.answer = answer;
        this.task = task;
        this.questions = questions;
        this.selectedAnswer = selectedAnswer;

    }

    boolean check(){
           return answer.equals(selectedAnswer);
    }
}
