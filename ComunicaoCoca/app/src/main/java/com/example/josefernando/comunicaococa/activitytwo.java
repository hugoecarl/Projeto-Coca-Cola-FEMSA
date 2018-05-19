package com.example.josefernando.comunicaococa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class activitytwo extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private String[] dataToTest = new String[10];


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        mRecyclerView = (RecyclerView) findViewById(R.id.reciclerView1);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(dataToTest);
        mRecyclerView.setAdapter(mAdapter);

        dataToTest[0] = "Mac";
        dataToTest[1] = "and";
        dataToTest[2] = "cheese";
    }

    public void mainactivity (View v) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}

