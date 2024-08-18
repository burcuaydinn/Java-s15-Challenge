package library.items;

public abstract class Item {
    protected String id;
    protected String isim;
    protected String yazar;
    protected String kategori;
    protected boolean ödünçAlınmaDurumu;
    protected String status; // Yeni eklenen alan

    public Item(String id, String isim, String yazar, String kategori) {
        this.id = id;
        this.isim = isim;
        this.yazar = yazar;
        this.kategori = kategori;
        this.ödünçAlınmaDurumu = false;
        this.status = "Rafta"; // Varsayılan olarak "Rafta" durumu
    }

    public String getId() {
        return id;
    }

    public String getIsim() {
        return isim;
    }

    public String getYazar() {
        return yazar;
    }

    public String getKategori() {
        return kategori;
    }

    public boolean isÖdünçAlınmaDurumu() {
        return ödünçAlınmaDurumu;
    }

    public void setÖdünçAlınmaDurumu(boolean ödünçAlınmaDurumu) {
        this.ödünçAlınmaDurumu = ödünçAlınmaDurumu;
        this.status = ödünçAlınmaDurumu ? "Ödünç Alındı" : "Rafta";
    }
    public void setId(String id) {
        this.id = id;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public void setYazar(String yazar) {
        this.yazar = yazar;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
}


    public String getStatus() {
        return status;
    }
}
