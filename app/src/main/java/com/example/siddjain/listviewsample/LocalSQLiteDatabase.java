package com.example.siddjain.listviewsample;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LocalSQLiteDatabase implements Database {
    private ArrayList<FamilyMaster> fFamilyMaster = new ArrayList<>();
    private ArrayList<String> fFamilyMasterID = new ArrayList<>();
    private Map<String, ArrayList<FamilyDetail>> fFamilyDetail = new HashMap<>();
    private static LocalSQLiteDatabase ldb = new LocalSQLiteDatabase();
    private DataBaseHelper myDBHealper;
    private Context fContext;
    private LocalSQLiteDatabase() {}
    public static LocalSQLiteDatabase getInstance(Context ctx) {
        ldb.fContext = ctx;
        if (ldb.fFamilyMaster.size() == 0) {
            SQLiteDatabase db;
            if (ldb.myDBHealper == null) {
                ldb.myDBHealper = new DataBaseHelper(ctx);
                try {
                    ldb.myDBHealper.createDataBase();
                } catch (IOException ioe) {
                    throw new Error("Unable to create database");
                }
                try {
                    db = ldb.myDBHealper.openDataBase();
                }catch(SQLException sqle){
                    throw sqle;
                }
            }
            else {
                db = ldb.myDBHealper.openDataBase();
            }
            Cursor c;
            try {
                String query = "select _id, name, address, phone_number, business, " +
                        "place_of_business, business_phone_number, native_place, email, " +
                        "special_qualification, patrika_subscription, spiritual_achievement, " +
                        "app_downloaded, religious_situation, economic_situation, samayik, " +
                        "guru_darshan, number_of_terapanth_card, " +
                        "dedicated_relegious_person_description from family_master order by name";
                c = db.rawQuery( query, null);
                c.moveToFirst();
                if (c.getColumnCount() != 19) {
                    return ldb;
                }
                for (int i = 0; i < c.getCount(); i++) {
                    Integer id = c.getInt(0);
                    String sID = Integer.toString(id);
                    FamilyMaster fm = new FamilyMaster(sID, c.getString(1),
                            c.getString(2), c.getString(3), c.getString(4),
                            c.getString(5), c.getString(6), c.getString(7),
                            c.getString(8), c.getString(9), c.getString(10),
                            c.getString(11), c.getString(12), c.getString(13),
                            c.getString(14), c.getString(15), c.getString(16),
                            c.getString(17), c.getString(18));
                    ldb.fFamilyMaster.add(fm);
                    ldb.fFamilyMasterID.add(sID);
                    c.moveToNext();
                }

                ldb.myDBHealper.close();
            } catch(SQLiteException ex) {

            }
        }
        return ldb;
    }
    @Override
    public ArrayList<FamilyMaster> getFamilyMaster() {
        return fFamilyMaster;
    }
    @Override
    public ArrayList<FamilyDetail> getFamilyDetail(int listIndex){
        FamilyMaster fm = fFamilyMaster.get(listIndex);
        String fmID = fm.getID();
        ArrayList<FamilyDetail> fd = fFamilyDetail.get(fmID);
        if (fd == null) {
            SQLiteDatabase db = myDBHealper.openDataBase();

            Cursor c = db.rawQuery("select _id,name, birthdate, anniversary_date, education, " +
                    "blood_group, mobile_number, outside, gender from family_detail " +
                    "where family_id = '" + fm.getID() + "'", null);
            fd = new ArrayList<>();
            c.moveToFirst();
            for (int i = 0; i < c.getCount(); i++) {
                Integer id = c.getInt(0);
                String sID = Integer.toString(id);
                FamilyDetail tmpfd = new FamilyDetail(sID, fmID, c.getString(1), c.getString(2),
                        c.getString(3), c.getString(4), c.getString(5),
                        c.getString(6), c.getString(7), c.getString(8), fm);
                fd.add(tmpfd);
            }
            fFamilyDetail.put(fmID, fd);
            myDBHealper.close();
        }
        return fd;
    }
}
