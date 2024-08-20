package library.items;

public class Book extends Item {
    private BookGenre genre;

    public Book(String id, String isim, String yazar, BookGenre genre, int fiyat) {
        super(id, isim, yazar, ItemType.BOOK.name(), fiyat); // Burada super çağrısı düzenlendi
        this.genre = genre;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }
    public void setYazar(String yazar) {
        this.yazar = yazar;
    }

    public void setGenre(BookGenre genre) {
        this.genre = genre;
    }
    @Override
    public String toString() {
        return "Book{" +
                "genre=" + genre +
                ", " + super.toString() +
                '}';
    }
}
