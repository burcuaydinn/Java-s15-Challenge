package library.models;

import java.util.Date;

public class Loan {
    private NormalUser user;
    private Item item;
    private Date loanDate;
    private Date returnDate;
    private Penalty penalty;

    public Loan(NormalUser user, Item item) {
        this.user = user;
        this.item = item;
        this.loanDate = new Date();
        this.penalty = new Penalty();
    }

    public void returnItem() {
        this.returnDate = new Date();
        this.penalty.calculatePenalty(loanDate, returnDate);
    }

    public Item getItem() {
        return item;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public Penalty getPenalty() {
        return penalty;
    }
}
