package com.example.quanlythuvien.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.quanlythuvien.Model.Sach;
import com.example.quanlythuvien.Sqlite.DBHelper;

import java.util.ArrayList;
import java.util.List;

public class SachDAO {
    SQLiteDatabase database;
    Context context;
    DBHelper dbHelper;

    public SachDAO(Context context) {
        this.context = context;
        dbHelper = new DBHelper(context);
        this.database = dbHelper.getWritableDatabase();
    }

    public List<Sach> getSachs() {
        Cursor cursor = database.rawQuery("select * from sach", null);
        List<Sach> sachList = new ArrayList<>();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Sach sach = new Sach(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3));
            sachList.add(sach);
            cursor.moveToNext();
        }
        return sachList;
    }

    public void updateSach(Sach sach, boolean isUpdate) {
        ContentValues values = new ContentValues();
        values.put("tensach", sach.getTensach());
        values.put("loaisach", sach.getLoaisach());
        values.put("giathue", sach.getGiathue());
        if (isUpdate) {
            values.put("id", sach.getId());
            database.update("Sach", values, "id = ?", new String[]{sach.getId() + ""});
        } else {
            database.insert("Sach", null, values);
        }
    }

    public void xoaSach(int id) {
        database.delete("Sach", "id = ?", new String[]{id + ""});
    }

}
