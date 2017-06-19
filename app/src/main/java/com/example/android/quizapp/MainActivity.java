package com.example.android.quizapp;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    // Used to clear the RadioButtons from another RadioGroup
    private RadioGroup radioGroupAnswersLeft;
    private RadioGroup radioGroupAnswersRight;

    private boolean isChecking = true;

    //  Declaring objects
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

        // Instances
        mFirstScreen = (RelativeLayout) findViewById(R.id.first_screen);
        mQuestionViewFlipper = (ViewFlipper) findViewById(R.id.question_view_flipper);
        mButtonPanel = (LinearLayout) findViewById(R.id.buttonPanel);
        mSubmitAnswersLayout = (RelativeLayout) findViewById(R.id.submit_answers_layout);
        mSubmitAnswersButton = (Button) findViewById(R.id.submit_answers);

        // Used to uncheck Radiobuttons from the other RadioGroup
        radioGroupAnswersLeft = (RadioGroup) findViewById(R.id.answers_left_group_question_four);
        radioGroupAnswersRight = (RadioGroup) findViewById(R.id.answers_right_group_question_four);

        radioGroupAnswersLeft.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (i != -1 && isChecking) {
                    isChecking = false;
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
                    radioGroupAnswersLeft.clearCheck();
                }
                isChecking = true;
            }
        });
    }

    /**
     * Function that check for the right answers of the questions
     * It increments the variable numberOfQuestions for every correct answer
     */
    public void checkAnswers() {

        // First Question
        RadioButton firstQuestionAnswer = (RadioButton) findViewById(R.id.answer_4_question_one);
        if (firstQuestionAnswer.isChecked()) {
            numberOfQuestions += 1;
        } else {
            Log.i(TAG, "Wrong answer to question one!");
        }

        // Second Question
        CheckBox checkBoxAnswer1 = (CheckBox) findViewById(R.id.answer_1_question_two);
        CheckBox checkBoxAnswer2 = (CheckBox) findViewById(R.id.answer_2_question_two);
        CheckBox checkBoxAnswer3 = (CheckBox) findViewById(R.id.answer_3_question_two);
        CheckBox checkBoxAnswer4 = (CheckBox) findViewById(R.id.answer_4_question_two);

        boolean isChecked1 = checkBoxAnswer1.isChecked();
        boolean isChecked2 = checkBoxAnswer2.isChecked();
        boolean isChecked3 = checkBoxAnswer3.isChecked();
        boolean isChecked4 = checkBoxAnswer4.isChecked();

        if (!isChecked1 && isChecked2 && isChecked3 && !isChecked4) {
            numberOfQuestions += 1;
        } else {
            Log.i(TAG, "Wrong answer to question two!");
        }

        // Third Question
        RadioButton radioButtonAnswer4 = (RadioButton) findViewById(R.id.answer_4_question_three);
        if (radioButtonAnswer4.isChecked()) {
            numberOfQuestions += 1;
        } else {
            Log.i(TAG, "Wrong answer to question three!");
        }

        // Fourth Question
        RadioButton fourthQuestionAnswer = (RadioButton) findViewById(R.id.answer_4_question_four);
        if (fourthQuestionAnswer.isChecked()) {
            numberOfQuestions += 1;
        } else {
            Log.i(TAG, "Wrong answer to question four!");
        }

        // Fifth Question
        EditText fifthQuestionAnswer = (EditText) findViewById(R.id.edit_box_answer_question_five);
        if (fifthQuestionAnswer.getText().toString().equalsIgnoreCase(getResources().getString(R.string.pepper))) {
            numberOfQuestions += 1;
        } else {
            Log.i(TAG, "Wrong answer to question five!");
        }

        // Sixth Question
        CheckBox checkBoxAnswer1QuestionSix = (CheckBox) findViewById(R.id.answer_1_question_six);
        CheckBox checkBoxAnswer2QuestionSix = (CheckBox) findViewById(R.id.answer_2_question_six);
        CheckBox checkBoxAnswer3QuestionSix = (CheckBox) findViewById(R.id.answer_3_question_six);
        CheckBox checkBoxAnswer4QuestionSix = (CheckBox) findViewById(R.id.answer_4_question_six);

        isChecked1 = checkBoxAnswer1QuestionSix.isChecked();
        isChecked2 = checkBoxAnswer2QuestionSix.isChecked();
        isChecked3 = checkBoxAnswer3QuestionSix.isChecked();
        isChecked4 = checkBoxAnswer4QuestionSix.isChecked();

        if (isChecked1 && isChecked2 && isChecked3 && !isChecked4) {
            numberOfQuestions += 1;
        } else {
            Log.i(TAG, "Wrong answer to question six!");
        }
    }

    /**
     * Change the layout to the next question
     *
     * @param view The view that calls this function. It is a button with the text Next or Back and
     *             the first button Start Quiz and the last button Submit ansvers
     */
    public void changeLayout(View view) {
        switch (view.getId()) {
            // Start the quiz from the first screen
            case R.id.start_quiz: {
                mQuestionViewFlipper.setVisibility(View.VISIBLE);
                mButtonPanel.setVisibility(View.VISIBLE);
                mFirstScreen.setVisibility(View.GONE);
                break;
            }
            // Go to the next question
            // If on the final question the next button is pressed the user is sent to submit the answers
            case R.id.next: {
                if (R.id.question_six == mQuestionViewFlipper.getCurrentView().getId()) {
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
            // Go back to review a question
            case R.id.back: {
                if (R.id.question_one != mQuestionViewFlipper.getCurrentView().getId())
                    mQuestionViewFlipper.showPrevious();
                break;
            }
            // Submit the answers
            case R.id.submit_answers: {
                String score = getResources().getString(R.string.score, numberOfQuestions);
                Toast.makeText(this, score, Toast.LENGTH_SHORT).show();
                TextView yourScoreTextView = (TextView) findViewById(R.id.your_score);
                yourScoreTextView.setVisibility(View.VISIBLE);
                yourScoreTextView.setText(score);
            }
        }
    }
}
