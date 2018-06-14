package com.google.firebase.quickstart.database.fragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

public class MyPostsFragment extends PostListFragment {

    public MyPostsFragment() {}

    @Override
    public Query getQuery(DatabaseReference databaseReference) {

        Query MyPostsQuery = databaseReference.child("Database").limitToFirst(100);


        return MyPostsQuery;
    }
}
