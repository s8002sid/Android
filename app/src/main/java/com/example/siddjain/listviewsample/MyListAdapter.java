package com.example.siddjain.listviewsample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.siddjain.listviewsample.R;

import java.util.ArrayList;

public class MyListAdapter extends ArrayAdapter<String> {
    private final Context fContext;
    private ArrayList<String> fName = new ArrayList<>();
    private ArrayList<String> fMobileNumber = new ArrayList<>();
    public MyListAdapter(@NonNull Context context, ArrayList<String> name, ArrayList<String> mobileNumber) {
        super(context, R.layout.activity_listview, name);
        this.fContext = context;
        this.fName = name;
        this.fMobileNumber = mobileNumber;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(fContext);
        View rowView= inflater.inflate(R.layout.activity_listview, null, true);
        TextView txtName = rowView.findViewById(R.id.tvName);
        TextView txtMobNo = rowView.findViewById(R.id.tvMobileNumber);
        txtName.setText(fName.get(position));
        String mobileNumber = fMobileNumber.get(position);
        txtMobNo.setText(mobileNumber);
        if (mobileNumber.equals("")) {
            txtMobNo.setVisibility(View.INVISIBLE);
        }
        return rowView;
    }
}
