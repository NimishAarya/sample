package com.example.sample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.parse.ParseUser;

public class WelcomeUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_user);

        TextView txtWelcome = findViewById(R.id.txtwelcome);
        txtWelcome.setText("Welcome "+ ParseUser.getCurrentUser().get("username"));

    }
}
