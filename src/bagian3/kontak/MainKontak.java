package bagian3.kontak;

public class MainKontak {
    public static void main(String[] args) {
        BukuKontak buku = new BukuKontak();

        // Memuat data lama dari berkas (jika ada)
        buku.muatDariBerkas();

        System.out.println("=== DATA AWAL DARI BERKAS ===");
        buku.tampilkanSemua();
        System.out.println();

        // Mengisi data kontak baru (Format: Nama, Telepon, Email)
        System.out.println("... Menambahkan kontak baru ...");
        buku.tambahKontak(new Kontak("Habsyi", "08123456", "habsyi@uniska.ac.id"));
        buku.tambahKontak(new Kontak("Andi", "08571122", "andi@gmail.com"));
        buku.tambahKontak(new Kontak("Siti", "08994455", "siti@yahoo.com"));
        
        // Simpan data baru tersebut ke dalam berkas kontak.txt
        buku.simpanKeBerkas();
        
        System.out.println("\n=== DATA SETELAH DITAMBAH ===");
        buku.tampilkanSemua();
        System.out.println();

        // Uji Poin 1: Melakukan pencarian kontak
        System.out.println("=== UJI COBA PENCARIAN KONTAK ===");
        buku.cariKontak("Habsyi");
        buku.cariKontak("Budi"); // Cari yang tidak ada
        System.out.println();

        // Uji Poin 3: Melakukan penghapusan kontak
        System.out.println("=== UJI COBA PENGHAPUSAN KONTAK ===");
        buku.hapusKontak("Andi"); // Menghapus Andi
        System.out.println();

        // Tampilkan hasil akhir untuk memastikan data Andi sudah hilang
        System.out.println("=== DATA AKHIR DI BUKU KONTAK ===");
        buku.tampilkanSemua();
    }
}