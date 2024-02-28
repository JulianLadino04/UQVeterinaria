package co.edu.uniquindio.labCollections.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.App;
import co.edu.uniquindio.labCollections.model.Producto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class inventarioController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lblTitle;

    @FXML
    private TextField txtBuscar;

    @FXML
    private Button btnAgregarProducto;
    

    @FXML
    private TableView<Producto> tablaInventario;

    @FXML
    private TableColumn<Producto, String> colCodigo;

    @FXML
    private TableColumn<Producto, String> colNombre;

    @FXML
    private TableColumn<Producto, String> colPrecio;

    @FXML
    private TableColumn<Producto, String> colCantidad;

    @FXML
    void buscarEvent(ActionEvent event) {

    }

    @FXML
    void irAgregarProductoEvent(ActionEvent event) {
    	/*
    	Stage stage= new Stage();
    	stage.setWidth(520);
    	stage.setHeight(720);
    	stage.setFullScreen(false);
    	stage.setAlwaysOnTop(true);
    	Scene scene;
		try {
			scene = new Scene(App.loadFXML("agregarProducto"));
			stage.setScene(scene);
	    	stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    */
    
    menuController.getInstancia().cambiarRight("agregarProducto");

    }

    @FXML
    void initialize() {

    }
}
