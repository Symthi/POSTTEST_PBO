package com.basket.model;

import org.apache.commons.lang3.StringUtils;

public class Atlet extends Person implements kontrak {
    private int nomorPunggung;
    private String posisi;
    private Tim tim;
    private double poinPerGame;
    private int tahunKontrak;
    private double gajiPokok;

    public Atlet(String nama, int nomorPunggung, String posisi, Tim tim, double poinPerGame) {
        super(nama);
        this.nomorPunggung = nomorPunggung;
        this.posisi = posisi;
        this.tim = tim;
        this.poinPerGame = poinPerGame;
        this.tahunKontrak = 2;
        this.gajiPokok = 5000000;
    }

    public int getNomorPunggung() {
        return nomorPunggung;
    }

    public void setNomorPunggung(int nomorPunggung) {
        this.nomorPunggung = nomorPunggung;
    }

    public String getPosisi() {
        return posisi;
    }

    public void setPosisi(String posisi) {
        this.posisi = posisi;
    }

    public Tim getTim() {
        return tim;
    }

    public void setTim(Tim tim) {
        this.tim = tim;
    }

    public double getPoinPerGame() {
        return poinPerGame;
    }

    public void setPoinPerGame(double poinPerGame) {
        this.poinPerGame = poinPerGame;
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
            System.out.println("Nama tidak boleh kosong!");
        } else {
            super.setNama(nama);
        }
    }

    // Implementasi abstract method dari Person
    @Override
    public String biodata() {
        return getNama() + " adalah atlet basket profesional yang bermain sebagai " + posisi +
                " untuk tim " + tim.getNamaTim() + " dengan nomor punggung " + nomorPunggung +
                ". Rata-rata poin per game: " + poinPerGame + ".";
    }

    // Implementasi method dari interface KontrakOlahraga
    @Override
    public void tampilkanKontrak() {
        System.out.println("=== KONTRAK ATLET ===");
        System.out.println("Nama: " + getNama());
        System.out.println("Tim: " + tim.getNamaTim());
        System.out.println("Durasi Kontrak: " + tahunKontrak + " tahun");
        System.out.println("Gaji Pokok: Rp " + String.format("%,.0f", gajiPokok));
        System.out.println("Total Gaji (dengan bonus): Rp " + String.format("%,.0f", hitungGaji()));
    }

    // Implementasi method dari interface KontrakOlahraga
    @Override
    public double hitungGaji() {
        double bonus = poinPerGame * 100000;
        return gajiPokok + bonus;
    }

    @Override
    public String toString() {
        return getNama() + " | #" + nomorPunggung + " | " + posisi + " | " + tim.toString() + " | PPG: " + poinPerGame;
    }
}