package deposits;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by ${Dotin} on ${4/25/2015}.
 */
public class Deposit implements Comparable<Deposit> {
    private int customerNumber;
    private BigDecimal depositBalance;
    private int durationInDays;
    private BigDecimal payedInterest;
    public DepositType depositType;

    public DepositType getDepositType() {
        return depositType;
    }

    public void setDepositType(DepositType depositType) {
        this.depositType = depositType;
    }



    public BigDecimal getPayedInterest() {
        return payedInterest;
    }

    public void setPayedInterest(BigDecimal payedInterest) {
        this.payedInterest = payedInterest;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public BigDecimal getDepositBalance() {
        return depositBalance;
    }

    public void setDepositBalance(BigDecimal depositBalance) {
        this.depositBalance = depositBalance;
    }

    public int getDurationInDays() {
        return durationInDays;
    }

    public void setDurationInDays(int durationInDays) {
        this.durationInDays = durationInDays;
    }

    public BigDecimal calculateInterest(BigDecimal depositBalance, int durationInDays , DepositType depositType)
    {
        return (new BigDecimal(depositType.interestRate*durationInDays).multiply(depositBalance)).divide(new BigDecimal(36500), 4, RoundingMode.HALF_UP);
    }


    @Override
    public int compareTo(Deposit deposit) {
        return deposit.payedInterest.compareTo(payedInterest);
    }

    @Override
    public String toString() {
        return customerNumber + "#" + payedInterest;
    }

}



