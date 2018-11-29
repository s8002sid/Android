package com.example.siddjain.listviewsample;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.siddjain.listviewsample.Utility.AWSProvider;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<FamilyMaster> fFamilyMaster;
    public static final String MESSAGE_ID = "com.example.siddjain.listviewsample.MESSAGE_ID";
    public static final int UPDATE_UI = 1;
    private final Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            final int what = msg.what;
            if (what == UPDATE_UI) {
                UpdateUI();
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Initialize ASWProvider
        AWSProvider awsProvider = AWSProvider.getInstance(MainActivity.this);

        setContentView(R.layout.activity_main);
        final ListView listview = findViewById(R.id.listview);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position < fFamilyMaster.size()) {
                    String rowID = fFamilyMaster.get(position).getID();
                    Intent intent = new Intent(view.getContext(), DisplayDetail.class);
                    intent.putExtra(MESSAGE_ID, rowID);
                    startActivity(intent);
                } else {
                    Log.d("ListViewSample", "Incorrect position found.");
                }
            }
        });
        Message msg = new Message();
        msg.what = UPDATE_UI;
        handler.handleMessage(msg);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflator = getMenuInflater();
        menuInflator.inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.menu_main_signout) {
            // Call function to signout of app
            AWSProvider.getIdentityManager().signOut();
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    protected void UpdateUI() {
        LocalSQLiteDatabase lsd = LocalSQLiteDatabase.getInstance(MainActivity.this);
        fFamilyMaster = lsd.getFamilyMaster();
        MyListAdapter listAdapter = new MyListAdapter(MainActivity.this, fFamilyMaster);
        final ListView listview = findViewById(R.id.listview);
        listview.setAdapter(listAdapter);
    }
}
