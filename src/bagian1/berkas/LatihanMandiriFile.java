package bagian1.berkas;

import java.io.File;         
import java.io.IOException;   

public class LatihanMandiriFile {
    public static void main(String[] args) {
        
        // SOAL 1: Cek keberadaan dan ukuran file laporan.txt
        
        System.out.println("=== SOAL 1: CEK LAPORAN.TXT ===");
        File fileLaporan = new File("laporan.txt");
        
        if (fileLaporan.exists()) {
            System.out.println("Berkas ada.");
            System.out.println("Ukuran berkas: " + fileLaporan.length() + " byte");
        } else {
            System.out.println("Berkas laporan.txt tidak ditemukan.");
        }
        System.out.println();

  
        // SOAL 2: Membuat folder baru bernama 'arsip' dengan mkdir()
        
        System.out.println("=== SOAL 2: BUAT FOLDER ARSIP ===");
        File folderArsip = new File("arsip");
        
        // method mkdir() mengembalikan nilai boolean (true jika berhasil, false jika gagal)
        if (folderArsip.mkdir()) {
            System.out.println("Pesan: Berhasil membuat folder baru bernama 'arsip'.");
        } else {
            System.out.println("Pesan: Gagal membuat folder (atau folder sudah ada sebelumnya).");
        }
        System.out.println();

        
        
        // SOAL 3: Buat file sementara.txt lalu hapus kembali dengan delete()
       
        System.out.println("=== SOAL 3: BUAT LALU HAPUS BERKAS ===");
        File fileSementara = new File("sementara.txt");
        
        try {
            // Membuat file baru kosong
            if (fileSementara.createNewFile()) {
                System.out.println("File sementara.txt berhasil dibuat.");
            }
            
            // Menampilkan status SEBELUM dihapus
            System.out.println("Status sebelum dihapus, apakah ada? : " + fileSementara.exists());
            
            // Menghapus file
            if (fileSementara.delete()) {
                System.out.println("File sementara.txt berhasil dihapus dari disk.");
            }
            
            // Menampilkan status SESUDAH dihapus
            System.out.println("Status sesudah dihapus, apakah ada? : " + fileSementara.exists());
            
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan IO: " + e.getMessage());
        }
    }
}