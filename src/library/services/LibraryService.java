package library.services;

import library.Library;
import library.items.Book;
import library.items.Item;
import library.items.Magazine;


import java.util.List;

public class LibraryService {

    private Library library;

    public LibraryService(Library library) {
        this.library = library;
    }

    public void addItem(Item item) {
        library.getItemMap().put(item.getId(), item);
        System.out.println(item.getIsim() + " kütüphaneye eklendi.");
    }

    public void deleteItem(String itemId) {
        Item removedItem = library.getItemMap().remove(itemId);
        if (removedItem != null) {
            System.out.println(removedItem.getIsim() + " kütüphaneden silindi.");
        } else {
            System.out.println("Item bulunamadı.");
        }
    }

    public void updateItem(Item item) {
        if (library.getItemMap().containsKey(item.getId())) {
            library.getItemMap().put(item.getId(), item);
            System.out.println(item.getIsim() + " güncellendi.");
        } else {
            System.out.println("Item bulunamadı.");
        }
    }

    public void searchByAuthor(String author) {
        List<Item> foundItems = library.getItemMap().values().stream()
                .filter(item -> item.getYazar() != null && item.getYazar().equalsIgnoreCase(author))
                .toList();
        if (foundItems.isEmpty()) {
            System.out.println("Bu yazara ait item bulunamadı.");
        } else {
            foundItems.forEach(item -> System.out.println("ID: " + item.getId() + ", İsim: " + item.getIsim() + ", Yazar: " + item.getYazar()));
        }
    }
}