package com.example.sample;

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


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ParseUser appUser = new ParseUser();
                appUser.setUsername(edtUsername.getText().toString());
                appUser.setPassword(edtPassword.getText().toString());;
                appUser.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if(e == null)
                            Toast.makeText(SignupLoginActivity.this,appUser.get("username")+" is signed up successfully",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(SignupLoginActivity.this,"Error in Signup"+e.toString(),Toast.LENGTH_LONG).show();

                    }
                });
            }
        });




        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser.logInInBackground(edtUsernameLogin.getText().toString(), edtPasswordLogin.getText().toString(), new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {
                        if(user != null && e==null)
                            Toast.makeText(SignupLoginActivity.this,user.get("username")+" is successfully logged in",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(SignupLoginActivity.this,"Error in login"+e.toString(),Toast.LENGTH_LONG).show();

                    }
                });
            }
        });

    }
}
