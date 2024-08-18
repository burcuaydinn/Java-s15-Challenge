package library;

import library.collections.BookCollection;
import library.collections.MagazineCollection;
import library.collections.NewspaperCollection;
import library.collections.UserCollection;
import library.items.*;
import library.services.LoanService;
import library.users.Librarian;
import library.users.NormalUser;

import java.util.Scanner;

public class LoginController {

    private Library library;
    private LoanService loanService;
    private BookCollection bookCollection;
    private MagazineCollection magazineCollection;
    private NewspaperCollection newspaperCollection;
    private UserCollection userCollection;

    public LoginController(Library library) {
        this.library = library;
        this.library.loadInitialData();
        this.loanService = new LoanService(library);
        this.bookCollection = new BookCollection();
        this.magazineCollection = new MagazineCollection();
        this.newspaperCollection = new NewspaperCollection();
        this.userCollection = new UserCollection();
    }

    public void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Librarian");
        System.out.println("2. Normal User");
        System.out.print("Seçiminizi yapın: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Satır sonu karakterini temizlemek için

        switch (choice) {
            case 1:
                librarianLogin(scanner);
                break;
            case 2:
                normalUserLogin(scanner);
                break;
            default:
                System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
                login();
                break;
        }
    }

    private void librarianLogin(Scanner scanner) {
        System.out.print("İsim: ");
        String isim = scanner.nextLine();
        System.out.print("Telefon Numarası: ");
        String telefonNumarası = scanner.nextLine();

        if (isim.equals("Burcu Aydın") && telefonNumarası.equals("05320000000")) {
            Librarian librarian = new Librarian("1", isim, telefonNumarası);
            librarianMenu(scanner, librarian);
        } else {
            System.out.println("Yanlış bilgi girdiniz. Lütfen tekrar deneyin.");
            librarianLogin(scanner);
        }
    }

    private void normalUserLogin(Scanner scanner) {
        System.out.print("İsim: ");
        String isim = scanner.nextLine();
        System.out.print("Telefon Numarası: ");
        String telefonNumarası = scanner.nextLine();

        for (NormalUser user : library.getUserMap().values()) {
            if (user.getIsim().equals(isim) && user.getTelefonNumarası().equals(telefonNumarası)) {
                normalUserMenu(scanner, user);
                return;
            }
        }
        System.out.println("Kullanıcı bulunamadı. Lütfen tekrar deneyin.");
        normalUserLogin(scanner);
    }

    private void normalUserMenu(Scanner scanner, NormalUser user) {
        while (true) {
            System.out.println("Normal User Menü:");
            System.out.println("1. Kitap/Dergi/Gazete Görüntüle");
            System.out.println("2. Kitap/Dergi/Gazete Ödünç Al");
            System.out.println("3. Kitap/Dergi/Gazete İade Et");
            System.out.println("4. Ceza Durumu Görüntüle");
            System.out.println("5. Ana Menüye Dön");
            System.out.println("6. Çıkış");
            System.out.print("Seçiminizi yapın: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewItems(scanner);
                    break;
                case 2:
                    loanItemMenu(scanner, user);
                    break;
                case 3:
                    returnItemMenu(scanner, user);
                    break;
                case 4:
                    System.out.println("Ceza durumu: " + (loanService.userHasReachedLimit(user.getId()) ? "5 kitap limitine ulaşıldı." : "Ceza yok."));
                    break;
                case 5:
                    login();
                    return;
                case 6:
                    System.out.println("Çıkış yapılıyor.");
                    return;
                default:
                    System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
                    break;
            }
        }
    }

    private void loanItemMenu(Scanner scanner, NormalUser user) {
        System.out.println("1. Kitap Ödünç Al");
        System.out.println("2. Dergi Ödünç Al");
        System.out.println("3. Gazete Ödünç Al");
        System.out.print("Seçiminizi yapın: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                bookCollection.getBooks().forEach(book -> System.out.println("ID: " + book.getId() + ", İsim: " + book.getIsim() + ", Yazar: " + book.getYazar() + ", Tür: " + book.getGenre() + (book.isÖdünçAlınmaDurumu() ? " - Ödünç Alındı" : "")));
                System.out.print("Ödünç almak istediğiniz kitabın ID'sini girin: ");
                String bookId = scanner.nextLine();
                loanService.loanItem(user, bookId);
                break;
            case 2:
                magazineCollection.getMagazines().forEach(magazine -> System.out.println("ID: " + magazine.getId() + ", İsim: " + magazine.getIsim() + ", Tür: " + magazine.getType() + (magazine.isÖdünçAlınmaDurumu() ? " - Ödünç Alındı" : "")));
                System.out.print("Ödünç almak istediğiniz derginin ID'sini girin: ");
                String magazineId = scanner.nextLine();
                loanService.loanItem(user, magazineId);
                break;
            case 3:
                newspaperCollection.getNewspapers().forEach(newspaper -> System.out.println("ID: " + newspaper.getId() + ", İsim: " + newspaper.getIsim() + ", Tür: " + newspaper.getType() + (newspaper.isÖdünçAlınmaDurumu() ? " - Ödünç Alındı" : "")));
                System.out.print("Ödünç almak istediğiniz gazetenin ID'sini girin: ");
                String newspaperId = scanner.nextLine();
                loanService.loanItem(user, newspaperId);
                break;
            default:
                System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
                loanItemMenu(scanner, user);
                break;
        }
    }

