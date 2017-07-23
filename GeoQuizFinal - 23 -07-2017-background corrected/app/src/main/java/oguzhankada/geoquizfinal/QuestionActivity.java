package oguzhankada.geoquizfinal;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionActivity extends AppCompatActivity {

<<<<<<< HEAD
    private User mainUser;
    private int mLocalTime, userScore, totalTime, progress;
    private TextView score_text, userID_text, timeRemained_text, mQuestionTextView;
    private ProgressBar progressBar;

    private Button mNextButton;
=======

    private User mainUser;
    private int mLocalTime;
    private TextView score_text;
    private TextView userID_text;
    private TextView timeRemained_text;
    private int userScore;
    private ProgressBar progressBar;
    private int progress;
>>>>>>> 11be444eea567caf2754cadfe40add0954f1c54d
    private Button[] answer_buttons = new Button[4];
    private Button answer1_button = answer_buttons[0];
    private Button answer2_button = answer_buttons[1];
    private Button answer3_button = answer_buttons[2];
    private Button answer4_button = answer_buttons[3];
<<<<<<< HEAD

    private int mAnswered = 99;
    private int mCurrentIndex = 0;

    private boolean timeUp;
    private boolean mIsPaused = false;
    private boolean isFocusedOn=true;
    private boolean isBundleEmpty = true;
    private boolean timeEnded =false;

    private Question[] mQuestionBank;
=======
    private  boolean timeUp;
    private int mAnswered = 99;
    private int totalTime;
    private boolean mIsPaused = false;

    //boolean -> isFocusedOn
    private boolean isFocusedOn=true;

    //is backUp bundle empty ?
    private boolean isBundleEmpty = true;

    private boolean timeEnded =false;

    private Button mNextButton;

    private TextView mQuestionTextView;


    private Question[] mQuestionBank;
    private int mCurrentIndex = 0;
>>>>>>> 11be444eea567caf2754cadfe40add0954f1c54d

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

<<<<<<< HEAD
=======



>>>>>>> 11be444eea567caf2754cadfe40add0954f1c54d
        //get intent
        Intent previousIntent = getIntent();
        mainUser = (User) previousIntent.getExtras().get(NicknameActivity.EXTRA_USER);
        userScore = mainUser.getmUserScore();
        mQuestionBank = (Question[]) previousIntent.getExtras().get(NicknameActivity.EXTRA_QUESTIONS);
        mCurrentIndex = (int) previousIntent.getExtras().get(NicknameActivity.EXTRA_INDEX);

<<<<<<< HEAD
=======

>>>>>>> 11be444eea567caf2754cadfe40add0954f1c54d
        //get the Bundle data (saved Instance)
        if (savedInstanceState != null) {
            isFocusedOn = savedInstanceState.getBoolean("isFocusedOn");
            mLocalTime = savedInstanceState.getInt("timeRemained");
            isBundleEmpty=false;
            timeEnded = savedInstanceState.getBoolean("timeEnded");
            mQuestionBank = (Question[]) savedInstanceState.getSerializable("questions");
            mainUser = (User) savedInstanceState.getSerializable("mainUser");
<<<<<<< HEAD
        }

        //progress bar
=======


        }

        //set the progress bar :)

>>>>>>> 11be444eea567caf2754cadfe40add0954f1c54d
        progress = mCurrentIndex;
        progressBar = (ProgressBar) findViewById(R.id.questionProgress_ProgressBar);
        progressBar.setProgress(progress);
        progressBar.setMax(mQuestionBank.length-1);

<<<<<<< HEAD
=======


>>>>>>> 11be444eea567caf2754cadfe40add0954f1c54d
        //total time counter
        totalTime = mainUser.getmTotalTime();
        totalTimeRunner();

<<<<<<< HEAD
        //remaining time checker
        if (!mQuestionBank[mCurrentIndex].IsAnswered()) {
            if(isBundleEmpty) {
                mLocalTime = mQuestionBank[mCurrentIndex].getmQuestionTime();
            }
            timeRemained_text = (TextView) findViewById(R.id.textView_remainingTime);
            runTimer();
        }
