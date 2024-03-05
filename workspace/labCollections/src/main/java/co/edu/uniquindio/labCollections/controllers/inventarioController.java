package co.edu.uniquindio.labCollections.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.labCollections.model.Producto;
import co.edu.uniquindio.labCollections.utils.UtilsFX;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

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
    	//TODO Esto no es necesario
    }

    @FXML
    void irAgregarProductoEvent(ActionEvent event) {
    	//TODO Revisen este codigo por si lo necesitan, de otra manera borrenlo. ElJuancho
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
    	UtilsFX.setAsIntegerTextfield(txtBuscar);
    	
    	txtBuscar.textProperty().addListener((observable, oldValue, newValue) -> {
    		actualizarTabla(Long.valueOf(newValue));
    	});
    }

	private void actualizarTabla(Long codigo) {
		tablaInventario.setItems(FXCollections.observableArrayList(ModelFactoryController.getIntance().filtrarInventario(codigo)));
		tablaInventario.refresh();
	}
}
