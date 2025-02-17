module com.example.week_02 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.week_02 to javafx.fxml;
    exports com.example.week_02;
}