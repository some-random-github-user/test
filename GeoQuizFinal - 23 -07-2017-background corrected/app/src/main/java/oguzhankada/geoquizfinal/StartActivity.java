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
    private Button StartButton;
    private User mainUser;
    private Question[] mQuestionDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Intent previousIntent = getIntent();
        mainUser = (User) previousIntent.getExtras().get(NicknameActivity.EXTRA_USER);
        mQuestionDatabase = (Question[]) previousIntent.getExtras().get(NicknameActivity.EXTRA_QUESTIONS);

        Button b =(Button)findViewById(R.id.start_button);

        //next button listener
        StartButton = (Button) findViewById(R.id.start_button) ;
        StartButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                if (!mainUser.IsMusicMuted()) playStartSound();
                //create an intent
                Intent startIntent = new Intent(StartActivity.this, QuestionActivity.class);
                startIntent.putExtra(NicknameActivity.EXTRA_USER, mainUser);
                startIntent.putExtra(NicknameActivity.EXTRA_QUESTIONS, mQuestionDatabase);
                startIntent.putExtra(NicknameActivity.EXTRA_INDEX, 0);
                startActivity(startIntent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        //toaster
        int messageResId = 0;
        messageResId = R.string.no_going_back;
        Toast.makeText(this, messageResId, Toast.LENGTH_LONG)
                .show();
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