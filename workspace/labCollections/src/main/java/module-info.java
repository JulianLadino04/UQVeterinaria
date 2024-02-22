module co.edu.uniquindio {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;

    opens co.edu.uniquindio.labCollections.controllers to javafx.fxml;
    exports co.edu.uniquindio;
}

