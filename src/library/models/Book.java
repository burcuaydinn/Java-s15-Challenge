package library.models;

import library.utils.Genre;

public class Book extends Item {
    private Author author;
    private String additionalInfo;

    public Book(String id, String title, Genre genre, Author author, String additionalInfo) {
        super(id, title, genre);
        this.author = author;
        this.additionalInfo = additionalInfo;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return super.toString() + ", author=" + author + ", additionalInfo='" + additionalInfo + '\'';
    }
}
