package commercial.bankingapplication;

import commercial.bankingapplication.Models.Model;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {



    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/Fxml/Login.fxml"));
////        Parent root = fxmlLoader.load();
//        Scene scene = new Scene(fxmlLoader.load());
//        stage.setScene(scene);
//        stage.setTitle("Banking Application");
//        stage.show();


        // access the view for the login window through the model
        // which object will create an instance on the ViewFactory to call the methods in the viewFactory
        Model.getInstance().getViewFactory().showLoginWindow();
 }
}
