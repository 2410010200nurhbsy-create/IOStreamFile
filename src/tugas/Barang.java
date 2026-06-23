package tugas;

public class Barang {
    // Atribut model barang (sesuai instruksi halaman 11)
    private String nama;
    private double harga;
    private int stok;

    // Constructor untuk menginisialisasi data barang
    public Barang(String nama, double harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    // Getter untuk mengakses atribut dari luar class
    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    // Method untuk mengubah objek menjadi satu baris teks untuk disimpan ke file (.txt)
    public String keBaris() {
        return nama + "," + harga + "," + stok;
    }

    // Method untuk menampilkan keterangan barang secara rapi
    public String info() {
        return nama + " - Rp" + harga + " (Stok: " + stok + ")";
    }
}