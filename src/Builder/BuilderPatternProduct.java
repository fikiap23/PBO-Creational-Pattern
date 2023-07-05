package Builder;

// Objek yang akan dibangun dengan bantuan Builder
class Product {
    private String nama;
    private String deskripsi;
    private double harga;

    public Product(String nama, String deskripsi, double harga) {
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public double getHarga() {
        return harga;
    }
}

// Builder untuk membangun objek Product
class ProductBuilder {
    private String nama;
    private String deskripsi;
    private double harga;

    /**
     * Mengatur nama produk.
     *
     * @param nama nama produk
     * @return instance builder
     */
    public ProductBuilder setNama(String nama) {
        this.nama = nama;
        return this;
    }

    /**
     * Mengatur deskripsi produk.
     *
     * @param deskripsi deskripsi produk
     * @return instance builder
     */
    public ProductBuilder setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
        return this;
    }

    /**
     * Mengatur harga produk.
     *
     * @param harga harga produk
     * @return instance builder
     */
    public ProductBuilder setHarga(double harga) {
        this.harga = harga;
        return this;
    }

    /**
     * Membangun objek Product berdasarkan nilai-nilai yang telah diatur.
     *
     * @return objek Product yang dibangun
     */
    public Product build() {
        return new Product(nama, deskripsi, harga);
    }
}

// Contoh penggunaan Builder
public class BuilderPatternProduct {
    /**
     * Contoh penggunaan pola desain Builder untuk membangun objek Product.
     *
     * @param args argumen baris perintah
     */
    public static void main(String[] args) {
        Product product = new ProductBuilder()
                .setNama("Keyboard")
                .setDeskripsi("Keyboard mekanik dengan pencahayaan RGB")
                .setHarga(99.99)
                .build();

        System.out.println("Nama Produk: " + product.getNama());
        System.out.println("Deskripsi: " + product.getDeskripsi());
        System.out.println("Harga: Rp" + product.getHarga());
    }
}
