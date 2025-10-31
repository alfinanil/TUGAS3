package After;

/**
 * Kelas {@code MakeupItem} merepresentasikan satu item kosmetik
 * yang memiliki atribut seperti nama, merek, kategori, harga, jumlah,
 * tanggal kadaluarsa, dan status favorit.
 * <p>
 * Kelas ini juga menyediakan fitur untuk menampilkan detail produk,
 * menghitung total nilai barang, serta menampilkan diskon berdasarkan kategori.
 *
 * <p><b>Kategori dan Diskon:</b>
 * <ul>
 *     <li>Lipstik → 10%</li>
 *     <li>Foundation → 15%</li>
 *     <li>Eyeshadow → 12%</li>
 * </ul>
 *
 * @author Alfina
 * @version 1.0
 * @since 2025-10-31
 */
public class MakeupItem {
    private String name;
    private String brand;
    private String category;
    private double price;
    private int quantity;
    private String expiryDate;
    private boolean favorite;

    //diskon berdasarkan kategori produk
    private static final double DISKON_LIPSTIK = 0.10;
    private static final double DISKON_FOUNDATION = 0.15;
    private static final double DISKON_EYESHADOW = 0.12;

    /**
     * Konstruktor untuk membuat objek {@code MakeupItem} baru.
     *
     * @param name        nama produk kosmetik
     * @param brand       merek produk kosmetik
     * @param category    kategori produk (contoh: "Lipstik", "Foundation", "Eyeshadow")
     * @param price       harga satuan produk
     * @param quantity    jumlah barang yang dimiliki
     * @param expiryDate  tanggal kadaluarsa produk dalam format string
     */
    public MakeupItem(String name, String brand, String category, double price, int quantity, String expiryDate) {
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
        this.favorite = false;
    }

    /**
     * Menampilkan semua informasi detail tentang produk kosmetik ke konsol,
     * termasuk harga total dan diskon jika berlaku.
     */
    public void displayDetails() {
        System.out.println("====================================");
        System.out.println("Nama: " + name);
        System.out.println("Brand: " + brand);
        System.out.println("Kategori: " + category);
        System.out.println("Harga: Rp " + price);
        System.out.println("Jumlah: " + quantity);
        System.out.println("Kadaluarsa: " + expiryDate);
        System.out.println("Favorit: " + (favorite ? "Ya" : "Tidak"));
        double total = price * quantity;
        System.out.println("Total Nilai: Rp " + total);

        double discount = 0;
        if (category.equals("Lipstik")) {
            discount = price * DISKON_LIPSTIK;
        } else if (category.equals("Foundation")) {
            discount = price * DISKON_FOUNDATION;
        } else if (category.equals("Eyeshadow")) {
            discount = price * DISKON_EYESHADOW;
        }

        if (discount > 0) {
            System.out.println("Diskon: Rp " + discount);
        }
        System.out.println("====================================");
    }

    /**
     * Mengembalikan nama produk kosmetik.
     *
     * @return nama produk
     */
    public String getName() {
        return name; }

    /**
     * Mengembalikan merek produk kosmetik.
     *
     * @return merek produk
     */
    public String getBrand() {
        return brand; }

    /**
     * Mengembalikan kategori produk kosmetik.
     *
     * @return kategori produk
     */
    public String getCategory() {
        return category; }

    /**
     * Mengembalikan harga satuan produk.
     *
     * @return harga produk
     */
    public double getPrice() {
        return price; }

    /**
     * Mengembalikan jumlah barang yang dimiliki.
     *
     * @return jumlah barang
     */
    public int getQuantity() {
        return quantity; }

    /**
     * Mengembalikan tanggal kadaluarsa produk.
     *
     * @return tanggal kadaluarsa
     */
    public String getExpiryDate() {
        return expiryDate; }

    /**
     * Mengembalikan status favorit dari produk ini.
     *
     * @return {@code true} jika produk termasuk favorit, {@code false} jika tidak
     */
    public boolean isFavorite() {
        return favorite; }

    /**
     * Mengubah status favorit produk.
     *
     * @param favorite nilai boolean untuk menentukan apakah produk menjadi favorit
     */
    public void setFavorite(boolean favorite) {
        this.favorite = favorite; }

    /**
     * Mengubah harga produk kosmetik.
     *
     * @param price harga baru untuk produk
     */
    public void setPrice(double price) {
        this.price = price; }
}
