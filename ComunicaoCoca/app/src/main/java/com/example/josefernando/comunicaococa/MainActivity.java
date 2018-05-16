package com.example.josefernando.comunicaococa;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.analytics.FirebaseAnalytics;


public class MainActivity extends AppCompatActivity {

    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        Button bt = (Button) findViewById(R.id.button);
        Typeface font = Typeface.createFromAsset(getAssets(),"calibri.ttf");
        bt.setTypeface(font);

        Button bt2 = (Button) findViewById(R.id.button2);
        bt2.setTypeface(font);

        Button bt3 = (Button) findViewById(R.id.button3);
        bt3.setTypeface(font);

        Button bt4 = (Button) findViewById(R.id.button4);
        bt4.setTypeface(font);

    }

    public void layouteventos(View v){

        Intent intent = new Intent(this, activitytwo.class);
        startActivity(intent);
        finish();

    }

    public void vagas (View v) {

        Intent intent = new Intent(this, activitythree.class);
        startActivity(intent);
        finish();

    }

    public void avisos (View v) {

        Intent intent = new Intent(this, activityfour.class);
        startActivity(intent);
        finish();
    }

    public void promoçoes (View v) {

        Intent intent = new Intent(this, activityfive.class);
        startActivity(intent);
        finish();
    }
}
