package library.items;

public class Magazine extends Item {
    private MagazineType type;

    public Magazine(String id, String isim, String yazar, MagazineType type, int fiyat) {
        super(id, isim, yazar, ItemType.MAGAZINE.name(), fiyat);
        this.type = type;
    }
    public void setIsim(String isim) {
        this.isim = isim;
    }

    public MagazineType getType() {
        return type;
    }

    public void setType(MagazineType type) {
        this.type = type;
    }
}
