package com.example.bottomnavigationbar.Model;

public class User {
    private int re_image;
    private String name;

    public User(int re_image, String name) {
        this.re_image = re_image;
        this.name = name;
    }

    public int getRe_image() {
        return re_image;
    }

    public void setRe_image(int re_image) {
        this.re_image = re_image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}