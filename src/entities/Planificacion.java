package entities;

import controllers.DBcontroller;

import java.util.ArrayList;
import java.util.List;

public class Planificacion {

    private int cantiCartas;
    private List<Carta> cartas = new ArrayList<Carta>();

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

    public void organizarCartas(ArrayList<Carta> cartas){

    }

    public void agregarCarta(Carta carta) {

        DBcontroller db = new DBcontroller();
        cartas.add(carta);
        cantiCartas++;

        db.AnadirCartaDB(carta);

    }

    public void OrganizarCartas(){




    }

    public int findId(){
        int idant = 0;
        DBcontroller ctrl = new DBcontroller();
        idant = ctrl.findIdentifcador();

        return idant;
    }
}
