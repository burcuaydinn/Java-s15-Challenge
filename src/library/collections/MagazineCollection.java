package library.collections;

import library.items.Magazine;
import library.items.MagazineType;

import java.util.HashMap;
import java.util.Map;

public class MagazineCollection {
    private Map<String, Magazine> magazines;

    public MagazineCollection() {
        this.magazines = new HashMap<>();
        initializeMagazines();
    }

    private void initializeMagazines() {
        magazines.put("M1", new Magazine("M1", "National Geographic", "National Geographic Partners", MagazineType.FASHION, 20));
        magazines.put("M2", new Magazine("M2", "Time", "Time USA, LLC", MagazineType.FASHION, 25));
        magazines.put("M3", new Magazine("M3", "The Economist", "The Economist Group", MagazineType.FASHION, 30));
        magazines.put("M4", new Magazine("M4", "Vogue", "Condé Nast", MagazineType.FASHION, 40));
        magazines.put("M5", new Magazine("M5", "Scientific American", "Springer Nature", MagazineType.FASHION, 35));
        magazines.put("M6", new Magazine("M6", "Wired", "Condé Nast", MagazineType.FASHION, 25));
        magazines.put("M7", new Magazine("M7", "Forbes", "Forbes Media", MagazineType.FASHION, 30));
        magazines.put("M8", new Magazine("M8", "People", "Meredith Corporation", MagazineType.FASHION, 20));
        magazines.put("M9", new Magazine("M9", "Vanity Fair", "Condé Nast", MagazineType.FASHION, 30));
        magazines.put("M10", new Magazine("M10", "New Yorker", "Condé Nast", MagazineType.FASHION, 35));
    }

    public Map<String, Magazine> getMagazines() {
        return magazines;
    }
}