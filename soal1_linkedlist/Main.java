import java.util.Scanner;

// Program pengelolaan daftar buku perpustakaan (Single Linked List)
public class Main {
    static final int MIN_BUKU = 5;      // jumlah data minimal
    static final int MAX_KODE = 5;      // panjang maksimal kodeBuku

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList daftar = new LinkedList();
        boolean jalan = true;

        while (jalan) {
            System.out.println();
            System.out.println("===== SISTEM DATA BUKU =====");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Hapus Buku");
            System.out.println("3. Cari Buku");
            System.out.println("4. Lihat Semua Buku");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            String pilih = sc.nextLine().trim();

            switch (pilih) {
                case "1":
                    tambahBuku(sc, daftar);
                    break;
                case "2":
                    // Hapus buku terakhir
                    if (daftar.isEmpty()) {
                        System.out.println("Tidak ada data untuk dihapus.");
                    } else {
                        daftar.pop();
                        System.out.println("Buku terakhir berhasil dihapus!");
                    }
                    break;
                case "3":
                    cariBuku(sc, daftar);
                    break;
                case "4":
                    daftar.tampil();
                    break;
                case "5":
                    // Validasi: data minimal 5 buku sebelum keluar
                    if (daftar.getSize() < MIN_BUKU) {
                        System.out.println("Data baru " + daftar.getSize()
                                + " buku. Minimal harus " + MIN_BUKU + " buku.");
                        System.out.print("Tetap keluar? (y/n): ");
                        String jawab = sc.nextLine().trim();
                        if (jawab.equalsIgnoreCase("y")) {
                            jalan = false;
                        }
                    } else {
                        jalan = false;
                    }
                    break;
                default:
                    System.out.println("Menu tidak valid, pilih 1-5.");
            }
        }
        System.out.println("Terima kasih, program selesai.");
        sc.close();
    }

    // Input data buku + validasi
    static void tambahBuku(Scanner sc, LinkedList daftar) {
        System.out.print("Masukkan Kode Buku: ");
        String kode = sc.nextLine().trim();
        if (kode.isEmpty() || kode.length() > MAX_KODE) {
            System.out.println("Gagal: kode buku wajib diisi dan maksimal "
                    + MAX_KODE + " karakter.");
            return;
        }
        if (daftar.sudahAda(kode)) {
            System.out.println("Gagal: kode buku " + kode + " sudah terdaftar.");
            return;
        }
        System.out.print("Masukkan Judul: ");
        String judul = sc.nextLine().trim();
        System.out.print("Masukkan Penulis: ");
        String penulis = sc.nextLine().trim();
        if (judul.isEmpty() || penulis.isEmpty()) {
            System.out.println("Gagal: judul dan penulis tidak boleh kosong.");
            return;
        }
        daftar.push(kode, judul, penulis);
        System.out.println("Data berhasil ditambahkan!");
    }

    // Cari buku berdasarkan kode
    static void cariBuku(Scanner sc, LinkedList daftar) {
        System.out.print("Masukkan Kode Buku: ");
        String kode = sc.nextLine().trim();
        Node hasil = daftar.cari(kode);
        if (hasil == null) {
            System.out.println("Buku tidak ditemukan.");
        } else {
            System.out.println("Buku ditemukan!");
            System.out.println("Kode: " + hasil.kodeBuku
                    + " | Judul: " + hasil.judul
                    + " | Penulis: " + hasil.penulis);
        }
    }
}
