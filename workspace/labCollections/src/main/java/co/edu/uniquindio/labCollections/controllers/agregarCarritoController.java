package co.edu.uniquindio.labCollections.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class agregarCarritoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAgregarCliente;

    @FXML
    private Button btnCerrar;

    @FXML
    private TextField txtCantidad;

    @FXML
    private TextField txtCodeProducto;

    @FXML
    private TextField txtIdentificacion;

    @FXML
    void CodeProductoEvent(ActionEvent event) {

    }

    @FXML
    void IdentificacionEvent(ActionEvent event) {

    }

    @FXML
    void agregarProductoEvent(ActionEvent event) {
    	agregarProductoAction();
    }

    private void agregarProductoAction() {
    	var producto = ModelFactoryController.getIntance().buscarProducto(Long.valueOf(txtCodeProducto.getText()));
		producto.setCantidad(Integer.valueOf(txtCantidad.getText()));
		ModelFactoryController.getIntance().agregarAlCarrito(txtIdentificacion.getText(), producto);
	}

	@FXML
    void cantidadEvent(ActionEvent event) {

    }

    @FXML
    void cerrarEvent(ActionEvent event) {
        menuController.getInstancia().setRight(null);
    }

    @FXML
    void initialize() {
    }

}
