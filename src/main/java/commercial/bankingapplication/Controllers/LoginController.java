package commercial.bankingapplication.Controllers;


import commercial.bankingapplication.Models.Model;
import commercial.bankingapplication.Views.AccountType;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController  implements Initializable {

    @FXML
    public ChoiceBox<AccountType> acc_selector;
    @FXML
    public Label payee_address_lbl;
    @FXML
    public TextField payee_address_fld;
    @FXML
    public PasswordField password_fld;
    @FXML
    public Button login_btn;
    @FXML
    public Label error_lbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // load the options
        acc_selector.setItems(FXCollections.observableArrayList(AccountType.values()));
//        acc_selector.setItems(FXCollections.observableArrayList(AccountType.CLIENT, AccountType.ADMIN));

        // set default value(client) as access level
        acc_selector.setValue(Model.getInstance().getViewFactory().getLoginAccountType());
        // add listener to check for the dropdown selection
        acc_selector.valueProperty().addListener(observable -> Model.getInstance().getViewFactory().setLoginAccountType(acc_selector.getValue()));
        login_btn.setOnAction(event -> onLogin());
    }

    private void onLogin(){
        // can use any node in that stage
        Stage stage = (Stage) error_lbl.getScene().getWindow();
        if (Model.getInstance().getViewFactory().getLoginAccountType().equals(AccountType.CLIENT)){
            // Evaluate login credentials
            Model.getInstance().evaluateClientCred(payee_address_fld.getText(), password_fld.getText());
            if (Model.getInstance().getClientLoginSuccessFlag()){
                Model.getInstance().getViewFactory().showClientWindow();
                // close the login stage
                Model.getInstance().getViewFactory().closeStage(stage);
            } else {
                payee_address_fld.setText("");
                password_fld.setText("");
                error_lbl.setText("No Such Account!");
            }
        } else {
            Model.getInstance().getViewFactory().showAdminWindow();
        }
    }
}


