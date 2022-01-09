package Controller;

import bo.BoFactory;
import bo.Impl.CustomerBOImpl;
import bo.CustomerBo;
import dto.CustomerDTO;
import entity.Customer;
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

public class AddNewCustomerFormController {
    public TextField txtId;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtTittle;
    public TextField txtCity;
    public TextField txtProvince;
    public Button btnCancel;
    public TextField txtPostalCode;

    CustomerBo customerBo= (CustomerBo) BoFactory.getBoFactory().getBo(BoFactory.BoTypes.CUSTOMER);;

    public void SaveCustomerOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {

        CustomerDTO c1=new CustomerDTO(
                txtId.getText(),txtTittle.getText(),txtName.getText(),txtAddress.getText(),
                txtCity.getText(),txtProvince.getText(),txtPostalCode.getText()
        );
        txtId.clear();
        txtName.clear();
        txtTittle.clear();
        txtAddress.clear();
        txtCity.clear();
        txtProvince.clear();
        txtPostalCode.clear();
        if(customerBo.addCustomer(c1))
            new Alert(Alert.AlertType.CONFIRMATION, "Saved..").show();
        else
            new Alert(Alert.AlertType.WARNING, "Try Again..").show();
    }


    public void CancelOnAction(ActionEvent event) throws IOException {
        URL resource = getClass().getResource("../View/CashierForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) btnCancel.getScene().getWindow();
        window.setScene(new Scene(load));

    }
}
