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

        Connection con = DBconnection.getCon();

        try{
            String query = "select * from carta";

            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);




            while(resultSet.next()){

                //System.out.println(resultSet.getString(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getString(4));

                Carta carta = new Carta();
                carta.setIdentificador(Integer.parseInt(resultSet.getString(1)));
                carta.setDireccionEntrega(resultSet.getString(2));
                carta.setTipoServicio(resultSet.getString(3));
                carta.setOwner(Integer.parseInt(resultSet.getString(4)));

                letterList.add(carta);


            }

        }catch (Exception e){
            System.out.println("Error en la conexion con la base de datos");
        }


    }

}