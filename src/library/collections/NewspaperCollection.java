package library.collections;

import library.items.Newspaper;
import library.items.NewspaperType;

import java.util.ArrayList;
import java.util.List;

public class NewspaperCollection {
    private List<Newspaper> newspapers;

    public NewspaperCollection() {
        this.newspapers = new ArrayList<>();
        initializeNewspapers();
    }

    private void initializeNewspapers() {
        newspapers.add(new Newspaper("N1", "The New York Times", "NY Times Co.", NewspaperType.DAILY));
        newspapers.add(new Newspaper("N2", "Le Monde", "Le Monde Group", NewspaperType.DAILY));
        newspapers.add(new Newspaper("N3", "The Guardian", "Guardian News & Media", NewspaperType.DAILY));
        newspapers.add(new Newspaper("N4", "Frankfurter Allgemeine", "FAZ", NewspaperType.DAILY));
        newspapers.add(new Newspaper("N5", "El País", "PRISA", NewspaperType.DAILY));
        newspapers.add(new Newspaper("N6", "Corriere della Sera", "RCS MediaGroup", NewspaperType.DAILY));
        newspapers.add(new Newspaper("N7", "Asahi Shimbun", "The Asahi Shimbun Company", NewspaperType.DAILY));
        newspapers.add(new Newspaper("N8", "China Daily", "China Daily Group", NewspaperType.DAILY));
        newspapers.add(new Newspaper("N9", "The Sydney Morning Herald", "Nine Entertainment", NewspaperType.DAILY));
        newspapers.add(new Newspaper("N10", "The Washington Post", "Nash Holdings", NewspaperType.DAILY));
    }

    public List<Newspaper> getNewspapers() {
        return newspapers;
    }
}
