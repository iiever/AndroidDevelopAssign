package com.inti.student.androidassign.Question;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.inti.student.androidassign.R;


public class QuestionPage extends FragmentActivity {

    private Button NextBtn;
    int click_count = 0;
    int score_count = 0;
    private static Question mQuestion;
    private TextView totalScore;
    private int test;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_page);
        mQuestion = new Question();


        NextBtn = (Button) findViewById(R.id.nextBtn);

        final FragmentManager fm = getSupportFragmentManager();
        final FragmentTransaction fragmentTransaction = fm.beginTransaction();

        QuestionFragment fragment = new QuestionFragment();
        fragmentTransaction.add(R.id.fragment_container, fragment);
        fragmentTransaction.commit();

            NextBtn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    if(click_count != 10) {

                        QuestionFragment fragment = new QuestionFragment();
                        fm.beginTransaction()
                                .replace(R.id.fragment_container, fragment).commit();

                        click_count++;

                       getTrue();

                        if(test == 5)
                        {
                          score_count = score_count +10;
                            mQuestion.getScore();
                            totalScore =(TextView)findViewById(R.id.total_score);
                            totalScore.setText("Score is "+ score_count);
                            mQuestion.setScore2(score_count);

                            setTest();
                        }
                        else if(test == 0) {

                            totalScore =(TextView)findViewById(R.id.total_score);
                            totalScore.setText("Score is "+score_count);
                        }
                    }
                    else if(click_count == 10) {

                        goTotalScorePage();
                    }
                }
            });
}

    public void getTrue (){
        Intent i = getIntent();
        test = i.getIntExtra("QuestionFragment", 5);
    }

    private void goTotalScorePage(){
        Intent intent = new Intent(QuestionPage.this, TotalScorePage.class);
        intent.putExtra("QuestionPage",score_count);
        startActivity(intent);
    }

    public void setTest(){
        test = 0;
    }

}

