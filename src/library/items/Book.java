package library.items;

public class Book extends Item {
    private BookGenre genre;

    public Book(String id, String isim, String yazar, BookGenre genre) {
        super(id, isim, yazar, ItemType.BOOK.name());
        this.genre = genre;
    }

    public BookGenre getGenre() {
        return genre;
    }

    public void setGenre(BookGenre genre) {
        this.genre = genre;
    }


}
