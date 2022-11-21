import entities.Carta;
import entities.DBconnection;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("resources/Inicio.fxml"));
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();

    }
    public static void main(String[] args) {
            launch(args);
    }

}