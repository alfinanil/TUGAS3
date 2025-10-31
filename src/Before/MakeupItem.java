package Before;

class MakeupItem {
    public String n;
    public String b;
    public String c;
    public double p;
    public int q;
    public String e;
    public boolean f;

    public MakeupItem(String n, String b, String c, double p, int q, String e) {
        this.n = n;
        this.b = b;
        this.c = c;
        this.p = p;
        this.q = q;
        this.e = e;
        this.f = false;
    }

    public void d() {
        System.out.println("====================================");
        System.out.println("Nama: " + n);
        System.out.println("Brand: " + b);
        System.out.println("Kategori: " + c);
        System.out.println("Harga: Rp " + p);
        System.out.println("Jumlah: " + q);
        System.out.println("Kadaluarsa: " + e);
        System.out.println("Favorit: " + (f ? "Ya" : "Tidak"));
        double total = p * q;
        System.out.println("Total Nilai: Rp " + total);

        if (c.equals("Lipstik")) {
            double disc = p * 0.1;
            System.out.println("Diskon: Rp " + disc);
        } else if (c.equals("Foundation")) {
            double disc = p * 0.15;
            System.out.println("Diskon: Rp " + disc);
        } else if (c.equals("Eyeshadow")) {
            double disc = p * 0.12;
            System.out.println("Diskon: Rp " + disc);
        }
        System.out.println("====================================");
    }
}

