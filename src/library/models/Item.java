package library.models;

import library.utils.Genre;

public abstract class Item {
    private String id;
    private String title;
    private Genre genre;

    public Item(String id, String title, Genre genre) {
        this.id = id;
        this.title = title;
        this.genre = genre;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Genre getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", genre=" + genre +
                '}';
    }
}
