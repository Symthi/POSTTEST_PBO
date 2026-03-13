package com.basket.model;

public class Tim {
    private String namaTim;
    private String kota;
    String kodeTim;

    public Tim(String namaTim, String kota) {
        this.namaTim = namaTim;
        this.kota = kota;
        this.kodeTim = generateKode();

        PackagePrivateDemo demo = new PackagePrivateDemo();
        demo.tampilkanPesan();
    }

    private String generateKode() {
        return kota.substring(0, 2).toUpperCase() + namaTim.substring(0, 2).toUpperCase();
    }

    public String getNamaTim() {
        return namaTim;
    }

    public void setNamaTim(String namaTim) {
        this.namaTim = namaTim;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public void tampilkanKode() {
        TimHelper.printKodeTim(this);
    }

    @Override
    public String toString() {
        return namaTim + " (" + kota + ")";
    }
}