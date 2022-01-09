package Controller;

import bo.BoFactory;
import bo.NewItemBo;
import bo.Impl.NewItemBoImpl;
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

public class NewItemFormController {
    public TextField txtItemCode;
    public TextField txtPackSize;
    public TextField txtUnitPrice;
    public TextField txtQuantityOnHand;
    public Button btnAddItem;
    public Button btnCancel;
    public TextField txtDescription;
    public TextField txtDiscount;

    NewItemBo newItemBo= (NewItemBo) BoFactory.getBoFactory().getBo(BoFactory.BoTypes.NEW_ITEM);;

    public void AddNewItemOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String discount=null;

        if(txtDiscount.getText().isEmpty()){
            discount="0";
        }else{
            discount=txtDiscount.getText();
        }
        Item i=new Item(
                txtItemCode.getText(),txtDescription.getText(),txtPackSize.getText(),
                Double.parseDouble(txtUnitPrice.getText()),Integer.parseInt(txtQuantityOnHand.getText()),
                Double.parseDouble(discount)
        );

        if(newItemBo.SaveItems(i))
            new Alert(Alert.AlertType.CONFIRMATION, "Saved..").show();
        else
            new Alert(Alert.AlertType.WARNING, "Try Again..").show();
        txtItemCode.clear();
        txtDescription.clear();
        txtPackSize.clear();
        txtUnitPrice.clear();
        txtQuantityOnHand.clear();
        txtDiscount.clear();

    }

    public void BackOnAction(ActionEvent event) throws IOException {
        URL resource = getClass().getResource("../View/AdminItemsForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) btnCancel.getScene().getWindow();
        window.setScene(new Scene(load));
    }
}