    private void returnItemMenu(Scanner scanner, NormalUser user) {
        System.out.println("1. Kitap İade Et");
        System.out.println("2. Dergi İade Et");
        System.out.println("3. Gazete İade Et");
        System.out.print("Seçiminizi yapın: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                bookCollection.getBooks().forEach(book -> System.out.println("ID: " + book.getId() + ", İsim: " + book.getIsim() + ", Yazar: " + book.getYazar() + (book.isÖdünçAlınmaDurumu() ? " - Ödünç Alındı" : "")));
                System.out.print("İade etmek istediğiniz kitabın ID'sini girin: ");
                String bookId = scanner.nextLine();
                loanService.returnItem(user, bookId);
                break;
            case 2:
                magazineCollection.getMagazines().forEach(magazine -> System.out.println("ID: " + magazine.getId() + ", İsim: " + magazine.getIsim() + ", Tür: " + magazine.getType() + (magazine.isÖdünçAlınmaDurumu() ? " - Ödünç Alındı" : "")));
                System.out.print("İade etmek istediğiniz derginin ID'sini girin: ");
                String magazineId = scanner.nextLine();
                loanService.returnItem(user, magazineId);
                break;
            case 3:
                newspaperCollection.getNewspapers().forEach(newspaper -> System.out.println("ID: " + newspaper.getId() + ", İsim: " + newspaper.getIsim() + ", Tür: " + newspaper.getType() + (newspaper.isÖdünçAlınmaDurumu() ? " - Ödünç Alındı" : "")));
                System.out.print("İade etmek istediğiniz gazetenin ID'sini girin: ");
                String newspaperId = scanner.nextLine();
                loanService.returnItem(user, newspaperId);
                break;
            default:
                System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
                returnItemMenu(scanner, user);
                break;
        }
    }

    private void librarianMenu(Scanner scanner, Librarian librarian) {
        while (true) {
            System.out.println("Librarian Menü:");
            System.out.println("1. Kitap/Dergi/Gazete Ekle");
            System.out.println("2. Kitap/Dergi/Gazete Sil");
            System.out.println("3. Kitap/Dergi/Gazete Güncelle");
            System.out.println("4. Üye Ekle/Sil/Güncelle");
            System.out.println("5. Kitap/Dergi/Gazete Görüntüle");
            System.out.println("6. Üye Görüntüle");
            System.out.println("7. Ana Menüye Dön");
            System.out.println("8. Çıkış");
            System.out.print("Seçiminizi yapın: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addItem(scanner);
                    break;
                case 2:
                    deleteItem(scanner);
                    break;
                case 3:
                    updateItem(scanner);
                    break;
                case 4:
                    manageUsers(scanner);
                    break;
                case 5:
                    viewItems(scanner);
                    break;
                case 6:
                    viewUsers();
                    break;
                case 7:
                    login();
                    return;
                case 8:
                    System.out.println("Çıkış yapılıyor.");
                    return;
                default:
                    System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
                    break;
            }
        }
    }

