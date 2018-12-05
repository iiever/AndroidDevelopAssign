package com.inti.student.androidassign.Question;

import android.widget.TextView;

import com.inti.student.androidassign.R;

import java.util.UUID;

public class Question {

    private UUID mId;
    private String mTitle;
    private int mTextResId;
    private boolean mAnswerTrue;
    private int Answer;
    private int Score;
    private int Score2;
    private String name;


    public Question(){
        mId = UUID.randomUUID();
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }

    public int getAnswer() {
        return Answer;
    }

    public void setAnswer(int answer) {
        Answer = answer;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        this.Score = score;
    }

    public void setScore2(int score){
        this.Score2 = score;
    }
    public int getScore2(){
        return Score2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
