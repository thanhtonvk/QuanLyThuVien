package com.example.quanlythuvien.Model;

public class Sach {
    private int id;
    private String tensach, loaisach;
    private int giathue;

    @Override
    public String toString() {
        return String.format(" Tên sách: %s \n Loại sách: %s \n Giá thuê: %s VND", tensach, loaisach, giathue);
    }

    public Sach(String tensach, String loaisach, int giathue) {
        this.tensach = tensach;
        this.loaisach = loaisach;
        this.giathue = giathue;
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

    public Sach(int id, String tensach, String loaisach, int giathue) {
        this.id = id;
        this.tensach = tensach;
        this.loaisach = loaisach;
        this.giathue = giathue;
    }
}
