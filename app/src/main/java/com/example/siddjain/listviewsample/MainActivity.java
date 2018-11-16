package com.example.siddjain.listviewsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] mobileArray = new String[]{"Android","IPhone","WindowsMobile","Blackberry",
                "WebOS","Ubuntu","Windows7","Max OS X"};

        ArrayAdapter adapter = new ArrayAdapter<>(this, R.layout.activity_listview, mobileArray);
        final ListView listview = findViewById(R.id.listview);
        listview.setAdapter(adapter);
    }
}
