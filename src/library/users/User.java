package library.users;

import library.items.Item;

import java.util.ArrayList;
import java.util.List;

public abstract class User {
    protected String id;
    protected String isim;
    protected String telefonNumarası;
    protected List<Item> aldığıKitaplar;

    public User(String id, String isim, String telefonNumarası) {
        this.id = id;
        this.isim = isim;
        this.telefonNumarası = telefonNumarası;
        this.aldığıKitaplar = new ArrayList<>();
    }

    public void kitapAl(Item item) {
        if (aldığıKitaplar.size() < 5) {
            aldığıKitaplar.add(item);
            item.setÖdünçAlınmaDurumu(true);
            System.out.println(isim + " " + item.getIsim() + " kitabını ödünç aldı.");
        } else {
            System.out.println("5 kitap limitine ulaşıldı.");
        }
    }

    public void kitapİadeEt(Item item) {
        if (aldığıKitaplar.contains(item)) {
            aldığıKitaplar.remove(item);
            item.setÖdünçAlınmaDurumu(false);
            System.out.println(isim + " " + item.getIsim() + " kitabını iade etti.");
        } else {
            System.out.println("Bu kitap bu kullanıcıda değil.");
        }
    }

    public String getId() {
        return id;
    }

    public String getIsim() {
        return isim;
    }

    public String getTelefonNumarası() {
        return telefonNumarası;
    }

    public List<Item> getAldığıKitaplar() {
        return aldığıKitaplar;
    }
}
