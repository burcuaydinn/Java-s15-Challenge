package library.collections;

import library.items.Magazine;
import library.items.MagazineType;

import java.util.ArrayList;
import java.util.List;

public class MagazineCollection {
    private List<Magazine> magazines;

    public MagazineCollection() {
        this.magazines = new ArrayList<>();
        initializeMagazines();
    }

    private void initializeMagazines() {
        magazines.add(new Magazine("M1", "National Geographic", "National Geographic Partners", MagazineType.FASHION));
        magazines.add(new Magazine("M2", "Time", "Time USA, LLC", MagazineType.FASHION));
        magazines.add(new Magazine("M3", "The Economist", "The Economist Group", MagazineType.FASHION));
        magazines.add(new Magazine("M4", "Vogue", "Condé Nast", MagazineType.FASHION));
        magazines.add(new Magazine("M5", "Scientific American", "Springer Nature", MagazineType.FASHION));
        magazines.add(new Magazine("M6", "Wired", "Condé Nast", MagazineType.FASHION));
        magazines.add(new Magazine("M7", "Forbes", "Forbes Media", MagazineType.FASHION));
        magazines.add(new Magazine("M8", "People", "Meredith Corporation", MagazineType.FASHION));
        magazines.add(new Magazine("M9", "Vanity Fair", "Condé Nast", MagazineType.FASHION));
        magazines.add(new Magazine("M10", "New Yorker", "Condé Nast", MagazineType.FASHION));
    }

    public List<Magazine> getMagazines() {
        return magazines;
    }
}
