package Bartleby;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/bartleby";
        String user ="root";
        String password ="PHSGOMNYDLHSLWTW";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,user,password);
            System.out.println("successfully connected to the database "+url);
            String query ="Insert into bartleby.carta(idcarta,direccionEntrega,tipoServicio,owner) values (101,'cra 123 #45-67','0',102)";
            Statement statement = connection.createStatement();

            statement.executeUpdate(query);

        } catch (ClassNotFoundException e) {
                e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}