=======
        //remaining time system begin
        if (!mQuestionBank[mCurrentIndex].IsAnswered()) {

            if(isBundleEmpty) {
                mLocalTime = mQuestionBank[mCurrentIndex].getmQuestionTime();
            }

            timeRemained_text = (TextView) findViewById(R.id.textView_remainingTime);

            runTimer();
        }
        //remaining time system end


>>>>>>> 11be444eea567caf2754cadfe40add0954f1c54d

        score_text = (TextView) findViewById(R.id.textView_userScore);
        score_text.setText("User score: " + userScore);

        userID_text = (TextView) findViewById(R.id.textView_userID);
        userID_text.setText("User: " + mainUser.getmUserNickname());

<<<<<<< HEAD
=======
        //score_text = (TextView) findViewById(R.id.textView_userScore);
        //score_text.setText("User score: " + userScore);


>>>>>>> 11be444eea567caf2754cadfe40add0954f1c54d
        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);
        Answer[] answers_question = mQuestionBank[mCurrentIndex].getAnswers();

        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
        buttonAnim(mQuestionTextView, 500);

        answer1_button = (Button) findViewById(R.id.answer1_button);
        answer1_button.setText(answers_question[0].getmAnswerTextID());
        buttonAnim(answer1_button, 1000);

        answer2_button = (Button) findViewById(R.id.answer2_button);
        answer2_button.setText(answers_question[1].getmAnswerTextID());
        buttonAnim(answer2_button, 1500);

        answer3_button = (Button) findViewById(R.id.answer3_button);
        answer3_button.setText(answers_question[2].getmAnswerTextID());
        buttonAnim(answer3_button, 2000);

        answer4_button = (Button) findViewById(R.id.answer4_button);
        answer4_button.setText(answers_question[3].getmAnswerTextID());
        buttonAnim(answer4_button, 2500);

<<<<<<< HEAD
=======


>>>>>>> 11be444eea567caf2754cadfe40add0954f1c54d
        //onClick if not answered ->get the answer click
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
<<<<<<< HEAD

        }else{

            totalTimeRunner();
            mAnswered = mQuestionBank[mCurrentIndex].getmGivenAnswer();

            if(mAnswered==99){ // time is up
=======
        }else{
            totalTimeRunner();
            mAnswered = mQuestionBank[mCurrentIndex].getmGivenAnswer();
            if(mAnswered==99){

                //if the time up case

>>>>>>> 11be444eea567caf2754cadfe40add0954f1c54d
                setButtonColor(1, false);
                setButtonColor(2, false);
                setButtonColor(3, false);
                setButtonColor(4, false);
<<<<<<< HEAD

            }else { // answered before the time is up

                setButtonColor(mAnswered, mQuestionBank[mCurrentIndex].isAnswerTrue());
            }

            //toaster
            int messageResId = 0;
            messageResId = R.string.already_answered;
            Toast.makeText(this, messageResId, Toast.LENGTH_LONG)
                    .show();
=======
            }else {

                // else -> the answered case
                setButtonColor(mAnswered, mQuestionBank[mCurrentIndex].isAnswerTrue());
            }

            //toast sending part

            int messageResId = 0;


            messageResId = R.string.already_answered;


            Toast.makeText(this, messageResId, Toast.LENGTH_LONG)
                    .show();

            //end of toast


>>>>>>> 11be444eea567caf2754cadfe40add0954f1c54d
        }

        mNextButton = (Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //increase the total time
                mainUser.setmTotalTime(totalTime);

                //helper method for intent for next question
                nextQuestion();
            }
        });
