package com.example.quanlythuvien.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.quanlythuvien.Model.MuonSach;
import com.example.quanlythuvien.Sqlite.DBHelper;

import java.util.ArrayList;
import java.util.List;

public class MuonSachDAO {
    DBHelper dbHelper;
    SQLiteDatabase database;

    public MuonSachDAO(Context context) {
        dbHelper = new DBHelper(context);
        database = dbHelper.getWritableDatabase();
    }

    public List<MuonSach> getSachChuaTra() {
        List<MuonSach> muonSachList = new ArrayList<>();
        Cursor cursor = database.rawQuery("select MuonSach.id,Sach.id,Sach.tensach,nguoithue,ngaythue,songaythue,trangthai from MuonSach,Sach where MuonSach.idsach = Sach.id and trangthai = '0'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            MuonSach muonSach = new MuonSach(cursor.getInt(0), cursor.getInt(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getInt(5), cursor.getString(6));
            muonSachList.add(muonSach);
            cursor.moveToNext();
        }
        return muonSachList;
    }

    public void muonSach(MuonSach muonSach) {
        ContentValues values = new ContentValues();
        values.put("idsach", muonSach.getIdsach());
        values.put("nguoithue", muonSach.getNguoithue());
        values.put("ngaythue", muonSach.getNgaythue());
        values.put("songaythue", muonSach.getSongaythue());
        values.put("trangthai", "0");
        database.insert("MuonSach", null, values);
    }

    public void traSach(int idMuonSach) {
        MuonSach muonSach = new MuonSach();
        for (MuonSach x : getSachChuaTra()
        ) {
            if (x.getId() == idMuonSach) muonSach = x;
        }
        muonSach.setTrangthai("1");
        ContentValues values = new ContentValues();
        values.put("idsach", muonSach.getIdsach());
        values.put("nguoithue", muonSach.getNguoithue());
        values.put("ngaythue", muonSach.getNgaythue());
        values.put("songaythue", muonSach.getSongaythue());
        values.put("trangthai", muonSach.getTrangthai());
        database.update("MuonSach", values, "id = ?", new String[]{muonSach.getId() + ""});
    }
}
