package Singleton;

import java.util.Scanner;

/**
 * Aplikasi untuk mengelola database barang menggunakan Singleton pattern.
 *
 * @author Fiki Aprian
 *         NIM: 1217050058
 *         UIN Sunan Gunung Djati
 * @since 5 Juli 2023
 */
public class Application {
    private static Database database = Database.getInstance();
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Metode utama yang dijalankan saat program dijalankan.
     *
     * @param args argumen baris perintah.
     */
    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            System.out.println("=== Menu ===");
            System.out.println("1. Tambah Barang");
            System.out.println("2. Cari Barang");
            System.out.println("3. Hapus Barang");
            System.out.println("4. Lihat Semua Barang");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            int menu = scanner.nextInt();

            switch (menu) {
                case 1:
                    tambahBarang();
                    break;
                case 2:
                    cariBarang();
                    break;
                case 3:
                    hapusBarang();
                    break;
                case 4:
                    lihatSemuaBarang();
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Menu tidak valid. Silakan pilih menu yang valid.");
            }

            System.out.println();
        }
    }

    /**
     * Menambahkan barang ke database.
     */
    private static void tambahBarang() {
        scanner.nextLine(); // Membersihkan newline karakter dari input sebelumnya
        System.out.print("Masukkan nama barang: ");
        String nama = scanner.nextLine();

        Barang barang = new Barang(nama);
        database.simpanBarang(barang);
        System.out.println("Barang berhasil ditambahkan ke database. ID: " + barang.getId());
    }

    /**
     * Mencari barang dalam database berdasarkan ID.
     */
    private static void cariBarang() {
        System.out.print("Masukkan ID barang yang ingin dicari: ");
        int id = scanner.nextInt();

        Barang barang = database.getBarang(id);
        if (barang != null) {
            System.out.println("Barang ditemukan: ID=" + barang.getId() + ", Nama=" + barang.getNama());
        } else {
            System.out.println("Barang tidak ditemukan.");
        }
    }

    /**
     * Menghapus barang dari database berdasarkan ID.
     */
    private static void hapusBarang() {
        System.out.print("Masukkan ID barang yang ingin dihapus: ");
        int id = scanner.nextInt();

        database.hapusBarang(id);
        System.out.println("Barang berhasil dihapus dari database.");
    }

    /**
     * Menampilkan semua barang yang ada dalam database.
     */
    private static void lihatSemuaBarang() {
        System.out.println("Daftar barang dalam database:");
        for (Barang barang : database.lihatSemuaBarang()) {
            System.out.println("ID: " + barang.getId() + ", Nama: " + barang.getNama());
        }
    }
}
