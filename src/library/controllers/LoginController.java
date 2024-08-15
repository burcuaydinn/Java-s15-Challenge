package library.controllers;

import library.models.*;
import library.utils.Genre;

import java.util.Scanner;

public class LoginController {
    private static Library library = new Library();  // Kütüphaneyi başlat

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hoşgeldiniz! Lütfen giriş yapmak için kullanıcı tipinizi seçin:");
        System.out.println("1. Librarian");
        System.out.println("2. Normal User");

        int userType = scanner.nextInt();
        scanner.nextLine();  // Enter tuşunu yakalamak için

        if (userType == 1) {
            // Librarian Girişi
            System.out.println("Librarian Girişi:");
            System.out.print("İsim: ");
            String name = scanner.nextLine();
            System.out.print("Soyisim: ");
            String surname = scanner.nextLine();
            System.out.print("Telefon Numarası: ");
            String phoneNumber = scanner.nextLine();

            // Önceden tanımlı librarian bilgisiyle karşılaştırıyoruz
            Librarian librarian = new Librarian("Burcu", "Aydın", "05355555555");

            if (librarian.getName().equals(name) &&
                    librarian.getSurname().equals(surname) &&
                    librarian.getPhoneNumber().equals(phoneNumber)) {
                System.out.println("Giriş başarılı!");
                librarianOperations(librarian);
            } else {
                System.out.println("Giriş bilgileri hatalı!");
            }

        } else if (userType == 2) {
            // Normal User Girişi
            System.out.println("Normal User Girişi:");
            System.out.print("İsim: ");
            String name = scanner.nextLine();
            System.out.print("Soyisim: ");
            String surname = scanner.nextLine();
            System.out.print("Telefon Numarası: ");
            String phoneNumber = scanner.nextLine();

            NormalUser normalUser = new NormalUser(name, surname, phoneNumber);
            System.out.println("Giriş başarılı!");
            userOperations(normalUser);
        } else {
            System.out.println("Geçersiz kullanıcı tipi!");
        }

