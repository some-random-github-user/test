package oguzhankada.geoquizfinal;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StartActivity extends AppCompatActivity {
<<<<<<< HEAD
=======


>>>>>>> 11be444eea567caf2754cadfe40add0954f1c54d
    private Button StartButton;
    private User mainUser;
    private Question[] mQuestionDatabase;

<<<<<<< HEAD
=======


>>>>>>> 11be444eea567caf2754cadfe40add0954f1c54d
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
<<<<<<< HEAD
=======

>>>>>>> 11be444eea567caf2754cadfe40add0954f1c54d
        Intent previousIntent = getIntent();
        mainUser = (User) previousIntent.getExtras().get(NicknameActivity.EXTRA_USER);
        mQuestionDatabase = (Question[]) previousIntent.getExtras().get(NicknameActivity.EXTRA_QUESTIONS);

        Button b =(Button)findViewById(R.id.start_button);

<<<<<<< HEAD
        //next button listener
=======
        //set onClick listener to the next button
>>>>>>> 11be444eea567caf2754cadfe40add0954f1c54d
        StartButton = (Button) findViewById(R.id.start_button) ;
        StartButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
<<<<<<< HEAD
                if (!mainUser.IsMusicMuted()) playStartSound();
=======
                //if music is not muted play the startGame sound
                if (!mainUser.IsMusicMuted()) playStartSound();


>>>>>>> 11be444eea567caf2754cadfe40add0954f1c54d
                //create an intent
                Intent startIntent = new Intent(StartActivity.this, QuestionActivity.class);
                startIntent.putExtra(NicknameActivity.EXTRA_USER, mainUser);
                startIntent.putExtra(NicknameActivity.EXTRA_QUESTIONS, mQuestionDatabase);
                startIntent.putExtra(NicknameActivity.EXTRA_INDEX, 0);
                startActivity(startIntent);
            }
        });
<<<<<<< HEAD
=======



>>>>>>> 11be444eea567caf2754cadfe40add0954f1c54d
    }

    @Override
    public void onBackPressed() {
<<<<<<< HEAD
        //toaster
        int messageResId = 0;
        messageResId = R.string.no_going_back;
        Toast.makeText(this, messageResId, Toast.LENGTH_LONG)
                .show();
=======
        //toast sending part

        int messageResId = 0;


        messageResId = R.string.no_going_back;


        Toast.makeText(this, messageResId, Toast.LENGTH_LONG)
                .show();

        //end of toast
>>>>>>> 11be444eea567caf2754cadfe40add0954f1c54d
    }

    public void playStartSound() {
        try {
            MediaPlayer playSound = MediaPlayer.create(StartActivity.this, R.raw.start_sound);
            playSound.start();
        }
        catch (NullPointerException e) {

        }
    }
}
