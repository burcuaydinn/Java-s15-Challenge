package library.models;

import library.interfaces.ItemOperations;
import library.utils.Genre;

import java.util.HashMap;
import java.util.Map;

public class Librarian extends User implements ItemOperations {
    private Map<String, Item> items;

    public Librarian(String name, String surname, String phoneNumber) {
        super(name, surname, phoneNumber);
        this.items = new HashMap<>();
    }

    @Override
    public void addItem(Item item) {
        items.put(item.getId(), item);
        System.out.println(item.getTitle() + " kütüphaneye eklendi.");
    }

    @Override
    public void removeItem(String id) {
        Item removedItem = items.remove(id);
        if (removedItem != null) {
            System.out.println(removedItem.getTitle() + " kütüphaneden silindi.");
        } else {
            System.out.println("Bu ID'ye sahip bir item bulunamadı.");
        }
    }

    @Override
    public Item findItemById(String id) {
        return items.get(id);
    }

    @Override
    public void listAllItems() {
        for (Item item : items.values()) {
            System.out.println(item);
        }
    }

    // Kitap/Dergi/Gazete güncelleme
    public void updateItem(String id, String newTitle, String newAuthor, Genre newGenre, String newAdditionalInfo) {
        Item itemToUpdate = items.get(id);

        if (itemToUpdate != null) {
            items.remove(id);

            // Güncellenmiş öğeyi oluşturuyoruz
            Item updatedItem;
            Author author = new Author(newAuthor.split(" ")[0], newAuthor.split(" ")[1]);
            if (itemToUpdate instanceof Book) {
                updatedItem = new Book(id, newTitle, newGenre, author, newAdditionalInfo);
            } else if (itemToUpdate instanceof Magazine) {
                updatedItem = new Magazine(id, newTitle, newGenre, newAdditionalInfo);
            } else if (itemToUpdate instanceof Newspaper) {
                updatedItem = new Newspaper(id, newTitle, newGenre, newAdditionalInfo);
            } else {
                System.out.println("Güncellenmiş tür desteklenmiyor.");
                return;
            }
            items.put(updatedItem.getId(), updatedItem);
            System.out.println("Kitap/Dergi/Gazete güncellendi.");
        } else {
            System.out.println("Kitap/Dergi/Gazete bulunamadı.");
        }
    }
}
