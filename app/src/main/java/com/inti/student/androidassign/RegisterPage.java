package com.inti.student.androidassign;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.inti.student.androidassign.User.User;
import com.rengwuxian.materialedittext.MaterialEditText;

public class RegisterPage extends AppCompatActivity {

    private TextView registerAcc;
    private MaterialEditText username;
    private MaterialEditText password;
    private MaterialEditText useremail;
    private Button submitBtn;

    FirebaseDatabase database;
    DatabaseReference users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        database = FirebaseDatabase.getInstance();
        users = database.getReference("Users");


        registerAcc = (TextView) findViewById(R.id.rgtAcc);
        username = (MaterialEditText) findViewById(R.id.userTxtBox);
        password = (MaterialEditText) findViewById(R.id.passtxtBox);
        useremail = (MaterialEditText) findViewById(R.id.emailTxtBox);
        submitBtn = (Button) findViewById(R.id.submitBtn);


        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final User user = new User(username.getText().toString(),
                        password.getText().toString(),
                        useremail.getText().toString());

                users.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.child(user.getUsername()).exists())
                            Toast.makeText(RegisterPage.this, "User already exists! Enter again ! ", Toast.LENGTH_SHORT).show();
                        else {
                            users.child(user.getUsername()).setValue(user);
                            Toast.makeText(RegisterPage.this, "Register completed !", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

                Intent intent = new Intent(RegisterPage.this, LoginPage.class);
                startActivity(intent);

            }
        });


    }
}
