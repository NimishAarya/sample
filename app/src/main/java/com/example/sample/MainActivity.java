package com.example.sample;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn_sl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_sl=findViewById(R.id.btn_signup_login);
        if(ParseUser.getCurrentUser() != null){
            ParseUser.getCurrentUser().logOut();
        }
         ParseInstallation.getCurrentInstallation().saveInBackground();

        btn_sl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,SignupLoginActivity.class);
                startActivity(intent);
            }
        });
    }

    public void helloWorldTapped(View view){
        ParseObject boxer = new ParseObject("Boxer");
        boxer.put("punch_speed",200);
        boxer.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if(e== null)
                    Toast.makeText(MainActivity.this,"saved successfully",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this,"Error"+e.getMessage()+e.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }

}
