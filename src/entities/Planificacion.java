package entities;

import controllers.DBcontroller;
import controllers.InterfaceController;
import entities.Carta;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Planificacion {

    private int cantiCartas;
    private List<Carta> cartas = new ArrayList<Carta>();

    public Planificacion() {
    }

    public List<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }

    public void organizarCartas(ArrayList<Carta> cartas){

    }

    public void agregarCarta(Carta carta) {

        DBcontroller db = new DBcontroller();
        cartas.add(carta);

        db.AnadirCartaDB(carta);



    }

    public int findId(){
        int idant = 0;
        DBcontroller ctrl = new DBcontroller();
        idant = ctrl.findIdentifcador();

        return idant;
    }
}
