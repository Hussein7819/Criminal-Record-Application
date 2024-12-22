module com.example.criminalrecordproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.criminalrecordproject to javafx.fxml;
    exports com.example.criminalrecordproject;
}