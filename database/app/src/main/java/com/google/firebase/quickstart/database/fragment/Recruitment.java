package com.google.firebase.quickstart.database.fragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

public class Recruitment extends PostListFragment {

    public Recruitment() {}

    @Override
    public Query getQuery(DatabaseReference databaseReference) {

        Query RecruitmentostsQuery = databaseReference.child("Database").orderByChild("type").equalTo("Vagas");

        return RecruitmentostsQuery;
    }
}
