package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    String strUserName, strPassWord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(CheckLoginShap() < 0){
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }
    }

    public int CheckLoginShap(){
        SharedPreferences preferences = getSharedPreferences("USERNAME", MODE_PRIVATE);
        boolean chk = preferences.getBoolean("REMEMBER", false);
        if(chk ){
            strUserName = preferences.getString("USERNAME","");
            strPassWord = preferences.getString("PASSWORD","");
            return 1;
        }
        return -1;

    }
}