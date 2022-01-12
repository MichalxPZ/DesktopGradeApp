module pl.poznan.pl.michalxpz.desktopgradeapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;

    opens pl.poznan.pl.michalxpz.desktopgradeapp to javafx.fxml;
    exports pl.poznan.pl.michalxpz.desktopgradeapp;
    exports pl.poznan.pl.michalxpz.desktopgradeapp.controllers;
    opens pl.poznan.pl.michalxpz.desktopgradeapp.controllers to javafx.fxml;
}