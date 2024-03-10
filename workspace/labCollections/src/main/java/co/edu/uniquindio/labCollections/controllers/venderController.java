package co.edu.uniquindio.labCollections.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.labCollections.model.Producto;
import co.edu.uniquindio.labCollections.utils.UtilsFX;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import static java.lang.String.valueOf;

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
        menuController.getInstancia().cambiarRight("agregarCarrito");
    }

    @FXML
    void buscarEvent(ActionEvent event) {
    	//TODO Esto no es necesario
    }
    
	@FXML
    void recargarEvent(ActionEvent event) {
        tablaVender.refresh();
    }

    @FXML
    void initialize() {
    	UtilsFX.setAsIntegerTextfield(txtBuscar);
    	inicializarTabla();
    	
    	
    	txtBuscar.textProperty().addListener((observable, oldValue, newValue) -> {
    		actualizarTabla(newValue);
    	});
    }
    
    private void actualizarTabla(String codigo) {
    	tablaVender.setItems(FXCollections.observableArrayList(ModelFactoryController.getIntance().filtrarProductos(Long.valueOf(codigo))));
    	tablaVender.refresh();
    }
    
    private void inicializarTabla() {
    	tablaVender.setItems(FXCollections.observableArrayList(ModelFactoryController.getIntance().getListProductos()));
    	
		colNombre.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getNombre()));
		colCantidad.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getCantidad().toString()));
		colPrecio.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getPrecio().toString()));
		colCodigo.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getCodigo().toString()));

	}

    private void inicializarTabla() {
            tablaVender.setItems(FXCollections.observableArrayList(ModelFactoryController.getIntance().getListProductos()));
            System.out.println(ModelFactoryController.getIntance().getListProductos());
            colNombre.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getNombre()));
            colCantidad.setCellValueFactory(e -> new ReadOnlyStringWrapper(valueOf(e.getValue().getCantidad())));
            colPrecio.setCellValueFactory(e -> new ReadOnlyStringWrapper(valueOf(e.getValue().getPrecio())));
            colCodigo.setCellValueFactory(e -> new ReadOnlyStringWrapper(valueOf(e.getValue().getCodigo())));


            tablaVender.refresh();
    }
}
