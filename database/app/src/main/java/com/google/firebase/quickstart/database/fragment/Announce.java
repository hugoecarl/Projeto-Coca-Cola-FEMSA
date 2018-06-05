package com.google.firebase.quickstart.database.fragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

public class Announce extends PostListFragment {

    public Announce() {}

    @Override
    public Query getQuery(DatabaseReference databaseReference) {

        Query AnnouncePostQuery = databaseReference.child("Database").orderByChild("type").equalTo("Avisos");

        return AnnouncePostQuery;
    }
}
