package controllers;

import entities.Carta;
import entities.DBconnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBcontroller {

    List<Carta> letterList = new ArrayList<Carta>();

    public void FirstReading(List<Carta> letterList){

        Connection con = DBconnection.getCon();
        try {
            String query = "select * from carta";

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
    }
    public void AnadirCartaDB(Carta carta) {

        String direccion = carta.getDireccionEntrega();
        String identificador = Integer.toString(carta.getIdentificador());
        String owner = Integer.toString(carta.getOwner());
        String servicio = carta.getTipoServicio();

        Connection con = DBconnection.getCon();
        try {

            String query = "insert into bartleby.carta(idcarta,direccionEntrega,tipoServicio,owner) values("+identificador+","+direccion+","+servicio+","+owner+")";
            System.out.println(query);
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

        } catch (Exception e) {
            System.out.println("Error en la conexion con la base de datos");
        }


    }
}
