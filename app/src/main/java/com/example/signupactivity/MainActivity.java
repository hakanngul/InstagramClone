package com.example.signupactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class MainActivity extends AppCompatActivity {
    EditText userNameText,userPasswordText;
    Button signUpBtn,singInBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userNameText=findViewById(R.id.signup_activityMain_textName);
        userPasswordText=findViewById(R.id.signup_activityMain_textPassword);
        //Kullanıcı Hatırlama Sistemi Yani En son açılan kullanıcı tekrar açıyor.
        ParseUser parseUser = ParseUser.getCurrentUser();
        if (parseUser!=null){
            Intent intent = new Intent(getApplicationContext(),FeedActivity.class);
            startActivity(intent);
        }
    }

    public void signIn(View view){
        ParseUser.logInInBackground(userNameText.getText().toString(), userPasswordText.getText().toString(), new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (e!=null)
                    Toast.makeText(getApplicationContext(),e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                else{
                    Toast.makeText(getApplicationContext(),"Welcome! "+user.getUsername(),Toast.LENGTH_LONG).show();
                    //Intent Yapılacak
                    Intent intent = new Intent(getApplicationContext(),FeedActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
    public void signUp(View view){
        ParseUser user = new ParseUser();
        user.setUsername(userNameText.getText().toString());
        user.setPassword(userPasswordText.getText().toString());
        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e!=null)
                    Toast.makeText(getApplicationContext(),e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                else {
                    Toast.makeText(getApplicationContext(),"User Created!!!",Toast.LENGTH_LONG).show();
                    //Intent intent = new Intent()
                    Intent intent = new Intent(getApplicationContext(),FeedActivity.class);
                    startActivity(intent);
                }
            }
        });
        System.out.println("Kullanıcı Adı : "+user.getUsername());

    }

}
