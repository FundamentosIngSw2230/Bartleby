package entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBconnection {

    static Connection con = null;

    private DBconnection (){

    }

    public static Connection getCon (){

        String url = "jdbc:mysql://localhost:3306/bartleby";
        String user ="root";
        String password ="PHSGOMNYDLHSLWTW";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url,user,password);
            System.out.println("successfully connected to the database "+url);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return con;
    }





}
