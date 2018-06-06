package com.google.firebase.quickstart.database.fragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

public class Events extends PostListFragment {

    public Events() {}

    @Override
    public Query getQuery(DatabaseReference databaseReference) {

        Query EventPostsQuery = databaseReference.child("Database").orderByChild("type").equalTo("Eventos");

        return EventPostsQuery;
    }
}
