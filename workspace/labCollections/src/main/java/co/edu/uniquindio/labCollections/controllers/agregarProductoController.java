package co.edu.uniquindio.labCollections.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class agregarProductoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCerrar;

    @FXML
    private TextField txtCantidad;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtPrecio;

    @FXML
    private Button btnAgregarCliente;

    @FXML
    void agregarProductoEvent(ActionEvent event) {

    }

    @FXML
    void cantidadEvent(ActionEvent event) {

    }

    @FXML
    void cerrarEvent(ActionEvent event) {
    	menuController.getInstancia().setRight(null);

    }

    @FXML
    void nombreEvent(ActionEvent event) {

    }

    @FXML
    void precioEvent(ActionEvent event) {

    }

    @FXML
    void initialize() {

    }
}
