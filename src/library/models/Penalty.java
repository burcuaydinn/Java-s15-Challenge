package library.models;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Penalty {
    private static final int LOAN_PERIOD_DAYS = 30;
    private static final double DAILY_PENALTY_RATE = 0.25; // 25 kuruş
    private double amount;

    public void calculatePenalty(Date loanDate, Date returnDate) {
        long diffInMillies = Math.abs(returnDate.getTime() - loanDate.getTime());
        long diffInDays = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        if (diffInDays > LOAN_PERIOD_DAYS) {
            this.amount = (diffInDays - LOAN_PERIOD_DAYS) * DAILY_PENALTY_RATE;
        } else {
            this.amount = 0;
        }

        System.out.println("Ceza miktarı: " + amount + " TL");
    }

    public double getAmount() {
        return amount;
    }
}
