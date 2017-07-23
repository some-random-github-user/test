package oguzhankada.geoquizfinal;

import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class NicknameActivity extends AppCompatActivity {

    static final String EXTRA_USER = "app.user";
    static final String EXTRA_INDEX = "app.questionIndex";
<<<<<<< HEAD
    static final String EXTRA_QUESTIONS = "app.questions";

    private EditText NicknameText;
    private Button NextButton, MuteMusic;
    private String Nickname;
    private boolean mIsMusicMuted = false;

=======
    private EditText NicknameText;
    private Button NextButton;
    private Button MuteMusic;
    private String Nickname;
    private boolean mIsMusicMuted = false;
>>>>>>> 11be444eea567caf2754cadfe40add0954f1c54d
    //private MediaPlayer startsoundmusicplayer = MediaPlayer.create(this, R.raw.start_sound);


    //create the question base
//    private Answer[] mQuestion1 = new Answer[] {
//            new Answer(R.string.question1answer1),
//            new Answer(R.string.question1answer2),
//            new Answer(R.string.question1answer3),
//            new Answer(R.string.question1answer4),
//    };

    private Answer[][] Answers = new Answer[16][4];

<<<<<<< HEAD
    //
=======


//
>>>>>>> 11be444eea567caf2754cadfe40add0954f1c54d
//    private Question[] mQuestionBank = new Question[] {
//            new Question(R.string.question1, 4, mQuestion1, 5),
//            new Question(R.string.question1, 4, mQuestion1, 10),
////            new Question(R.string.question_oceans, true),
////            new Question(R.string.question_mideast, false),
////            new Question(R.string.question_africa, false),
////            new Question(R.string.question_americas, true),
////            new Question(R.string.question_asia, true),
//    };

<<<<<<< HEAD
    private Question[] mQuestionBank = new Question[16];
=======

    private Question[] mQuestionBank = new Question[16];


    //end question creation


    static final String EXTRA_QUESTIONS = "app.questions";

>>>>>>> 11be444eea567caf2754cadfe40add0954f1c54d
    static Bundle savedInstanceState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nickname);
<<<<<<< HEAD
        createQuestionArchieve();
        this.savedInstanceState = savedInstanceState;

=======

        createQuestionArchieve();


        this.savedInstanceState = savedInstanceState;
>>>>>>> 11be444eea567caf2754cadfe40add0954f1c54d
        NicknameText = (EditText) findViewById(R.id.Nickname_EditText);

        if (savedInstanceState != null) {
            Nickname = savedInstanceState.getString("Nickname");
            NicknameText.setText(Nickname);
        }
<<<<<<< HEAD
        //set onClick listener to the next button
        NextButton = (Button) findViewById(R.id.Nickname_NextButton) ;
        NextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //get the Nickname (from EditText) upon button click
                Nickname = NicknameText.getText().toString();
                //check if the Nickname is valid (if not ask for a new Nick
                if(isValidNickname(Nickname)) {

                    if (!mIsMusicMuted) playStartSound();
                    User mainUser = new User(Nickname);
                    mainUser.setmIsMusicMuted(mIsMusicMuted);
                    Intent nextIntent = new Intent(NicknameActivity.this, StartActivity.class);
                    nextIntent.putExtra(EXTRA_USER, mainUser);
                    nextIntent.putExtra(EXTRA_QUESTIONS, mQuestionBank);
                    startActivity(nextIntent);

                }else{

                    makeAToast(R.string.emptyNickname);

                }
