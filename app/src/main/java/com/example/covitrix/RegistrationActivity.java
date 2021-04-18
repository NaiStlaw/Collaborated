package com.example.covitrix;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText RegEmail, RegPassword;
    private Button RegBtn;
    private TextView RegQn;
    private FirebaseAuth mAuth;

    private ProgressDialog loader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mAuth =FirebaseAuth.getInstance();
        loader= new ProgressDialog(this);

        RegEmail=findViewById(R.id.registrationEmail);
        RegPassword=findViewById(R.id.registrationPassword);
        RegBtn= findViewById(R.id.registrationButton);
        RegQn=findViewById(R.id.registrationPageQuestion);

        RegQn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(RegistrationActivity.this,LoginActivity.class);
                startActivity(i);

            }
        });

        RegBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email =RegEmail.getText().toString().trim();
                String password=RegPassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    RegEmail.setError("email is incorrect");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    RegPassword.setError("Password required");
                    return;
                }else{
                    loader.setMessage("Registration in Progress");
                    loader.setCanceledOnTouchOutside(false);
                    loader.show();
                    mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {
                                Intent i = new Intent(RegistrationActivity.this, MainActivity.class);
                                startActivity(i);
                                finish();
                                loader.dismiss();
                            } else {
                                String error =task.getException().toString();
                                Toast.makeText(RegistrationActivity.this, "Registration failed" + error, Toast.LENGTH_SHORT).show();
                                loader.dismiss();
                            }
                        }
                    });

                }

            }
        });
    }
}