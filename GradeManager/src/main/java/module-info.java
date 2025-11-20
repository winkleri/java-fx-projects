module org.example.pm2vier {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.pm2vier to javafx.fxml;
    exports org.example.pm2vier;
    exports org.example.pm2vier.MVC;
    opens org.example.pm2vier.MVC to javafx.fxml;
}