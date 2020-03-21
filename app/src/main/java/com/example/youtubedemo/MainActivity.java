package com.example.youtubedemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
   // variables
    private EditText email,password;
    private Button signup;
    private TextView txtviewsignin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //connecting your variables with the layout id
        email = (EditText)findViewById(R.id.editTextemail);
        password = (EditText)findViewById(R.id.editTextpassword);
        txtviewsignin = (TextView)findViewById(R.id.txtviewsigninhere);
        txtviewsignin.setOnClickListener(this);
        signup= (Button)findViewById(R.id.btnsignup);

        // set click listener
        signup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v==signup)
        {
            userRegister();

        }
        if(v==txtviewsignin);
        {
            startActivity(new Intent(MainActivity.this,Sign_in_Activity.class));

        }
    }

    private void userRegister() {
        String Email = email.getText().toString().trim();
        String Password = password.getText().toString().trim();

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(Email,Password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()){
                            Toast.makeText(MainActivity.this,"successful",Toast.LENGTH_SHORT).show();

                        }
                        else
                        {
                            Toast.makeText(MainActivity.this, task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }

                    }
                });

    }
}
