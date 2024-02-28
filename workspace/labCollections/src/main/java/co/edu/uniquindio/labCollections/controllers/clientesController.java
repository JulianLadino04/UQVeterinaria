package co.edu.uniquindio.labCollections.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.labCollections.model.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class clientesController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lblTitle;

    @FXML
    private TextField txtBuscar;

    @FXML
    private Button btnAgregarCliente;

    @FXML
    private TableView<Cliente> tablaClientes;

    @FXML
    private TableColumn<Cliente, String> colNombre;

    @FXML
    private TableColumn<Cliente, String> colIdentificacion;

    @FXML
    private TableColumn<Cliente, String> colDireccion;

    @FXML
    void buscarEvent(ActionEvent event) {

    }

    @FXML
    void irAgregarClienteEvent(ActionEvent event) {
    	menuController.getInstancia().cambiarRight("agregarCliente");

    }

    @FXML
    void initialize() {

    }
}
