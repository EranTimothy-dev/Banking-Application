package commercial.bankingapplication.Models;

import commercial.bankingapplication.Views.AccountType;
import commercial.bankingapplication.Views.ViewFactory;

import java.sql.ResultSet;
import java.time.LocalDate;

public class Model {
    private final ViewFactory viewFactory;
    private static Model model;
    private final DatabaseDriver databaseDriver;
    private AccountType loginAccountType = AccountType.CLIENT;

    // Client Data Section
    private final Client client;
    private boolean clientLoginSuccessFlag;
    // Admin Data Section

    private Model(){
        this.viewFactory = new ViewFactory();
        this.databaseDriver = new DatabaseDriver();
        // Client Section
        this.clientLoginSuccessFlag = false;
        this.client = new Client("", "", "", null, null, null);
        // Admin Section
    }

    //create an instance of Model class if it has not already been created
    public static synchronized Model getInstance(){
        if(model == null){
            model = new Model();
        }
        return model;
    }

    // return the ViewFactory object that was created to call the views for the application
    public ViewFactory getViewFactory(){
        return viewFactory;
    }

    public DatabaseDriver getDatabaseDriver(){
        return databaseDriver;
    }

    public AccountType getLoginAccountType() {
        return loginAccountType;
    }

    public void setLoginAccountType(AccountType loginAccountType) {
        this.loginAccountType = loginAccountType;
    }

    public boolean getClientLoginSuccessFlag(){
        return this.clientLoginSuccessFlag;
    }

    public void setClientLoginSuccessFlag(boolean flag){
        this.clientLoginSuccessFlag = flag;
    }

    public Client getClient(){
        return client;
    }

    public void evaluateClientCred(String pAddress, String password){
        CheckingAccount checkingAccount;
        SavingsAccount savingsAccount;
        // retrieve data from database
        ResultSet resultSet = databaseDriver.getClientData(pAddress, password);
        try{
            // check if the data id in the first row
            if (resultSet.isBeforeFirst()){
                this.client.firstNameProperty().set(resultSet.getString("FirstName")); // name of the column
                this.client.lastNameProperty().set(resultSet.getString("LastName"));
                 this.client.pAddressProperty().set(resultSet.getString("PayeeAddress"));
                // create LocalDate object from the date in the database
                String[] dateParts = resultSet.getString("Date").split("-");
                LocalDate date = LocalDate.of(Integer.parseInt(dateParts[0]), Integer.parseInt(dateParts[1]), Integer.parseInt(dateParts[2]));
                this.client.dateProperty().set(date);
                this.clientLoginSuccessFlag = true;
            }
        } catch (Exception e){
            e.printStackTrace();

        }
    }



}
