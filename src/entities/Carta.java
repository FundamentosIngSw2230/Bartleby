package entities;

import java.time.LocalDate;
import java.util.Date;

public class Carta {

    private int identificador;
    private String direccionEntrega;
    private String tipoServicio;
    private int owner;
    private LocalDate disponibilidadEntrega;

    public Carta() {
    }

    public Carta(int identificador,String direccionEntrega, String tipoServicio,int owner, LocalDate disponibilidadEntrega) {
        this.identificador = identificador;
        this.direccionEntrega = direccionEntrega;
        this.tipoServicio = tipoServicio;
        this.owner = owner;
        this.disponibilidadEntrega = disponibilidadEntrega;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public LocalDate getDisponibilidadEntrega() {
        return disponibilidadEntrega;
    }

    public void setDisponibilidadEntrega(LocalDate disponibilidadEntrega) {
        this.disponibilidadEntrega = disponibilidadEntrega;
    }


}
