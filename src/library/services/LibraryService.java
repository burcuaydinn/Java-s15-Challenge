package library.services;

import library.Library;
import library.items.Book;
import library.items.Item;
import library.items.Magazine;
import library.items.Newspaper;

import java.util.List;

public class LibraryService {

    private Library library;

    public LibraryService(Library library) {
        this.library = library;
    }
   /* public void addItem(Book book) {
        library.getItemMap().put(book.getId(), book);
        System.out.println(book.getIsim() + " kütüphaneye eklendi.");
    }

    // Overloaded method for adding a magazine
    public void addItem(Magazine magazine) {
        library.getItemMap().put(magazine.getId(), magazine);
        System.out.println(magazine.getIsim() + " kütüphaneye eklendi.");
    }

    // Overloaded method for adding a newspaper
    public void addItem(Newspaper newspaper) {
        library.getItemMap().put(newspaper.getId(), newspaper);
        System.out.println(newspaper.getIsim() + " kütüphaneye eklendi.");
    }*/

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
