package com.tutorials.hp.listviewpicassowebimages;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


import com.tutorials.hp.listviewpicassowebimages.mFireBase.Fire;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final static String DB_URL="https://wedata.firebaseio.com/";
    EditText nameEditText,urlEditText;
    Button saveBtn;
    Fire fire;
    ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        lv= (ListView) findViewById(R.id.lv);

        fire=new Fire(this,DB_URL,lv);

        fire.refreshData();



        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 displayDialog();
            }
        });
    }

    //SHOW DIALOG
    private void displayDialog()
    {
        Dialog d=new Dialog(this);
        d.setTitle("Save Online");
        d.setContentView(R.layout.dialoglayout);

        nameEditText= (EditText) d.findViewById(R.id.nameEditText);
        urlEditText= (EditText) d.findViewById(R.id.urlEditText);
        saveBtn= (Button) d.findViewById(R.id.saveBtn);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fire.saveOnline(nameEditText.getText().toString(),urlEditText.getText().toString());

                nameEditText.setText("");
                urlEditText.setText("");
            }
        });

        //show
        d.show();

    }





}
