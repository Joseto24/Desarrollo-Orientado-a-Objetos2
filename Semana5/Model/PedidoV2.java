package Model;

import Util.EstadoPedido;

public class PedidoV2 {

    private final int pedidoId;
    private final String direccionDeEntrega;
    private EstadoPedido estado;


    public PedidoV2(int pedidoId, String direccionDeEntrega) {
        this.pedidoId = pedidoId;
        this.direccionDeEntrega = direccionDeEntrega;
        this.estado = EstadoPedido.PENDIENTE;
    }

    public int getPedidoId() {
        return pedidoId;
    }

    public String getDireccionDeEntrega() {
        return direccionDeEntrega;
    }

    public synchronized EstadoPedido getEstado() {
        return estado;
    }

    public synchronized void cambiarEstado(EstadoPedido nuevoEstado) {
        this.estado = nuevoEstado;
    }
}
