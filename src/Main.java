import library.controllers.LoginController;
import library.models.Book;
import library.models.Author;
import library.models.Librarian;
import library.models.Magazine;
import library.models.Newspaper;
import library.utils.Genre;

public class Main {
    public static void main(String[] args) {
        // Önceden tanımlı veriler
        Librarian librarian = new Librarian("Burcu", "Aydın", "05355555555");

        // Yazar objelerini oluşturun
        Author author1 = new Author("Jose", "Saramago");
        Author author2 = new Author("Franz", "Kafka");
        Author author3 = new Author("Fyodor", "Dostoyevski");
        Author author4 = new Author("George", "Orwell");
        Author author5 = new Author("Victor", "Hugo");
        Author author6 = new Author("Leo", "Tolstoy");
        Author author7 = new Author("Gustave", "Flaubert");
        Author author8 = new Author("Miguel", "de Cervantes");
        Author author9 = new Author("Herman", "Melville");

        // Kitapları ekleyin
        librarian.addItem(new Book("B001", "Görmek", Genre.FICTION, author1, ""));
        librarian.addItem(new Book("B002", "Dönüşüm", Genre.CLASSIC, author2, ""));
        librarian.addItem(new Book("B003", "Suç ve Ceza", Genre.CLASSIC, author3, ""));
        librarian.addItem(new Book("B004", "1984", Genre.CLASSIC, author4, ""));
        librarian.addItem(new Book("B005", "Karamazov Kardeşler", Genre.CLASSIC, author3, ""));
        librarian.addItem(new Book("B006", "Sefiller", Genre.CLASSIC, author5, ""));
        librarian.addItem(new Book("B007", "Anna Karenina", Genre.CLASSIC, author6, ""));
        librarian.addItem(new Book("B008", "Madame Bovary", Genre.CLASSIC, author7, ""));
        librarian.addItem(new Book("B009", "Don Quixote", Genre.CLASSIC, author8, ""));
        librarian.addItem(new Book("B010", "Moby Dick", Genre.CLASSIC, author9, ""));

        // Dergileri ekleyin
        librarian.addItem(new Magazine("M001", "New Times", Genre.MAGAZINE, "2024-08"));
        librarian.addItem(new Magazine("M002", "Science Journal", Genre.MAGAZINE, "2024-08"));
        librarian.addItem(new Magazine("M003", "National Geographic", Genre.MAGAZINE, "2024-08"));
        librarian.addItem(new Magazine("M004", "Forbes", Genre.MAGAZINE, "2024-08"));
        librarian.addItem(new Magazine("M005", "Time", Genre.MAGAZINE, "2024-08"));
        librarian.addItem(new Magazine("M006", "Cosmopolitan", Genre.MAGAZINE, "2024-08"));
        librarian.addItem(new Magazine("M007", "Vogue", Genre.MAGAZINE, "2024-08"));
        librarian.addItem(new Magazine("M008", "People", Genre.MAGAZINE, "2024-08"));
        librarian.addItem(new Magazine("M009", "Nature", Genre.MAGAZINE, "2024-08"));
        librarian.addItem(new Magazine("M010", "Scientific American", Genre.MAGAZINE, "2024-08"));

        // Gazeteleri ekleyin
        librarian.addItem(new Newspaper("N001", "Daily News", Genre.NEWSPAPER, "2024-08-15"));
        librarian.addItem(new Newspaper("N002", "The Guardian", Genre.NEWSPAPER, "2024-08-15"));
        librarian.addItem(new Newspaper("N003", "The New York Times", Genre.NEWSPAPER, "2024-08-15"));
        librarian.addItem(new Newspaper("N004", "The Washington Post", Genre.NEWSPAPER, "2024-08-15"));
        librarian.addItem(new Newspaper("N005", "The Wall Street Journal", Genre.NEWSPAPER, "2024-08-15"));
        librarian.addItem(new Newspaper("N006", "The Times", Genre.NEWSPAPER, "2024-08-15"));
        librarian.addItem(new Newspaper("N007", "The Telegraph", Genre.NEWSPAPER, "2024-08-15"));
        librarian.addItem(new Newspaper("N008", "Le Monde", Genre.NEWSPAPER, "2024-08-15"));
        librarian.addItem(new Newspaper("N009", "El Pais", Genre.NEWSPAPER, "2024-08-15"));
        librarian.addItem(new Newspaper("N010", "The Independent", Genre.NEWSPAPER, "2024-08-15"));

        // Kullanıcı girişine yönlendirme
        LoginController.main(args);
    }
}
