package After;

import java.util.ArrayList;

/**
 * Kelas {@code MakeupCollection} digunakan untuk mengelola daftar koleksi makeup.
 * <p>
 * Kelas ini menyediakan berbagai fitur seperti menambahkan produk,
 * menampilkan semua koleksi, mencari berdasarkan kategori, memperbarui harga,
 * menghitung statistik koleksi, dan menandai produk favorit.
 * </p>
 *
 * <p><b>Fitur utama:</b></p>
 * <ul>
 *     <li>Validasi input produk</li>
 *     <li>Penambahan dan pengelolaan koleksi makeup</li>
 *     <li>Statistik nilai total dan level kolektor</li>
 *     <li>Menandai produk favorit</li>
 * </ul>
 *
 * @author Alfina
 * @version 1.0
 * @since 2025-10-31
 */
public class MakeupCollection {
    private ArrayList<MakeupItem> items;
    private static final double PREMIUM_THRESHOLD = 100000;
    private static final double STANDARD_THRESHOLD = 50000;
    private static final int LEVEL_EXPERT = 10;
    private static final int LEVEL_INTERMEDIATE = 5;

    /**
     * Konstruktor untuk membuat koleksi makeup baru.
     * Inisialisasi daftar item dengan {@link ArrayList}.
     */
    public MakeupCollection() {
        this.items = new ArrayList<>();
    }

    /**
     * Memeriksa validitas data input sebelum menambahkan produk.
     *
     * @param name     nama produk
     * @param brand    merek produk
     * @param category kategori produk
     * @param price    harga produk
     * @param quantity jumlah produk
     * @return true jika data valid, false jika ada kesalahan input
     */
    private boolean isValidInput(String name, String brand, String category, double price, int quantity) {
        if (name == null || name.isEmpty()) {
            System.out.println("Error: Nama tidak boleh kosong!");
            return false;
        }
        if (brand == null || brand.isEmpty()) {
            System.out.println("Error: Brand tidak boleh kosong!");
            return false;
        }
        if (category == null || category.isEmpty()) {
            System.out.println("Error: Kategori tidak boleh kosong!");
            return false;
        }
        if (price <= 0) {
            System.out.println("Error: Harga harus lebih dari 0!");
            return false;
        }
        if (quantity < 0) {
            System.out.println("Error: Jumlah tidak boleh negatif!");
            return false;
        }
        return true;
    }

    /**
     * Menambahkan item makeup baru ke dalam koleksi.
     *
     * @param name     nama produk
     * @param brand    merek produk
     * @param category kategori produk
     * @param price    harga satuan
     * @param quantity jumlah produk
     * @param expiry   tanggal kedaluwarsa
     */
    public void addItem(String name, String brand, String category, double price, int quantity, String expiry) {
        if (!isValidInput(name, brand, category, price, quantity)) return;
        MakeupItem item = new MakeupItem(name, brand, category, price, quantity, expiry);
        items.add(item);
        System.out.println("Produk berhasil ditambahkan!");
    }

    /**
     * Menghitung dan menampilkan statistik koleksi makeup, termasuk total nilai,
     * jumlah per kategori, serta status dan level kolektor.
     */
    public void calculateStatistics() {
        double totalValue = 0;
        int lipstikCount = 0, foundationCount = 0, eyeshadowCount = 0, otherCount = 0;

        for (MakeupItem item : items) {
            double itemValue = item.getPrice() * item.getQuantity();
            totalValue += itemValue;

            switch (item.getCategory()) {
                case "Lipstik" -> lipstikCount++;
                case "Foundation" -> foundationCount++;
                case "Eyeshadow" -> eyeshadowCount++;
                default -> otherCount++;
            }
        }

        System.out.println("\n===== STATISTIK KOLEKSI =====");
        System.out.println("Total Item: " + items.size());
        System.out.println("Total Nilai: Rp " + totalValue);
        System.out.println("Lipstik: " + lipstikCount);
        System.out.println("Foundation: " + foundationCount);
        System.out.println("Eyeshadow: " + eyeshadowCount);
        System.out.println("Lainnya: " + otherCount);

        if (totalValue > PREMIUM_THRESHOLD) {
            System.out.println("Status: Koleksi Premium");
        } else if (totalValue > STANDARD_THRESHOLD) {
            System.out.println("Status: Koleksi Standar");
        } else {
            System.out.println("Status: Koleksi Pemula");
        }

        if (items.size() > LEVEL_EXPERT) {
            System.out.println("Kolektor Level: Expert");
        } else if (items.size() > LEVEL_INTERMEDIATE) {
            System.out.println("Kolektor Level: Intermediate");
        } else {
            System.out.println("Kolektor Level: Beginner");
        }
    }

