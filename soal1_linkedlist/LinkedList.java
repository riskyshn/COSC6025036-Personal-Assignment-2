// Single Linked List untuk daftar buku perpustakaan
public class LinkedList {
    private Node head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    // Cek apakah kodeBuku sudah dipakai (mencegah data ganda)
    public boolean sudahAda(String kode) {
        return cari(kode) != null;
    }

    // PUSH: tambah data baru di AKHIR daftar
    public void push(String kode, String judul, String penulis) {
        Node baru = new Node(kode, judul, penulis);
        if (head == null) {
            head = baru; // daftar kosong, node baru jadi head
        } else {
            Node bantu = head;
            while (bantu.next != null) { // telusuri sampai node terakhir
                bantu = bantu.next;
            }
            bantu.next = baru; // sambungkan di belakang node terakhir
        }
        size++;
    }

    // POP: hapus data buku TERAKHIR. Mengembalikan false jika daftar kosong
    public boolean pop() {
        if (head == null) {
            return false;
        }
        if (head.next == null) { // hanya satu node
            head = null;
        } else {
            Node bantu = head;
            while (bantu.next.next != null) { // berhenti di node sebelum terakhir
                bantu = bantu.next;
            }
            bantu.next = null; // putus node terakhir
        }
        size--;
        return true;
    }

    // CARI: temukan buku berdasarkan kodeBuku (tidak peduli huruf besar/kecil)
    public Node cari(String kode) {
        Node bantu = head;
        while (bantu != null) {
            if (bantu.kodeBuku.equalsIgnoreCase(kode)) {
                return bantu;
            }
            bantu = bantu.next;
        }
        return null;
    }

    // TAMPIL: cetak semua buku sesuai urutan input + total di akhir
    public void tampil() {
        if (head == null) {
            System.out.println("Daftar buku masih kosong.");
            System.out.println("Total Buku: 0");
            return;
        }
        System.out.println("Daftar Buku:");
        Node bantu = head;
        while (bantu != null) {
            System.out.println("Kode: " + bantu.kodeBuku
                    + " | Judul: " + bantu.judul
                    + " | Penulis: " + bantu.penulis);
            bantu = bantu.next;
        }
        System.out.println("Total Buku: " + size);
    }
}
