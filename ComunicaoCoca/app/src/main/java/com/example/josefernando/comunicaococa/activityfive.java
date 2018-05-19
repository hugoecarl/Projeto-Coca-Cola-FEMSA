package com.example.josefernando.comunicaococa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class activityfive extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity5);
    }

    public void mainactivity (View v) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}
