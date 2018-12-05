package com.inti.student.androidassign;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.inti.student.androidassign.Question.QuestionPage;
import com.inti.student.androidassign.Score.ScorePage;

public class MainPage extends AppCompatActivity {


    private ImageButton startBtn;
    private ImageButton checkScoreBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startBtn = (ImageButton)findViewById(R.id.startBtn);
        checkScoreBtn =(ImageButton)findViewById(R.id.scoreBtn);


        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPage.this, QuestionPage.class);
                startActivity(intent);
            }
        });

        checkScoreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPage.this, ScorePage.class);
                startActivity(intent);
            }
        });
    }


}
