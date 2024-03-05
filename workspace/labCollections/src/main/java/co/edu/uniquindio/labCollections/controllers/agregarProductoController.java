package co.edu.uniquindio.labCollections.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.labCollections.model.Producto;
import co.edu.uniquindio.labCollections.utils.UtilsFX;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
		if (!verificarCamposVacios()) {
			new Alert(AlertType.WARNING, "Todos los campos deben ser llenados").show();
			return;
		}
		var producto = new Producto(Integer.valueOf(txtCantidad.getText()), txtNombre.getText(), Double.valueOf(txtPrecio.getText()));
		ModelFactoryController.getIntance().agregarProducto(producto);
	}

	@FXML
	void cantidadEvent(ActionEvent event) {
		// TODO Esto no es necesario
	}

	@FXML
	void cerrarEvent(ActionEvent event) {
		menuController.getInstancia().setRight(null);
	}

	@FXML
	void nombreEvent(ActionEvent event) {
		// TODO Esto no es necesario
	}

	@FXML
	void precioEvent(ActionEvent event) {
		// TODO Esto no es necesario
	}

	@FXML
	void initialize() {
		UtilsFX.setAsNameTextField(txtNombre);
		UtilsFX.setAsIntegerTextfield(txtCantidad);
		UtilsFX.setAsNumberTextfield(txtPrecio);
	}

	private boolean verificarCamposVacios() {
		return (txtCantidad.getText().isBlank() || txtNombre.getText().isBlank() || txtPrecio.getText().isBlank())
				? false
				: true;
	}
}
