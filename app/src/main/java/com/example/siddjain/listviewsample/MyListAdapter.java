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

public class MyListAdapter extends ArrayAdapter<FamilyMaster> {
    private final Context fContext;
    private ArrayList<FamilyMaster> fFamilyMasterAL = new ArrayList<>();
    public MyListAdapter(@NonNull Context context, ArrayList<FamilyMaster> fm_al) {
        super(context, R.layout.activity_listview, fm_al);
        this.fContext = context;
        this.fFamilyMasterAL = fm_al;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(fContext);
        View rowView= inflater.inflate(R.layout.activity_listview, null, true);
        TextView txtName = rowView.findViewById(R.id.tvName);
        TextView txtMobNo = rowView.findViewById(R.id.tvMobileNumber);
        FamilyMaster fm = fFamilyMasterAL.get(position);
        txtName.setText(fm.getName());
        String phno = fm.getPhoneNumber();
        txtMobNo.setText(phno);
        return rowView;
    }
}
