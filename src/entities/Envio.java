package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Envio {

    private int idcarta;
    private int estado;
    private int tiempoTotal;
    List<Carta> cartasEnvio = new ArrayList<Carta>();
    public void recibirRuta(String[] ruta){


        Connection con = DBconnection.getCon();
        Carta carta = new Carta();
        try {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM bartleby.carta");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                for (String a : ruta){

                    if(a == rs.getString(5)){
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
    public void EntregarCarta(int tiempo, int estado){

    }
}
