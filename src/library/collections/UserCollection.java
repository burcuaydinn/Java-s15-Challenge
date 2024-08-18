package library.collections;

import library.users.NormalUser;

import java.util.ArrayList;
import java.util.List;

public class UserCollection {
    private List<NormalUser> users;

    public UserCollection() {
        this.users = new ArrayList<>();
        initializeUsers();
    }

    private void initializeUsers() {
        users.add(new NormalUser("U1", "Ali Veli", "05320000001"));
        users.add(new NormalUser("U2", "Ayşe Yılmaz", "05320000002"));
        users.add(new NormalUser("U3", "Mehmet Demir", "05320000003"));
        users.add(new NormalUser("U4", "Fatma Kaya", "05320000004"));
        users.add(new NormalUser("U5", "Hasan Can", "05320000005"));
        users.add(new NormalUser("U6", "Zeynep Er", "05320000006"));
        users.add(new NormalUser("U7", "Ahmet Gül", "05320000007"));
        users.add(new NormalUser("U8", "Emine Şen", "05320000008"));
        users.add(new NormalUser("U9", "Yusuf Öz", "05320000009"));
        users.add(new NormalUser("U10", "Cemre Taş", "05320000010"));
    }

    public List<NormalUser> getUsers() {
        return users;
    }
}
