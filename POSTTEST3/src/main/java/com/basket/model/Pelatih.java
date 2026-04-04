package com.basket.model;

import org.apache.commons.lang3.StringUtils;

public class Pelatih extends Person {
    private String spesialisasi;
    private int tahunPengalaman;

    public Pelatih(String nama, String spesialisasi, int tahunPengalaman) {
        super(nama);
        this.spesialisasi = spesialisasi;
        this.tahunPengalaman = tahunPengalaman;
    }

    public String getSpesialisasi() {
        return spesialisasi;
    }

    public void setSpesialisasi(String spesialisasi) {
        this.spesialisasi = spesialisasi;
    }

    public int getTahunPengalaman() {
        return tahunPengalaman;
    }

    public void setTahunPengalaman(int tahunPengalaman) {
        this.tahunPengalaman = tahunPengalaman;
    }

    @Override
    public void setNama(String nama) {
        if (StringUtils.isBlank(nama)) {
            System.out.println("Nama pelatih tidak boleh kosong!");
        } else {
            super.setNama(nama);
        }
    }

    @Override
    public String toString() {
        return getNama() + " | Spesialisasi: " + spesialisasi + " | Pengalaman: " + tahunPengalaman + " tahun";
    }
}