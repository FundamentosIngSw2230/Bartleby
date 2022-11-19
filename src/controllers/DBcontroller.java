package controllers;

import entities.Carta;
import entities.DBconnection;
import javafx.collections.ObservableList;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DBcontroller {

    List<Carta> letterList = new ArrayList<Carta>();

    public List<Carta> FirstReading(List<Carta> letterList){

        Connection con = DBconnection.getCon();
        try {
            String query = "select * from bartleby.carta";

            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);


            while (resultSet.next()) {

                //System.out.println(resultSet.getString(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getString(4));
                Carta carta = new Carta();
                carta.setIdentificador(Integer.parseInt(resultSet.getString(1)));
                carta.setDireccionEntrega(resultSet.getString(2));
                carta.setTipoServicio(resultSet.getString(3));
                carta.setOwner(Integer.parseInt(resultSet.getString(4)));

                letterList.add(carta);

            }

        } catch (Exception e) {
            System.out.println("Error en la conexion con la base de datos");
        }

        return letterList;
    }

    public int findIdentifcador(){

        Connection con = DBconnection.getCon();
        int id=0;

        try {

            System.out.println("Entro en try");
            String idquery = "SELECT * from bartleby.carta ORDER BY idcarta DESC LIMIT 1";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(idquery);

            while(resultSet.next()){
                id = Integer.parseInt(resultSet.getString(1));
            }

        } catch (Exception e) {
            System.out.println("Error en la conexion con la base de datos");
            System.out.println("error en find");
        }
        return id;

    }
    public void AnadirCartaDB(Carta carta) {

        String direccion = carta.getDireccionEntrega();
        int identificador = carta.getIdentificador();
        int owner = carta.getOwner();
        String servicio = carta.getTipoServicio();
        LocalDate fecha = carta.getDisponibilidadEntrega();

        Connection con = DBconnection.getCon();
        try {

            String query = "insert into bartleby.carta(idcarta,direccionEntrega,tipoServicio,owner,disponibilidadEntrega) values("+identificador+",'"+direccion+"','"+servicio+"',"+owner+",'"+fecha+"')";
            System.out.println(query);
            Statement statement = con.createStatement();
            statement.executeUpdate(query);

        } catch (Exception e) {
            System.out.println("Error en la conexion con la base de datos");
        }


    }


}
