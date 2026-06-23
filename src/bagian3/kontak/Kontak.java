package bagian3.kontak;

public class Kontak {
    private String nama;
    private String telepon;
    private String email; // Poin 2: Tambah atribut email

    // Poin 2: Constructor diperbarui untuk menerima email
    public Kontak(String nama, String telepon, String email) {
        this.nama = nama;
        this.telepon = telepon;
        this.email = email;
    }

    public String getNama() {
        return nama;
    }

    public String getTelepon() {
        return telepon;
    }

    // Poin 2: Getter untuk email
    public String getEmail() {
        return email;
    }

    // Poin 2: Mengubah objek menjadi baris teks untuk disimpan di file (dipisah koma)
    public String keBaris() {
        return nama + "," + telepon + "," + email;
    }

    // Poin 2: Format tampilan informasi kontak di layar cetak
    public String info() {
        return nama + " - " + telepon + " (" + email + ")";
    }
}