    private void addItem(Scanner scanner) {
        System.out.println("1. Kitap Ekle");
        System.out.println("2. Dergi Ekle");
        System.out.println("3. Gazete Ekle");
        System.out.print("Seçiminizi yapın: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Kitap ID: ");
                String bookId = scanner.nextLine();
                System.out.print("Kitap İsmi: ");
                String bookName = scanner.nextLine();
                System.out.print("Yazar: ");
                String author = scanner.nextLine();
                System.out.print("Tür (CLASSIC, FANTASY, SCIENCE_FICTION, MYSTERY): ");
                BookGenre genre = BookGenre.valueOf(scanner.nextLine().toUpperCase());
                Book newBook = new Book(bookId, bookName, author, genre);
                bookCollection.getBooks().add(newBook);
                library.getItemMap().put(newBook.getId(), newBook);
                System.out.println("Kitap eklendi.");
                break;
            case 2:
                System.out.print("Dergi ID: ");
                String magazineId = scanner.nextLine();
                System.out.print("Dergi İsmi: ");
                String magazineName = scanner.nextLine();
                System.out.print("Tür (FASHION, TECHNOLOGY, SPORTS): ");
                MagazineType magazineType = MagazineType.valueOf(scanner.nextLine().toUpperCase());
                Magazine newMagazine = new Magazine(magazineId, magazineName,null, magazineType);
                magazineCollection.getMagazines().add(newMagazine);
                library.getItemMap().put(newMagazine.getId(), newMagazine);
                System.out.println("Dergi eklendi.");
                break;
            case 3:
                System.out.print("Gazete ID: ");
                String newspaperId = scanner.nextLine();
                System.out.print("Gazete İsmi: ");
                String newspaperName = scanner.nextLine();
                System.out.print("Tür (DAILY, WEEKLY, MONTHLY): ");
                NewspaperType newspaperType = NewspaperType.valueOf(scanner.nextLine().toUpperCase());
                Newspaper newNewspaper = new Newspaper(newspaperId, newspaperName, null, newspaperType);
                newspaperCollection.getNewspapers().add(newNewspaper);
                library.getItemMap().put(newNewspaper.getId(), newNewspaper);
                System.out.println("Gazete eklendi.");
                break;
            default:
                System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
                addItem(scanner);
                break;
        }
    }

    private void deleteItem(Scanner scanner) {
        System.out.println("1. Kitap Sil");
        System.out.println("2. Dergi Sil");
        System.out.println("3. Gazete Sil");
        System.out.print("Seçiminizi yapın: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Silinecek Kitap ID: ");
                String bookId = scanner.nextLine();
                bookCollection.getBooks().removeIf(book -> book.getId().equals(bookId));
                library.getItemMap().remove(bookId);
                System.out.println("Kitap silindi.");
                break;
            case 2:
                System.out.print("Silinecek Dergi ID: ");
                String magazineId = scanner.nextLine();
                magazineCollection.getMagazines().removeIf(magazine -> magazine.getId().equals(magazineId));
                library.getItemMap().remove(magazineId);
                System.out.println("Dergi silindi.");
                break;
            case 3:
                System.out.print("Silinecek Gazete ID: ");
                String newspaperId = scanner.nextLine();
                newspaperCollection.getNewspapers().removeIf(newspaper -> newspaper.getId().equals(newspaperId));
                library.getItemMap().remove(newspaperId);
                System.out.println("Gazete silindi.");
                break;
            default:
                System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
                deleteItem(scanner);
                break;
        }
    }

    private void updateItem(Scanner scanner) {
        System.out.println("1. Kitap Güncelle");
        System.out.println("2. Dergi Güncelle");
        System.out.println("3. Gazete Güncelle");
        System.out.print("Seçiminizi yapın: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Güncellenecek Kitap ID: ");
                String bookId = scanner.nextLine();
                Book bookToUpdate = (Book) library.getItemMap().get(bookId);
                if (bookToUpdate != null) {
                    System.out.print("Yeni Kitap İsmi: ");
                    String bookName = scanner.nextLine();
                    System.out.print("Yeni Yazar: ");
                    String author = scanner.nextLine();
                    System.out.print("Yeni Tür (CLASSIC, FANTASY, SCIENCE_FICTION, MYSTERY): ");
                    BookGenre genre = BookGenre.valueOf(scanner.nextLine().toUpperCase());
                    bookToUpdate.setIsim(bookName);
                    bookToUpdate.setYazar(author);
                    bookToUpdate.setGenre(genre);
                    System.out.println("Kitap güncellendi.");
                } else {
                    System.out.println("Kitap bulunamadı.");
                }
                break;
            case 2:
                System.out.print("Güncellenecek Dergi ID: ");
                String magazineId = scanner.nextLine();
                Magazine magazineToUpdate = (Magazine) library.getItemMap().get(magazineId);
                if (magazineToUpdate != null) {
                    System.out.print("Yeni Dergi İsmi: ");
                    String magazineName = scanner.nextLine();
                    System.out.print("Yeni Tür (FASHION, TECHNOLOGY, SPORTS): ");
                    MagazineType magazineType = MagazineType.valueOf(scanner.nextLine().toUpperCase());
                    magazineToUpdate.setIsim(magazineName);
                    magazineToUpdate.setType(magazineType);
                    System.out.println("Dergi güncellendi.");
                } else {
                    System.out.println("Dergi bulunamadı.");
                }
                break;
            case 3:
                System.out.print("Güncellenecek Gazete ID: ");
                String newspaperId = scanner.nextLine();
                Newspaper newspaperToUpdate = (Newspaper) library.getItemMap().get(newspaperId);
                if (newspaperToUpdate != null) {
                    System.out.print("Yeni Gazete İsmi: ");
                    String newspaperName = scanner.nextLine();
                    System.out.print("Yeni Tür (DAILY, WEEKLY, MONTHLY): ");
                    NewspaperType newspaperType = NewspaperType.valueOf(scanner.nextLine().toUpperCase());
                    newspaperToUpdate.setIsim(newspaperName);
                    newspaperToUpdate.setType(newspaperType);
                    System.out.println("Gazete güncellendi.");
                } else {
                    System.out.println("Gazete bulunamadı.");
                }
                break;
            default:
                System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
                updateItem(scanner);
                break;
        }
    }

    private void manageUsers(Scanner scanner) {
        System.out.println("1. Üye Ekle");
        System.out.println("2. Üye Sil");
        System.out.println("3. Üye Güncelle");
        System.out.print("Seçiminizi yapın: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Üye ID: ");
                String userId = scanner.nextLine();
                System.out.print("Üye İsmi: ");
                String userName = scanner.nextLine();
                System.out.print("Telefon Numarası: ");
                String phoneNumber = scanner.nextLine();
                NormalUser newUser = new NormalUser(userId, userName, phoneNumber);
                userCollection.getUsers().add(newUser);
                library.getUserMap().put(newUser.getId(), newUser);
                System.out.println("Üye eklendi.");
                break;
            case 2:
                System.out.print("Silinecek Üye ID: ");
                String userIdToDelete = scanner.nextLine();
                userCollection.getUsers().removeIf(user -> user.getId().equals(userIdToDelete));
                library.getUserMap().remove(userIdToDelete);
                System.out.println("Üye silindi.");
                break;
            case 3:
                System.out.print("Güncellenecek Üye ID: ");
                String userIdToUpdate = scanner.nextLine();
                NormalUser userToUpdate = library.getUserMap().get(userIdToUpdate);
                if (userToUpdate != null) {
                    System.out.print("Yeni Üye İsmi: ");
                    String userNameToUpdate = scanner.nextLine();
                    System.out.print("Yeni Telefon Numarası: ");
                    String phoneNumberToUpdate = scanner.nextLine();
                    userToUpdate.setIsim(userNameToUpdate);
                    userToUpdate.setTelefonNumarası(phoneNumberToUpdate);
                    System.out.println("Üye güncellendi.");
                } else {
                    System.out.println("Üye bulunamadı.");
                }
                break;
            default:
                System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
                manageUsers(scanner);
                break;
        }
    }

    private void viewItems(Scanner scanner) {
        System.out.println("1. Kitapları Görüntüle");
        System.out.println("2. Dergileri Görüntüle");
        System.out.println("3. Gazeteleri Görüntüle");
        System.out.print("Seçiminizi yapın: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                bookCollection.getBooks().forEach(book -> {
                    Item item = library.getItemMap().get(book.getId());
                    System.out.println("ID: " + item.getId() + ", İsim: " + item.getIsim() + ", Yazar: " + item.getYazar() + ", Durum: " + item.getStatus());
                });
                break;
            case 2:
                magazineCollection.getMagazines().forEach(magazine -> {
                    Item item = library.getItemMap().get(magazine.getId());
                    System.out.println("ID: " + item.getId() + ", İsim: " + item.getIsim() + ", Durum: " + item.getStatus());
                });
                break;
            case 3:
                newspaperCollection.getNewspapers().forEach(newspaper -> {
                    Item item = library.getItemMap().get(newspaper.getId());
                    System.out.println("ID: " + item.getId() + ", İsim: " + item.getIsim() + ", Durum: " + item.getStatus());
                });
                break;
            default:
                System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
                viewItems(scanner);
                break;
        }
    }

    private void viewUsers() {
        userCollection.getUsers().forEach(user -> System.out.println("ID: " + user.getId() + ", İsim: " + user.getIsim() + ", Telefon: " + user.getTelefonNumarası()));
    }

    public static void main(String[] args) {
        Library library = new Library();
        LoginController controller = new LoginController(library);
        controller.login();
    }
}
