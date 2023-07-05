package Abstract_Factory;

import java.util.Scanner;

// Abstract Product: Tiket Penerbangan
interface TiketPenerbangan {
    void pesan();
}

// Concrete Products: Tiket Ekonomi
class TiketEkonomi implements TiketPenerbangan {
    @Override
    public void pesan() {
        System.out.println("Memesan tiket kelas ekonomi...");
    }
}

// Concrete Products: Tiket Bisnis
class TiketBisnis implements TiketPenerbangan {
    @Override
    public void pesan() {
        System.out.println("Memesan tiket kelas bisnis...");
    }
}

// Abstract Product: Maskapai Penerbangan
interface MaskapaiPenerbangan {
    TiketPenerbangan pesanTiket();
}

// Concrete Products: Maskapai Garuda Indonesia
class GarudaIndonesia implements MaskapaiPenerbangan {
    @Override
    public TiketPenerbangan pesanTiket() {
        return new TiketEkonomi();
    }
}

// Concrete Products: Maskapai Lion Air
class LionAir implements MaskapaiPenerbangan {
    @Override
    public TiketPenerbangan pesanTiket() {
        return new TiketBisnis();
    }
}

// Abstract Factory: Penerbangan Factory
abstract class PenerbanganFactory {
    abstract MaskapaiPenerbangan createMaskapai();
}

// Concrete Factory: Penerbangan Ekonomi Factory
class PenerbanganEkonomiFactory extends PenerbanganFactory {
    @Override
    public MaskapaiPenerbangan createMaskapai() {
        return new GarudaIndonesia();
    }
}

// Concrete Factory: Penerbangan Bisnis Factory
class PenerbanganBisnisFactory extends PenerbanganFactory {
    @Override
    public MaskapaiPenerbangan createMaskapai() {
        return new LionAir();
    }
}

// Client Code
public class PesawatApp {
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
