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

import com.example.quanlythuvien.DAO.DocGiaDAO;
import com.example.quanlythuvien.Model.DocGia;
import com.example.quanlythuvien.R;

import java.util.List;

public class QuanLyDocGiaActivity extends AppCompatActivity {

    EditText edt_hoten, edt_ngaysinh, edt_ngaythamgia, edt_email, edt_sdt;
    AutoCompleteTextView edt_timkiem;
    ListView lv_docgia;
    Button btn_them, btn_sua, btn_xoa;
    List<DocGia> docGiaList;
    DocGiaDAO docGiaDAO;
    DocGia docGia;
    ArrayAdapter<DocGia> docGiaArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_doc_gia);
        anhXa();
        docGiaDAO = new DocGiaDAO(getApplicationContext());
        loadDanhSach();
        onClick();
    }

    private void loadDanhSach() {
        docGiaList = docGiaDAO.getDocGias();
        docGiaArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, docGiaList);
        lv_docgia.setAdapter(docGiaArrayAdapter);
        edt_timkiem.setAdapter(docGiaArrayAdapter);
    }

    private void onClick() {
        lv_docgia.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                docGia = docGiaList.get(i);
                edt_hoten.setText(docGia.getHoten());
                edt_ngaysinh.setText(docGia.getNgaysinh());
                edt_ngaythamgia.setText(docGia.getNgaythamgia());
                edt_email.setText(docGia.getEmail());
                edt_sdt.setText(docGia.getSdt());
            }
        });
        btn_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hoten = edt_hoten.getText().toString();
                String ngaysinh = edt_ngaysinh.getText().toString();
                String ngaythamgia = edt_ngaythamgia.getText().toString();
                String email = edt_email.getText().toString();
                String sdt = edt_sdt.getText().toString();
                DocGia docGia = new DocGia();
                docGia.setHoten(hoten);
                docGia.setNgaysinh(ngaysinh);
                docGia.setNgaythamgia(ngaythamgia);
                docGia.setEmail(email);
                docGia.setSdt(sdt);
                docGiaDAO.updateDocGia(docGia, false);
                loadDanhSach();
            }
        });
        btn_sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (docGia != null) {
                    String hoten = edt_hoten.getText().toString();
                    String ngaysinh = edt_ngaysinh.getText().toString();
                    String ngaythamgia = edt_ngaythamgia.getText().toString();
                    String email = edt_email.getText().toString();
                    String sdt = edt_sdt.getText().toString();
                    docGia.setHoten(hoten);
                    docGia.setNgaysinh(ngaysinh);
                    docGia.setNgaythamgia(ngaythamgia);
                    docGia.setEmail(email);
                    docGia.setSdt(sdt);
                    docGiaDAO.updateDocGia(docGia, true);
                    loadDanhSach();
                }
            }
        });
        btn_xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (docGia != null) {
                    docGiaDAO.deleteDocGia(docGia.getId());
                    loadDanhSach();
                }
            }
        });
    }

    private void anhXa() {
        edt_hoten = findViewById(R.id.edt_hoten);
        edt_ngaysinh = findViewById(R.id.edt_ngaysinh);
        edt_ngaythamgia = findViewById(R.id.edt_ngaytham);
        edt_email = findViewById(R.id.edt_email);
        edt_sdt = findViewById(R.id.edt_sdt);
        edt_timkiem = findViewById(R.id.edt_timkiem);
        btn_them = findViewById(R.id.btn_them);
        btn_sua = findViewById(R.id.btn_sua);
        btn_xoa = findViewById(R.id.btn_xoa);
        lv_docgia = findViewById(R.id.lv_docgia);
    }
}