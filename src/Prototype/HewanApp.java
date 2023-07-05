package Prototype;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Interface Prototype untuk hewan.
 */
interface Hewan extends Cloneable {
    Hewan clone();

    void suara();
}

/**
 * Concrete Prototype 1: Implementasi prototipe Kucing.
 */
class Kucing implements Hewan {
    private String nama;

    public Kucing(String nama) {
        this.nama = nama;
    }

    @Override
    public Hewan clone() {
        return new Kucing(nama);
    }

    @Override
    public void suara() {
        System.out.println("Meong!");
    }
}

/**
 * Concrete Prototype 2: Implementasi prototipe Anjing.
 */
class Anjing implements Hewan {
    private String nama;

    public Anjing(String nama) {
        this.nama = nama;
    }

    @Override
    public Hewan clone() {
        return new Anjing(nama);
    }

    @Override
    public void suara() {
        System.out.println("Guk!");
    }
}

/**
 * Prototype Registry: Kelas untuk menyimpan dan mengakses prototipe hewan.
 */
class HewanRegistry {
    private Map<String, Hewan> hewans;

    public HewanRegistry() {
        hewans = new HashMap<>();
    }

    /**
     * Menambahkan prototipe hewan ke dalam registry.
     *
     * @param key   Kunci untuk mengakses prototipe hewan.
     * @param hewan Objek prototipe hewan.
     */
    public void tambahHewan(String key, Hewan hewan) {
        hewans.put(key, hewan);
    }

    /**
     * Mengambil prototipe hewan dari registry.
     *
     * @param key Kunci untuk mengakses prototipe hewan.
     * @return Prototipe hewan yang telah diklon.
     */
    public Hewan getHewan(String key) {
        Hewan hewan = hewans.get(key);
        if (hewan != null) {
            return hewan.clone();
        }
        return null;
    }
}

/**
 * Contoh penggunaan program.
 */
public class HewanApp {
    public static void main(String[] args) {
        // Inisialisasi objek-objek prototipe hewan
        Kucing prototipeKucing = new Kucing("Meongth");
        Anjing prototipeAnjing = new Anjing("Puppy");

        // Registrasikan prototipe hewan dalam registry
        HewanRegistry registry = new HewanRegistry();
        registry.tambahHewan("KUCING", prototipeKucing);
        registry.tambahHewan("ANJING", prototipeAnjing);

        // Buat scanner untuk membaca input dari pengguna
        Scanner scanner = new Scanner(System.in);

        // Tampilkan menu
        System.out.println("=== Aplikasi Hewan ===");
        System.out.println("Pilih hewan yang ingin dikloning:");
        System.out.println("1. Kucing");
        System.out.println("2. Anjing");
        System.out.print("Pilihan Anda: ");

        // Baca pilihan pengguna
        int pilihan = scanner.nextInt();

        // Proses pilihan pengguna
        switch (pilihan) {
            case 1:
                // Klone dan tampilkan kucing dari registry
                Hewan kucingKlon = registry.getHewan("KUCING");
                if (kucingKlon != null) {
                    System.out.print("Kloning Kucing: ");
                    kucingKlon.suara();
                }
                break;
            case 2:
                // Klone dan tampilkan anjing dari registry
                Hewan anjingKlon = registry.getHewan("ANJING");
                if (anjingKlon != null) {
                    System.out.print("Kloning Anjing: ");
                    anjingKlon.suara();
                }
                break;
            default:
                System.out.println("Pilihan tidak valid.");
        }

        // Tutup scanner
        scanner.close();
    }
}
