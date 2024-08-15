package library.models;

import library.utils.Genre;

public class Newspaper extends Item {
    private String additionalInfo;

    public Newspaper(String id, String title, Genre genre, String additionalInfo) {
        super(id, title, genre);
        this.additionalInfo = additionalInfo;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    @Override
    public String toString() {
        return super.toString() + ", additionalInfo='" + additionalInfo + '\'';
    }
}
