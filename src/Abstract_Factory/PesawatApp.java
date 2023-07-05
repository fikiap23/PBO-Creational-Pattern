package Abstract_Factory;

import java.util.Scanner;

/**
 * Interface abstrak untuk Tiket Penerbangan.
 */
interface TiketPenerbangan {
    /**
     * Metode untuk memesan tiket penerbangan.
     */
    void pesan();
}

/**
 * Implementasi konkret untuk Tiket Ekonomi.
 */
class TiketEkonomi implements TiketPenerbangan {
    @Override
    public void pesan() {
        System.out.println("Memesan tiket kelas ekonomi...");
    }
}

/**
 * Implementasi konkret untuk Tiket Bisnis.
 */
class TiketBisnis implements TiketPenerbangan {
    @Override
    public void pesan() {
        System.out.println("Memesan tiket kelas bisnis...");
    }
}

/**
 * Interface abstrak untuk Maskapai Penerbangan.
 */
interface MaskapaiPenerbangan {
    /**
     * Metode untuk memesan tiket penerbangan.
     *
     * @return Objek TiketPenerbangan yang dipesan.
     */
    TiketPenerbangan pesanTiket();
}

/**
 * Implementasi konkret untuk Maskapai Garuda Indonesia.
 */
class GarudaIndonesia implements MaskapaiPenerbangan {
    @Override
    public TiketPenerbangan pesanTiket() {
        return new TiketEkonomi();
    }
}

/**
 * Implementasi konkret untuk Maskapai Lion Air.
 */
class LionAir implements MaskapaiPenerbangan {
    @Override
    public TiketPenerbangan pesanTiket() {
        return new TiketBisnis();
    }
}

/**
 * Abstract Factory: Penerbangan Factory.
 */
abstract class PenerbanganFactory {
    /**
     * Metode untuk membuat objek MaskapaiPenerbangan.
     *
     * @return Objek MaskapaiPenerbangan yang dibuat.
     */
    abstract MaskapaiPenerbangan createMaskapai();
}

/**
 * Concrete Factory: Penerbangan Ekonomi Factory.
 */
class PenerbanganEkonomiFactory extends PenerbanganFactory {
    @Override
    public MaskapaiPenerbangan createMaskapai() {
        return new GarudaIndonesia();
    }
}

/**
 * Concrete Factory: Penerbangan Bisnis Factory.
 */
class PenerbanganBisnisFactory extends PenerbanganFactory {
    @Override
    public MaskapaiPenerbangan createMaskapai() {
        return new LionAir();
    }
}

/**
 * Program utama untuk pemesanan tiket pesawat.
 */
public class PesawatApp {
    /**
     * Metode utama program.
     *
     * @param args Argumen baris perintah (tidak digunakan dalam contoh ini).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selamat datang di sistem pemesanan tiket pesawat!");
        System.out.println("Silakan pilih jenis penerbangan: ");
        System.out.println("1. Ekonomi");
        System.out.println("2. Bisnis");

        int pilihanPenerbangan = scanner.nextInt();

        PenerbanganFactory penerbanganFactory;

        if (pilihanPenerbangan == 1) {
            penerbanganFactory = new PenerbanganEkonomiFactory();
        } else if (pilihanPenerbangan == 2) {
            penerbanganFactory = new PenerbanganBisnisFactory();
        } else {
            throw new IllegalArgumentException("Pilihan tidak valid.");
        }

        MaskapaiPenerbangan maskapaiPenerbangan = penerbanganFactory.createMaskapai();
        TiketPenerbangan tiketPenerbangan = maskapaiPenerbangan.pesanTiket();
        tiketPenerbangan.pesan();
    }
}
