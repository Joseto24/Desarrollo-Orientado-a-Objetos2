package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Entrega {

    private int idEntrega;
    private int idPedido;
    private int idRepartidor;
    private LocalDate fechaEntrega;
    private LocalTime horaEntrega;

    // Constructor para CREAR una nueva Entrega.
    public Entrega(int idPedido, int idRepartidor) {
        this.idPedido = idPedido;
        this.idRepartidor = idRepartidor;
        this.fechaEntrega = LocalDate.now();
        this.horaEntrega = LocalTime.now();
    }

    // Constructor para LEER o ACTUALIZAR una Entrega.


    public Entrega(int idEntrega, int idPedido, int idRepartidor, LocalDate fechaEntrega, LocalTime horaEntrega) {
        this.idEntrega = idEntrega;
        this.idPedido = idPedido;
        this.idRepartidor = idRepartidor;
        this.fechaEntrega = fechaEntrega;
        this.horaEntrega = horaEntrega;
    }

    public int getIdEntrega() {
        return idEntrega;
    }

    public void setIdEntrega(int idEntrega) {
        this.idEntrega = idEntrega;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdRepartidor() {
        return idRepartidor;
    }

    public void setIdRepartidor(int idRepartidor) {
        this.idRepartidor = idRepartidor;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public LocalTime getHoraEntrega() {
        return horaEntrega;
    }

    public void setHoraEntrega(LocalTime horaEntrega) {
        this.horaEntrega = horaEntrega;
    }


    @Override
    public String toString() {
        return "Entrega #" + idEntrega +
                " - Pedido #" + idPedido +
                " asignado a Repartidor #" + idRepartidor +
                " [" + fechaEntrega + " " + horaEntrega + "]";
    }
}
