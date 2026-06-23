package tugas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList; // Wajib di-import untuk menampung objek Barang

public class Gudang {
    // Menyimpan daftar barang menggunakan ArrayList yang dinamis
    private ArrayList<Barang> daftarBarang = new ArrayList<>();
    private String namaBerkas = "barang.txt"; // Nama berkas penyimpanan

    // Method untuk menambahkan barang baru ke koleksi
    public void tambahBarang(Barang brg) {
        daftarBarang.add(brg);
    }

    // Method untuk menampilkan semua data barang yang ada di dalam list
    public void tampilkanSemua() {
        if (daftarBarang.isEmpty()) {
            System.out.println("Gudang kosong.");
            return;
        }
        for (Barang brg : daftarBarang) {
            System.out.println("- " + brg.info());
        }
    }

    // Method untuk menyimpan seluruh data barang ke berkas teks, satu barang per baris
    public void simpanKeBerkas() {
        try (PrintWriter penulis = new PrintWriter(new FileWriter(namaBerkas))) {
            for (Barang brg : daftarBarang) {
                penulis.println(brg.keBaris());
            }
            System.out.println("Data barang berhasil disimpan ke " + namaBerkas);
        } catch (IOException e) {
            System.out.println("Gagal menyimpan berkas: " + e.getMessage());
        }
    }

    // Method untuk membaca kembali data barang dari berkas ke dalam ArrayList
    public void muatDariBerkas() {
        File file = new File(namaBerkas);
        if (!file.exists()) {
            System.out.println("Berkas " + namaBerkas + " belum ada.");
            return;
        }

        daftarBarang.clear(); // Bersihkan list lama sebelum memuat data baru
        try (BufferedReader pembaca = new BufferedReader(new FileReader(namaBerkas))) {
            String baris;
            while ((baris = pembaca.readLine()) != null) {
                String[] bagian = baris.split(",");
                // Memastikan baris memiliki 3 bagian data (Nama, Harga, Stok)
                if (bagian.length == 3) {
                    String nama = bagian[0];
                    double harga = Double.parseDouble(bagian[1]);
                    int stok = Integer.parseInt(bagian[2]);
                    daftarBarang.add(new Barang(nama, harga, stok));
                }
            }
            System.out.println("Data barang berhasil dimuat dari " + namaBerkas);
        } catch (IOException e) {
            System.out.println("Gagal memuat berkas: " + e.getMessage());
        }
    }

    // Method untuk menjumlahkan harga dikali stok dari seluruh barang di gudang
    public double totalNilai() {
        double total = 0;
        for (Barang brg : daftarBarang) {
            total += brg.getHarga() * brg.getStok();
        }
        return total;
    }
}