        scanner.close();
    }

    private static void librarianOperations(Librarian librarian) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nLibrarian Menüsü:");
            System.out.println("1. Kitap/Dergi/Gazete Ekle");
            System.out.println("2. Kitap/Dergi/Gazete Sil");
            System.out.println("3. Kitap/Dergi/Gazete Güncelle");
            System.out.println("4. Ödünç Alınan Kitapları Görüntüle");
            System.out.println("5. Çıkış");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Enter tuşunu yakalamak için

            switch (choice) {
                case 1:
                    // Ekleme işlemleri
                    addItem(librarian, scanner);
                    break;
                case 2:
                    // Silme işlemleri
                    removeItem(librarian, scanner);
                    break;
                case 3:
                    // Güncelleme işlemleri
                    updateItem(librarian, scanner);
                    break;
                case 4:
                    // Ödünç alınan kitapları görüntüleme
                    viewLoanedItems(librarian);
                    break;
                case 5:
                    // Çıkış
                    System.out.println("Çıkış yapılıyor...");
                    running = false;
                    break;
                default:
                    System.out.println("Geçersiz seçenek!");
                    break;
            }
        }
    }

    private static void addItem(Librarian librarian, Scanner scanner) {
        System.out.println("Eklenecek türü seçin: ");
        System.out.println("1. Kitap");
        System.out.println("2. Dergi");
        System.out.println("3. Gazete");
        int type = scanner.nextInt();
        scanner.nextLine();  // Enter tuşunu yakalamak için

        System.out.print("Başlık: ");
        String title = scanner.nextLine();
        System.out.print("Yazar (Ad Soyad) (Kitap için): ");
        String authorName = scanner.nextLine();
        Author author = new Author(authorName.split(" ")[0], authorName.split(" ")[1]);  // Assuming "Ad Soyad"
        System.out.print("Ekstra Bilgi: ");
        String additionalInfo = scanner.nextLine();
        System.out.print("Tür (FICTION, CLASSIC, MAGAZINE, NEWSPAPER): ");
        String genre = scanner.nextLine();
        Genre itemGenre = Genre.valueOf(genre.toUpperCase());

        String id = "ID_" + title;  // Basit bir ID oluşturma

        switch (type) {
            case 1:
                library.addItem(new Book(id, title, itemGenre, author, additionalInfo));
                break;
            case 2:
                library.addItem(new Magazine(id, title, itemGenre, additionalInfo));
                break;
            case 3:
                library.addItem(new Newspaper(id, title, itemGenre, additionalInfo));
                break;
            default:
                System.out.println("Geçersiz tür!");
                break;
        }
    }

    private static void removeItem(Librarian librarian, Scanner scanner) {
        System.out.print("Silinecek öğenin ID'sini girin: ");
        String id = scanner.nextLine();
        library.removeItem(id);
    }

    private static void updateItem(Librarian librarian, Scanner scanner) {
        System.out.print("Güncellenecek öğenin ID'sini girin: ");
        String id = scanner.nextLine();
        System.out.print("Yeni başlık: ");
        String newTitle = scanner.nextLine();
        System.out.print("Yeni yazar (Ad Soyad) (Kitap için): ");
        String newAuthorName = scanner.nextLine();
        Author newAuthor = new Author(newAuthorName.split(" ")[0], newAuthorName.split(" ")[1]);  // Assuming "Ad Soyad"
        System.out.print("Yeni tür (FICTION, CLASSIC, MAGAZINE, NEWSPAPER): ");
        String newGenre = scanner.nextLine();
        Genre newItemGenre = Genre.valueOf(newGenre.toUpperCase());
        System.out.print("Yeni ekstra bilgi: ");
        String newAdditionalInfo = scanner.nextLine();

        // Öğeyi güncelleme işlemi
        library.removeItem(id);  // Önce eski öğeyi kaldır
        Item updatedItem;
        if (newItemGenre == Genre.MAGAZINE) {
            updatedItem = new Magazine(id, newTitle, newItemGenre, newAdditionalInfo);
        } else if (newItemGenre == Genre.NEWSPAPER) {
            updatedItem = new Newspaper(id, newTitle, newItemGenre, newAdditionalInfo);
        } else {
            updatedItem = new Book(id, newTitle, newItemGenre, newAuthor, newAdditionalInfo);
        }
        library.addItem(updatedItem);  // Yeni öğeyi ekle
    }

    private static void viewLoanedItems(Librarian librarian) {
        library.viewLoanedItems();
    }

    private static void userOperations(NormalUser normalUser) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nKullanıcı Menüsü:");
            System.out.println("1. Kitapları Görüntüle");
            System.out.println("2. Kitap Ödünç Al");
            System.out.println("3. Kitap Geri Ver");
            System.out.println("4. Cezai Durumu Görüntüle");
            System.out.println("5. Çıkış");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Enter tuşunu yakalamak için

            switch (choice) {
                case 1:
                    // Kitapları görüntüleme
                    viewItems(normalUser);
                    break;
                case 2:
                    // Kitap ödünç alma
                    borrowItem(normalUser, scanner);
                    break;
                case 3:
                    // Kitap geri verme
                    returnItem(normalUser, scanner);
                    break;
                case 4:
                    // Cezai durumu görüntüleme
                    viewPenalties(normalUser);
                    break;
                case 5:
                    // Çıkış
                    System.out.println("Çıkış yapılıyor...");
                    running = false;
                    break;
                default:
                    System.out.println("Geçersiz seçenek!");
                    break;
            }
        }
    }

    private static void viewItems(NormalUser normalUser) {
        library.listAllItems();  // Tüm öğeleri listele
    }

    private static void borrowItem(NormalUser normalUser, Scanner scanner) {
        System.out.print("Ödünç alınacak öğenin ID'sini girin: ");
        String id = scanner.nextLine();
        Item item = library.findItemById(id);  // ID ile item bulunmalı
        if (item != null) {
            library.borrowItem(normalUser, item);
            System.out.println("Ödünç alma işlemi başarılı.");
        } else {
            System.out.println("Ödünç alınacak öğe bulunamadı.");
        }
    }

    private static void returnItem(NormalUser normalUser, Scanner scanner) {
        System.out.print("Geri verilecek öğenin ID'sini girin: ");
        String id = scanner.nextLine();
        Item item = library.findItemById(id);  // ID ile item bulunmalı
        if (item != null) {
            library.returnItem(normalUser, item);
            System.out.println("Geri verme işlemi başarılı.");
        } else {
            System.out.println("Geri verilecek öğe bulunamadı.");
        }
    }

    private static void viewPenalties(NormalUser normalUser) {
        // Cezai durumu görüntülemek için gerekli metod
        System.out.println("Cezai durum görüntüleniyor...");
        // Örneğin:
        // List<Penalty> penalties = library.getPenaltiesForUser(normalUser);
        // penalties.forEach(System.out::println);
    }
}
