package com.epizy.someone.jimly_1202150091_modul3;


public class profiling {
    int gambar;
    String caption, nama, gitlab, instagram;

    public profiling(int gambar, String caption, String nama, String gitlab, String instagram) {
        this.gambar = gambar;
        this.caption = caption;
        this.nama = nama;
        this.gitlab = gitlab;
        this.instagram = instagram;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getGitlab() {
        return gitlab;
    }

    public void setGitlab(String gitlab) {
        this.gitlab = gitlab;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}
