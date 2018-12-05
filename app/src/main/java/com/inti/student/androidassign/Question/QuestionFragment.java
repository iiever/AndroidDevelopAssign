package com.inti.student.androidassign.Question;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.inti.student.androidassign.R;

import java.util.Random;

public class QuestionFragment extends Fragment {

    View myFragment;


    private Question mQuestion;
    private TextView questionFront;
    private TextView questionBack;
    private TextView questionSymbol;
    private int currentScore;
    int btnAns = 0;

    private Button BtnA;
    private Button BtnB;
    private Button BtnC;
    private Button BtnD;

    FirebaseDatabase database;
    DatabaseReference questions;
    DatabaseReference scoress;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        database = FirebaseDatabase.getInstance();
        questions = database.getReference("Question");
        scoress = database.getReference("Score");
        mQuestion = new Question();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myFragment = inflater.inflate(R.layout.question_fragment, container, false);


        int symbol;
        final double total;
        double qnFront, qnBack;




        questionFront = (TextView) myFragment.findViewById(R.id.question_front);
        qnFront = QuestionGenerate();
        int qnFrontC = (int) qnFront;
        String frontNum = String.valueOf(qnFrontC);
        questionFront.setText(frontNum);


        questionSymbol = (TextView) myFragment.findViewById(R.id.question_symbol_1);
        symbol = RandomSymbol();

        if (symbol == 1) {

            questionSymbol.setText(" + ");
        } else if (symbol == 2) {

            questionSymbol.setText("  - ");
        } else if (symbol == 3) {

            questionSymbol.setText(" * ");
        } else if (symbol == 4) {

            questionSymbol.setText(" / ");
        }


        questionBack = (TextView) myFragment.findViewById(R.id.question_back);
        qnBack = QuestionGenerate();
        int qnBackC = (int) qnBack;
        String backNum = String.valueOf(qnBackC);
        questionBack.setText(backNum);

        total = CalculateAns(qnFrontC, symbol, qnBackC);

        int totalc = (int) total;


        BtnA = (Button) myFragment.findViewById(R.id.btnA);
        BtnB = (Button) myFragment.findViewById(R.id.btnB);
        BtnC = (Button) myFragment.findViewById(R.id.btnC);
        BtnD = (Button) myFragment.findViewById(R.id.btnD);



        btnAns = GenerateAns();

        if(btnAns == 1 ){


            String BtnAAns = String.valueOf(totalc);
            BtnA.setText(BtnAAns);

            String BtnBAns = String.valueOf(BtnAns());
            BtnB.setText(BtnBAns);

            String BtnCAns = String.valueOf(BtnAns());
            BtnC.setText(BtnCAns);

            String BtnDAns = String.valueOf(BtnAns());
            BtnD.setText(BtnDAns);

        }else if(btnAns == 2 ){

            String BtnAAns = String.valueOf(BtnAns());
            BtnA.setText(BtnAAns);

            String BtnBAns = String.valueOf(totalc);
            BtnB.setText(BtnBAns);

            String BtnCAns = String.valueOf(BtnAns());
            BtnC.setText(BtnCAns);

            String BtnDAns = String.valueOf(BtnAns());
            BtnD.setText(BtnDAns);


        }else if(btnAns == 3 ) {

            String BtnAAns = String.valueOf(BtnAns());
            BtnA.setText(BtnAAns);

            String BtnBAns = String.valueOf(BtnAns());
            BtnB.setText(BtnBAns);

            String BtnCAns = String.valueOf(totalc);
            BtnC.setText(BtnCAns);

            String BtnDAns = String.valueOf(BtnAns());
            BtnD.setText(BtnDAns);

        }else if(btnAns == 4 ) {

            String BtnAAns = String.valueOf(BtnAns());
            BtnA.setText(BtnAAns);

            String BtnBAns = String.valueOf(BtnAns());
            BtnB.setText(BtnBAns);

            String BtnCAns = String.valueOf(BtnAns());
            BtnC.setText(BtnCAns);

            String BtnDAns = String.valueOf(totalc);
            BtnD.setText(BtnDAns);
        }




        BtnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(btnAns == 1){
                    currentScore+=10;
                    mQuestion.setScore(currentScore);
                    mQuestion.setAnswerTrue(true);
                    Toast.makeText(getContext()," Correct ! ", Toast.LENGTH_SHORT).show();
                    Intent pass = new Intent(getContext(),QuestionPage.class);
                    pass.putExtra("QuestionFragment",5);
                    BtnA.setEnabled(false);
            }
                else {
                    mQuestion.setScore(currentScore);
                    Toast.makeText(getContext(), " Incorrect ! ", Toast.LENGTH_SHORT).show();
                    Intent pass = new Intent(getContext(),QuestionPage.class);
                    pass.putExtra("QuestionFragment",0);
                    BtnA.setEnabled(false);
                }
            }
        });

        BtnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnAns == 2){
                    currentScore +=10;
                    mQuestion.setScore(currentScore);
                    mQuestion.setAnswerTrue(true);
                    Toast.makeText(getContext()," Correct ! ", Toast.LENGTH_SHORT).show();
                    Intent pass = new Intent(getContext(),QuestionPage.class);
                    pass.putExtra("QuestionFragment",5);
                    BtnB.setEnabled(false);
                }
                else{
                    mQuestion.setScore(currentScore);
                    Toast.makeText(getContext()," Incorrect ! ", Toast.LENGTH_SHORT).show();
                    Intent pass = new Intent(getContext(),QuestionPage.class);
                    pass.putExtra("QuestionFragment",0);
                    BtnB.setEnabled(false);
                }


            }
        });

        BtnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnAns == 3){
                    currentScore+=10;
                    mQuestion.setScore(currentScore);
                    Toast.makeText(getContext()," Correct ! ", Toast.LENGTH_SHORT).show();
                    Intent pass = new Intent(getContext(),QuestionPage.class);
                    pass.putExtra("QuestionFragment",5);
                    BtnC.setEnabled(false);
                }
                else{
                    mQuestion.setScore(currentScore);
                    Toast.makeText(getContext()," Incorrect ! ", Toast.LENGTH_SHORT).show();
                    Intent pass = new Intent(getContext(),QuestionPage.class);
                    pass.putExtra("QuestionFragment",0);
                    BtnC.setEnabled(false);

                }

            }
        });

        BtnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnAns == 4){
                    currentScore +=10;
                    mQuestion.setScore(currentScore);
                    Toast.makeText(getContext()," Correct ! ", Toast.LENGTH_SHORT).show();
                    Intent pass = new Intent(getContext(),QuestionPage.class);
                    pass.putExtra("QuestionFragment",5);
                    BtnD.setEnabled(false);
                }
                else{
                    mQuestion.setScore(currentScore);
                    Toast.makeText(getContext()," Incorrect ! ", Toast.LENGTH_SHORT).show();
                    Intent pass = new Intent(getContext(),QuestionPage.class);
                    pass.putExtra("QuestionFragment",0);
                    BtnD.setEnabled(false);

            }


            }
        });


        return myFragment;
    }

    public int QuestionGenerate (){
        Random rand = new Random();
        int value = rand.nextInt(100)+1;

        return value;

    }

    public int RandomSymbol(){

        Random rand = new Random();
        int value = rand.nextInt(4)+1;


        return value;

    }

    public int BtnAns(){
        Random rand = new Random();
        int value = rand.nextInt(1000);

        return value;
    }

    public int GenerateAns() {


        Random ansRan = new Random();
        int choice = ansRan.nextInt(4) + 1;

        return choice;
    }


    public double CalculateAns(int front , int symbol , int back){

         double result = 0 ;

        if(symbol == 1){
            result = front + back;
        }

        else if(symbol == 2){
            result = front - back;
        }

        else if(symbol == 3){
            result = front * back;
        }

        else if(symbol == 4){
            result = (front / back);
        }

        return result;

    }


}


