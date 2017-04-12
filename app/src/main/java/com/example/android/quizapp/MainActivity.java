package com.example.android.quizapp;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {


    private RadioGroup radioGroupAnswersLeft;
    private RadioGroup radioGroupAnswersRight;

    private boolean isChecking = true;
    private int mCheckedId = R.id.answer_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
            case R.id.next_radio:{
                setContentView(R.layout.text_check_image_layout);
                break;
            }
            case R.id.next_checkbox:{
                setContentView(R.layout.text_edit_layout);
                break;
            }
            case R.id.next_editbox:{
                setContentView(R.layout.text_radio_image_layout);
                break;
            }
            case R.id.back_radio:{
                setContentView(R.layout.text_edit_layout);
                break;
            }
            case R.id.back_checkbox:{
                setContentView(R.layout.text_radio_image_layout);
                break;
            }
            case R.id.back_editbox:{
                setContentView(R.layout.text_check_image_layout);
                break;
            }
        }
    }
}
