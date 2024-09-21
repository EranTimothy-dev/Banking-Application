package commercial.bankingapplication.Controllers.Admin;

import commercial.bankingapplication.Models.Model;
import commercial.bankingapplication.Views.AdminMenuOptions;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminMenuController implements Initializable {
    public Button create_client_btn;
    public Button clients_btn;
    public Button deposit_btn;
    public Button logout_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}

    private void addListeners(){
        create_client_btn.setOnAction(event -> onCreateClient());
    }


    private void onCreateClient(){
        // set the StringProperty to CreateClient when create client btn is clicked to trigger method for it in AdminController
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOptions.CREATE_CLIENT);
    }
}
