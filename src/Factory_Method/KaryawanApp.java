package Factory_Method;

import java.util.Scanner;

// Abstract class Karyawan
abstract class Karyawan {
    private String nama;
    private String jabatan;

    /**
     * Konstruktor untuk kelas Karyawan.
     *
     * @param nama    Nama karyawan.
     * @param jabatan Jabatan karyawan.
     */
    public Karyawan(String nama, String jabatan) {
        this.nama = nama;
        this.jabatan = jabatan;
    }

    /**
     * Mengembalikan nama karyawan.
     *
     * @return Nama karyawan.
     */
    public String getNama() {
        return nama;
    }

    /**
     * Mengembalikan jabatan karyawan.
     *
     * @return Jabatan karyawan.
     */
    public String getJabatan() {
        return jabatan;
    }

    /**
     * Menghitung gaji karyawan.
     *
     * @return Gaji karyawan.
     */
    public abstract double hitungGaji();
}

// Concrete class Manager
class Manager extends Karyawan {
    /**
     * Konstruktor untuk kelas Manager.
     *
     * @param nama Nama karyawan.
     */
    public Manager(String nama) {
        super(nama, "Manager");
    }

    @Override
    public double hitungGaji() {
        // Logika perhitungan gaji untuk Manager
        return 10000000.0;
    }
}

// Concrete class Staff
class Staff extends Karyawan {
    /**
     * Konstruktor untuk kelas Staff.
     *
     * @param nama Nama karyawan.
     */
    public Staff(String nama) {
        super(nama, "Staff");
    }

    @Override
    public double hitungGaji() {
        // Logika perhitungan gaji untuk Staff
        return 5000000.0;
    }
}

// Abstract factory class
abstract class KaryawanFactory {
    /**
     * Membuat objek Karyawan.
     *
     * @param nama Nama karyawan.
     * @return Objek Karyawan.
     */
    public abstract Karyawan createKaryawan(String nama);
}

// Concrete factory class for creating Manager
class ManagerFactory extends KaryawanFactory {
    @Override
    public Karyawan createKaryawan(String nama) {
        return new Manager(nama);
    }
}

// Concrete factory class for creating Staff
class StaffFactory extends KaryawanFactory {
    @Override
    public Karyawan createKaryawan(String nama) {
        return new Staff(nama);
    }
}

// Class Utama
public class KaryawanApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        System.out.println("Selamat datang di Program Perhitungan Gaji Karyawan");
        System.out.println("-----------------------------------------------");

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Buat Karyawan Manager");
            System.out.println("2. Buat Karyawan Staff");
            System.out.println("0. Keluar");
            System.out.print("Pilihan Anda: ");
            pilihan = scanner.nextInt();

            if (pilihan == 0) {
                System.out.println("Terima kasih telah menggunakan program ini. Sampai jumpa!");
                break;
            }

            System.out.print("Masukkan nama karyawan: ");
            scanner.nextLine(); // Membuang newline character
            String nama = scanner.nextLine();

            KaryawanFactory factory;
            if (pilihan == 1) {
                factory = new ManagerFactory();
            } else if (pilihan == 2) {
                factory = new StaffFactory();
            } else {
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                continue;
            }

            Karyawan karyawan = factory.createKaryawan(nama);
            System.out.println("Karyawan berhasil dibuat:");
            System.out.println("Nama: " + karyawan.getNama());
            System.out.println("Jabatan: " + karyawan.getJabatan());
            System.out.println("Gaji: Rp" + karyawan.hitungGaji());
            System.out.println();
        }
    }
}
