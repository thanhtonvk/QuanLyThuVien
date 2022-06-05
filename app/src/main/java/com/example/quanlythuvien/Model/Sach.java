package com.example.quanlythuvien.Model;

public class Sach {
    private int id;
    private String tensach, loaisach;
    private int giathue;
    private int namxb;
    private String tacgia;
    private int soluong;
    private String mota;
    @Override
    public String toString() {
        return String.format(" Tên sách: %s \n Loại sách: %s \n Giá thuê: %s VND", tensach, loaisach, giathue);
    }

    public int getNamxb() {
        return namxb;
    }

    public void setNamxb(int namxb) {
        this.namxb = namxb;
    }

    public String getTacgia() {
        return tacgia;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public Sach(String tensach, String loaisach, int giathue, int namxb, String tacgia, int soluong, String mota) {
        this.tensach = tensach;
        this.loaisach = loaisach;
        this.giathue = giathue;
        this.namxb = namxb;
        this.tacgia = tacgia;
        this.soluong = soluong;
        this.mota = mota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTensach() {
        return tensach;
    }

    public void setTensach(String tensach) {
        this.tensach = tensach;
    }

    public String getLoaisach() {
        return loaisach;
    }

    public void setLoaisach(String loaisach) {
        this.loaisach = loaisach;
    }

    public int getGiathue() {
        return giathue;
    }

    public void setGiathue(int giathue) {
        this.giathue = giathue;
    }

    public Sach(int id, String tensach, String loaisach, int giathue, int namxb, String tacgia, int soluong, String mota) {
        this.id = id;
        this.tensach = tensach;
        this.loaisach = loaisach;
        this.giathue = giathue;
        this.namxb = namxb;
        this.tacgia = tacgia;
        this.soluong = soluong;
        this.mota = mota;
    }
}
