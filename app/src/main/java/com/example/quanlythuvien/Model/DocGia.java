package com.example.quanlythuvien.Model;

public class DocGia {

    private int id;
    private String hoten, ngaysinh, ngaythamgia, email, sdt;

    public DocGia() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getNgaythamgia() {
        return ngaythamgia;
    }

    public void setNgaythamgia(String ngaythamgia) {
        this.ngaythamgia = ngaythamgia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public DocGia(int id, String hoten, String ngaysinh, String ngaythamgia, String email, String sdt) {
        this.id = id;
        this.hoten = hoten;
        this.ngaysinh = ngaysinh;
        this.ngaythamgia = ngaythamgia;
        this.email = email;
        this.sdt = sdt;
    }

    @Override
    public String toString() {
        return String.format(" Họ tên: %s \n Ngày sinh: %s \n Ngày tham gia: %s \n Email: %s \n SĐT: %s", hoten, ngaysinh, ngaythamgia, email, sdt);
    }
}
