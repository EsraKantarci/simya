/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sımya.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;

/**
 *
 * @author n
 */
public class TabController implements Initializable {

    @FXML
    private Parent paneMesaj;
    @FXML
    private Button btnCikisCikisyap;


    @FXML
    private void kisi1() {
        paneMesaj.setVisible(true);

    }

    @FXML
    private void kisi2() {
        paneMesaj.setVisible(true);

    }

    @FXML
    private void spam1() {
        paneMesaj.setVisible(true);

    }

    @FXML
    private void spam2() {
        paneMesaj.setVisible(true);

    }

    public void handleButtonAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        Parent root = null;
        if (event.getSource() == btnCikisCikisyap) {
            root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        }

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
          paneMesaj.setVisible(false);
    }
}
