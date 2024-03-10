package co.edu.uniquindio.labCollections.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.labCollections.model.Producto;
import co.edu.uniquindio.labCollections.utils.UtilsFX;
import javafx.collections.FXCollections;
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
    private Button btnRecargar;

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
    	//TODO Aparentemente se tiene que redisenar algunas partes del modelo
    }

    @FXML
    void buscarEvent(ActionEvent event) {
    	//TODO Esto no es necesario
    }
    
	@FXML
    void recargarEvent(ActionEvent event) {

    }

    @FXML
    void initialize() {
    	UtilsFX.setAsIntegerTextfield(txtBuscar);
    	
    	txtBuscar.textProperty().addListener((observable, oldValue, newValue) -> {
    		actualizarTabla(Long.valueOf(newValue));
    	});
    }
    
    private void actualizarTabla(Long codigo) {
    	tablaVender.setItems(FXCollections.observableArrayList(ModelFactoryController.getIntance().filtrarProductos(codigo)));
    }

}
