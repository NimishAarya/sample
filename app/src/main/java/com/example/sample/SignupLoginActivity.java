package com.example.sample;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignupLoginActivity extends AppCompatActivity
{
    private EditText edtUsername, edtPassword, edtUsernameLogin, edtPasswordLogin;
    private Button btnRegister, btnLogin;
    //private
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_login_activity);

        edtUsername =  findViewById(R.id.edtUsername);
        edtPassword =findViewById(R.id.edtPassword);
        edtUsernameLogin = findViewById(R.id.edtUsernameLogin);
        edtPasswordLogin = findViewById(R.id.edtPasswordLogin);

        btnRegister = findViewById(R.id.btnRegister);
        btnLogin = findViewById(R.id.btnLogin);

//        if(ParseUser.getCurrentUser() != null)
//        {
//            //ParseUser.getCurrentUser().logOut();
//            transitionToWelcomeUser();
//        }

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ParseUser appUser = new ParseUser();
                appUser.setUsername(edtUsername.getText().toString());
                appUser.setPassword(edtPassword.getText().toString());

//                ProgressDialog progressdialog = new ProgressDialog(SignupLoginActivity.this);
//                progressdialog.setMessage("Signing up");

                appUser.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if(e == null)
                        {
                            edtUsername.setText("");
                            edtPassword.setText("");
                            Toast.makeText(SignupLoginActivity.this,appUser.get("username")+" is signed up successfully",Toast.LENGTH_LONG).show();
//                            Intent intent = new Intent(SignupLoginActivity.this,WelcomeUser.class);
//                            startActivity(intent);
                            transitionToWelcomeUser();

                        }
                        else
                            Toast.makeText(SignupLoginActivity.this,"Error in Signup"+e.toString(),Toast.LENGTH_LONG).show();

                    }
                });
            }
        });




        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                ProgressDialog progressdialog1 = new ProgressDialog(SignupLoginActivity.this);
//                progressdialog1.setMessage("Logging in");

                ParseUser.logInInBackground(edtUsernameLogin.getText().toString(), edtPasswordLogin.getText().toString(), new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {
                        if(user != null && e==null)
                        {
                            edtPasswordLogin.setText("");
                            edtUsernameLogin.setText("");
                            Toast.makeText(SignupLoginActivity.this,user.get("username")+" is successfully logged in",Toast.LENGTH_LONG).show();
//                            Intent intent = new Intent(SignupLoginActivity.this,WelcomeUser.class);
//                            startActivity(intent);
                            transitionToWelcomeUser();

                        }
                        else
                            Toast.makeText(SignupLoginActivity.this,"Error in login"+e.toString(),Toast.LENGTH_LONG).show();

                    }
                });
            }
        });





    }

    private void transitionToWelcomeUser() {
        Intent intent =new Intent(SignupLoginActivity.this,WelcomeUser.class);
        startActivity(intent);
    }

}
