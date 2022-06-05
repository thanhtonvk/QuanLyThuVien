package com.example.quanlythuvien.Activity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quanlythuvien.DAO.SachDAO;
import com.example.quanlythuvien.Model.Sach;
import com.example.quanlythuvien.R;

import java.util.List;

public class QuanLySachActivity extends AppCompatActivity {
    EditText edt_ten, edt_gia, edt_namxb, edt_tacgia, edt_soluong, edt_mota;
    Spinner sp_loai;
    AutoCompleteTextView edt_timkiem;
    ListView lv_sach;
    Button btn_them, btn_sua, btn_xoa;
    ArrayAdapter<Sach> sachArrayAdapter;
    List<Sach> sachList;
    SachDAO sachDAO;
    Sach sach;
    ArrayAdapter<String> loaiSachAdapter;
    //loại sách
    String[] loaiSachs = {"Truyện cười", "Khoa học"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_sach);
        sachDAO = new SachDAO(getApplicationContext());
        anhXa();
        loadDuLieu();
        onClick();
    }

    private void anhXa() {
        edt_ten = findViewById(R.id.edt_ten);
        sp_loai = findViewById(R.id.sp_loai);
        edt_gia = findViewById(R.id.edt_gia);
        edt_timkiem = findViewById(R.id.edt_timkiem);
        lv_sach = findViewById(R.id.lv_sach);
        btn_them = findViewById(R.id.btn_them);
        btn_sua = findViewById(R.id.btn_sua);
        btn_xoa = findViewById(R.id.btn_xoa);
        edt_namxb = findViewById(R.id.edt_namxb);
        edt_tacgia = findViewById(R.id.edt_tacgia);
        edt_soluong = findViewById(R.id.edt_soluong);
        edt_mota = findViewById(R.id.edt_mota);
    }

    private void loadDuLieu() {
        sachList = sachDAO.getSachs();
        sachArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sachList);
        lv_sach.setAdapter(sachArrayAdapter);
        edt_timkiem.setAdapter(sachArrayAdapter);
        loaiSachAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, loaiSachs);
        sp_loai.setAdapter(loaiSachAdapter);
    }

    private void onClick() {
        btn_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tensach = edt_ten.getText().toString();
                String loai = loaiSachs[sp_loai.getSelectedItemPosition()];
                String gia = edt_gia.getText().toString();
                String mota = edt_mota.getText().toString();
                String namxb = edt_namxb.getText().toString();
                String tacgia = edt_tacgia.getText().toString();
                String soluong = edt_soluong.getText().toString();
                Sach sach = new Sach(tensach, loai, Integer.parseInt(gia), Integer.parseInt(namxb), tacgia, Integer.parseInt(soluong), mota);
                sachDAO.updateSach(sach, false);
                loadDuLieu();
            }
        });
        lv_sach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                sach = sachList.get(i);
                edt_ten.setText(sach.getTensach());
                edt_gia.setText(sach.getGiathue() + "");
                edt_soluong.setText(sach.getSoluong() + "");
                edt_namxb.setText(sach.getNamxb() + "");
                edt_mota.setText(sach.getMota());
                edt_tacgia.setText(sach.getTacgia());
                showDialog();
            }
        });
        btn_sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sach != null) {
                    String tensach = edt_ten.getText().toString();
                    String loai = loaiSachs[sp_loai.getSelectedItemPosition()];
                    String gia = edt_gia.getText().toString();
                    String mota = edt_mota.getText().toString();
                    String namxb = edt_namxb.getText().toString();
                    String tacgia = edt_tacgia.getText().toString();
                    String soluong = edt_soluong.getText().toString();
                    sach.setTensach(tensach);
                    sach.setLoaisach(loai);
                    sach.setGiathue(Integer.parseInt(gia));
                    sach.setMota(mota);
                    sach.setNamxb(Integer.parseInt(namxb));
                    sach.setTacgia(tacgia);
                    sach.setSoluong(Integer.parseInt(soluong));
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

    private void showDialog() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.item_sach);
        TextView tv_ten, tv_gia, tv_soluong, tv_namxb, tv_mota, tv_tacgia, tv_loai;
        tv_ten = dialog.findViewById(R.id.tv_tensach);
        tv_loai = dialog.findViewById(R.id.tv_loaisach);
        tv_gia = dialog.findViewById(R.id.tv_giathue);
        tv_soluong = dialog.findViewById(R.id.tv_soluong);
        tv_namxb = dialog.findViewById(R.id.tv_namxb);
        tv_tacgia = dialog.findViewById(R.id.tv_tacgia);
        tv_mota = dialog.findViewById(R.id.tv_mota);
        tv_ten.setText(sach.getTensach());
        tv_loai.setText(sach.getLoaisach());
        tv_gia.setText(sach.getGiathue() + " VNĐ");
        tv_soluong.setText(sach.getSoluong() + " Quyển");
        tv_namxb.setText(sach.getNamxb() + "");
        tv_tacgia.setText(sach.getTacgia());
        tv_mota.setText(sach.getMota());
        dialog.show();
    }

}