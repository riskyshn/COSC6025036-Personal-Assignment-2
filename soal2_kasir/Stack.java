// Stack (LIFO) berbasis linked list untuk riwayat transaksi
public class Stack {
    private Node top; // transaksi terbaru
    private int size;

    public Stack() {
        top = null;
        size = 0;
    }

    public int getSize() { return size; }

    public boolean isEmpty() { return top == null; }

    // PUSH: simpan transaksi baru di paling atas
    public void push(String kode, String nama, double total) {
        Node baru = new Node(kode, nama, total);
        baru.next = top;
        top = baru;
        size++;
    }

    // Tampilkan riwayat dari terbaru (atas) ke terlama (bawah)
    public void display() {
        if (top == null) {
            System.out.println("Belum ada riwayat transaksi.");
            return;
        }
        System.out.println("Riwayat Transaksi (terbaru ke lama):");
        Node bantu = top;
        int no = 1;
        double jumlah = 0;
        while (bantu != null) {
            System.out.printf("%d. %s | %s | Rp%,.0f%n", no++, bantu.kode, bantu.nama, bantu.total);
            jumlah += bantu.total;
            bantu = bantu.next;
        }
        System.out.println("Total transaksi: " + size);
        System.out.printf("Total pendapatan: Rp%,.0f%n", jumlah);
    }
}
