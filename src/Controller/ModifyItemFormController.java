package Controller;

import bo.BoFactory;
import bo.ModifyItemBo;
import bo.Impl.ModifyItemBoImpl;
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

public class ModifyItemFormController {
    public TextField txtItemCode;
    public TextField txtPackSize;
    public TextField txtUnitPrice;
    public TextField txtQuantityOnHand;
    public Button btnAddItem;
    public Button btnCancel;
    public TextField txtDescription;
    public TextField txtDiscount;

    ModifyItemBo modifyItemBo= (ModifyItemBo) BoFactory.getBoFactory().getBo(BoFactory.BoTypes.MODIFY_ITEM);;

    public void ModifyItemOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String discount=null;

        if(txtDiscount.getText().isEmpty()){
            discount="0";
        }else{
            discount=txtDiscount.getText();
        }

    Item i=new Item(txtItemCode.getText(),txtDescription.getText(),txtPackSize.getText(),
            Double.parseDouble(txtUnitPrice.getText()),Integer.parseInt(txtQuantityOnHand.getText()),Double.parseDouble(discount));
            txtItemCode.clear();
            txtDescription.clear();
            txtPackSize.clear();
            txtUnitPrice.clear();
            txtQuantityOnHand.clear();
            txtDiscount.clear();

        if (modifyItemBo.updateItem(i))
            new Alert(Alert.AlertType.CONFIRMATION,"Updated..").show();
        else
            new Alert(Alert.AlertType.WARNING,"Try Again").show();

    }

    public void BackOnAction(ActionEvent event) throws IOException {
        URL resource = getClass().getResource("../View/AdminItemsForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) btnCancel.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void SearchOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        Item i=modifyItemBo.searchItem(txtItemCode.getText());
        if (i==null){
            new Alert(Alert.AlertType.ERROR, "Invalid Item Id").show();
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
