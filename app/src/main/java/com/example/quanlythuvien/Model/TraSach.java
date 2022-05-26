package com.example.quanlythuvien.Model;

public class TraSach {
    private int id;
    private int idmuonsach;
    private String ngaytra;
    private String nguoithue;
    private String ngaythue;
    private int songaythue;
    private String tensach;

    @Override
    public String toString() {
        return String.format(" Người mượn: %s \n Ngày mượn: %s \n Ngày trả: %s \n Sách mượn: %s \n Số ngày mượn: %s", nguoithue, ngaythue, ngaytra, tensach, songaythue);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdmuonsach() {
        return idmuonsach;
    }

    public void setIdmuonsach(int idmuonsach) {
        this.idmuonsach = idmuonsach;
    }

    public String getNgaytra() {
        return ngaytra;
    }

    public void setNgaytra(String ngaytra) {
        this.ngaytra = ngaytra;
    }

    public String getNguoithue() {
        return nguoithue;
    }

    public void setNguoithue(String nguoithue) {
        this.nguoithue = nguoithue;
    }

    public String getNgaythue() {
        return ngaythue;
    }

    public void setNgaythue(String ngaythue) {
        this.ngaythue = ngaythue;
    }

    public int getSongaythue() {
        return songaythue;
    }

    public void setSongaythue(int songaythue) {
        this.songaythue = songaythue;
    }

    public String getTensach() {
        return tensach;
    }

    public void setTensach(String tensach) {
        this.tensach = tensach;
    }

    public TraSach(String nguoithue, String ngaythue, String ngaytra, String tensach, int songaythue) {
        this.ngaytra = ngaytra;
        this.nguoithue = nguoithue;
        this.ngaythue = ngaythue;
        this.songaythue = songaythue;
        this.tensach = tensach;
    }
}
