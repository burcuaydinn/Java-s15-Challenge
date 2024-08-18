package library.items;

public class Magazine extends Item {
    private MagazineType type;

    public Magazine(String id, String isim, String yazar, MagazineType type) {
        super(id, isim, yazar, ItemType.MAGAZINE.name());
        this.type = type;
    }

    public MagazineType getType() {
        return type;
    }

    public void setType(MagazineType type) {
        this.type = type;
    }
}
