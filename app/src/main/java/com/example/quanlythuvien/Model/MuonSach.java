package com.example.quanlythuvien.Model;

public class MuonSach {
    private int id;
    private int idsach;
    private String tensach;
    private String nguoithue, ngaythue;
    private int songaythue;
    private String trangthai;

    public MuonSach(int id, int idsach, String tensach, String nguoithue, String ngaythue, int songaythue, String trangthai) {
        this.id = id;
        this.idsach = idsach;
        this.tensach = tensach;
        this.nguoithue = nguoithue;
        this.ngaythue = ngaythue;
        this.songaythue = songaythue;
        this.trangthai = trangthai;
    }

    public MuonSach() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdsach() {
        return idsach;
    }

    public void setIdsach(int idsach) {
        this.idsach = idsach;
    }

    public String getTensach() {
        return tensach;
    }

    public void setTensach(String tensach) {
        this.tensach = tensach;
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

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    @Override
    public String toString() {
        return String.format(" Sách: %s \n Người mượn: %s \n Ngày mượn: %s \n Số ngày mượn: %s", tensach, nguoithue, ngaythue, songaythue);
    }
}