=======


        //set onClick listener to the next button
        NextButton = (Button) findViewById(R.id.Nickname_NextButton) ;
        NextButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                //get the Nickname (from EditText) upon button click

                Nickname = NicknameText.getText().toString();


                //check if the Nickname is valid (if not ask for a new Nick
                if(isValidNickname(Nickname)) {

                    //if music is not muted play the startGame sound
                    //if(!mIsMusicMuted) startsoundmusicplayer.start();
                    if (!mIsMusicMuted) playStartSound();

                    //create a new user with given Nickname
                    User mainUser = new User(Nickname);

                    //modify IsMusicMuted of mainUser accordingly
                    mainUser.setmIsMusicMuted(mIsMusicMuted);

                    //create an intent
                    Intent nextIntent = new Intent(NicknameActivity.this, StartActivity.class);
                    nextIntent.putExtra(EXTRA_USER, mainUser);
                    nextIntent.putExtra(EXTRA_QUESTIONS, mQuestionBank);

                    startActivity(nextIntent);
                }else{


                    makeAToast(R.string.emptyNickname);


                }

>>>>>>> 11be444eea567caf2754cadfe40add0954f1c54d
            }
        });
        //end of onclick for next button

        //set onClick listener to the muteMusic button
        MuteMusic = (Button) findViewById(R.id.musicMute_button) ;
        MuteMusic.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
<<<<<<< HEAD
                mIsMusicMuted = !mIsMusicMuted;
                if(mIsMusicMuted) {

                    MuteMusic.setText(R.string.musicMuted);
                }else{

                    MuteMusic.setText(R.string.notMusicMuted);
                }
            }
        });
        //end of onclick for muteMusic button
    }

=======

                mIsMusicMuted = !mIsMusicMuted;
                if(mIsMusicMuted) {
                    MuteMusic.setText(R.string.musicMuted);
                }else{
                    MuteMusic.setText(R.string.notMusicMuted);
                }

            }
        });
        //end of onclick for muteMusic button



    }



>>>>>>> 11be444eea567caf2754cadfe40add0954f1c54d
    @Override
    public void onBackPressed() {
        makeAToast(R.string.no_going_back);
    }

<<<<<<< HEAD
=======

>>>>>>> 11be444eea567caf2754cadfe40add0954f1c54d
    private boolean isValidNickname(String name){
        return !(name.isEmpty());
    }

<<<<<<< HEAD
    private void makeAToast(int messageResId){

        Toast.makeText(this, messageResId, Toast.LENGTH_LONG)
                .show();
=======

    private void makeAToast(int messageResId){
        //toast sending part


        Toast.makeText(this, messageResId, Toast.LENGTH_LONG)
                .show();

        //end of toast
>>>>>>> 11be444eea567caf2754cadfe40add0954f1c54d
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        Nickname = NicknameText.getText().toString();
        savedInstanceState.putString("Nickname", Nickname);
    }

    public void playStartSound() {
        try {
            MediaPlayer playSound = MediaPlayer.create(NicknameActivity.this, R.raw.start_sound);
            playSound.start();
        }
        catch (NullPointerException e) {

        }
    }
<<<<<<< HEAD

=======
>>>>>>> 11be444eea567caf2754cadfe40add0954f1c54d
    private void createQuestionArchieve(){
        for(int y=1; y<17; y++){
            for(int x=1; x<5;x++) {
                Resources res = getResources();
                String message = "question" + y + "answer" + x;
                int id = res.getIdentifier(message, "string", getPackageName());
<<<<<<< HEAD
                Answers[y-1][x-1] = new Answer(id);
=======

                Answers[y-1][x-1] = new Answer(id);

>>>>>>> 11be444eea567caf2754cadfe40add0954f1c54d
            }
        }

        for(int i=0; i<16; i++){
            Resources res = getResources();
            String question_txt = "question" + (i+1);
            int question_text_id = res.getIdentifier(question_txt, "string", getPackageName());
<<<<<<< HEAD
            String question_answer_txt = "question" + (i+1) + "answer";
            int question_answer_id = res.getIdentifier(question_answer_txt, "integer", getPackageName());
=======

            String question_answer_txt = "question" + (i+1) + "answer";
            int question_answer_id = res.getIdentifier(question_answer_txt, "integer", getPackageName());

>>>>>>> 11be444eea567caf2754cadfe40add0954f1c54d
            mQuestionBank[i] = new Question(question_text_id, res.getInteger(question_answer_id), Answers[i], 20);
        }


    }
}
