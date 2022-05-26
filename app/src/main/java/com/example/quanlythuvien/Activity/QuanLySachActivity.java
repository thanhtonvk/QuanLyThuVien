package com.example.quanlythuvien.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quanlythuvien.DAO.SachDAO;
import com.example.quanlythuvien.Model.Sach;
import com.example.quanlythuvien.R;

import java.util.List;

public class QuanLySachActivity extends AppCompatActivity {
    EditText edt_ten, edt_loai, edt_gia;
    AutoCompleteTextView edt_timkiem;
    ListView lv_sach;
    Button btn_them, btn_sua, btn_xoa;
    ArrayAdapter<Sach> sachArrayAdapter;
    List<Sach> sachList;
    SachDAO sachDAO;
    Sach sach;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_sach);
        sachDAO = new SachDAO(getApplicationContext());
        anhXa();
        loadDuLieu();
        onClick();
    }

    private void loadDuLieu() {
        sachList = sachDAO.getSachs();
        sachArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sachList);
        lv_sach.setAdapter(sachArrayAdapter);
        edt_timkiem.setAdapter(sachArrayAdapter);
    }

    private void onClick() {
        btn_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tensach = edt_ten.getText().toString();
                String loai = edt_loai.getText().toString();
                String gia = edt_gia.getText().toString();
                Sach sach = new Sach(tensach, loai, Integer.parseInt(gia));
                sachDAO.updateSach(sach, false);
                loadDuLieu();
            }
        });
        lv_sach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                sach = sachList.get(i);
                edt_ten.setText(sach.getTensach());
                edt_gia.setText(sach.getGiathue()+"");
                edt_loai.setText(sach.getLoaisach());
            }
        });
        btn_sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sach != null) {
                    String tensach = edt_ten.getText().toString();
                    String loai = edt_loai.getText().toString();
                    String gia = edt_gia.getText().toString();
                    sach.setTensach(tensach);
                    sach.setLoaisach(loai);
                    sach.setGiathue(Integer.parseInt(gia));
                    sachDAO.updateSach(sach, true);
                    loadDuLieu();
                }
            }
        });
        btn_xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sach != null) {
                    sachDAO.xoaSach(sach.getId());
                    loadDuLieu();
                }
            }
        });
    }


    private void anhXa() {
        edt_ten = findViewById(R.id.edt_ten);
        edt_loai = findViewById(R.id.edt_loai);
        edt_gia = findViewById(R.id.edt_gia);
        edt_timkiem = findViewById(R.id.edt_timkiem);
        lv_sach = findViewById(R.id.lv_sach);
        btn_them = findViewById(R.id.btn_them);
        btn_sua = findViewById(R.id.btn_sua);
        btn_xoa = findViewById(R.id.btn_xoa);
    }
}