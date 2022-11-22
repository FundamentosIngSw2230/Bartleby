package entities;

import controllers.DBcontroller;
import controllers.InterfaceController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Planificacion {
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

        Envio ev = Envio.getInstance();

        ev.recibirRuta(direcciones);


    }
    public boolean agregarAPlan(Carta current_carta){

        cartas.add(current_carta);
        boolean done = false;

        for(int i=0; i < cartas.size(); i++){
            if(i == cartas.size()-1) {
                if (current_carta.getIdentificador() == cartas.get(i).getIdentificador()) {
                    done = true;
                }
            }
        }
        return done;

    }

    public int findId(){
        int idant = 0;
        DBcontroller ctrl = new DBcontroller();
        idant = ctrl.findIdentifcador();

        return idant;
    }
}
