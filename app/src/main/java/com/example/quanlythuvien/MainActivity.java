package com.example.quanlythuvien;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quanlythuvien.Activity.MuonSachActivity;
import com.example.quanlythuvien.Activity.QuanLyDocGiaActivity;
import com.example.quanlythuvien.Activity.QuanLySachActivity;
import com.example.quanlythuvien.Activity.TraSachActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_qlsach).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), QuanLySachActivity.class));
            }
        });
        findViewById(R.id.btn_muon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MuonSachActivity.class));
            }
        });
        findViewById(R.id.btn_tra).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), TraSachActivity.class));
            }
        });
        findViewById(R.id.btn_docgia).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), QuanLyDocGiaActivity.class));
            }
        });
    }
}