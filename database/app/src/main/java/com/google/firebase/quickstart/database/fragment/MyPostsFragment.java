package com.google.firebase.quickstart.database.fragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

public class MyPostsFragment extends PostListFragment {

    public MyPostsFragment() {}

    @Override
    public Query getQuery(DatabaseReference databaseReference) {
        // [START recent_posts_query]
        // Last 100 posts, these are automatically the 100 most recent
        // due to sorting by push() keys
        Query myPostsQuery = databaseReference.child("Database")
                .limitToFirst(100);
        // [END recent_posts_query]

        return myPostsQuery;
    }
}