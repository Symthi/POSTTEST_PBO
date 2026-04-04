package com.basket.model;

import org.apache.commons.lang3.StringUtils;

public class Atlet extends Person {
    private int nomorPunggung;
    private String posisi;
    private Tim tim;
    private double poinPerGame;

    public Atlet(String nama, int nomorPunggung, String posisi, Tim tim, double poinPerGame) {
        super(nama);
        this.nomorPunggung = nomorPunggung;
        this.posisi = posisi;
        this.tim = tim;
        this.poinPerGame = poinPerGame;
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

    @Override
    public void setNama(String nama) {
        if (StringUtils.isBlank(nama)) {
            System.out.println("Nama tidak boleh kosong!");
        } else {
            super.setNama(nama);
        }
    }

    @Override
    public String toString() {
        return getNama() + " | #" + nomorPunggung + " | " + posisi + " | " + tim.toString() + " | PPG: " + poinPerGame;
    }
}