package com.google.firebase.quickstart.database.fragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;


public class Authentication{
    public Authentication() {
    }



    public Query getQuery(DatabaseReference databaseReference) {

        Query Auth = databaseReference.child("Colaborators").child("funcionarios").orderByChild("br");

        return Auth;
    }
}
