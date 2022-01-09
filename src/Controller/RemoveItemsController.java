package Controller;

import bo.BoFactory;
import bo.RemoveItemBo;
import bo.Impl.RemoveItemBoImpl;
import entity.Item;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;

public class RemoveItemsController {

    public TextField txtItemCode;
    public TextField txtPackSize;
    public TextField txtUnitPrice;
    public TextField txtQuantityOnHand;
    public Button btnAddItem;
    public Button btnCancel;
    public TextField txtDescription;
    public TextField txtDiscount;

    RemoveItemBo removeItemBo= (RemoveItemBo) BoFactory.getBoFactory().getBo(BoFactory.BoTypes.REMOVE_ITEM);


    public void BackOnAction(ActionEvent event) throws IOException {
        URL resource = getClass().getResource("../View/AdminItemsForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) btnCancel.getScene().getWindow();
        window.setScene(new Scene(load));

    }

    public void RemoveItemOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        if (removeItemBo.deleteItem(txtItemCode.getText())){
            new Alert(Alert.AlertType.CONFIRMATION, "Deleted").show();
        }else{
            new Alert(Alert.AlertType.WARNING, "Try Again").show();
        }
        txtItemCode.clear();
        txtDescription.clear();
        txtPackSize.clear();
        txtUnitPrice.clear();
        txtQuantityOnHand.clear();
        txtDiscount.clear();

    }

    public void SearchCustomerOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        Item i=removeItemBo.searchItem(txtItemCode.getText());
        if (i==null){
            new Alert(Alert.AlertType.ERROR, "Invalid Customer Id").show();
        }else{
            setData(i);
        }
    }
    void setData(Item i) {
        txtDescription.setText(i.getDescription());
        txtPackSize.setText(i.getPackSize());
        txtUnitPrice.setText(String.valueOf(i.getUnitPrice()));
        txtQuantityOnHand.setText(String.valueOf(i.getQtyOnHand()));
        txtDiscount.setText(String.valueOf(i.getDiscount()));
    }
}
