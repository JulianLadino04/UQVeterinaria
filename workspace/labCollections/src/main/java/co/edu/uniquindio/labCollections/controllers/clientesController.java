package co.edu.uniquindio.labCollections.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import co.edu.uniquindio.labCollections.model.Cliente;
import co.edu.uniquindio.labCollections.utils.UtilsFX;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

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
		UtilsFX.setAsIntegerTextfield(txtBuscar);
		inicializarTabla();

		txtBuscar.textProperty().addListener((observable, oldValue, newValue) -> {
			actualizarTabla(newValue);
		});
	}

	private void actualizarTabla(String identificacion) {
		tablaClientes.setItems(FXCollections.observableArrayList(ModelFactoryController.getIntance().filtrarClientes(identificacion)));
		tablaClientes.refresh();
	}

	private void inicializarTabla(){
		tablaClientes.setItems(FXCollections.observableArrayList(ModelFactoryController.getIntance().getListClientes()));
		System.out.println(ModelFactoryController.getIntance().getListClientes());

		colNombre.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getNombre()));
		colDireccion.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getDireccion()));
		colIdentificacion.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getnIdentificacion()));

		tablaClientes.refresh();
	}
}
