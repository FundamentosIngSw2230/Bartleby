package entities;

import controllers.DBcontroller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBconnection {

    static Connection con = null;

    public DBconnection (){

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

    public void InitialReading() {

        List<Carta> letterList = new ArrayList<Carta>();
        DBcontroller control = new DBcontroller();

        control.FirstReading(letterList);

    }

}
