package com.example.siddjain.listviewsample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> fID;
    public static final String MESSAGE_ID = "com.example.siddjain.listviewsample.MESSAGE_ID";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LocalSQLiteDatabase lsd = LocalSQLiteDatabase.getInstance(MainActivity.this);
        ArrayList<FamilyMaster> fm_al = lsd.getFamilyMaster();
        MyListAdapter listAdapter = new MyListAdapter(MainActivity.this, fm_al);
        final ListView listview = findViewById(R.id.listview);
        listview.setAdapter(listAdapter);


        //Adding listview onItemClick listener
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String rowID = fID.get(position);
                Intent intent = new Intent(view.getContext(), DisplayDetail.class);
                intent.putExtra(MESSAGE_ID, rowID);
                startActivity(intent);
            }
        });
    }
}
