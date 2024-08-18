package library.collections;

import library.items.Book;
import library.items.BookGenre;

import java.util.ArrayList;
import java.util.List;

public class BookCollection {
    private List<Book> books;

    public BookCollection() {
        this.books = new ArrayList<>();
        initializeBooks();
    }

    private void initializeBooks() {
        books.add(new Book("B1", "Körlük", "Jose Saramago", BookGenre.SCIENCE_FICTION));
        books.add(new Book("B2", "1984", "George Orwell", BookGenre.SCIENCE_FICTION));
        books.add(new Book("B3", "Suç ve Ceza", "Fyodor Dostoyevski", BookGenre.CLASSIC));
        books.add(new Book("B4", "Sefiller", "Victor Hugo", BookGenre.CLASSIC));
        books.add(new Book("B5", "Yüzyıllık Yalnızlık", "Gabriel Garcia Marquez", BookGenre.CLASSIC));
        books.add(new Book("B6", "Hayvan Çiftliği", "George Orwell", BookGenre.CLASSIC));
        books.add(new Book("B7", "Uğultulu Tepeler", "Emily Bronte", BookGenre.CLASSIC));
        books.add(new Book("B8", "Madam Bovary", "Gustave Flaubert", BookGenre.CLASSIC));
        books.add(new Book("B9", "Don Kişot", "Miguel de Cervantes", BookGenre.CLASSIC));
        books.add(new Book("B10", "Anna Karenina", "Lev Tolstoy", BookGenre.CLASSIC));
    }

    public List<Book> getBooks() {
        return books;
    }
}
