package library.items;

import java.util.Objects;

public abstract class Item  {
    protected String id;
    protected String isim;
    protected String yazar;
    protected String kategori;
    protected boolean ödünçAlınmaDurumu;
    protected int fiyat;

    public Item(String id, String isim, String yazar, String kategori, int fiyat) {
        this.id = id;
        this.isim = isim;
        this.yazar = yazar;
        this.kategori = kategori;
        this.ödünçAlınmaDurumu = false;
        this.fiyat = fiyat;
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
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }

    public String getStatus() {
        return ödünçAlınmaDurumu ? "Ödünç Alındı" : "Rafta";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id.equals(item.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", isim='" + isim + '\'' +
                ", yazar='" + yazar + '\'' +
                ", kategori='" + kategori + '\'' +
                ", ödünçAlınmaDurumu=" + (ödünçAlınmaDurumu ? "Ödünç Alındı" : "Rafta") +
                ", fiyat=" + fiyat +
                '}';
    }
}
