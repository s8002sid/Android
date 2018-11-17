package com.example.siddjain.listviewsample;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DisplayDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_detail);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String family_id = intent.getStringExtra(MainActivity.MESSAGE_ID);
        DataBaseHelper myDbHelper = new DataBaseHelper(this);
        SQLiteDatabase db = myDbHelper.openDataBase();

        Cursor resultSet;
        try
        {
            resultSet = db.rawQuery("select _id, family_id, name, birthdate, anniversary_date, education, blood_group, mobile_number, gender from family_detail where family_id = " + family_id, null);

        }
        catch (SQLiteException ex)
        {

        }
        myDbHelper.close();
    }
}
