package library.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private Map<String, Item> items;  // Kitaplar, dergiler ve gazeteler
    private Map<User, List<Item>> borrowedItems;  // Kullanıcı ve ödünç alınan öğeler

    public Library() {
        this.items = new HashMap<>();
        this.borrowedItems = new HashMap<>();
    }

    // Öğeleri ekle
    public void addItem(Item item) {
        items.put(item.getId(), item);
        System.out.println(item.getTitle() + " kütüphaneye eklendi.");
    }

    // Öğeleri sil
    public void removeItem(String id) {
        Item removedItem = items.remove(id);
        if (removedItem != null) {
            System.out.println(removedItem.getTitle() + " kütüphaneden silindi.");
        } else {
            System.out.println("Bu ID'ye sahip bir item bulunamadı.");
        }
    }

    // Öğeleri ID ile bul
    public Item findItemById(String id) {
        return items.get(id);
    }

    // Tüm öğeleri listele
    public void listAllItems() {
        for (Item item : items.values()) {
            System.out.println(item);
        }
    }

    // Öğeleri ödünç al
    public void borrowItem(User user, Item item) {
        if (items.containsKey(item.getId())) {
            borrowedItems.computeIfAbsent(user, k -> new java.util.ArrayList<>()).add(item);
            System.out.println(user.getName() + " " + item.getTitle() + " kitabını ödünç aldı.");
        } else {
            System.out.println("Bu ID'ye sahip bir item bulunamadı.");
        }
    }

    // Öğeleri geri ver
    public void returnItem(User user, Item item) {
        List<Item> userItems = borrowedItems.get(user);
        if (userItems != null && userItems.remove(item)) {
            System.out.println(user.getName() + " " + item.getTitle() + " kitabını geri verdi.");
            if (userItems.isEmpty()) {
                borrowedItems.remove(user);
            }
        } else {
            System.out.println("Kullanıcının ödünç aldığı bu item bulunamadı.");
        }
    }

    // Ödünç alınan öğeleri görüntüle
    public void viewLoanedItems() {
        if (borrowedItems.isEmpty()) {
            System.out.println("Ödünç alınan öğe bulunmuyor.");
            return;
        }
        for (Map.Entry<User, List<Item>> entry : borrowedItems.entrySet()) {
            User user = entry.getKey();
            List<Item> items = entry.getValue();
            System.out.println("Kullanıcı: " + user.getName() + " " + user.getSurname());
            for (Item item : items) {
                System.out.println(item);
            }
        }
    }
}
