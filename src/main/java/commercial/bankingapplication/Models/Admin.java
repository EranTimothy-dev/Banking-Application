package commercial.bankingapplication.Models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Admin {
    private final StringProperty userName;

    public Admin(String userName) {
        this.userName = new SimpleStringProperty(this, "Username", userName);
    }

    public StringProperty userNameProperty(){
        return this.userName;
    }



}
