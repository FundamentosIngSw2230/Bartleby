package entities;

public class Carta {

    private int identificador;
    private String direccionEntrega;
    private char tipoServicio;
    private int owner;

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

    public char getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(char tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }
}
