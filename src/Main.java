import entities.Carta;
import entities.DBconnection;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent homeRoot = FXMLLoader.load(getClass().getResource("resources/Inicio.fxml"));
        primaryStage.setTitle("Bartleby");
        Scene home = new Scene(homeRoot);

        primaryStage.setScene(home);
        primaryStage.show();
    }
    public static void main(String[] args) {

        launch(args);

        List<Carta> letterList = new ArrayList<Carta>();
        int i=0;




    }

}