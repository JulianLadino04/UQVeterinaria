package co.edu.uniquindio.labCollections.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.labCollections.model.Cliente;
import co.edu.uniquindio.labCollections.utils.UtilsFX;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class agregarClienteController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btnCerrar;

	@FXML
	private TextField txtIdentificacion;

	@FXML
	private TextField txtDireccion;

	@FXML
	private TextField txtNombre;

	@FXML
	private Button btnAgregarCliente;

	@FXML
	void agregarClienteEvent(ActionEvent event) {
		agregarClienteAction();
	}

	private void agregarClienteAction() {
		if (!verificarCamposVacios()) {
			new Alert(AlertType.WARNING, "Todos los campos deben estar llenos").show();
			return;
		}
		var cliente = new Cliente(txtNombre.getText(), txtDireccion.getText(), txtIdentificacion.getText());
		ModelFactoryController.getIntance().agregarCliente(cliente);
	}

	@FXML
	void cerrarEvent(ActionEvent event) {
		menuController.getInstancia().setRight(null);
	}

	@FXML
	void initialize() {
		UtilsFX.setAsNameTextField(txtNombre);
		UtilsFX.setAsMultiTextField(txtDireccion);
		UtilsFX.setAsIntegerTextfield(txtIdentificacion);

	}

	private boolean verificarCamposVacios() {
		return (txtNombre.getText().isBlank() || txtIdentificacion.getText().isBlank()
				|| txtDireccion.getText().isBlank()) ? false : true;
	}
}
