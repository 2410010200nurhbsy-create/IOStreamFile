// Nama: Nur Habsyiah
// NPM: 2410010200
package tugas;

public class MainTugas {
    public static void main(String[] args) {
        // Poin 1: Menyimpan daftar nama kategori dalam array String (minimal 3, ukuran tetap)
        String[] kategori = {"Elektronik", "Pakaian", "Makanan & Minuman"};
        
        System.out.println("=== DAFTAR KATEGORI TOKO ===");
        for (int i = 0; i < kategori.length; i++) {
            System.out.println((i + 1) + ". " + kategori[i]);
        }
        System.out.println();

        // Pembuatan objek Gudang Pertama untuk mengisi data awal
        Gudang gudangAwal = new Gudang();

        // Poin 3: Menambahkan minimal 5 objek Barang di awal
        gudangAwal.tambahBarang(new Barang("Laptop", 8500000, 10));
        gudangAwal.tambahBarang(new Barang("Kemeja", 150000, 50));
        gudangAwal.tambahBarang(new Barang("Kopi Susu", 15000, 100));
        gudangAwal.tambahBarang(new Barang("Mouse Wireless", 200000, 25));
        gudangAwal.tambahBarang(new Barang("Celana Jeans", 250000, 30));

        // Poin 2: Menyimpan seluruh data barang ke berkas teks
        System.out.println("=== PROSES PENYIMPANAN DATA ===");
        gudangAwal.simpanKeBerkas();
        System.out.println();

        // Poin 3: Membuat objek Gudang baru untuk memuat kembali data dari berkas
        System.out.println("=== MEMBUAT OBJEK GUDANG BARU & MEMUAT FILE ===");
        Gudang gudangBaru = new Gudang();
        gudangBaru.muatDariBerkas();
        
        System.out.println("\n=== DATA BARANG DI GUDANG BARU ===");
        gudangBaru.tampilkanSemua();
        
        // Poin 3: Menampilkan total nilai persediaan gudang baru
        System.out.println("\n=== TOTAL NILAI PERSEDIAAN ===");
        System.out.printf("Total Nilai Aset Gudang: Rp%,.2f\n", gudangBaru.totalNilai());
    }
}