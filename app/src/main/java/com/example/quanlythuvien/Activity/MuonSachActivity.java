package com.example.quanlythuvien.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quanlythuvien.DAO.MuonSachDAO;
import com.example.quanlythuvien.DAO.TraSachDAO;
import com.example.quanlythuvien.Model.MuonSach;
import com.example.quanlythuvien.R;

import java.time.LocalDate;
import java.util.List;

public class MuonSachActivity extends AppCompatActivity {

    AutoCompleteTextView edt_timkiem;
    Button btn_muonsach;
    ListView lv_muonsach;
    MuonSachDAO muonSachDAO;
    TraSachDAO traSachDAO;
    ArrayAdapter<MuonSach> adapter;
    List<MuonSach> muonSachList;
    MuonSach muonSach;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muon_sach);
        muonSachDAO = new MuonSachDAO(getApplicationContext());
        traSachDAO = new TraSachDAO(getApplicationContext());
        anhXa();
        loadDuLieu();
        onClick();
    }

    private void loadDuLieu() {
        muonSachList = muonSachDAO.getSachChuaTra();

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, muonSachList);
        lv_muonsach.setAdapter(adapter);
        edt_timkiem.setAdapter(adapter);
    }

    private void onClick() {
        btn_muonsach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ThemMuonSachActivity.class));
            }
        });
        lv_muonsach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                muonSach = muonSachList.get(i);
                setDialog();
            }
        });
    }

    private void setDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Bạn có muốn trả sách?");
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String ngay = LocalDate.now().toString();
                traSachDAO.traSach(muonSach.getId(), ngay);
                loadDuLieu();
            }
        });
        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

    private void anhXa() {
        edt_timkiem = findViewById(R.id.edt_timkiem);
        btn_muonsach = findViewById(R.id.btn_muonsach);
        lv_muonsach = findViewById(R.id.lv_muonsach);
    }
}