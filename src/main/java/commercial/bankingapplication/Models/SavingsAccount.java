package commercial.bankingapplication.Models;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class SavingsAccount extends Account{
    // The withdrawal limit from the savings account
    private final DoubleProperty withdrawalLimit;

    public SavingsAccount(String owner, String accountNumber, double balance, double withdrawalLimit) {
        super(owner, accountNumber, balance);
        this.withdrawalLimit = new SimpleDoubleProperty(this, "Transaction Limit", withdrawalLimit);
    }

    public DoubleProperty transactionLimitProperty(){
        return withdrawalLimit;
    }
}
