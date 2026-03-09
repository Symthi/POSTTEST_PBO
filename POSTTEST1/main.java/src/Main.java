import java.util.ArrayList;
import java.util.Scanner;

// ==================== CLASS TIM ====================
class Tim {
    private String namaTim;
    private String kota;

    // Constructor
    public Tim(String namaTim, String kota) {
        this.namaTim = namaTim;
        this.kota = kota;
    }

    // Getter dan Setter
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

    // Untuk menampilkan info tim
    public String toString() {
        return namaTim + " (" + kota + ")";
    }
}

// ==================== CLASS ATLET ====================
class Atlet {
    private String nama;
    private int nomorPunggung;
    private String posisi;
    private Tim tim;         // objek Tim
    private double poinPerGame;

    // Constructor
    public Atlet(String nama, int nomorPunggung, String posisi, Tim tim, double poinPerGame) {
        this.nama = nama;
        this.nomorPunggung = nomorPunggung;
        this.posisi = posisi;
        this.tim = tim;
        this.poinPerGame = poinPerGame;
    }

    // Getter dan Setter
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
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

    // Menampilkan info atlet
    public String toString() {
        return nama + " | #" + nomorPunggung + " | " + posisi + " | " + tim.toString() + " | PPG: " + poinPerGame;
    }
}

// ==================== CLASS MAIN ====================
public class Main {
    static ArrayList<Tim> daftarTim = new ArrayList<>();
    static ArrayList<Atlet> daftarAtlet = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Isi data awal biar gak kosong
        initData();

        int pilihan;
        do {
            System.out.println("\n=== SISTEM PENDATAAN ATLET BASKET ===");
            System.out.println("1. Kelola Atlet");
            System.out.println("2. Kelola Tim");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();
            sc.nextLine();  // buang newline

            switch (pilihan) {
                case 1:
                    menuAtlet();
                    break;
                case 2:
                    menuTim();
                    break;
                case 3:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 3);
    }

    // Inisialisasi data contoh
    static void initData() {
        // Tambah tim NBA
        daftarTim.add(new Tim("Los Angeles Lakers", "Los Angeles"));
        daftarTim.add(new Tim("Golden State Warriors", "San Francisco"));
        daftarTim.add(new Tim("Chicago Bulls", "Chicago"));
        daftarTim.add(new Tim("Boston Celtics", "Boston"));

        // Tambah atlet
        daftarAtlet.add(new Atlet("LeBron James", 23, "Small Forward", daftarTim.get(0), 25.7));
        daftarAtlet.add(new Atlet("Stephen Curry", 30, "Point Guard", daftarTim.get(1), 29.4));
        daftarAtlet.add(new Atlet("Michael Jordan", 23, "Shooting Guard", daftarTim.get(2), 30.1));
        daftarAtlet.add(new Atlet("Jayson Tatum", 0, "Small Forward", daftarTim.get(3), 26.9));
    }

    // ========== MENU ATLET ==========
    static void menuAtlet() {
        int pilih;
        do {
            System.out.println("\n--- MENU ATLET ---");
            System.out.println("1. Tambah Atlet");
            System.out.println("2. Lihat Semua Atlet");
            System.out.println("3. Update Atlet");
            System.out.println("4. Hapus Atlet");
            System.out.println("5. Kembali");
            System.out.print("Pilih: ");
            pilih = sc.nextInt();
            sc.nextLine();

            switch (pilih) {
                case 1:
                    tambahAtlet();
                    break;
                case 2:
                    lihatAtlet();
                    break;
                case 3:
                    updateAtlet();
                    break;
                case 4:
                    hapusAtlet();
                    break;
                case 5:
                    System.out.println("Kembali ke menu utama.");
                    break;
                default:
                    System.out.println("Pilihan salah!");
            }
        } while (pilih != 5);
    }