    /**
     * Mencari produk berdasarkan kategori dan menampilkan hasilnya.
     *
     * @param category kategori yang ingin dicari (misalnya: "Lipstik", "Foundation")
     */
    public void searchByCategory(String category) {
        System.out.println("\n===== HASIL PENCARIAN: " + category + " =====");
        boolean found = false;
        double totalPrice = 0;
        int count = 0;

        for (MakeupItem item : items) {
            if (item.getCategory().equalsIgnoreCase(category)) {
                found = true;
                count++;
                totalPrice += item.getPrice() * item.getQuantity();
                item.displayDetails();
            }
        }

        if (found) {
            System.out.println("Total " + category + " ditemukan: " + count);
            System.out.println("Total nilai: Rp " + totalPrice);
        } else {
            System.out.println("Tidak ada produk dengan kategori: " + category);
        }
    }

    /**
     * Memperbarui harga produk berdasarkan nama.
     *
     * @param name     nama produk yang ingin diubah
     * @param newPrice harga baru produk
     */
    public void updatePrice(String name, double newPrice) {
        for (MakeupItem item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                double oldPrice = item.getPrice();
                item.setPrice(newPrice);
                System.out.println("Harga " + item.getName() + " diupdate dari Rp " + oldPrice + " ke Rp " + newPrice);
                return;
            }
        }
        System.out.println("Produk tidak ditemukan!");
    }

    /**
     * Menampilkan seluruh koleksi makeup yang tersedia.
     * Jika koleksi kosong, akan menampilkan pesan informasi.
     */
    public void displayAll() {
        if (items.isEmpty()) {
            System.out.println("Koleksi masih kosong!");
            return;
        }
        System.out.println("\n===== SEMUA KOLEKSI MAKEUP =====");
        for (int i = 0; i < items.size(); i++) {
            System.out.println("\nItem #" + (i + 1));
            items.get(i).displayDetails();
        }
    }

    /**
     * Menandai produk tertentu sebagai favorit.
     *
     * @param name nama produk yang ingin dijadikan favorit
     */
    public void markAsFavorite(String name) {
        for (MakeupItem item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                item.setFavorite(true);
                System.out.println(name + " ditandai sebagai favorit!");
                return;
            }
        }
        System.out.println("Produk tidak ditemukan!");
    }

    /**
     * Menampilkan seluruh produk yang telah ditandai sebagai favorit.
     * Jika belum ada, akan muncul pesan bahwa belum ada makeup favorit.
     */
    public void showFavorites() {
        System.out.println("\n===== MAKEUP FAVORIT =====");
        boolean hasFavorite = false;
        for (MakeupItem item : items) {
            if (item.isFavorite()) {
                hasFavorite = true;
                item.displayDetails();
            }
        }
        if (!hasFavorite) {
            System.out.println("Belum ada makeup favorit!");
        }
    }

    /**
     * Menambahkan produk ke koleksi dengan informasi tambahan seperti tanggal pembelian,
     * toko tempat membeli, dan catatan tambahan.
     *
     * @param item         objek {@link MakeupItem} yang akan ditambahkan
     * @param purchaseDate tanggal pembelian produk
     * @param store        nama toko tempat membeli
     * @param notes        catatan tambahan
     */
    public void addItemWithDetails(MakeupItem item, String purchaseDate, String store, String notes) {
        items.add(item);
        System.out.println("Produk dengan detail lengkap berhasil ditambahkan!");
        System.out.println("Tanggal beli: " + purchaseDate);
        System.out.println("Toko: " + store);
        System.out.println("Catatan: " + notes);
    }

    /**
     * Mengambil jumlah total produk dalam koleksi.
     *
     * @return jumlah total item makeup
     */
    public int getTotalItems() {
        return items.size();
    }
}
