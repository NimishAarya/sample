package com.example.sample;
import com.parse.Parse;
import android.app.Application;
public class App extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("4qS69CI34IffQFSZHiyxuiK7OPHb18pg5UjUHAlg")
                .clientKey("4tzusj2LwZ1jX5ysw3jmu1paXNQREt1UzBQUWRx6")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
