package com.example.sample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;
//import android.support.v7.widget.Toolbar;

import com.parse.ParseUser;

public class WelcomeUser extends AppCompatActivity {

    //private android.support.v7.widget.Toolbar toolbar;

//    private ViewPager viewpager;
//    private TableLayout tablayout;
//    private TabAdapter tabadapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_user);

//        setTitle("Users portfolio");
//        toolbar = findViewById(R.id.user_toolbar);
//        setSupportActionBar(toolbar);
//        viewpager = findViewById(R.id.viewpager);


//        TextView txtWelcome = findViewById(R.id.txtwelcome);
//        txtWelcome.setText("Welcome "+ ParseUser.getCurrentUser().get("username").toString());

        findViewById((R.id.btnLogout)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser.logOut();
                finish();
            }
        });

    }
}
