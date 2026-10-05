package model;

public class Repartidor {

    private int idRepartidor;
    private String nombreRepartidor;


    // Constructor para CREAR.
    public Repartidor(String nombreRepartidor) {
        this.nombreRepartidor = nombreRepartidor;
    }

    //Constructor para LEER o ACTUALIZAR
    public Repartidor(int idRepartidor, String nombreRepartidor) {
        this.idRepartidor = idRepartidor;
        this.nombreRepartidor = nombreRepartidor;
    }

    public int getIdRepartidor() {
        return idRepartidor;
    }

    public String getNombreRepartidor() {
        return nombreRepartidor;
    }

    public void setNombreRepartidor(String nombreRepartidor) {
        this.nombreRepartidor = nombreRepartidor;
    }

    @Override
    public String toString() {
        return "Repartidor #" + idRepartidor + " - " + nombreRepartidor;
    }
}
