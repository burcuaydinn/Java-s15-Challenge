package library.services;

import library.Library;
import library.items.Item;
import library.users.NormalUser;

import java.util.HashMap;
import java.util.Map;

public class LoanService {
    private Library library;
    private Map<String, String> loanRecords; // Kitap ID ve User ID'yi saklar
    private Map<String, Double> invoiceRecords; // Kullanıcı ID ve Fatura Tutarını saklar

    public LoanService(Library library) {
        this.library = library;
        this.loanRecords = new HashMap<>();
        this.invoiceRecords = new HashMap<>();
    }

    public void loanItem(NormalUser user, String itemId) {
        if (loanRecords.containsKey(itemId)) {
            System.out.println("Bu item zaten ödünç alınmış.");
            return;
        }

        if (userHasReachedLimit(user.getId())) {
            System.out.println("Kitap limitinize ulaştınız. Daha fazla kitap ödünç alamazsınız.");
            return;
        }

        Item item = library.getItemMap().get(itemId);

        if (item == null) {
            System.out.println("Bu ID'ye sahip bir item bulunamadı.");
            return;
        }

        item.setÖdünçAlınmaDurumu(true);
        loanRecords.put(itemId, user.getId());
        double invoiceAmount = calculateInvoice(item);
        invoiceRecords.put(user.getId(), invoiceAmount);
        System.out.println(user.getIsim() + " " + item.getIsim() + " itemini ödünç aldı. Fatura tutarı: " + invoiceAmount + " TL.");
    }

    public void returnItem(NormalUser user, String itemId) {
        if (!loanRecords.containsKey(itemId) || !loanRecords.get(itemId).equals(user.getId())) {
            System.out.println("Bu item bu kullanıcıda değil.");
            return;
        }

        loanRecords.remove(itemId);
        double refundAmount = invoiceRecords.remove(user.getId());
        Item item = library.getItemMap().get(itemId);
        item.setÖdünçAlınmaDurumu(false);

        // Fatura oluşturma (iade edildiğinde)
        System.out.println(user.getIsim() + " " + itemId + " ID'li itemi geri iade etti. İade edilen tutar: " + refundAmount + " TL.");
        System.out.println("Fatura kesildi: " + refundAmount + " TL.");
    }

    private double calculateInvoice(Item item) {
        return item.getFiyat(); // Her itemin kendi fiyatını kullan
    }

    public boolean userHasReachedLimit(String userId) {
        int count = 0;
        for (String borrowedUserId : loanRecords.values()) {
            if (borrowedUserId.equals(userId)) {
                count++;
            }
        }
        return count >= 5;
    }
}