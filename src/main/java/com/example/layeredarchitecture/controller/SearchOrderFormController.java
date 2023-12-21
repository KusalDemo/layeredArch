package com.example.layeredarchitecture.controller;

import com.example.layeredarchitecture.dao.custom.CustomerDAO;
import com.example.layeredarchitecture.dao.custom.QueryDAO;
import com.example.layeredarchitecture.dao.custom.impl.CustomerDAOImpl;
import com.example.layeredarchitecture.dao.custom.impl.QueryDAOImpl;
import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.SearchDTO;
import com.jfoenix.controls.JFXComboBox;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;

public class SearchOrderFormController {
    public AnchorPane root;
    public TextField txtCustomerName;
    public JFXComboBox cmbOrderId;
    public TableView tblOrderDetails;
    public Label lblId;
    public Label lblDate;
    public TextField txtOrderDate;
    public JFXComboBox cmbCustomerId;
    public JFXComboBox cmbItemCode;

    QueryDAOImpl queryDAO = new QueryDAOImpl();
    CustomerDAO customerDAO = new CustomerDAOImpl();

    public void initialize() throws SQLException, ClassNotFoundException {

        loadAllCustomerIds();
    }

    public void navigateToHome(MouseEvent mouseEvent) throws IOException {
        URL resource = this.getClass().getResource("/com/example/layeredarchitecture/main-form.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) (this.root.getScene().getWindow());
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        Platform.runLater(() -> primaryStage.sizeToScene());
    }

    public void OrderIdOnAction(ActionEvent actionEvent) {

    }

    public void cusIdOnAction(ActionEvent actionEvent) {
        String CustomerId = (String) cmbCustomerId.getValue();
        cmbOrderId.getItems().clear();

        try {
            ArrayList<SearchDTO> searchedDetails = queryDAO.search(CustomerId);

            for (SearchDTO searchDTO : searchedDetails) {
                cmbOrderId.getItems().add(searchDTO.getOid());
                txtCustomerName.setText(searchDTO.getName());
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public void loadAllCustomerIds() throws SQLException, ClassNotFoundException {
        ArrayList<CustomerDTO> allCustomers = customerDAO.getAll();
        for (CustomerDTO customerDTO : allCustomers) {
            cmbCustomerId.getItems().add(customerDTO.getId());
        }

    }
}
