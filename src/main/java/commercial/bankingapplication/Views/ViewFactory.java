package commercial.bankingapplication.Views;

import commercial.bankingapplication.Controllers.Client.ClientController;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

// class to create methods handling the view of the application
public class ViewFactory {
    //Client Views
    private final StringProperty clientSelectedMenuItem;
    private AnchorPane dashboardView;
    private AnchorPane transactionsView;
    private AnchorPane accountsView;

    // create constructor for ViewFactory
    public ViewFactory(){
        // create a string property that will store which menu item the user has selected
        this.clientSelectedMenuItem = new SimpleStringProperty("");
    }

    /*
    * Client View Section
     */
    public StringProperty getClientSelectedMenuItem(){
        return clientSelectedMenuItem;
    }

    // load the dashboard fxml
    public AnchorPane getDashboardView(){
        if(dashboardView == null){
            try {
                dashboardView = new FXMLLoader(getClass().getResource("/Fxml/Client/Dashboard.fxml")).load();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return dashboardView;
    }

    // load the transaction fxml
    public AnchorPane getTransactionsView(){
        if(transactionsView == null){
            try{
                transactionsView = new FXMLLoader(getClass().getResource("/FXML/Client/Transactions.fxml")).load();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return transactionsView;
    }

    // load the transaction fxml
    public AnchorPane getAccountsView(){
        if(accountsView == null){
            try{
                accountsView = new FXMLLoader(getClass().getResource("/Fxml/Client/Accounts.fxml")).load();
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        return accountsView;
    }

    // get the login window
    public void showLoginWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Login.fxml"));
        createStage(loader);
    }

    // get the client window
    public void showClientWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Client/Client.fxml"));
        ClientController clientController = new ClientController();
        loader.setController(clientController);
        createStage(loader);
    }

    // create reusable method to load the fxml file and create the stage from it
    private void createStage(FXMLLoader loader) {
        Scene scene = null;
        try{
            scene = new Scene(loader.load());
        } catch (IOException e){
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Banking Application");
        stage.show();
    }

    // create method to close the stage
    public void closeStage(Stage stage){
        stage.close();
    }
}
