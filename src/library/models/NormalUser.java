package library.models;

import java.util.ArrayList;
import java.util.List;

public class NormalUser extends User {
    private List<Loan> loans;
    private static final int MAX_LOANS = 5;

    public NormalUser(String name, String surname, String phoneNumber) {
        super(name, surname, phoneNumber);
        this.loans = new ArrayList<>();
    }

    public boolean borrowItem(Item item) {
        if (loans.size() >= MAX_LOANS) {
            System.out.println("Maksimum ödünç alma limitine ulaştınız.");
            return false;
        }

        Loan loan = new Loan(this, item);
        loans.add(loan);
        System.out.println(item.getTitle() + " ödünç alındı.");
        return true;
    }

    public boolean returnItem(String itemId) {
        Loan loanToRemove = null;
        for (Loan loan : loans) {
            if (loan.getItem().getId().equals(itemId)) {
                loanToRemove = loan;
                break;
            }
        }

        if (loanToRemove != null) {
            loans.remove(loanToRemove);
            System.out.println(loanToRemove.getItem().getTitle() + " iade edildi.");
            return true;
        } else {
            System.out.println("Bu ID'ye sahip bir ödünç alınmış item bulunamadı.");
            return false;
        }
    }

    public void listBorrowedItems() {
        if (loans.isEmpty()) {
            System.out.println("Ödünç alınmış item yok.");
        } else {
            for (Loan loan : loans) {
                System.out.println(loan.getItem());
            }
        }
    }
}
