package library.items;

public class Newspaper extends Item {
    private NewspaperType type;

    public Newspaper(String id, String isim, String yazar, NewspaperType type) {
        super(id, isim, yazar, ItemType.NEWSPAPER.name());
        this.type = type;
    }

    public NewspaperType getType() {
        return type;
    }

    public void setType(NewspaperType type) {
        this.type = type;
    }
}
