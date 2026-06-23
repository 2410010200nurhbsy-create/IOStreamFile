package bagian3.kontak;

import java.io.*;
import java.util.ArrayList;

public class BukuKontak {
    private ArrayList<Kontak> daftarKontak = new ArrayList<>();
    private String namaBerkas = "kontak.txt";

    public void tambahKontak(Kontak k) {
        daftarKontak.add(k);
    }

    public void tampilkanSemua() {
        System.out.println("== Daftar Kontak ==");
        for (Kontak k : daftarKontak) {
            System.out.println("- " + k.info());
        }
    }

    // Poin 1: Method cariKontak
    public void cariKontak(String nama) {
        for (Kontak k : daftarKontak) {
            if (k.getNama().equalsIgnoreCase(nama)) {
                System.out.println("Kontak Ditemukan: " + k.info());
                return;
            }
        }
        System.out.println("Kontak dengan nama '" + nama + "' tidak ditemukan.");
    }

    // ====================================================================
    // Poin 3: Method hapusKontak (Otomatis panggil simpanKeBerkas)
    // ====================================================================
    public void hapusKontak(String nama) {
        for (int i = 0; i < daftarKontak.size(); i++) {
            if (daftarKontak.get(i).getNama().equalsIgnoreCase(nama)) {
                daftarKontak.remove(i);
                System.out.println("Kontak '" + nama + "' berhasil dihapus.");
                simpanKeBerkas(); // Langsung simpan perubahan terbaru ke file
                return;
            }
        }
        System.out.println("Gagal menghapus! Kontak '" + nama + "' tidak ditemukan.");
    }

    // Menyimpan data arraylist ke file teks
    public void simpanKeBerkas() {
        try (PrintWriter penulis = new PrintWriter(new FileWriter(namaBerkas))) {
            for (Kontak k : daftarKontak) {
                penulis.println(k.keBaris());
            }
        } catch (IOException e) {
            System.out.println("Gagal menyimpan berkas: " + e.getMessage());
        }
    }

    // Poin 2: Memuat berkas teks dan memisahnya menjadi 3 bagian kolom
    public void muatDariBerkas() {
        File file = new File(namaBerkas);
        if (!file.exists()) return;

        daftarKontak.clear(); // Bersihkan list lama sebelum dimuat ulang
        try (BufferedReader pembaca = new BufferedReader(new FileReader(namaBerkas))) {
            String baris;
            while ((baris = pembaca.readLine()) != null) {
                String[] bagian = baris.split(",");
                // Pastikan baris memiliki 3 bagian data (Nama, Telepon, Email)
                if (bagian.length == 3) {
                    daftarKontak.add(new Kontak(bagian[0], bagian[1], bagian[2]));
                }
            }
        } catch (IOException e) {
            System.out.println("Gagal memuat berkas: " + e.getMessage());
        }
    }
}