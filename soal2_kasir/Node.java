// Node untuk menyimpan data pelanggan / transaksi
public class Node {
    String kode;      // nomor antrian
    String nama;      // nama pelanggan
    double total;     // total belanja
    Node next;

    public Node(String kode, String nama, double total) {
        this.kode = kode;
        this.nama = nama;
        this.total = total;
        this.next = null;
    }
}
