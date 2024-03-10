package co.edu.uniquindio.labCollections.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.labCollections.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class menuController {

	private static menuController instancia;

	public static menuController getInstancia() {
		return instancia;
	}

	public menuController() {instancia = this;}

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private VBox btnInventario;

	@FXML
	private VBox btnClientes;

	@FXML
	private VBox btnVender;

	@FXML
	private BorderPane centerPane;

	@FXML
	private BorderPane principalPane;

	@FXML
	private Button btnCarro;

	@FXML
	private Button btnAyuda;

	@FXML
	void irAyudaEvent(ActionEvent event) {

	}

	@FXML
	void irCarroEvent(ActionEvent event) {

	}

	@FXML
	void irClientesEvent(MouseEvent event) {
		cambiarVentana("clientes");
		principalPane.setRight(null);

	}

	@FXML
	void irInventarioEvent(MouseEvent event) {
		cambiarVentana("inventario");
		principalPane.setRight(null);

	}

	@FXML
	void irVenderEvent(MouseEvent event) {
		cambiarVentana("vender");
		principalPane.setRight(null);
	}

	@FXML
	void initialize() {
	}

	private void cambiarVentana(String fxmlname) {
		try {
			Node nodo = App.loadFXML(fxmlname);
			setCenter(nodo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void cambiarRight(String fxmlname) {
		try {
			Node nodo = App.loadFXML(fxmlname);
			setRight(nodo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setCenter(Node node) {
		centerPane.setCenter(node);
	}

	public void setRight(Node node) {
		principalPane.setRight(node);
	}

}
