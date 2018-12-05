package com.inti.student.androidassign;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.inti.student.androidassign.User.User;
import com.rengwuxian.materialedittext.MaterialEditText;

public class LoginPage extends AppCompatActivity {

    private MaterialEditText loginId;
    private MaterialEditText password;
    private Button loginBtn;
    private Button registerBtn;
    FirebaseDatabase database;
    DatabaseReference users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        database = FirebaseDatabase.getInstance();
        users = database.getReference("Users");

        loginId = (MaterialEditText)findViewById(R.id.logintxtbox);
        password = (MaterialEditText)findViewById(R.id.passwordtxtbox);
        loginBtn = (Button)findViewById(R.id.LoginBtn);
        registerBtn = (Button)findViewById(R.id.registerBtn);


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                validate(loginId.getText().toString(),password.getText().toString());
                MaterialEditText loginId = (MaterialEditText)findViewById(R.id.logintxtbox);
                loginId.setText("");
                MaterialEditText password = (MaterialEditText)findViewById(R.id.passwordtxtbox);
                password.setText("");
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginPage.this, RegisterPage.class);
                startActivity(intent);
            }
        });

    }


    private void validate (final String user, final String password) {

        users.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.child(user).exists())
                {
                    if(!user.isEmpty())
                    {
                        User login = dataSnapshot.child(user).getValue(User.class);
                        if(login.getPassword().equals(password)) {
                            Intent intent = new Intent(LoginPage.this, MainPage.class);
                            startActivity(intent);

                        }
                    else
                            Toast.makeText(LoginPage.this, " Incorrect Password !", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(LoginPage.this, "Enter username please.", Toast.LENGTH_SHORT).show();
                        }

                        }
                        else
                            Toast.makeText(LoginPage.this, " User does not exists !", Toast.LENGTH_SHORT).show();
                }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
