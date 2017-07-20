package oguzhankada.geoquizfinal;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionActivity extends AppCompatActivity {


    private User mainUser;
    private TextView score_text;
    private TextView userID_text;
    private TextView timeRemained_text;
    private int userScore;
    private Button[] answer_buttons = new Button[4];
    private Button answer1_button = answer_buttons[0];
    private Button answer2_button = answer_buttons[1];
    private Button answer3_button = answer_buttons[2];
    private Button answer4_button = answer_buttons[3];

    private Button mNextButton;

    private TextView mQuestionTextView;
//    private Answer[] mQuestion1 = new Answer[] {
//            new Answer(R.string.question1answer1),
//            new Answer(R.string.question1answer2),
//            new Answer(R.string.question1answer3),
//            new Answer(R.string.question1answer4),
//    };

//    private Question[] mQuestionBank = new Question[] {
//            new Question(R.string.question1, 4, mQuestion1, 6000),
////            new Question(R.string.question_oceans, true),
////            new Question(R.string.question_mideast, false),
////            new Question(R.string.question_africa, false),
////            new Question(R.string.question_americas, true),
////            new Question(R.string.question_asia, true),
//    };

    private Question[] mQuestionBank;
    private int mCurrentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);


        //get intent
        Intent previousIntent = getIntent();
        mainUser = (User) previousIntent.getExtras().get(NicknameActivity.EXTRA_USER);
        userScore = mainUser.getmUserScore();
        mQuestionBank = (Question[]) previousIntent.getExtras().get(NicknameActivity.EXTRA_QUESTIONS);
        mCurrentIndex = (int) previousIntent.getExtras().get(NicknameActivity.EXTRA_INDEX);




        score_text = (TextView) findViewById(R.id.textView_userScore);
        score_text.setText("User score: " + userScore);

        userID_text = (TextView) findViewById(R.id.textView_userID);
        userID_text.setText("User: " + mainUser.getmUserNickname());

        //score_text = (TextView) findViewById(R.id.textView_userScore);
        //score_text.setText("User score: " + userScore);


        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);
        Answer[] answers_question = mQuestionBank[mCurrentIndex].getAnswers();

        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);


        answer1_button = (Button) findViewById(R.id.answer1_button);
        answer1_button.setText(answers_question[0].getmAnswerTextID());

        answer2_button = (Button) findViewById(R.id.answer2_button);
        answer2_button.setText(answers_question[1].getmAnswerTextID());

        answer3_button = (Button) findViewById(R.id.answer3_button);
        answer3_button.setText(answers_question[2].getmAnswerTextID());

        answer4_button = (Button) findViewById(R.id.answer4_button);
        answer4_button.setText(answers_question[3].getmAnswerTextID());



        //onClick if not answered
        if(mQuestionBank[mCurrentIndex].IsAnswered() == false){

            answer1_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setAnswer(1);
                }
            });
            answer2_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setAnswer(2);
                }
            });
            answer3_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setAnswer(3);
                }
            });
            answer4_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setAnswer(4);
                }
            });
        }else{
            setButtonColor(mQuestionBank[mCurrentIndex].getmGivenAnswer(), mQuestionBank[mCurrentIndex].isAnswerTrue());

            //toast sending part

            int messageResId = 0;


            messageResId = R.string.already_answered;


            Toast.makeText(this, messageResId, Toast.LENGTH_LONG)
                    .show();

            //end of toast
        }

        mNextButton = (Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1);
                //helper method for intent for next question
                nextQuestion();
            }
        });


    }

    private void nextQuestion() {
        /*this method checks for the question number
        -> if the current question is the last question :: outputs the score screen
        -> else shows the next question
         */

        if (mCurrentIndex >= mQuestionBank.length){
            //score screen
            Intent scoreScreen = new Intent(QuestionActivity.this, ScoreScreenActivity.class);
            scoreScreen.putExtra(NicknameActivity.EXTRA_USER, mainUser);
            startActivity(scoreScreen);

            //toast sending part

            int messageResId = 0;


            messageResId = R.string.bravo;


            Toast.makeText(this, messageResId, Toast.LENGTH_LONG)
                    .show();

            //end of toast

        }else {
            //intent for next question
            //set onClick listener to the next button


            //create an intent
            Intent startIntent = new Intent(QuestionActivity.this, QuestionActivity.class);
            startIntent.putExtra(NicknameActivity.EXTRA_USER, mainUser);
            startIntent.putExtra(NicknameActivity.EXTRA_QUESTIONS, mQuestionBank);
            startIntent.putExtra(NicknameActivity.EXTRA_INDEX, mCurrentIndex);
            startActivity(startIntent);
        }

    }


    private void prevQuestion() {


        if (mCurrentIndex == 0){
            //if the first question -> cannot go back

            int messageResId = 0;


            messageResId = R.string.first_question_no_back;


            Toast.makeText(this, messageResId, Toast.LENGTH_LONG)
                    .show();

            //end of toast

        }else {
            //intent for prev question



            //create an intent
            Intent startIntent = new Intent(QuestionActivity.this, QuestionActivity.class);
            startIntent.putExtra(NicknameActivity.EXTRA_USER, mainUser);
            startIntent.putExtra(NicknameActivity.EXTRA_QUESTIONS, mQuestionBank);
            startIntent.putExtra(NicknameActivity.EXTRA_INDEX, (mCurrentIndex - 1) );
            startActivity(startIntent);
        }

    }

    private void setAnswer(int userPressed) {

        //if question is answered dont allow to answer again
        //else answer the question
        if (mQuestionBank[mCurrentIndex].IsAnswered()) {
            //toast sending part

            int messageResId = 0;


            messageResId = R.string.already_answered;


            Toast.makeText(this, messageResId, Toast.LENGTH_LONG)
                    .show();

            //end of toast
        } else {
            mQuestionBank[mCurrentIndex].setIsAnswered(true);

            //check for answer
            mQuestionBank[mCurrentIndex].setIsAnswerTrue(userPressed);
            boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();

            //update given answer
            mQuestionBank[mCurrentIndex].setmGivenAnswer(userPressed);

            //update the user score
            if (answerIsTrue) {
                mainUser.rightAnswer();
            } else {
                mainUser.wrongAnswer();
            }

            //update score text
            updateScore();

            //change the pressed button color
            setButtonColor(userPressed, answerIsTrue);



            //toast sending part

            int messageResId = 0;

            if (answerIsTrue) {
                messageResId = R.string.correct_toast;
            } else {
                messageResId = R.string.incorrect_toast;
            }

            Toast.makeText(this, messageResId, Toast.LENGTH_LONG)
                    .show();

            //end of toast
        }
    }

    private void updateScore(){
        userScore = mainUser.getmUserScore();
        score_text.setText("User score: " + userScore);
    }


    private void setButtonColor(int answeredButton, boolean answerIsTrue){


        //color button in accordance with the answerIsTrue boolean -> if true answer green button, else red button
        int updatedButtonColor;
        if (answerIsTrue) {
            updatedButtonColor = Color.GREEN;
        } else {
            updatedButtonColor = Color.RED;

        }


        //update color
        switch (answeredButton) {
            case 1:
                answer1_button.setTextColor(updatedButtonColor);
                break;
            case 2:
                answer2_button.setTextColor(updatedButtonColor);
                break;
            case 3:
                answer3_button.setTextColor(updatedButtonColor);
                break;
            case 4:
                answer4_button.setTextColor(updatedButtonColor);
                break;
        }
    }

    //handle back button
    @Override
    public void onBackPressed() {
        prevQuestion();
    }
}
