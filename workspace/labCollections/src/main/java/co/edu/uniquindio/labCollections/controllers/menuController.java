package co.edu.uniquindio.labCollections.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class menuController {

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

    }

    @FXML
    void irInventarioEvent(MouseEvent event) {
    	cambiarVentana("inventario");

    }

    @FXML
    void irVenderEvent(MouseEvent event) {

    }

    @FXML
    void initialize() {

    }
    
    private void cambiarVentana(String fxmlname) { 		
    	try { 			
    		Node nodo = App.loadFXML(fxmlname); 			
    		setCenter(nodo); 		
    		} 
    	catch (IOException e) { 			
    		e.printStackTrace(); 		
    		} 	
    	}  	
    
    public void setCenter(Node node){ 		
    	centerPane.setCenter(node); 	
    	}
}
