package com.basket.model;

import org.apache.commons.lang3.StringUtils;

public class Official extends Person {
    private String peran;

    public Official(String nama, String peran) {
        super(nama);
        this.peran = peran;
    }

    public String getPeran() {
        return peran;
    }

    public void setPeran(String peran) {
        this.peran = peran;
    }

    @Override
    public void setNama(String nama) {
        if (StringUtils.isBlank(nama)) {
            System.out.println("Nama official tidak boleh kosong!");
        } else {
            super.setNama(nama);
        }
    }

    @Override
    public String biodata() {
        return getNama() + " adalah seorang official pertandingan basket yang bertugas sebagai " + peran + ".";
    }

    @Override
    public String toString() {
        return getNama() + " | Peran: " + peran;
    }
}