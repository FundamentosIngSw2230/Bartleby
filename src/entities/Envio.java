package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Envio {


    List<Carta> cartasEnvio = new ArrayList<Carta>();

    private static Envio instance;

    private Envio()
    {
        // private constructor
    }

    //method to return instance of class
    public static Envio getInstance()
    {
        if (instance == null)
        {
            // if instance is null, initialize
            instance = new Envio();
        }
        return instance;
    }


    public List<Carta> getCartasEnvio() {
        return cartasEnvio;
    }

    public void recibirRuta(String[] ruta){


        Connection con = DBconnection.getCon();

        try {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM bartleby.carta");
            ResultSet rs = pst.executeQuery();

            for (String a : ruta){
                System.out.println(a);
                rs.beforeFirst();
                while (rs.next()){

                    System.out.println("repito");

                    if(a.equals(rs.getString(2))){
                        Carta carta = new Carta();
                        carta.setIdentificador(Integer.parseInt(rs.getString(1)));
                        carta.setDireccionEntrega(rs.getString(2));
                        carta.setTipoServicio(rs.getString(3));
                        carta.setOwner(Integer.parseInt(rs.getString(4)));
                        carta.setDisponibilidadEntrega(LocalDate.parse(rs.getString(5)));
                        cartasEnvio.add(carta);

                    }
                }

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public String estadoCarta(int e){

        String estado = "en entrega";

        if(e == 0){
            estado = "no entregada";

        }else if(e == 1){
            estado = "entregada";
        }

        return estado;


    }

}
