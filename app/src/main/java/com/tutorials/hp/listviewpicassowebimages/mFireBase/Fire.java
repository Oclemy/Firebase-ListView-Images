package com.tutorials.hp.listviewpicassowebimages.mFireBase;

import android.content.Context;
import android.widget.ListView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.tutorials.hp.listviewpicassowebimages.mData.Movie;
import com.tutorials.hp.listviewpicassowebimages.mListView.CustomAdapter;

import java.util.ArrayList;

/**
 * Created by Oclemmy on 4/12/2016 for ProgrammingWizards Channel.
 */
public class Fire {

    Context c;
    ArrayList<Movie> movies=new ArrayList<>();
    CustomAdapter adapter;
    ListView lv;
    Firebase firebase;
    String DB_URL;

    public Fire(Context c, String DB_URL, ListView lv) {
        this.c = c;
        this.DB_URL = DB_URL;
        this.lv = lv;

        //INITIALIZE
        Firebase.setAndroidContext(c);
        firebase=new Firebase(DB_URL);
    }

    //SAVE DATA
    public void saveOnline(String name,String url)
    {
        Movie m=new Movie();
        m.setName(name);
        m.setUrl(url);

        firebase.child("Movie").push().setValue(m);
    }

    //RETRIEVEING
    public void refreshData()
    {
        firebase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                fetchUpdates(dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                 fetchUpdates(dataSnapshot);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

    private void fetchUpdates(DataSnapshot dataSnapshot)
    {
        movies.clear();

        for (DataSnapshot ds : dataSnapshot.getChildren())
        {
            Movie m=new Movie();
            m.setName(ds.getValue(Movie.class).getName());
            m.setUrl(ds.getValue(Movie.class).getUrl());

            movies.add(m);
        }

        if(movies.size()>0)
        {
            adapter=new CustomAdapter(c,movies);
            lv.setAdapter(adapter);
        }


    }


}
