package oguzhankada.geoquizfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ScoreScreenActivity extends AppCompatActivity {

    private Button mRestartButton;
    private User mainUser;
    private int mFinalScore;
    private TextView scoreText;
    private TextView timeText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_screen);

        Intent previousIntent = getIntent();
        mainUser = (User) previousIntent.getExtras().get(NicknameActivity.EXTRA_USER);
        mFinalScore = mainUser.getmUserScore();


        scoreText = (TextView) findViewById(R.id.scoreScreen_text);
        scoreText.setText("Final Score: " + mFinalScore);

        timeText = (TextView) findViewById(R.id.timeScreen_text);
        timeText.setText("Total time: " + mainUser.getmTotalTime() + " seconds");

        mRestartButton =(Button)findViewById(R.id.newGame_button);

<<<<<<< HEAD
        //restart button listener
=======

        //set onClick listener to the restart button

>>>>>>> 11be444eea567caf2754cadfe40add0954f1c54d
        mRestartButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
<<<<<<< HEAD
=======

>>>>>>> 11be444eea567caf2754cadfe40add0954f1c54d
                Intent restartIntent = new Intent(ScoreScreenActivity.this, NicknameActivity.class);
                startActivity(restartIntent);
            }
        });
    }

<<<<<<< HEAD
    @Override
    public void onBackPressed() {
        //toaster
        int messageResId = 0;
        messageResId = R.string.no_going_back;
        Toast.makeText(this, messageResId, Toast.LENGTH_LONG)
                .show();
=======

    @Override
    public void onBackPressed() {
        //toast sending part

        int messageResId = 0;


        messageResId = R.string.no_going_back;


        Toast.makeText(this, messageResId, Toast.LENGTH_LONG)
                .show();

        //end of toast
>>>>>>> 11be444eea567caf2754cadfe40add0954f1c54d
    }
}
