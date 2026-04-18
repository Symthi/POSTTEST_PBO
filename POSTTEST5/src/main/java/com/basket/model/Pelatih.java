package com.basket.model;

import org.apache.commons.lang3.StringUtils;

public class Pelatih extends Person implements kontrak {
    private String spesialisasi;
    private int tahunPengalaman;
    private int tahunKontrak;
    private double gajiPokok;

    public Pelatih(String nama, String spesialisasi, int tahunPengalaman) {
        super(nama);
        this.spesialisasi = spesialisasi;
        this.tahunPengalaman = tahunPengalaman;
        this.tahunKontrak = 3;
        this.gajiPokok = 8000000;
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

    public int getTahunKontrak() {
        return tahunKontrak;
    }

    public void setTahunKontrak(int tahunKontrak) {
        this.tahunKontrak = tahunKontrak;
    }

    public double getGajiPokok() {
        return gajiPokok;
    }

    public void setGajiPokok(double gajiPokok) {
        this.gajiPokok = gajiPokok;
    }

    @Override
    public void setNama(String nama) {
        if (StringUtils.isBlank(nama)) {
            System.out.println("Nama pelatih tidak boleh kosong!");
        } else {
            super.setNama(nama);
        }
    }

    // Implementasi abstract method dari Person
    @Override
    public String biodata() {
        return getNama() + " adalah pelatih basket dengan spesialisasi " + spesialisasi +
                " dan telah memiliki pengalaman melatih selama " + tahunPengalaman + " tahun.";
    }

    // Implementasi method dari interface KontrakOlahraga
    @Override
    public void tampilkanKontrak() {
        System.out.println("=== KONTRAK PELATIH ===");
        System.out.println("Nama: " + getNama());
        System.out.println("Spesialisasi: " + spesialisasi);
        System.out.println("Durasi Kontrak: " + tahunKontrak + " tahun");
        System.out.println("Gaji Pokok: Rp " + String.format("%,.0f", gajiPokok));
        System.out.println("Total Gaji (dengan bonus pengalaman): Rp " + String.format("%,.0f", hitungGaji()));
    }

    // Implementasi method dari interface KontrakOlahraga
    @Override
    public double hitungGaji() {
        double bonus = tahunPengalaman * 500000;
        return gajiPokok + bonus;
    }

    @Override
    public String toString() {
        return getNama() + " | Spesialisasi: " + spesialisasi + " | Pengalaman: " + tahunPengalaman + " tahun";
    }
}