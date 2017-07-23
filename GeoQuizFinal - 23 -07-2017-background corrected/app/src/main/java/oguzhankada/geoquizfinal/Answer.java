package oguzhankada.geoquizfinal;

import java.io.Serializable;

<<<<<<< HEAD
=======
/**
 * Created by Orklar on 7/19/2017.
 */

>>>>>>> 11be444eea567caf2754cadfe40add0954f1c54d
public class Answer implements Serializable {

    private int mAnswerTextID;
    public Answer(int answerTextID) {
        mAnswerTextID= answerTextID;
    }

    public int getmAnswerTextID() {
        return mAnswerTextID;
    }

    public void setmAnswerTextID(int mAnswerTextID) {
        this.mAnswerTextID = mAnswerTextID;
    }
}
