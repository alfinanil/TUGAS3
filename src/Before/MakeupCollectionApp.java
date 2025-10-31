package Before;

import java.util.Scanner;

public class MakeupCollectionApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MakeupCollection collection = new MakeupCollection();

        collection.addItem("Maybelline SuperStay Matte Ink", "Maybelline", "Lipstik",
                89000, 2, "2026-12-31");
        collection.addItem("L'Oreal Infallible Foundation", "L'Oreal", "Foundation",
                175000, 1, "2026-06-30");
        collection.addItem("Wardah Colorfit Velvet Matte", "Wardah", "Lipstik",
                45000, 3, "2026-08-15");
        collection.addItem("Focallure Eyeshadow Palette", "Focallure", "Eyeshadow",
                120000, 1, "2026-10-20");
        collection.addItem("Emina Bare With Me Cushion", "Emina", "Cushion",
                65000, 2, "2025-12-31");

        boolean running = true;

        while (running) {
            System.out.println("\n╔════════════════════════════════════════╗");
            System.out.println("║   PROGRAM KOLEKSI MAKEUP PRIBADI       ║");
            System.out.println("╚════════════════════════════════════════╝");
            System.out.println("1. Tampilkan Semua Koleksi");
            System.out.println("2. Tambah Produk Baru");
            System.out.println("3. Cari Berdasarkan Kategori");
            System.out.println("4. Update Harga");
            System.out.println("5. Tandai Sebagai Favorit");
            System.out.println("6. Tampilkan Favorit");
            System.out.println("7. Lihat Statistik");
            System.out.println("8. Keluar");
            System.out.print("Pilih menu (1-8): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    collection.displayAll();
                    break;

                case 2:
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
                    break;

                case 3:
                    System.out.print("Masukkan kategori: ");
                    String searchCategory = scanner.nextLine();
                    collection.searchByCategory(searchCategory);
                    break;

                case 4:
                    System.out.print("Nama produk: ");
                    String updateName = scanner.nextLine();
                    System.out.print("Harga baru: ");
                    double newPrice = scanner.nextDouble();
                    collection.updatePrice(updateName, newPrice);
                    break;

                case 5:
                    System.out.print("Nama produk: ");
                    String favName = scanner.nextLine();
                    collection.markAsFavorite(favName);
                    break;

                case 6:
                    collection.showFavorites();
                    break;

                case 7:
                    collection.calculateStatistics();
                    break;

                case 8:
                    running = false;
                    System.out.println("Terima kasih telah menggunakan program ini!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }

        scanner.close();
    }
}