<<<<<<< HEAD
    }

    private void nextQuestion() {
=======


    }

    private void nextQuestion() {
        //end current question -> make it unanswarable
>>>>>>> 11be444eea567caf2754cadfe40add0954f1c54d
        endQuestion();

        /*this method checks for the question number
        -> if the current question is the last question :: outputs the score screen
        -> else shows the next question
         */
<<<<<<< HEAD
        if (mCurrentIndex >= (mQuestionBank.length-1)){
            //play trophy sound if not muted
            if(!mainUser.IsMusicMuted()) playSound(R.raw.endgame_sound);
=======

        if (mCurrentIndex >= (mQuestionBank.length-1)){

            //play trophy sound if not muted
            if(!mainUser.IsMusicMuted()) playSound(R.raw.endgame_sound);

>>>>>>> 11be444eea567caf2754cadfe40add0954f1c54d
            //score screen
            Intent scoreScreen = new Intent(QuestionActivity.this, ScoreScreenActivity.class);
            scoreScreen.putExtra(NicknameActivity.EXTRA_USER, mainUser);
            startActivity(scoreScreen);

<<<<<<< HEAD
            //toaster
            int messageResId = 0;
            messageResId = R.string.bravo;
            Toast.makeText(this, messageResId, Toast.LENGTH_LONG)
                    .show();
        }else {
            //play nextQuestion sound if not muted
            if(!mainUser.IsMusicMuted()) playSound(R.raw.nextquestion_sound);
            //intent for next question
            //set onClick listener to the next button
=======
            //toast sending part

            int messageResId = 0;


            messageResId = R.string.bravo;


            Toast.makeText(this, messageResId, Toast.LENGTH_LONG)
                    .show();

            //end of toast

        }else {
            //play nextQuestion sound if not muted
            if(!mainUser.IsMusicMuted()) playSound(R.raw.nextquestion_sound);

            //intent for next question
            //set onClick listener to the next button


>>>>>>> 11be444eea567caf2754cadfe40add0954f1c54d
            //create an intent
            Intent startIntent = new Intent(QuestionActivity.this, QuestionActivity.class);
            startIntent.putExtra(NicknameActivity.EXTRA_USER, mainUser);
            startIntent.putExtra(NicknameActivity.EXTRA_QUESTIONS, mQuestionBank);
            startIntent.putExtra(NicknameActivity.EXTRA_INDEX, (mCurrentIndex+1));
            startActivity(startIntent);
        }
<<<<<<< HEAD
    }

    private void prevQuestion() {
        endQuestion();
        if (mCurrentIndex == 0){ // case: current question -> first question
            // toaster
            int messageResId = 0;
            messageResId = R.string.first_question_no_back;
            Toast.makeText(this, messageResId, Toast.LENGTH_LONG)
                    .show();
        }else {
            //intent for prev question
=======

    }


    private void prevQuestion() {

        //end current question -> make it unanswarable
        endQuestion();

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
>>>>>>> 11be444eea567caf2754cadfe40add0954f1c54d
            Intent startIntent = new Intent(QuestionActivity.this, QuestionActivity.class);
            startIntent.putExtra(NicknameActivity.EXTRA_USER, mainUser);
            startIntent.putExtra(NicknameActivity.EXTRA_QUESTIONS, mQuestionBank);
            startIntent.putExtra(NicknameActivity.EXTRA_INDEX, (mCurrentIndex - 1) );
            startActivity(startIntent);
        }
<<<<<<< HEAD
    }

    private void setAnswer(int userPressed) {
        if (mQuestionBank[mCurrentIndex].IsAnswered()) {
            //toaster
            int messageResId = 0;
            messageResId = R.string.already_answered;
            Toast.makeText(this, messageResId, Toast.LENGTH_LONG)
                    .show();
        } else {
            mQuestionBank[mCurrentIndex].setIsAnswered(true);
            //check for answer
            mQuestionBank[mCurrentIndex].setIsAnswerTrue(userPressed);
            boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();
            //update given answer
            mQuestionBank[mCurrentIndex].setmGivenAnswer(userPressed);
=======

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

>>>>>>> 11be444eea567caf2754cadfe40add0954f1c54d
            //update the user score
            if (answerIsTrue) {
                mainUser.rightAnswer();
            } else {
                mainUser.wrongAnswer();
            }
<<<<<<< HEAD
            //update score text
            updateScore();
            //change the pressed button color
            setButtonColor(userPressed, answerIsTrue);

            //toaster & sound
            int messageResId = 0;
=======

            //update score text
            updateScore();

            //change the pressed button color
            setButtonColor(userPressed, answerIsTrue);



            //toast sending part & also plays sound (wrong or right) if not muted

            int messageResId = 0;

>>>>>>> 11be444eea567caf2754cadfe40add0954f1c54d
            if (answerIsTrue) {
                messageResId = R.string.correct_toast;
                if(!mainUser.IsMusicMuted()) playSound(R.raw.rightanswer_sound);
            } else {
                messageResId = R.string.incorrect_toast;
                if(!mainUser.IsMusicMuted()) playSound(R.raw.wronganswer_sound);
            }
<<<<<<< HEAD
            Toast.makeText(this, messageResId, Toast.LENGTH_LONG)
                    .show();
=======

            Toast.makeText(this, messageResId, Toast.LENGTH_LONG)
                    .show();

            //end of toast
>>>>>>> 11be444eea567caf2754cadfe40add0954f1c54d
        }
    }

    private void updateScore(){
        userScore = mainUser.getmUserScore();
        score_text.setText("User score: " + userScore);
    }

<<<<<<< HEAD
    private void setButtonColor(int answeredButton, boolean answerIsTrue){ // right -> green, wrong -> red
        int updatedButtonColor;
        if (answerIsTrue) {
            updatedButtonColor = Color.GREEN;
        } else {
            updatedButtonColor = Color.RED;
        }
=======

    private void setButtonColor(int answeredButton, boolean answerIsTrue){


        //color button in accordance with the answerIsTrue boolean -> if true answer green button, else red button

        int updatedButtonColor;
        if (answerIsTrue) {
            updatedButtonColor = Color.GREEN;

        } else {
            updatedButtonColor = Color.RED;

        }


>>>>>>> 11be444eea567caf2754cadfe40add0954f1c54d
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

<<<<<<< HEAD
    // handling back button
=======
    //handle back button
>>>>>>> 11be444eea567caf2754cadfe40add0954f1c54d
    @Override
    public void onBackPressed() {
        prevQuestion();
    }

    private void runTimer() {
        timeUp = false;
<<<<<<< HEAD
=======


>>>>>>> 11be444eea567caf2754cadfe40add0954f1c54d
        final Handler countDown_handler = new Handler();
        countDown_handler.post(new Runnable() {

            @Override
            public void run() {
                if (!timeUp && !timeEnded) {
                    if(!mQuestionBank[mCurrentIndex].IsAnswered()){
                        String remainingTime = "Remaining Time: " + mLocalTime;
                        timeRemained_text.setText(remainingTime);
                        if (mLocalTime <= 0 ) {
                            timeUp = true;
<<<<<<< HEAD
                        }
                        //before continuing the count down check if app is paused
                        if(!mIsPaused) mLocalTime--;
=======


                        }

                        //before continuing the count down check if app is paused
                        if(!mIsPaused) mLocalTime--;

>>>>>>> 11be444eea567caf2754cadfe40add0954f1c54d
                        countDown_handler.postDelayed(this, 1000);
                    }else {
                        String remainingTime = "Already answered!";
                        timeRemained_text.setText(remainingTime);
                    }
                }else{
                    timeIsUp();
                }
            }

        });
<<<<<<< HEAD
        //increase the total time
        mainUser.setmTotalTime(totalTime);
    }

    private void makeAToast(int messageResId){
        //toaster
        Toast.makeText(this, messageResId, Toast.LENGTH_LONG)
                .show();
=======

        //increase the total time
        mainUser.setmTotalTime(totalTime);


    }


    private void makeAToast(int messageResId){
        //toast sending part


        Toast.makeText(this, messageResId, Toast.LENGTH_LONG)
                .show();

        //end of toast
>>>>>>> 11be444eea567caf2754cadfe40add0954f1c54d
    }

    public void timeIsUp() {
        mQuestionBank[mCurrentIndex].setIsAnswered(true);
        setButtonColor(1, false);
        setButtonColor(2, false);
        setButtonColor(3, false);
        setButtonColor(4, false);
<<<<<<< HEAD
        makeAToast(R.string.timeIsUp);

        if(!mainUser.IsMusicMuted()) playSound(R.raw.timeup_sound);

        nextQuestion(); //when time is up
=======

        makeAToast(R.string.timeIsUp);


        //play timeUp sound if not muted
        if(!mainUser.IsMusicMuted()) playSound(R.raw.timeup_sound);

        //go to next question when time is up
        nextQuestion();






>>>>>>> 11be444eea567caf2754cadfe40add0954f1c54d
    }

    public void timeIsUpGoNext() {
        mQuestionBank[mCurrentIndex].setIsAnswered(true);
        setButtonColor(1, false);
        setButtonColor(2, false);
        setButtonColor(3, false);
        setButtonColor(4, false);
<<<<<<< HEAD
        makeAToast(R.string.timeIsUp);
         if(!mainUser.IsMusicMuted()) playSound(R.raw.wronganswer_sound);
    }

    public void totalTimeRunner(){
=======

        makeAToast(R.string.timeIsUp);


        //play wrong sound if not muted
        if(!mainUser.IsMusicMuted()) playSound(R.raw.wronganswer_sound);







    }

    public void totalTimeRunner(){



>>>>>>> 11be444eea567caf2754cadfe40add0954f1c54d
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
<<<<<<< HEAD
                //before increasing the time check if the app is paused
                if(!mIsPaused) totalTime++;
=======

                //before increasing the time check if the app is paused
                if(!mIsPaused) totalTime++;

>>>>>>> 11be444eea567caf2754cadfe40add0954f1c54d
                handler.postDelayed(this, 1000);
            }
        });
    }

