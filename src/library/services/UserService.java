package library.services;

import library.Library;
import library.users.NormalUser;

public class UserService {

    private Library library;

    public UserService(Library library) {
        this.library = library;
    }

    public void addUser(NormalUser user) {
        library.getUserMap().put(user.getId(), user);
        System.out.println(user.getIsim() + " kütüphaneye üye olarak eklendi.");
    }

    public void deleteUser(String userId) {
        NormalUser removedUser = library.getUserMap().remove(userId);
        if (removedUser != null) {
            System.out.println(removedUser.getIsim() + " kütüphaneden silindi.");
        } else {
            System.out.println("Üye bulunamadı.");
        }
    }

    public void updateUser(NormalUser user) {
        if (library.getUserMap().containsKey(user.getId())) {
            library.getUserMap().put(user.getId(), user);
            System.out.println(user.getIsim() + " güncellendi.");
        } else {
            System.out.println("Üye bulunamadı.");
        }
    }

    public void viewUsers() {
        library.getUserMap().values().forEach(user -> System.out.println("ID: " + user.getId() + ", İsim: " + user.getIsim() + ", Telefon: " + user.getTelefonNumarası()));
    }
}
