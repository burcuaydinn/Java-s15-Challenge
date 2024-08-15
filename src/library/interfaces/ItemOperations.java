package library.interfaces;

import library.models.Item;

public interface ItemOperations {
    void addItem(Item item);
    void removeItem(String id);
    Item findItemById(String id);
    void listAllItems();
}
