package entities;

import entities.Carta;

import java.util.LinkedList;

public class Planificacion {

    private int cantiCartas;
    private LinkedList<Carta> cartas = new LinkedList<Carta>();

    public Planificacion() {
    }

    public LinkedList<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(LinkedList<Carta> cartas) {
        this.cartas = cartas;
    }

    public void organizarCartas(LinkedList<Carta> cartas){

    }

    public boolean agregarCarta(LinkedList<Carta> cartas){

        boolean cartaAgregada = false;

        return cartaAgregada;
    }
}
