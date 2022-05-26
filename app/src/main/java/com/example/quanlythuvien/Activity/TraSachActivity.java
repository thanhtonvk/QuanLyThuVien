package com.example.quanlythuvien.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;

import com.example.quanlythuvien.DAO.TraSachDAO;
import com.example.quanlythuvien.Model.TraSach;
import com.example.quanlythuvien.R;

import java.util.List;

public class TraSachActivity extends AppCompatActivity {

    ListView lv_trasach;
    List<TraSach> traSachList;
    ArrayAdapter<TraSach> traSachArrayAdapter;
    AutoCompleteTextView edt_timkiem;
    TraSachDAO traSachDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tra_sach);
        traSachDAO = new TraSachDAO(getApplicationContext());
        anhXAView();
    }

    private void anhXAView() {
        lv_trasach = findViewById(R.id.lv_trasach);
        edt_timkiem = findViewById(R.id.edt_timkiem);
        traSachList = traSachDAO.getSachDaTra();
        traSachArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, traSachList);
        lv_trasach.setAdapter(traSachArrayAdapter);
        edt_timkiem.setAdapter(traSachArrayAdapter);
    }
}