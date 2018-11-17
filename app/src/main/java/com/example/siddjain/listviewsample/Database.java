package com.example.siddjain.listviewsample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public interface Database {

    /*
    private static Database fDatabase = new Database();
    private ArrayList<FamilyMaster> fFamilyMaster = new ArrayList<>();
    private Map<String, FamilyDetail> fFamilyDetail = new HashMap<>();
    private Database() {}
    public Database getInstance() {return fDatabase;}

    public ArrayList<String> GetData()
    {

    }*/
    ArrayList<FamilyMaster> getFamilyMaster();
    ArrayList<FamilyDetail> getFamilyDetail(int id);
}
