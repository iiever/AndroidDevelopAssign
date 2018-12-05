package com.inti.student.androidassign.Question;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.inti.student.androidassign.MainPage;
import com.inti.student.androidassign.R;

public class TotalScorePage extends AppCompatActivity {

    private Question mQuestion;

    private TextView totalscore;
    private int ttlscore;

    private Button homePageBtn;

    FirebaseDatabase database;
    DatabaseReference questions;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        database = FirebaseDatabase.getInstance();
        questions = database.getReference("Question");
        mQuestion = new Question();
        setContentView(R.layout.total_score_page);

        totalscore = (TextView) findViewById(R.id.totalscore);
        Intent get = getIntent();
        ttlscore = get.getIntExtra("QuestionPage", 0);
        String ttllscore = String.valueOf(ttlscore);

        totalscore.setText(ttllscore);

        homePageBtn = (Button) findViewById(R.id.home_Btn);

        homePageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TotalScorePage.this, MainPage.class);
                startActivity(intent);
            }

        });
    }
}
