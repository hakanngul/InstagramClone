package com.example.signupactivity;

import android.app.Application;

import com.parse.Parse;

public class ParseStarterActivity extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.setLogLevel(Parse.LOG_LEVEL_DEBUG);
        //initialize burada parse ı entegre ederek başlatma yapıyoruz.
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("IbociLe0iwly2kbvjK3QmHo6bzB9xzZioRcpIlR6")
                .clientKey("Vt6Gg8ZZwB9hwP8fZk0gLcj0tJttlMWCRgyAMYY6")
                .server("https://parseapi.back4app.com/")
                .build()
                );

    }
}
