package library;

import library.collections.BookCollection;
import library.collections.MagazineCollection;
import library.collections.NewspaperCollection;
import library.collections.UserCollection;
import library.items.Item;
import library.users.NormalUser;

import java.util.Map;
import java.util.TreeMap;

public class Library {
    private Map<String, Item> itemMap;
    private Map<String, NormalUser> userMap;

    public Library() {
        this.itemMap = new TreeMap<>();
        this.userMap = new TreeMap<>();
    }

    public void loadInitialData() {
        BookCollection bookCollection = new BookCollection();
        MagazineCollection magazineCollection = new MagazineCollection();
        NewspaperCollection newspaperCollection = new NewspaperCollection();
        UserCollection userCollection = new UserCollection();

        bookCollection.getBooks().forEach((id, book) -> itemMap.put(id, book));
        magazineCollection.getMagazines().forEach((id, magazine) -> itemMap.put(id, magazine));
        newspaperCollection.getNewspapers().forEach((id, newspaper) -> itemMap.put(id, newspaper));
        userCollection.getUsers().forEach((id, user) -> userMap.put(id, user));
    }

    public Map<String, Item> getItemMap() {
        return itemMap;
    }

    public Map<String, NormalUser> getUserMap() {
        return userMap;
    }
}
