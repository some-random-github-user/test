package oguzhankada.geoquizfinal;

import java.io.Serializable;

<<<<<<< HEAD
public class Question implements Serializable {

    private int mTextResId, mRightAnswer, mQuestionTime, mGivenAnswer;
    private boolean mIsAnswered, mIsAnswerTrue;
    private Answer[] mAnswers;

    //constructor
=======
/**
 * Created by Orklar on 7/19/2017.
 */

public class Question implements Serializable {


    private int mTextResId;
    private int mRightAnswer;
    private boolean mIsAnswered;
    private Answer[] mAnswers;
    private  boolean mIsAnswerTrue;
    private int mQuestionTime; //seconds
    private int mGivenAnswer;


    //constructor for question
>>>>>>> 11be444eea567caf2754cadfe40add0954f1c54d
    public Question(int textResId, int rightAnswer, Answer[] answers, int time) {
        mTextResId = textResId;
        mRightAnswer = rightAnswer;
        mIsAnswered = false;
        mAnswers = answers;
        mIsAnswerTrue = false;
        mQuestionTime = time;
        mGivenAnswer = 99;
    }

<<<<<<< HEAD
=======



>>>>>>> 11be444eea567caf2754cadfe40add0954f1c54d
    public int getmRightAnswer() {
        return mRightAnswer;
    }

<<<<<<< HEAD
=======

>>>>>>> 11be444eea567caf2754cadfe40add0954f1c54d
    public boolean IsAnswered() {
        return mIsAnswered;
    }

    public void setIsAnswered(boolean mIsAnswered) {
        this.mIsAnswered = mIsAnswered;
    }

    public Answer[] getAnswers() {
        return mAnswers;
    }

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

<<<<<<< HEAD
=======

>>>>>>> 11be444eea567caf2754cadfe40add0954f1c54d
    public boolean isAnswerTrue() {
        return mIsAnswerTrue;
    }

    public void setIsAnswerTrue(int answer) {
        mIsAnswerTrue = mRightAnswer==answer;
    }

    public int getmQuestionTime() {
        return mQuestionTime;
    }

    public void setmQuestionTime(int mQuestionTime) {
        this.mQuestionTime = mQuestionTime;
    }

    public int getmGivenAnswer() {
        return mGivenAnswer;
    }

    public void setmGivenAnswer(int mGivenAnswer) {
        this.mGivenAnswer = mGivenAnswer;
    }
}
