package oguzhankada.geoquizfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class NicknameActivity extends AppCompatActivity {

    static final String EXTRA_USER = "app.user";
    static final String EXTRA_INDEX = "app.questionIndex";
    private EditText NicknameText;
    private Button NextButton;

    //create the question base
    private Answer[] mQuestion1 = new Answer[] {
            new Answer(R.string.question1answer1),
            new Answer(R.string.question1answer2),
            new Answer(R.string.question1answer3),
            new Answer(R.string.question1answer4),
    };


    private Question[] mQuestionBank = new Question[] {
            new Question(R.string.question1, 4, mQuestion1, 60),
            new Question(R.string.question1, 4, mQuestion1, 60),
//            new Question(R.string.question_oceans, true),
//            new Question(R.string.question_mideast, false),
//            new Question(R.string.question_africa, false),
//            new Question(R.string.question_americas, true),
//            new Question(R.string.question_asia, true),
    };

    static final String EXTRA_QUESTIONS = "app.questions";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nickname);



        //set onClick listener to the next button
        NextButton = (Button) findViewById(R.id.Nickname_NextButton) ;
        NextButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                //get the Nickname (from EditText) upon button click
                NicknameText = (EditText) findViewById(R.id.Nickname_EditText);
                String Nickname = NicknameText.getText().toString();

                //check if the Nickname is valid (if not ask for a new Nick
                if(isValidNickname(Nickname)) {

                    //create a new user with given Nickname
                    User mainUser = new User(Nickname);

                    //create an intent
                    Intent nextIntent = new Intent(NicknameActivity.this, StartActivity.class);
                    nextIntent.putExtra(EXTRA_USER, mainUser);
                    nextIntent.putExtra(EXTRA_QUESTIONS, mQuestionBank);

                    startActivity(nextIntent);
                }else{


                    makeAToast(R.string.emptyNickname);


                }

            }
        });










    }


    @Override
    public void onBackPressed() {
        makeAToast(R.string.no_going_back);
    }


    private boolean isValidNickname(String name){
        return !(name.isEmpty());
    }


    private void makeAToast(int messageResId){
        //toast sending part


        Toast.makeText(this, messageResId, Toast.LENGTH_LONG)
                .show();

        //end of toast
    }
}
