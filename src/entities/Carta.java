package entities;

public class Carta {

    private int identificador;
    private String direccionEntrega;
    private String tipoServicio;
    private int owner;
    private int disponibilidadEntrega;

    public Carta() { }

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

    public int getDisponibilidadEntrega() {
        return disponibilidadEntrega;
    }

    public void setDisponibilidadEntrega(int disponibilidadEntrega) {
        this.disponibilidadEntrega = disponibilidadEntrega;
    }
}
