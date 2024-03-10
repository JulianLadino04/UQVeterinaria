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

public class FinalizarVentaController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btnBorrar;

	@FXML
	private Button btnBuscar;

	@FXML
	private Button btnFinalizar;

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

	private Producto productoSeleccionado;

	@FXML
	void borrarEvent(ActionEvent event) {
		borraAction();
	}

	@FXML
	void buscarEvent(ActionEvent event) {
		buscarAction();
	}

	@FXML
	void finalizarEvent(ActionEvent event) {
		ModelFactoryController.getIntance().finalizarVenta(txtBuscar.getText());
	}

	@FXML
	void initialize() {
		UtilsFX.setAsIntegerTextfield(txtBuscar);
		inicializarTabla();
		tablaVender.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

			if (newValue == null) {
				return;
			}
			productoSeleccionado = newValue;
		});
	}

	private void buscarAction() {
		actualizarTabla(txtBuscar.getText());
	}

	private void borraAction() {
		ModelFactoryController.getIntance().eliminarProductoCarrito(txtBuscar.getText(), productoSeleccionado);
		actualizarTabla(txtBuscar.getText());
	}

	private void actualizarTabla(String codigo) {
		tablaVender.setItems(
				FXCollections.observableArrayList(ModelFactoryController.getIntance().getCarritoCliente(codigo)));
	}

	private void inicializarTabla() {
		colNombre.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getNombre()));
		colCantidad.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getCantidad().toString()));
		colPrecio.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getPrecio().toString()));
		colCodigo.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getCodigo().toString()));

	}
}
