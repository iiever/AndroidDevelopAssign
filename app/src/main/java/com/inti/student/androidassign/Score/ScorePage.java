package com.inti.student.androidassign.Score;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.inti.student.androidassign.Question.Question;
import com.inti.student.androidassign.R;

import java.util.ArrayList;
import java.util.List;

public class ScorePage extends AppCompatActivity {


    RecyclerView recyclerView;
    ScoreAdapter adapter;

    List<Question> scoreList;
    FirebaseDatabase database;
    DatabaseReference question;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        database = FirebaseDatabase.getInstance();
        question = database.getReference("Question");

        setContentView(R.layout.activity_score_page);

        scoreList = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        for(int index=0; index<scoreList.size();index++) {
            scoreList.get(index).getScore();
        }

        adapter = new ScoreAdapter(this, scoreList);
        recyclerView.setAdapter(adapter);
    }
}
