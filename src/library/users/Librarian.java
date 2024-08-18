package library.users;

import library.Library;
import library.items.Item;

public class Librarian extends User {
    public Librarian(String id, String isim, String telefonNumarası) {
        super(id, isim, telefonNumarası);
    }

    public void kitapEkle(Library library, Item item) {
        library.getItemMap().put(item.getId(), item);
        System.out.println(item.getIsim() + " kütüphaneye eklendi.");
    }

    public void kitapSil(Library library, Item item) {
        library.getItemMap().remove(item.getId());
        System.out.println(item.getIsim() + " kütüphaneden silindi.");
    }

    public void kitapGüncelle(Library library, Item eskiItem, Item yeniItem) {
        if (library.getItemMap().containsKey(eskiItem.getId())) {
            library.getItemMap().put(yeniItem.getId(), yeniItem);
            System.out.println(eskiItem.getIsim() + " güncellendi.");
        } else {
            System.out.println("Kitap bulunamadı.");
        }
    }
}
