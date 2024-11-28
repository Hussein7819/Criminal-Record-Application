module com.example.criminalrecordproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.criminalrecordproject to javafx.fxml;
    exports com.example.criminalrecordproject;
}