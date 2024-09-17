package commercial.bankingapplication.Controllers.Client;

import commercial.bankingapplication.Models.Model;
//import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientMenuController implements Initializable {
    public Button report_btn;
    public Button dashboard_btn;
    public Button transaction_btn;
    public Button accounts_btn;
    public Button profile_btn;
    public Button logout_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }


    // listen for when the user clicks a button to set the string property value to call the required view in ClientController
    private void addListeners(){
        dashboard_btn.setOnAction(event -> onDashboard());
        transaction_btn.setOnAction(event -> onTransaction());
        accounts_btn.setOnAction(event -> onAccounts());
    }

    private void onDashboard(){
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set("Dashboard");
    }

    private void onTransaction(){
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set("Transactions");
    }

    private void onAccounts(){
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set("Accounts");
    }
}
