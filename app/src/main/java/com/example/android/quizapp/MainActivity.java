package com.example.android.quizapp;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import static com.example.android.quizapp.R.id.answer_4_question_three;
import static com.example.android.quizapp.R.id.bottom;

public class MainActivity extends AppCompatActivity {


    private RadioGroup radioGroupAnswersLeft;
    private RadioGroup radioGroupAnswersRight;

    private boolean isChecking = true;
    private int mCheckedId = R.id.answer_1;

    private ViewFlipper mQuestionViewFlipper;
    private RelativeLayout mFirstScreen;
    private LinearLayout mButtonPanel;
    private RelativeLayout mSubmitAnswersLayout;
    private Button mSubmitAnswersButton;

    // Score counter for the number of correct answers
    private int numberOfQuestions = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFirstScreen = (RelativeLayout) findViewById(R.id.first_screen);
        mQuestionViewFlipper = (ViewFlipper) findViewById(R.id.question_view_flipper);
        mButtonPanel = (LinearLayout) findViewById(R.id.buttonPanel);
        mSubmitAnswersLayout = (RelativeLayout) findViewById(R.id.submit_answers_layout);
        mSubmitAnswersButton = (Button) findViewById(R.id.submit_answers);


        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        radioGroupAnswersLeft = (RadioGroup) findViewById(R.id.answers_left_group_question_four);
        radioGroupAnswersRight = (RadioGroup) findViewById(R.id.answers_right_group_question_four);

        radioGroupAnswersLeft.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (i != -1 && isChecking) {
                    isChecking = false;
                    mCheckedId = i;
                    radioGroupAnswersRight.clearCheck();
                }
                isChecking = true;
            }
        });

        radioGroupAnswersRight.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (i != -1 && isChecking) {
                    isChecking = false;
                    mCheckedId = i;
                    radioGroupAnswersLeft.clearCheck();
                }
                isChecking = true;
            }
        });

//          Se poate folosi doar intro alta activiatate
//                ((Activity) getContext()).getWindowManager()
//                        .getDefaultDisplay()
//                        .getMetrics(displayMetrics);


    }

    public void checkAnswers() {

        // First Question
        RadioButton firstQuestionAnswer = (RadioButton) findViewById(R.id.answer_4_question_one);
        if (firstQuestionAnswer.isChecked()) {
            numberOfQuestions += 1;
        }

        // Second Question
        CheckBox checkBoxAnswer2 = (CheckBox) findViewById(R.id.answer_2_question_two);
        CheckBox checkBoxAnswer3 = (CheckBox) findViewById(R.id.answer_3_question_two);
        boolean isChecked2 = checkBoxAnswer2.isChecked();

        boolean isChecked3 = checkBoxAnswer3.isChecked();
        if (isChecked2 && isChecked3) {
            numberOfQuestions += 1;
        }

        // Third Question
        RadioButton radioButtonAnswer4 = (RadioButton) findViewById(R.id.answer_4_question_three);
        if(radioButtonAnswer4.isChecked()){
            numberOfQuestions+=1;
        }

        // Fourth Question
        RadioButton fourthQuestionAnswer = (RadioButton) findViewById(R.id.answer_4_question_four);
        if (fourthQuestionAnswer.isChecked()) {
            numberOfQuestions += 1;
        }

        // Fifth Question
        EditText fifthQuestionAnswer = (EditText) findViewById(R.id.edit_box_answer_question_five);
        if(fifthQuestionAnswer.getText().toString().equalsIgnoreCase(getResources().getString(R.string.ardei))){
            numberOfQuestions +=1;
        }

        // Sixth Question
        CheckBox checkBoxAnswer1QuestionSix = (CheckBox) findViewById(R.id.answer_1_question_six);
        CheckBox checkBoxAnswer2QuestionSix = (CheckBox) findViewById(R.id.answer_2_question_six);
        CheckBox checkBoxAnswer3QuestionSix = (CheckBox) findViewById(R.id.answer_3_question_six);

        boolean isChecked1 = checkBoxAnswer1QuestionSix.isChecked();
        isChecked2 = checkBoxAnswer2QuestionSix.isChecked();
        isChecked3 = checkBoxAnswer3QuestionSix.isChecked();

        if (isChecked1 && isChecked2 && isChecked3) {
            numberOfQuestions += 1;
        }

    }

    /**
     * Change the layout to the next question
     *
     * @param view
     */
    public void changeLayout(View view) {
        switch (view.getId()) {
            case R.id.start_quiz: {
                mQuestionViewFlipper.setVisibility(View.VISIBLE);
                mButtonPanel.setVisibility(View.VISIBLE);
                mFirstScreen.setVisibility(View.GONE);
                break;
            }
            case R.id.next: {
                if ( R.id.question_six == mQuestionViewFlipper.getCurrentView().getId()) {
                    checkAnswers();
                    mQuestionViewFlipper.setVisibility(View.GONE);
                    mButtonPanel.setVisibility(View.GONE);
                    mSubmitAnswersLayout.setVisibility(View.VISIBLE);
                    mSubmitAnswersButton.setVisibility(View.VISIBLE);
                    break;
                }
                mQuestionViewFlipper.showNext();
                break;
            }
            case R.id.back: {
                mQuestionViewFlipper.showPrevious();
                break;
            }
            case R.id.submit_answers: {
                String score = "This is your score: " + numberOfQuestions + " from 6.";
                Toast.makeText(this, score, Toast.LENGTH_SHORT).show();
                TextView yourScoreTextView = (TextView) findViewById(R.id.your_score);
                yourScoreTextView.setVisibility(View.VISIBLE);
                yourScoreTextView.setText(score);
            }
        }
    }
}
