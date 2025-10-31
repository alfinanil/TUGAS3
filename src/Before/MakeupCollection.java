package Before;

import java.util.ArrayList;

class MakeupCollection {
    private ArrayList<MakeupItem> items;

    public MakeupCollection() {
        this.items = new ArrayList<>();
    }

    public void addItem(String name, String brand, String category, double price,
                        int quantity, String expiry) {
        if (name == null || name.isEmpty()) {
            System.out.println("Error: Nama tidak boleh kosong!");
            return;
        }
        if (brand == null || brand.isEmpty()) {
            System.out.println("Error: Brand tidak boleh kosong!");
            return;
        }
        if (category == null || category.isEmpty()) {
            System.out.println("Error: Kategori tidak boleh kosong!");
            return;
        }
        if (price <= 0) {
            System.out.println("Error: Harga harus lebih dari 0!");
            return;
        }
        if (quantity < 0) {
            System.out.println("Error: Jumlah tidak boleh negatif!");
            return;
        }

        MakeupItem item = new MakeupItem(name, brand, category, price, quantity, expiry);
        items.add(item);
        System.out.println("Produk berhasil ditambahkan!");
    }

    // Method dengan banyak magic number
    public void calculateStatistics() {
        double totalValue = 0;
        int lipstikCount = 0;
        int foundationCount = 0;
        int eyeshadowCount = 0;
        int otherCount = 0;

        for (int i = 0; i < items.size(); i++) {
            MakeupItem item = items.get(i);
            double itemValue = item.p * item.q;
            totalValue += itemValue;

            if (item.c.equals("Lipstik")) {
                lipstikCount++;
            } else if (item.c.equals("Foundation")) {
                foundationCount++;
            } else if (item.c.equals("Eyeshadow")) {
                eyeshadowCount++;
            } else {
                otherCount++;
            }
        }

        System.out.println("\n===== STATISTIK KOLEKSI =====");
        System.out.println("Total Item: " + items.size());
        System.out.println("Total Nilai: Rp " + totalValue);
        System.out.println("Lipstik: " + lipstikCount);
        System.out.println("Foundation: " + foundationCount);
        System.out.println("Eyeshadow: " + eyeshadowCount);
        System.out.println("Lainnya: " + otherCount);

        // Magic number 100000 dan 50000
        if (totalValue > 100000) {
            System.out.println("Status: Koleksi Premium");
        } else if (totalValue > 50000) {
            System.out.println("Status: Koleksi Standar");
        } else {
            System.out.println("Status: Koleksi Pemula");
        }

        // Magic number 10 dan 5
        if (items.size() > 10) {
            System.out.println("Kolektor Level: Expert");
        } else if (items.size() > 5) {
            System.out.println("Kolektor Level: Intermediate");
        } else {
            System.out.println("Kolektor Level: Beginner");
        }
    }

    // Method dengan logic yang bisa di-extract
    public void searchByCategory(String category) {
        System.out.println("\n===== HASIL PENCARIAN: " + category + " =====");
        boolean found = false;
        int count = 0;
        double totalPrice = 0;

        for (int i = 0; i < items.size(); i++) {
            MakeupItem item = items.get(i);
            if (item.c.equalsIgnoreCase(category)) {
                found = true;
                count++;
                totalPrice += item.p * item.q;
                item.d();
            }
        }

        if (found) {
            System.out.println("Total " + category + " ditemukan: " + count);
            System.out.println("Total nilai: Rp " + totalPrice);
        } else {
            System.out.println("Tidak ada produk dengan kategori: " + category);
        }
    }

    public void updatePrice(String name, double newPrice) {
        boolean itemFound = false;
        MakeupItem foundItem = null;

        for (int i = 0; i < items.size(); i++) {
            MakeupItem tempItem = items.get(i);
            String tempName = tempItem.n;
            if (tempName.equalsIgnoreCase(name)) {
                foundItem = tempItem;
                itemFound = true;
                break;
            }
        }

        if (itemFound) {
            double oldPrice = foundItem.p;
            foundItem.p = newPrice;
            System.out.println("Harga " + foundItem.n + " diupdate dari Rp " +
                    oldPrice + " ke Rp " + newPrice);
        } else {
            System.out.println("Produk tidak ditemukan!");
        }
    }

    public void displayAll() {
        if (items.size() == 0) {
            System.out.println("Koleksi masih kosong!");
            return;
        }

        System.out.println("\n===== SEMUA KOLEKSI MAKEUP =====");
        for (int i = 0; i < items.size(); i++) {
            System.out.println("\nItem #" + (i + 1));
            items.get(i).d();
        }
    }

    public void markAsFavorite(String name) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).n.equalsIgnoreCase(name)) {
                items.get(i).f = true;
                System.out.println(name + " ditandai sebagai favorit!");
                return;
            }
        }
        System.out.println("Produk tidak ditemukan!");
    }

    public void showFavorites() {
        System.out.println("\n===== MAKEUP FAVORIT =====");
        boolean hasFavorite = false;

        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).f) {
                hasFavorite = true;
                items.get(i).d();
            }
        }

        if (!hasFavorite) {
            System.out.println("Belum ada makeup favorit!");
        }
    }

    public void addItemWithDetails(String name, String brand, String category,
                                   double price, int quantity, String expiry,
                                   boolean isFavorite, String purchaseDate,
                                   String store, String notes) {
        MakeupItem item = new MakeupItem(name, brand, category, price, quantity, expiry);
        item.f = isFavorite;
        items.add(item);
        System.out.println("Produk dengan detail lengkap berhasil ditambahkan!");
        System.out.println("Tanggal beli: " + purchaseDate);
        System.out.println("Toko: " + store);
        System.out.println("Catatan: " + notes);
    }

    public int getTotalItems() {
        return items.size();
    }
}
