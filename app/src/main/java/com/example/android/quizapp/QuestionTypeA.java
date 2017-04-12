package com.example.android.quizapp;

/**
 * Created by Vengage on 4/12/2017.
 *
 * Question of type text-radio-text
 */

public class QuestionTypeA extends Question {

    // Text question
    private String mQuestion;

    // ID of the answers
    private int mAnswerOne;
    private int mAnswerTwo;
    private int mAnswerThree;
    private int mAnswerFour;

    // ID of the right answers
    private int mGold;

    // Index of the previous question
    private int mBackIndex;

    // Index of the next question
    private int mNextIndex;

}
