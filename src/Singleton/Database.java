package Singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Database {
    private static Database instance;
    private ConcurrentHashMap<Integer, Barang> database;

    /**
     * Konstruktor private untuk mencegah instansiasi langsung.
     */
    private Database() {
        database = new ConcurrentHashMap<>();
    }

    /**
     * Mengembalikan instance singleton dari kelas Database.
     *
     * @return instance singleton dari kelas Database.
     */
    public static Database getInstance() {
        if (instance == null) {
            synchronized (Database.class) {
                if (instance == null) {
                    instance = new Database();
                }
            }
        }
        return instance;
    }

    /**
     * Menyimpan barang ke dalam database.
     *
     * @param barang barang yang akan disimpan.
     */
    public void simpanBarang(Barang barang) {
        database.put(barang.getId(), barang);
        System.out.println("Barang dengan ID " + barang.getId() + " disimpan di database.");
    }

    /**
     * Mengambil barang dari database berdasarkan ID.
     *
     * @param id ID barang yang akan diambil.
     * @return barang yang sesuai dengan ID atau null jika tidak ditemukan.
     */
    public Barang getBarang(int id) {
        return database.get(id);
    }

    /**
     * Menghapus barang dari database berdasarkan ID.
     *
     * @param id ID barang yang akan dihapus.
     */
    public void hapusBarang(int id) {
        database.remove(id);
        System.out.println("Barang dengan ID " + id + " dihapus dari database.");
    }

    /**
     * Melihat semua barang yang tersimpan dalam database.
     *
     * @return daftar barang yang tersimpan dalam database.
     */
    public List<Barang> lihatSemuaBarang() {
        return new ArrayList<>(database.values());
    }
}
