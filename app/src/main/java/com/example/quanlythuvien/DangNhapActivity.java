package com.example.quanlythuvien;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DangNhapActivity extends AppCompatActivity {

    EditText edttk, edtmk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        edttk = findViewById(R.id.edittk);
        edtmk = findViewById(R.id.editmk);
        findViewById(R.id.btndangky).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), DangKyActivity.class));
            }
        });
        findViewById(R.id.btndangnhap).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tk = edttk.getText().toString();
                String mk = edtmk.getText().toString();
                if (tk.equals("admin") && mk.equals("admin")) {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                } else {
                    Toast.makeText(getApplicationContext(), "Tài khoản hoặc mật khẩu không chính xác", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}