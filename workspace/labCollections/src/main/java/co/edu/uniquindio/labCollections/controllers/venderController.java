package co.edu.uniquindio.labCollections.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.labCollections.model.Producto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class venderController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAgregarCarrito;

    @FXML
    private TableColumn<Producto, String> colCantidad;

    @FXML
    private TableColumn<Producto, String> colCodigo;

    @FXML
    private TableColumn<Producto, String> colNombre;

    @FXML
    private TableColumn<Producto, String> colPrecio;

    @FXML
    private TableView<Producto> tablaVender;

    @FXML
    private TextField txtBuscar;

    @FXML
    void agregarAlCarrito(ActionEvent event) {

    }

    @FXML
    void buscarEvent(ActionEvent event) {

    }

    @FXML
    void initialize() {

    }

}