    static void tambahAtlet() {
        System.out.println("\n--- TAMBAH ATLET ---");
        if (daftarTim.isEmpty()) {
            System.out.println("Belum ada tim. Silakan tambah tim dulu.");
            return;
        }

        System.out.print("Nama atlet: ");
        String nama = sc.nextLine();
        System.out.print("Nomor punggung: ");
        int nomor = sc.nextInt();
        sc.nextLine();
        System.out.print("Posisi: ");
        String posisi = sc.nextLine();

        // Pilih tim
        System.out.println("Daftar Tim:");
        for (int i = 0; i < daftarTim.size(); i++) {
            System.out.println((i+1) + ". " + daftarTim.get(i).toString());
        }
        System.out.print("Pilih nomor tim: ");
        int idxTim = sc.nextInt() - 1;
        sc.nextLine();
        if (idxTim < 0 || idxTim >= daftarTim.size()) {
            System.out.println("Tim tidak valid!");
            return;
        }
        Tim timDipilih = daftarTim.get(idxTim);

        System.out.print("Rata-rata poin per game: ");
        double ppg = sc.nextDouble();
        sc.nextLine();

        Atlet a = new Atlet(nama, nomor, posisi, timDipilih, ppg);
        daftarAtlet.add(a);
        System.out.println("Atlet berhasil ditambahkan!");
    }

    static void lihatAtlet() {
        System.out.println("\n--- DAFTAR ATLET ---");
        if (daftarAtlet.isEmpty()) {
            System.out.println("Belum ada data atlet.");
            return;
        }
        for (int i = 0; i < daftarAtlet.size(); i++) {
            System.out.println((i+1) + ". " + daftarAtlet.get(i).toString());
        }
    }

    static void updateAtlet() {
        System.out.println("\n--- UPDATE ATLET ---");
        lihatAtlet();
        if (daftarAtlet.isEmpty()) return;

        System.out.print("Pilih nomor atlet yang akan diupdate: ");
        int idx = sc.nextInt() - 1;
        sc.nextLine();
        if (idx < 0 || idx >= daftarAtlet.size()) {
            System.out.println("Nomor tidak valid!");
            return;
        }

        Atlet a = daftarAtlet.get(idx);
        System.out.println("Update data (kosongkan jika tidak ingin mengubah)");

        System.out.print("Nama baru [" + a.getNama() + "]: ");
        String nama = sc.nextLine();
        if (!nama.isEmpty()) a.setNama(nama);

        System.out.print("Nomor punggung baru [" + a.getNomorPunggung() + "]: ");
        String inputNomor = sc.nextLine();
        if (!inputNomor.isEmpty()) a.setNomorPunggung(Integer.parseInt(inputNomor));

        System.out.print("Posisi baru [" + a.getPosisi() + "]: ");
        String posisi = sc.nextLine();
        if (!posisi.isEmpty()) a.setPosisi(posisi);

        // Update tim
        System.out.println("Daftar Tim:");
        for (int i = 0; i < daftarTim.size(); i++) {
            System.out.println((i+1) + ". " + daftarTim.get(i).toString());
        }
        System.out.print("Pilih nomor tim baru (kosongkan jika tidak ubah): ");
        String inputTim = sc.nextLine();
        if (!inputTim.isEmpty()) {
            int idxTim = Integer.parseInt(inputTim) - 1;
            if (idxTim >= 0 && idxTim < daftarTim.size()) {
                a.setTim(daftarTim.get(idxTim));
            } else {
                System.out.println("Nomor tim tidak valid, tim tidak diubah.");
            }
        }

        System.out.print("PPG baru [" + a.getPoinPerGame() + "]: ");
        String inputPpg = sc.nextLine();
        if (!inputPpg.isEmpty()) a.setPoinPerGame(Double.parseDouble(inputPpg));

        System.out.println("Data atlet berhasil diupdate!");
    }

