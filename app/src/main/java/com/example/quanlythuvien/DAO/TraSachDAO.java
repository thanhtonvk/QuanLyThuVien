package com.example.quanlythuvien.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.quanlythuvien.Model.TraSach;
import com.example.quanlythuvien.Sqlite.DBHelper;

import java.util.ArrayList;
import java.util.List;

public class TraSachDAO {
    SQLiteDatabase database;
    Context context;
    DBHelper dbHelper;

    public TraSachDAO(Context context) {
        this.context = context;
        dbHelper = new DBHelper(context);
        this.database = dbHelper.getWritableDatabase();
    }

    public List<TraSach> getSachDaTra() {
        List<TraSach> traSachList = new ArrayList<>();
        Cursor cursor = database.rawQuery("select nguoithue,ngaythue,ngaytra,tensach,songaythue from Sach,MuonSach,TraSach where Sach.id = MuonSach.idsach and TraSach.idmuonsach = MuonSach.id", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            TraSach traSach = new TraSach(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getInt(4));
            traSachList.add(traSach);
            cursor.moveToNext();
        }
        return traSachList;
    }

    public void traSach(int idmuonsach, String ngaytra) {
        MuonSachDAO muonSachDAO = new MuonSachDAO(context);
        ContentValues values = new ContentValues();
        values.put("idmuonsach", idmuonsach);
        values.put("ngaytra", ngaytra);
        database.insert("TraSach", null, values);
        muonSachDAO.traSach(idmuonsach);
    }
}
