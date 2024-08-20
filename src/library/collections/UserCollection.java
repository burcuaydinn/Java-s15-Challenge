package library.collections;

import library.users.NormalUser;

import java.util.HashMap;
import java.util.Map;

public class UserCollection {
    private Map<String, NormalUser> users;

    public UserCollection() {
        this.users = new HashMap<>();
        initializeUsers();
    }

    private void initializeUsers() {
        users.put("U1", new NormalUser("U1", "Ali Veli", "05320000001"));
        users.put("U2", new NormalUser("U2", "Ayşe Yılmaz", "05320000002"));
        users.put("U3", new NormalUser("U3", "Mehmet Demir", "05320000003"));
        users.put("U4", new NormalUser("U4", "Fatma Kaya", "05320000004"));
        users.put("U5", new NormalUser("U5", "Hasan Can", "05320000005"));
        users.put("U6", new NormalUser("U6", "Zeynep Er", "05320000006"));
        users.put("U7", new NormalUser("U7", "Ahmet Gül", "05320000007"));
        users.put("U8", new NormalUser("U8", "Emine Şen", "05320000008"));
        users.put("U9", new NormalUser("U9", "Yusuf Öz", "05320000009"));
        users.put("U10", new NormalUser("U10", "Cemre Taş", "05320000010"));
    }

    public Map<String, NormalUser> getUsers() {
        return users;
    }
}