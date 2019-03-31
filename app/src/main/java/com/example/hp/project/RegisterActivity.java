package com.example.hp.project;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.QuickContactBadge;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;



public class RegisterActivity extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private FirebaseAuth firebaseAuth;
    private Button btn;

    private ProgressDialog progressDialog;
    String email1,pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        btn = (Button) findViewById(R.id.btnRegister);
        TextView loginScreen = (TextView) findViewById(R.id.link_to_login);

        firebaseAuth = FirebaseAuth.getInstance();


        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);

        progressDialog = new ProgressDialog(this);





//
//        // Listening to Login Screen link
//        loginScreen.setOnClickListener(new View.OnClickListener() {
//
//            public void onClick(View arg0) {
//                // Closing registration screen
//                // Switching to Login Screen/closing register screen
//                finish();
//            }
//        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email1 = email.getText().toString().trim();
                pass = password.getText().toString().trim();


                progressDialog.setMessage("Registering User");
                progressDialog.show();


                firebaseAuth.createUserWithEmailAndPassword("parlikarvarad@gmail.com","pass").addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()==true){
                            Toast.makeText(RegisterActivity.this, "Registered", Toast.LENGTH_SHORT).show();

                        progressDialog.dismiss();
                            startActivity(new Intent(getApplication(),LoginActivity.class));
                        }
                        else{
                            Toast.makeText(RegisterActivity.this, "Not Happening", Toast.LENGTH_SHORT).show();
                        }
                    }
                });



            }
        });

    }
}
