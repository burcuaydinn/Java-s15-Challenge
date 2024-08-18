package library;

import library.collections.BookCollection;
import library.collections.MagazineCollection;
import library.collections.NewspaperCollection;
import library.collections.UserCollection;
import library.items.Item;
import library.users.NormalUser;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<String, Item> itemMap;
    private Map<String, NormalUser> userMap;

    public Library() {
        this.itemMap = new HashMap<>();
        this.userMap = new HashMap<>();
    }

    public void loadInitialData() {
        BookCollection bookCollection = new BookCollection();
        MagazineCollection magazineCollection = new MagazineCollection();
        NewspaperCollection newspaperCollection = new NewspaperCollection();
        UserCollection userCollection = new UserCollection();

        bookCollection.getBooks().forEach(book -> itemMap.put(book.getId(), book));
        magazineCollection.getMagazines().forEach(magazine -> itemMap.put(magazine.getId(), magazine));
        newspaperCollection.getNewspapers().forEach(newspaper -> itemMap.put(newspaper.getId(), newspaper));
        userCollection.getUsers().forEach(user -> userMap.put(user.getId(), user));
    }

    public Map<String, Item> getItemMap() {
        return itemMap;
    }

    public Map<String, NormalUser> getUserMap() {
        return userMap;
    }
}
