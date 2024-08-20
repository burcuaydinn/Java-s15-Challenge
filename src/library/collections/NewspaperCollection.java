package library.collections;

import library.items.Newspaper;
import library.items.NewspaperType;

import java.util.HashMap;
import java.util.Map;

public class NewspaperCollection {
    private Map<String, Newspaper> newspapers;

    public NewspaperCollection() {
        this.newspapers = new HashMap<>();
        initializeNewspapers();
    }

    private void initializeNewspapers() {
        newspapers.put("N1", new Newspaper("N1", "The New York Times", "NY Times Co.", NewspaperType.DAILY, 5));
        newspapers.put("N2", new Newspaper("N2", "Le Monde", "Le Monde Group", NewspaperType.DAILY, 5));
        newspapers.put("N3", new Newspaper("N3", "The Guardian", "Guardian News & Media", NewspaperType.DAILY, 5));
        newspapers.put("N4", new Newspaper("N4", "Frankfurter Allgemeine", "FAZ", NewspaperType.DAILY, 5));
        newspapers.put("N5", new Newspaper("N5", "El País", "PRISA", NewspaperType.DAILY, 5));
        newspapers.put("N6", new Newspaper("N6", "Corriere della Sera", "RCS MediaGroup", NewspaperType.DAILY, 5));
        newspapers.put("N7", new Newspaper("N7", "Asahi Shimbun", "The Asahi Shimbun Company", NewspaperType.DAILY, 5));
        newspapers.put("N8", new Newspaper("N8", "China Daily", "China Daily Group", NewspaperType.DAILY, 5));
        newspapers.put("N9", new Newspaper("N9", "The Sydney Morning Herald", "Nine Entertainment", NewspaperType.DAILY, 5));
        newspapers.put("N10", new Newspaper("N10", "The Washington Post", "Nash Holdings", NewspaperType.DAILY, 5));
    }

    public Map<String, Newspaper> getNewspapers() {
        return newspapers;
    }
}