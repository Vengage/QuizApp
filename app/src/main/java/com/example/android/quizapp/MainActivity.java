package com.example.android.quizapp;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {


    private RadioGroup radioGroupAnswersLeft;
    private RadioGroup radioGroupAnswersRight;

    private boolean isChecking = true;
    private int mCheckedId = R.id.answer_1;


    private ViewFlipper mQuestionViewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mQuestionViewFlipper = (ViewFlipper) findViewById(R.id.question_view_flipper);

//        DisplayMetrics displayMetrics = new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
//        int height = displayMetrics.heightPixels;
//        int width = displayMetrics.widthPixels;
//
//        radioGroupAnswersLeft = (RadioGroup) findViewById(R.id.answers_left_group);
//        radioGroupAnswersRight = (RadioGroup) findViewById(R.id.answers_right_group);
//
//        radioGroupAnswersLeft.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
//                if (i != -1 && isChecking) {
//                    isChecking = false;
//                    mCheckedId = i;
//                    radioGroupAnswersRight.clearCheck();
//                }
//                isChecking = true;
//            }
//        });
//
//        radioGroupAnswersRight.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
//                if (i != -1 && isChecking) {
//                    isChecking = false;
//                    mCheckedId = i;
//                    radioGroupAnswersLeft.clearCheck();
//                }
//                isChecking = true;
//            }
//        });
//  Se poate folosi doar intro alta activiatate
//        ((Activity) getContext()).getWindowManager()
//                .getDefaultDisplay()
//                .getMetrics(displayMetrics);


    }

    /**
     * Change the layout to the next question
     * @param view
     */
    public void changeLayout(View view){
        switch (view.getId()){
            case R.id.start_quiz:{
                mQuestionViewFlipper.showNext();
                break;
            }
            case R.id.next_question_one:{
                mQuestionViewFlipper.showNext();
                break;
            }
            case R.id.next_question_two:{
                mQuestionViewFlipper.showNext();
                break;
            }
            case R.id.next_question_three:{
                mQuestionViewFlipper.showNext();
                break;
            }
            case R.id.next_question_four:{
                mQuestionViewFlipper.showNext();
                break;
            }
            case R.id.next_question_five:{
                mQuestionViewFlipper.showNext();
                break;
            }
            case R.id.next_question_six:{
                mQuestionViewFlipper.showNext();
                break;
            }
            case R.id.back_question_one:{
                mQuestionViewFlipper.showPrevious();
                break;
            }
            case R.id.back_question_two:{
                mQuestionViewFlipper.showPrevious();
                break;
            }
            case R.id.back_question_three:{
                mQuestionViewFlipper.showPrevious();
                break;
            }
            case R.id.back_question_four:{
                mQuestionViewFlipper.showPrevious();
                break;
            }
            case R.id.back_question_five:{
                mQuestionViewFlipper.showPrevious();
                break;
            }
            case R.id.back_question_six:{
                mQuestionViewFlipper.showPrevious();
                break;
            }
        }
    }
}
