package commercial.bankingapplication.Controllers.Client;

import commercial.bankingapplication.Models.Model;
import javafx.application.Application;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientController implements Initializable {

    public BorderPane client_parent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // add a listener to this property
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().addListener((observableValue, oldVal, newVal) -> {
            switch (newVal){
                case "Transactions" -> client_parent.setCenter(Model.getInstance().getViewFactory().getTransactionsView());
                default -> client_parent.setCenter(Model.getInstance().getViewFactory().getDashboardView());
            }
        });

    }
}
