package entities;

import entities.DBconnection;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("Bartleby");
        Parent homeRoot = FXMLLoader.load(getClass().getResource("resources/prueba.fxml"));
        Scene home = new Scene(homeRoot);

        primaryStage.setScene(home);
        primaryStage.show();
    }
    public static void main(String[] args) {


        Connection con = DBconnection.getCon();

        try{
            String query = "select * from carta";

            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){

                System.out.println(resultSet.getString(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getString(4));

            }

        }catch (Exception e){
            System.out.println("Error en la conexion con la base de datos");
        }

    }

}