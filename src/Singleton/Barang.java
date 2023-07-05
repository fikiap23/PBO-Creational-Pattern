package Singleton;

public class Barang {
    private static int counter = 0;

    private int id;
    private String nama;

    /**
     * Konstruktor untuk membuat objek Barang dengan nama tertentu.
     *
     * @param nama nama barang.
     */
    public Barang(String nama) {
        this.id = generateId();
        this.nama = nama;
    }

    /**
     * Metode private yang digunakan untuk menghasilkan ID barang secara otomatis.
     *
     * @return ID unik untuk barang.
     */
    private static synchronized int generateId() {
        return counter++;
    }

    /**
     * Mengembalikan ID barang.
     *
     * @return ID barang.
     */
    public int getId() {
        return id;
    }

    /**
     * Mengembalikan nama barang.
     *
     * @return nama barang.
     */
    public String getNama() {
        return nama;
    }
}
