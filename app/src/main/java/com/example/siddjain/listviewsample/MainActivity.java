package com.example.siddjain.listviewsample;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
            resultSet = db.rawQuery("Select name from family_master", null);
        ArrayList<String> mylist = new ArrayList<>();
        resultSet.moveToFirst();
        for (int i = 0; i < resultSet.getCount(); i++)
        {
            mylist.add(resultSet.getString(0));
            resultSet.moveToNext();
        }

        ArrayAdapter adapter = new ArrayAdapter<>(this, R.layout.activity_listview, mylist);
        final ListView listview = findViewById(R.id.listview);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected item text from ListView
                String selectedItem = (String) parent.getItemAtPosition(position);
            }
        });

        } catch(SQLiteException e) {
            throw e;
        }
    }
}
