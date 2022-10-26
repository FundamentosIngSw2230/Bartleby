import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
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