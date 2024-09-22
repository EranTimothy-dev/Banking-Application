package commercial.bankingapplication.Models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class CheckingAccount extends Account{
    // The number of transactions a customer is allowed to do per day
    private final IntegerProperty transactionLimit;

    public CheckingAccount(String owner, String accountNumber, double balance, int limit){
        super(owner, accountNumber, balance);
        this.transactionLimit = new SimpleIntegerProperty(limit);
    }

    public IntegerProperty transactionLimitProperty(){
        return transactionLimit;
    }
}
