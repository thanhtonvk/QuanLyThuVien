package com.example.quanlythuvien;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quanlythuvien.Activity.MuonSachActivity;
import com.example.quanlythuvien.Activity.QuanLySachActivity;
import com.example.quanlythuvien.Activity.TraSachActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_quanlysach).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), QuanLySachActivity.class));
            }
        });
        findViewById(R.id.btn_muonsach).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MuonSachActivity.class));
            }
        });
        findViewById(R.id.btn_trasach).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), TraSachActivity.class));
            }
        });
    }
}