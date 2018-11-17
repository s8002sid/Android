package com.example.siddjain.listviewsample;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
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

        fID = new ArrayList<>();
        DataBaseHelper myDbHelper = new DataBaseHelper(this);

        try {

            myDbHelper.createDataBase();

        } catch (IOException ioe) {

            throw new Error("Unable to create database");

        }

        try {

            myDbHelper.openDataBase();

        }catch(SQLException sqle){

            throw sqle;

        }
        SQLiteDatabase db = null;
        String myPath = DataBaseHelper.DB_PATH + DataBaseHelper.DB_NAME;
        db = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        Cursor resultSet;
        try {
            resultSet = db.rawQuery("Select name, phone_number, _id from family_master order by name", null);
        ArrayList<String> nameList = new ArrayList<>();
            ArrayList<String> phoneNumberList = new ArrayList<>();
        resultSet.moveToFirst();
        for (int i = 0; i < resultSet.getCount(); i++)
        {
            nameList.add(resultSet.getString(0));
            phoneNumberList.add(resultSet.getString(1));
            Integer val = new Integer(resultSet.getInt(2));
            fID.add(Integer.toString(val));
            resultSet.moveToNext();
        }

        MyListAdapter listAdapter = new MyListAdapter(MainActivity.this, nameList, phoneNumberList);
        //ArrayAdapter adapter = new ArrayAdapter<>(this, R.layout.activity_listview, mylist);
        final ListView listview = findViewById(R.id.listview);
        listview.setAdapter(listAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected item text from ListView
                //String selectedItem = (String) parent.getItemAtPosition(position);
                String rowid = fID.get(position);
                Intent intent = new Intent(view.getContext(), DisplayDetail.class);
                intent.putExtra(MESSAGE_ID, rowid);
                startActivity(intent);
            }
        });

        } catch(SQLiteException e) {
            throw e;
        }
    }
}
