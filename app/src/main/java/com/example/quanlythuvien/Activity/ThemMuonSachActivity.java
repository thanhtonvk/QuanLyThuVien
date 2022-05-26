package com.example.quanlythuvien.Activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.util.LocaleData;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.quanlythuvien.DAO.MuonSachDAO;
import com.example.quanlythuvien.DAO.SachDAO;
import com.example.quanlythuvien.Model.MuonSach;
import com.example.quanlythuvien.Model.Sach;
import com.example.quanlythuvien.R;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

public class ThemMuonSachActivity extends AppCompatActivity {


    EditText edt_tensach, edt_nguoimuon, edt_songay;
    Button btn_muon;
    ListView lv_sach;
    SachDAO sachDAO;
    MuonSachDAO muonSachDAO;
    ArrayAdapter<Sach> sachArrayAdapter;
    List<Sach> sachList;
    Sach sach;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_muon_sach);
        sachDAO = new SachDAO(getApplicationContext());
        muonSachDAO = new MuonSachDAO(getApplicationContext());
        anhXaView();
        loadDuLieu();
        onClick();
    }

    private void anhXaView() {
        edt_tensach = findViewById(R.id.edt_tensach);
        edt_nguoimuon = findViewById(R.id.edt_ten);
        edt_songay = findViewById(R.id.edt_songay);
        lv_sach = findViewById(R.id.lv_sach);
        btn_muon = findViewById(R.id.btn_muon);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void onClick() {

        String ngayHienTai = LocalDate.now().toString();
        btn_muon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sach != null) {
                    if (!edt_songay.getText().toString().equals("")) {
                        MuonSach muonSach = new MuonSach();
                        muonSach.setIdsach(sach.getId());
                        muonSach.setNgaythue(ngayHienTai);
                        muonSach.setNguoithue(edt_nguoimuon.getText().toString());
                        muonSach.setSongaythue(Integer.parseInt(edt_songay.getText().toString()));
                        muonSach.setTrangthai("0");
                        muonSachDAO.muonSach(muonSach);
                        Toast.makeText(getApplicationContext(), "Mượn sách thành công", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });
        lv_sach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                sach = sachList.get(i);
                edt_tensach.setText(sach.getTensach());
            }
        });
    }

    private void loadDuLieu() {
        sachList = sachDAO.getSachs();
        sachArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sachList);
        lv_sach.setAdapter(sachArrayAdapter);
    }

    @Override
    public void onBackPressed() {
        finish();
        startActivity(new Intent(getApplicationContext(), MuonSachActivity.class));
    }
}