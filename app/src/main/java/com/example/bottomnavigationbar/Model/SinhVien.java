package com.example.bottomnavigationbar.Model;

public class SinhVien {
    private int id;
    private String anh;
    private String hoten;
    private int   namsinh;
    private String diachi;

    public SinhVien() {
    }

    public SinhVien(int id, String anh, String hoten, int namsinh, String diachi) {
        this.id = id;
        this.anh = anh;
        this.hoten = hoten;
        this.namsinh = namsinh;
        this.diachi = diachi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public int getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(int namsinh) {
        this.namsinh = namsinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
}
