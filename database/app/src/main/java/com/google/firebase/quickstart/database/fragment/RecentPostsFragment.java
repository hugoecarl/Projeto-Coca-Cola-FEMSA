package com.google.firebase.quickstart.database.fragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

public class RecentPostsFragment extends PostListFragment {

    public RecentPostsFragment() {}

    @Override
    public Query getQuery(DatabaseReference databaseReference) {

        Query RecentPostsQuery = databaseReference.child("Database")
                .limitToFirst(100);


        return RecentPostsQuery;
    }
}
