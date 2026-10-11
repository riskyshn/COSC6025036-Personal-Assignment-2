// Queue (FIFO) berbasis linked list untuk antrian pelanggan
public class Queue {
    private Node front; // depan antrian (dilayani duluan)
    private Node rear;  // belakang antrian (tempat pelanggan baru masuk)
    private int size;

    public Queue() {
        front = rear = null;
        size = 0;
    }

    public int getSize() { return size; }

    public boolean isEmpty() { return front == null; }

    // Cek apakah nomor antrian sudah dipakai
    public boolean sudahAda(String kode) {
        Node bantu = front;
        while (bantu != null) {
            if (bantu.kode.equalsIgnoreCase(kode)) return true;
            bantu = bantu.next;
        }
        return false;
    }

    // ENQUEUE: tambah pelanggan di belakang antrian
    public void enqueue(String kode, String nama, double total) {
        Node baru = new Node(kode, nama, total);
        if (rear == null) {
            front = rear = baru;
        } else {
            rear.next = baru;
            rear = baru;
        }
        size++;
    }

    // DEQUEUE: ambil pelanggan paling depan. Null jika kosong
    public Node dequeue() {
        if (front == null) return null;
        Node keluar = front;
        front = front.next;
        if (front == null) rear = null; // antrian jadi kosong
        keluar.next = null;
        size--;
        return keluar;
    }

    // Tampilkan seluruh antrian dari depan ke belakang
    public void tampil() {
        if (front == null) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("Antrian saat ini:");
        Node bantu = front;
        int no = 1;
        while (bantu != null) {
            System.out.printf("%d. %s | %s | Rp%,.0f%n", no++, bantu.kode, bantu.nama, bantu.total);
            bantu = bantu.next;
        }
        System.out.println("Jumlah dalam antrian: " + size);
    }
}
