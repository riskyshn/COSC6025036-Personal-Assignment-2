import java.util.Scanner;

// Sistem kasir toko: Queue untuk antrian, Stack untuk riwayat transaksi
public class Main {
    static final int MAX_ANTRIAN = 5; // validasi jumlah data antrian <= 5

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue antrian = new Queue();
        Stack riwayat = new Stack();
        boolean jalan = true;

        while (jalan) {
            System.out.println();
            System.out.println("=== SISTEM KASIR TOKO ===");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Layani Pelanggan");
            System.out.println("3. Tampilkan Antrian");
            System.out.println("4. Lihat Riwayat Transaksi");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            String pilih = sc.nextLine().trim();

            switch (pilih) {
                case "1":
                    tambahAntrian(sc, antrian);
                    break;
                case "2":
                    layani(antrian, riwayat);
                    break;
                case "3":
                    antrian.tampil();
                    break;
                case "4":
                    riwayat.display();
                    break;
                case "5":
                    jalan = false;
                    break;
                default:
                    System.out.println("Menu tidak valid, pilih 1-5.");
            }
        }
        System.out.println("Terima kasih, program selesai.");
        sc.close();
    }

    // Enqueue pelanggan baru dengan validasi
    static void tambahAntrian(Scanner sc, Queue antrian) {
        if (antrian.getSize() >= MAX_ANTRIAN) {
            System.out.println("Antrian penuh (maksimal " + MAX_ANTRIAN
                    + " pelanggan). Layani pelanggan terlebih dahulu.");
            return;
        }
        System.out.print("Masukkan Nomor Antrian: ");
        String kode = sc.nextLine().trim();
        if (kode.isEmpty()) {
            System.out.println("Gagal: nomor antrian tidak boleh kosong.");
            return;
        }
        if (antrian.sudahAda(kode)) {
            System.out.println("Gagal: nomor antrian " + kode + " sudah ada.");
            return;
        }
        System.out.print("Masukkan Nama Pelanggan: ");
        String nama = sc.nextLine().trim();
        if (nama.isEmpty()) {
            System.out.println("Gagal: nama tidak boleh kosong.");
            return;
        }
        System.out.print("Masukkan Total Belanja: ");
        double total;
        try {
            total = Double.parseDouble(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Gagal: total belanja harus berupa angka.");
            return;
        }
        if (total <= 0) {
            System.out.println("Gagal: total belanja harus lebih dari 0.");
            return;
        }
        antrian.enqueue(kode, nama, total);
        System.out.println("Data pelanggan ditambahkan ke antrian!");
    }

    // Dequeue pelanggan terdepan lalu push ke stack riwayat
    static void layani(Queue antrian, Stack riwayat) {
        Node pelanggan = antrian.dequeue();
        if (pelanggan == null) {
            System.out.println("Tidak ada pelanggan dalam antrian.");
            return;
        }
        System.out.println("Melayani pelanggan " + pelanggan.kode + " (" + pelanggan.nama + ")");
        riwayat.push(pelanggan.kode, pelanggan.nama, pelanggan.total);
        System.out.println("Transaksi disimpan ke riwayat.");
    }
}
