package library.collections;

import library.items.Book;
import library.items.BookGenre;

import java.util.HashMap;
import java.util.Map;

public class BookCollection {
    private Map<String, Book> books;

    public BookCollection() {
        this.books = new HashMap<>();
        initializeBooks();
    }

    private void initializeBooks() {
        books.put("B1", new Book("B1", "Körlük", "Jose Saramago", BookGenre.SCIENCE_FICTION, 50));
        books.put("B2", new Book("B2", "1984", "George Orwell", BookGenre.SCIENCE_FICTION, 45));
        books.put("B3", new Book("B3", "Suç ve Ceza", "Fyodor Dostoyevski", BookGenre.CLASSIC, 40));
        books.put("B4", new Book("B4", "Sefiller", "Victor Hugo", BookGenre.CLASSIC, 55));
        books.put("B5", new Book("B5", "Yüzyıllık Yalnızlık", "Gabriel Garcia Marquez", BookGenre.CLASSIC, 60));
        books.put("B6", new Book("B6", "Hayvan Çiftliği", "George Orwell", BookGenre.CLASSIC, 30));
        books.put("B7", new Book("B7", "Uğultulu Tepeler", "Emily Bronte", BookGenre.CLASSIC, 50));
        books.put("B8", new Book("B8", "Madam Bovary", "Gustave Flaubert", BookGenre.CLASSIC, 45));
        books.put("B9", new Book("B9", "Don Kişot", "Miguel de Cervantes", BookGenre.CLASSIC, 70));
        books.put("B10", new Book("B10", "Anna Karenina", "Lev Tolstoy", BookGenre.CLASSIC, 65));
    }

    public Map<String, Book> getBooks() {
        return books;
    }
}