package com.example.quanlythuvien.Sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
        super(context, "csdl.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table Sach(" +
                "id integer primary key autoincrement," +
                "tensach nvarchar(100) not null," +
                "loaisach nvarchar(50) not null," +
                "giathue integer)");
        sqLiteDatabase.execSQL("create table MuonSach(" +
                "id integer primary key autoincrement," +
                "idsach integer," +
                "nguoithue nvarchar(50) not null," +
                "ngaythue nvarchar(50) not null," +
                "songaythue integer not null," +
                "trangthai char(1))");
        sqLiteDatabase.execSQL("create table TraSach(" +
                "id integer primary key autoincrement," +
                "idmuonsach integer not null," +
                "ngaytra nvarchar(50) not null)");
        sqLiteDatabase.execSQL("create table DocGia(" +
                "id integer primary key autoincrement," +
                "hoten nvarchar(50)," +
                "ngaysinh nvarchar(50)," +
                "ngaythamgia nvarchar(50)," +
                "email nvarchar(50)," +
                "sdt nvarchar(50))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
