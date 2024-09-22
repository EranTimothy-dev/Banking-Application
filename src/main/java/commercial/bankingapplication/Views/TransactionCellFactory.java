package commercial.bankingapplication.Views;

import commercial.bankingapplication.Controllers.Client.TransactionCellController;
import commercial.bankingapplication.Models.Transaction;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

import java.io.IOException;

public class TransactionCellFactory extends ListCell<Transaction> {

    // update the listview cell with the fxml instead of text
    @Override
    protected void updateItem(Transaction transaction, boolean empty) {
        super.updateItem(transaction, empty);
        if (empty){
            setText(null);
            setGraphic(null);
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Client/TransactionCell.fxml"));
            TransactionCellController controller = new TransactionCellController(transaction);
            loader.setController(controller);
            setText(null);
            try{
                setGraphic(loader.load());
            } catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
