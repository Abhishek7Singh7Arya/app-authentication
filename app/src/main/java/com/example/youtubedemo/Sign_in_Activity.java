package com.example.youtubedemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Sign_in_Activity extends AppCompatActivity implements View.OnClickListener {
    EditText txtemail,txtpassword;
    Button btnsignin;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_);
        txtemail= (EditText)findViewById(R.id.edtxtemail);
        txtpassword=(EditText)findViewById(R.id.edtxtpassword);
        btnsignin=(Button)findViewById(R.id.btnsignin);
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseDatabase=FirebaseDatabase.getInstance();

        btnsignin.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        if(v==btnsignin){
            signin();

        }

    }

    private void signin() {
        String email=txtemail.getText().toString();
        String password = txtpassword.getText().toString();

        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Toast.makeText(Sign_in_Activity.this,"user Sign in successful ",Toast.LENGTH_SHORT).show();

            }
        });


    }
}
