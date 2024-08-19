package library.items;

public class Newspaper extends Item {
    private NewspaperType type;

    public Newspaper(String id, String isim, String yazar, NewspaperType type ,int fiyat) {
        super(id, isim, yazar, ItemType.NEWSPAPER.name() ,fiyat);
        this.type = type;

    }
    public void setIsim(String isim) {
        this.isim = isim;
    }

    public NewspaperType getType() {
        return type;
    }

    public void setType(NewspaperType type) {
        this.type = type;
    }
}
