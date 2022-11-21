package entities;

import controllers.DBcontroller;
import controllers.InterfaceController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Planificacion {

    private int cantiCartas;
    private List<Carta> cartas = new ArrayList<Carta>();

    String direcciones[] = null;

    public Planificacion() {
    }

    public List<Carta> getCartas() {
        return cartas;
    }
    public void setCartas(List<Carta> cartas) {
        this.cartas = cartas;
    }

    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }

    public void agregarCarta(Carta carta) {

        DBcontroller db = new DBcontroller();
        db.AnadirCartaDB(carta);
    }


    public void OrganizarCartas(String ruta){

        direcciones = ruta.split("\n");
        Envio ev = new Envio();

        ev.recibirRuta(direcciones);


    }
    public void agregarAPlan(Carta current_carta){

        cartas.add(current_carta);

    }

    public int findId(){
        int idant = 0;
        DBcontroller ctrl = new DBcontroller();
        idant = ctrl.findIdentifcador();

        return idant;
    }
}
