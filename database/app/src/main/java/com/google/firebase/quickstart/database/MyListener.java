package com.google.firebase.quickstart.database;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class MyListener implements ValueEventListener{


    private SignInActivity act;

    public MyListener(SignInActivity SignInActivity){
        this.act = SignInActivity ;
    }

    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        act.setSnapshot(dataSnapshot);
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
}
