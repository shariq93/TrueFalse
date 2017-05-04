package com.example.innovativenetwork.truefalse.DataClasses;

import com.orm.SugarRecord;

/**
 * Created by DeLL on 03-May-17.
 */

public class QuestionData extends SugarRecord {
     int dificulty, category;
     boolean isAnswered, answer, givenAnswer;
     String imageBase64, questionText;
    public QuestionData(){}
    public int getDificulty() {
        return dificulty;
    }

    public void setDificulty(int dificulty) {
        this.dificulty = dificulty;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public boolean isAnswered() {
        return isAnswered;
    }

    public void setAnswered(boolean answered) {
        isAnswered = answered;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    public boolean isGivenAnswer() {
        return givenAnswer;
    }

    public void setGivenAnswer(boolean givenAnswer) {
        this.givenAnswer = givenAnswer;
    }

    public String getImageBase64() {
        return imageBase64;
    }

    public void setImageBase64(String imageBase64) {
        this.imageBase64 = imageBase64;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    @Override
    public String toString() {
        return "QuestionData{" +
                "dificulty=" + dificulty +
                ", category=" + category +
                ", isAnswered=" + isAnswered +
                ", answer=" + answer +
                ", givenAnswer=" + givenAnswer +
                ", imageBase64='" +imageBase64 + '\'' +
                ", questionText='" + questionText + '\'' +
                '}';
    }
}