    static void hapusAtlet() {
        System.out.println("\n--- HAPUS ATLET ---");
        lihatAtlet();
        if (daftarAtlet.isEmpty()) return;

        System.out.print("Pilih nomor atlet yang akan dihapus: ");
        int idx = sc.nextInt() - 1;
        sc.nextLine();
        if (idx < 0 || idx >= daftarAtlet.size()) {
            System.out.println("Nomor tidak valid!");
            return;
        }

        Atlet a = daftarAtlet.remove(idx);
        System.out.println("Atlet " + a.getNama() + " telah dihapus.");
    }

    // ========== MENU TIM ==========
    static void menuTim() {
        int pilih;
        do {
            System.out.println("\n--- MENU TIM ---");
            System.out.println("1. Tambah Tim");
            System.out.println("2. Lihat Semua Tim");
            System.out.println("3. Update Tim");
            System.out.println("4. Hapus Tim");
            System.out.println("5. Kembali");
            System.out.print("Pilih: ");
            pilih = sc.nextInt();
            sc.nextLine();

            switch (pilih) {
                case 1:
                    tambahTim();
                    break;
                case 2:
                    lihatTim();
                    break;
                case 3:
                    updateTim();
                    break;
                case 4:
                    hapusTim();
                    break;
                case 5:
                    System.out.println("Kembali ke menu utama.");
                    break;
                default:
                    System.out.println("Pilihan salah!");
            }
        } while (pilih != 5);
    }

    static void tambahTim() {
        System.out.println("\n--- TAMBAH TIM ---");
        System.out.print("Nama tim: ");
        String nama = sc.nextLine();
        System.out.print("Kota: ");
        String kota = sc.nextLine();

        Tim t = new Tim(nama, kota);
        daftarTim.add(t);
        System.out.println("Tim berhasil ditambahkan!");
    }

    static void lihatTim() {
        System.out.println("\n--- DAFTAR TIM ---");
        if (daftarTim.isEmpty()) {
            System.out.println("Belum ada data tim.");
            return;
        }
        for (int i = 0; i < daftarTim.size(); i++) {
            System.out.println((i+1) + ". " + daftarTim.get(i).toString());
        }
    }

    static void updateTim() {
        System.out.println("\n--- UPDATE TIM ---");
        lihatTim();
        if (daftarTim.isEmpty()) return;

        System.out.print("Pilih nomor tim yang akan diupdate: ");
        int idx = sc.nextInt() - 1;
        sc.nextLine();
        if (idx < 0 || idx >= daftarTim.size()) {
            System.out.println("Nomor tidak valid!");
            return;
        }

        Tim t = daftarTim.get(idx);
        System.out.println("Update data (kosongkan jika tidak ingin mengubah)");

        System.out.print("Nama tim baru [" + t.getNamaTim() + "]: ");
        String nama = sc.nextLine();
        if (!nama.isEmpty()) t.setNamaTim(nama);

        System.out.print("Kota baru [" + t.getKota() + "]: ");
        String kota = sc.nextLine();
        if (!kota.isEmpty()) t.setKota(kota);

        System.out.println("Data tim berhasil diupdate!");
    }

    static void hapusTim() {
        System.out.println("\n--- HAPUS TIM ---");
        lihatTim();
        if (daftarTim.isEmpty()) return;

        System.out.print("Pilih nomor tim yang akan dihapus: ");
        int idx = sc.nextInt() - 1;
        sc.nextLine();
        if (idx < 0 || idx >= daftarTim.size()) {
            System.out.println("Nomor tidak valid!");
            return;
        }

        // Cek apakah tim masih digunakan oleh atlet
        Tim timHapus = daftarTim.get(idx);
        boolean dipakai = false;
        for (Atlet a : daftarAtlet) {
            if (a.getTim().equals(timHapus)) {
                dipakai = true;
                break;
            }
        }
        if (dipakai) {
            System.out.println("Tim tidak bisa dihapus karena masih dipakai oleh atlet!");
            return;
        }

        daftarTim.remove(idx);
        System.out.println("Tim berhasil dihapus.");
    }
}