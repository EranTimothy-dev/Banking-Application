module commercial.bankingapplication {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires de.jensd.fx.glyphs.fontawesome;
    requires org.xerial.sqlitejdbc;

    opens commercial.bankingapplication to javafx.fxml;
    exports commercial.bankingapplication;
    exports commercial.bankingapplication.Controllers;
    exports commercial.bankingapplication.Controllers.Admin;
    exports commercial.bankingapplication.Controllers.Client;
    exports commercial.bankingapplication.Models;
    exports commercial.bankingapplication.Views;
}