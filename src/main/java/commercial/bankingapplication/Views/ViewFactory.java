package commercial.bankingapplication.Views;

import commercial.bankingapplication.Controllers.Admin.AdminController;
import commercial.bankingapplication.Controllers.Client.ClientController;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

// class to create methods handling the view of the application
public class ViewFactory {
    private AccountType loginAccountType;
    //Client Views
    // use enums as objectproperty instead of stringproperty to reduce possibility of error
    private final ObjectProperty<ClientMenuOptions> clientSelectedMenuItem;
    private AnchorPane dashboardView;
    private AnchorPane transactionsView;
    private AnchorPane accountsView;

    // Admin Views
    // use enums as objectproperty instead of stringproperty to reduce possibility of error
    private final ObjectProperty<AdminMenuOptions> adminSelectedMenuItem;
    private AnchorPane createClientView;
    private AnchorPane clientsView;
    private AnchorPane depositView;



    // create constructor for ViewFactory
    public ViewFactory(){
        this.loginAccountType = AccountType.CLIENT;
        // create a string property that will store which menu item the user has selected
        this.clientSelectedMenuItem = new SimpleObjectProperty<>();
        this.adminSelectedMenuItem = new SimpleObjectProperty<>();
    }

    public AccountType getLoginAccountType(){
        return loginAccountType;
    }

    public void setLoginAccountType(AccountType loginAccountType) {
        this.loginAccountType = loginAccountType;
    }

    /*
    * Client View Section
     */
    public ObjectProperty<ClientMenuOptions> getClientSelectedMenuItem(){
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

    /*
    * Admin Views Section
     */

    public ObjectProperty<AdminMenuOptions> getAdminSelectedMenuItem(){
        return adminSelectedMenuItem;
    }

    // fmxl view to create a client
    public AnchorPane getCreateClientView(){
        if(createClientView == null){
            try{
                createClientView = new FXMLLoader(getClass().getResource("/Fxml/Admin/CreateClient.fxml")).load();
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        return createClientView;
    }

    // fxml view to see created clients
    public AnchorPane getClientsView(){
        if (clientsView == null){
            try{
                clientsView = new FXMLLoader(getClass().getResource("/Fxml/Admin/Clients.fxml")).load();
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        return clientsView;
    }

    public AnchorPane getDepositView(){
        if (depositView == null) {
            try{
                depositView = new FXMLLoader(getClass().getResource("/Fxml/Admin/Deposit.fxml")).load();
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        return depositView;
    }


    public void showAdminWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Admin/Admin.fxml"));
        AdminController adminController = new AdminController();
        loader.setController(adminController);
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
        stage.setResizable(false);
        stage.getIcons().add(new Image(String.valueOf(ViewFactory.class.getResource("/Images/bankIcon.png"))));
        stage.show();
    }

    // create method to close the stage
    public void closeStage(Stage stage){
        stage.close();
    }


}
