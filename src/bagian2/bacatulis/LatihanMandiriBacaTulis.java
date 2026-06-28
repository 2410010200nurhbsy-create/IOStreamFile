package bagian2.bacatulis;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;

public class LatihanMandiriBacaTulis {
    public static void main(String[] args) {
        String namaBerkas = "hari.txt";
        
        // SOAL 1: Tulis 5 nama hari ke hari.txt, lalu baca & tampilkan
        System.out.println("=== SOAL 1: TULIS & BACA 5 NAMA HARI ===");
        String[] hariAwal = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat"};
        
        // Menulis 5 nama hari (menggunakan try-with-resources agar otomatis close)
        try (PrintWriter penulis = new PrintWriter(new FileWriter(namaBerkas))) {
            for (String h : hariAwal) {
                penulis.println(h);
            }
            System.out.println("Berhasil menulis 5 nama hari ke " + namaBerkas);
        } catch (IOException e) {
            System.out.println("Gagal menulis: " + e.getMessage());
        }

        // Membaca kembali berkas dan menampilkan ke layar monitor
        System.out.println("\nIsi berkas " + namaBerkas + " saat ini:");
        bacaDanTampilkan(namaBerkas);
        System.out.println();
        
        // SOAL 2: Tambahkan (append) 2 nama hari lagi tanpa menghapus isi lama
        System.out.println("=== SOAL 2: APPEND 2 NAMA HARI ===");
        // Parameter 'true' pada FileWriter digunakan untuk mode append (menambah data)
        try (PrintWriter penulis = new PrintWriter(new FileWriter(namaBerkas, true))) {
            penulis.println("Sabtu");
            penulis.println("Minggu");
            System.out.println("Berhasil menambahkan hari Sabtu dan Minggu.");
        } catch (IOException e) {
            System.out.println("Gagal menambah data: " + e.getMessage());
        }

        // Tampilkan kembali seluruh isinya setelah proses penambahan data (append)
        System.out.println("\nIsi berkas " + namaBerkas + " setelah append:");
        bacaDanTampilkan(namaBerkas);
        System.out.println();

        // SOAL 3: Baca berkas hari.txt lalu hitung jumlah total barisnya
        System.out.println("=== SOAL 3: HITUNG JUMLAH BARIS ===");
        int jumlahBaris = 0;
        
        try (BufferedReader pembaca = new BufferedReader(new FileReader(namaBerkas))) {
            // Perulangan akan berjalan terus sampai readLine() menghasilkan null (akhir file)
            while (pembaca.readLine() != null) {
                jumlahBaris++;
            }
            System.out.println("Jumlah total baris di dalam " + namaBerkas + ": " + jumlahBaris + " baris");
        } catch (IOException e) {
            System.out.println("Gagal membaca berkas: " + e.getMessage());
        }
    }

    // Fungsi pembantu (helper method) untuk membaca berkas teks baris demi baris
    private static void bacaDanTampilkan(String namaBerkas) {
        try (BufferedReader pembaca = new BufferedReader(new FileReader(namaBerkas))) {
            String baris;
            while ((baris = pembaca.readLine()) != null) {
                System.out.println("- " + baris);
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca berkas: " + e.getMessage());
        }
    }
}