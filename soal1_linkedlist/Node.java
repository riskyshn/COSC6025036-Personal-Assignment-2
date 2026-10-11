// Node untuk menyimpan satu data buku
public class Node {
    String kodeBuku;
    String judul;
    String penulis;
    Node next; // penunjuk ke node berikutnya

    public Node(String kodeBuku, String judul, String penulis) {
        this.kodeBuku = kodeBuku;
        this.judul = judul;
        this.penulis = penulis;
        this.next = null;
    }
}
