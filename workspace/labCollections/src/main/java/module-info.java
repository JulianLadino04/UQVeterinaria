module co.edu.uniquindio {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.desktop;
	requires com.fasterxml.jackson.databind;

    opens co.edu.uniquindio.labCollections.controllers to javafx.fxml;
    
    exports co.edu.uniquindio;
}