<<<<<<< HEAD
=======

>>>>>>> 11be444eea567caf2754cadfe40add0954f1c54d
    public void playSound(int id) {
        try {
            MediaPlayer playSound = MediaPlayer.create(QuestionActivity.this, id);
            playSound.start();
        }
        catch (NullPointerException e) {

        }
    }
<<<<<<< HEAD
    //button animation methods
    private void buttonAnim(View myView, long duration){
=======

    //button animation methods
    private void buttonAnim(View myView, long duration){


>>>>>>> 11be444eea567caf2754cadfe40add0954f1c54d
        myView.startAnimation(inFromDownAnimation(duration));
    }

    private Animation inFromDownAnimation(long duration) {
<<<<<<< HEAD
=======

>>>>>>> 11be444eea567caf2754cadfe40add0954f1c54d
        Animation downtoup = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, +1.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f);
        downtoup.setDuration(duration);
        downtoup.setInterpolator(new AccelerateInterpolator());
        return downtoup;
    }
    //end of button animation methods

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        isFocusedOn = false;
<<<<<<< HEAD
=======

>>>>>>> 11be444eea567caf2754cadfe40add0954f1c54d
        savedInstanceState.putBoolean("isFocusedOn", isFocusedOn);
        savedInstanceState.putInt("timeRemained", mLocalTime);
        if(mLocalTime <= 0) timeEnded =true;
        savedInstanceState.putBoolean("timeEnded", timeEnded);
        mainUser.setmTotalTime(totalTime);
        savedInstanceState.putSerializable("mainUser", mainUser);
        savedInstanceState.putSerializable("questions", mQuestionBank);
<<<<<<< HEAD
    }

=======

    }


>>>>>>> 11be444eea567caf2754cadfe40add0954f1c54d
    //if time didn't end and the question is not answered but clicked to next or prev
    private void endQuestion(){
        if (!timeUp && !mQuestionBank[mCurrentIndex].IsAnswered()){
            timeIsUpGoNext();
        }
    }

<<<<<<< HEAD
=======

>>>>>>> 11be444eea567caf2754cadfe40add0954f1c54d
    //on pause
    @Override
    public void onPause() {
        super.onPause();  // Always call the superclass method first

        mIsPaused=true;


    }
<<<<<<< HEAD
=======
    //end onpause

>>>>>>> 11be444eea567caf2754cadfe40add0954f1c54d

    //on resume
    @Override
    public void onResume() {
        super.onResume();
<<<<<<< HEAD
        mIsPaused=false;
        }
=======

        mIsPaused=false;
        }


    //end onresume

>>>>>>> 11be444eea567caf2754cadfe40add0954f1c54d
}
