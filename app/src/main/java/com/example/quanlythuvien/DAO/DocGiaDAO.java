package com.example.quanlythuvien.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.quanlythuvien.Model.DocGia;
import com.example.quanlythuvien.Sqlite.DBHelper;

import java.util.ArrayList;
import java.util.List;

public class DocGiaDAO {
    SQLiteDatabase database;
    Context context;
    DBHelper dbHelper;

    public DocGiaDAO(Context context) {
        this.context = context;
        dbHelper = new DBHelper(context);
        this.database = dbHelper.getWritableDatabase();
    }

    public List<DocGia> getDocGias() {
        List<DocGia> docGiaList = new ArrayList<>();
        Cursor cursor = database.rawQuery("select * from DocGia", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            DocGia docGia = new DocGia(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5));
            docGiaList.add(docGia);
            cursor.moveToNext();
        }
        return docGiaList;
    }

    public void updateDocGia(DocGia docGia, boolean isUpdate) {
        ContentValues values = new ContentValues();

        values.put("hoten", docGia.getHoten());
        values.put("ngaysinh", docGia.getNgaysinh());
        values.put("ngaythamgia", docGia.getNgaythamgia());
        values.put("email", docGia.getEmail());
        values.put("sdt", docGia.getSdt());
        if (isUpdate) {
            values.put("id", docGia.getId());
            database.update("DocGia", values, "id = ?", new String[]{docGia.getId() + ""});
        } else {
            database.insert("DocGia", null, values);
        }
    }

    public void deleteDocGia(int id) {
        database.delete("DocGia", "id = ?", new String[]{id + ""});
    }
}
