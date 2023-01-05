module com.jose {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    opens com.jose to javafx.fxml;
    exports com.jose;
}
