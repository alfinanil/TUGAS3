package After;

import java.util.Scanner;

/**
 * Kelas {@code MakeupCollectionApp} merupakan kelas utama (entry point)
 * untuk menjalankan aplikasi manajemen koleksi makeup berbasis console.
 * <p>
 * Aplikasi ini memungkinkan pengguna untuk:
 * <ul>
 *     <li>Menampilkan semua koleksi makeup</li>
 *     <li>Menambahkan produk baru</li>
 *     <li>Mencari produk berdasarkan kategori</li>
 *     <li>Memperbarui harga produk</li>
 *     <li>Menandai produk favorit</li>
 *     <li>Melihat produk favorit</li>
 *     <li>Menampilkan statistik koleksi</li>
 * </ul>
 *
 * <p>Program ini menggunakan kelas {@link MakeupCollection}
 * sebagai pengelola utama data koleksi makeup.</p>
 *
 * @author Alfina
 * @version 1.0
 * @since 2025-10-31
 */

public class MakeupCollectionApp {
    /**
     * Metode utama untuk menjalankan aplikasi koleksi makeup.
     * Aplikasi berjalan dalam mode interaktif dengan menu berbasis teks.
     *
     * @param args argumen baris perintah (tidak digunakan dalam program ini)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MakeupCollection collection = new MakeupCollection();

        // Tambahkan beberapa data awal ke dalam koleksi
        collection.addItem("Maybelline SuperStay Matte Ink", "Maybelline", "Lipstik", 89000, 2, "2026-12-31");
        collection.addItem("L'Oreal Infallible Foundation", "L'Oreal", "Foundation", 175000, 1, "2026-06-30");
        collection.addItem("Wardah Colorfit Velvet Matte", "Wardah", "Lipstik", 45000, 3, "2026-08-15");

        boolean running = true;

        // Loop menu utama
        while (running) {
            System.out.println("\n1. Tampilkan Semua Koleksi");
            System.out.println("2. Tambah Produk Baru");
            System.out.println("3. Cari Berdasarkan Kategori");
            System.out.println("4. Update Harga");
            System.out.println("5. Tandai Sebagai Favorit");
            System.out.println("6. Tampilkan Favorit");
            System.out.println("7. Lihat Statistik");
            System.out.println("8. Keluar");
            System.out.print("Pilih menu (1-8): ");
            int choice = scanner.nextInt();
            scanner.nextLine();// membersihkan newline buffer

            switch (choice) {
                case 1 -> collection.displayAll();
                case 2 -> {
                    System.out.print("Nama produk: ");
                    String name = scanner.nextLine();
                    System.out.print("Brand: ");
                    String brand = scanner.nextLine();
                    System.out.print("Kategori: ");
                    String category = scanner.nextLine();
                    System.out.print("Harga: ");
                    double price = scanner.nextDouble();
                    System.out.print("Jumlah: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Tanggal kadaluarsa (YYYY-MM-DD): ");
                    String expiry = scanner.nextLine();
                    collection.addItem(name, brand, category, price, quantity, expiry);
                }
                case 3 -> {
                    System.out.print("Masukkan kategori: ");
                    String category = scanner.nextLine();
                    collection.searchByCategory(category);
                }
                case 4 -> {
                    System.out.print("Nama produk: ");
                    String updateName = scanner.nextLine();
                    System.out.print("Harga baru: ");
                    double newPrice = scanner.nextDouble();
                    collection.updatePrice(updateName, newPrice);
                }
                case 5 -> {
                    System.out.print("Nama produk: ");
                    String favName = scanner.nextLine();
                    collection.markAsFavorite(favName);
                }
                case 6 -> collection.showFavorites();
                case 7 -> collection.calculateStatistics();
                case 8 -> running = false;
                default -> System.out.println("Pilihan tidak valid!");
            }
        }
        scanner.close();
    }
}
