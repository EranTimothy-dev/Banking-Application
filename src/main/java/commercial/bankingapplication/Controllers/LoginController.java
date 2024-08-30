package commercial.bankingapplication.Controllers;


import commercial.bankingapplication.Models.Model;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController  implements Initializable {

    @FXML
    public ChoiceBox acc_selector;
    @FXML
    public Label payee_address_lbl;
    @FXML
    public TextField payee_address_fld;
    @FXML
    public TextField password_fld;
    @FXML
    public Button login_btn;
    @FXML
    public Label error_lbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        login_btn.setOnAction(event -> Model.getInstance().getViewFactory().showClientWindow());
 }
}
