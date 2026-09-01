package Model;

import Util.Despachable;
import Util.Rastreable;

public class PedidoEncomienda extends Pedido implements Despachable, Rastreable {

    /**
     * Constructor de la clase Pedido
     *
     * @param idPedido         Es el numero de pedido.
     * @param direccionEntrega Es la direccion donde se entregara el pedido.
     * @param distanciaKm      Es la distancia que hay desde el lugar que sale el pedido hasta el punto de entrega.
     */
    public PedidoEncomienda(int idPedido, String direccionEntrega, int distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }


    @Override
    public void asignarRepartidor() {
        this.repartidor = "Leo Messi";
        System.out.println("\n[Pedido Encomienda]");
        super.asignarRepartidor();
        System.out.println("Validando peso y embalaje...");
        System.out.println("Peso y embalaje OK");
        System.out.println("Pedido asignado a " + repartidor);
    }


    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("\n[Pedido Encomienda]");
        super.asignarRepartidor();
        System.out.println("Validando peso y embalaje...");
        System.out.println("Peso y embalaje OK");
        System.out.println("Pedido asignado a " + repartidor);
    }

    @Override
    public void mostrarResumen() {
        super.mostrarResumen();
        System.out.println("Tipo de Pedido: Encomienda");
        System.out.println("Numero de Pedido: #" + idPedido);
        System.out.println("Direccion de Entrega: " + direccionEntrega);
        System.out.println("Distancia: " + distanciaKm + " KM");
    }

    @Override
    public void calcularTiempoEntrega() {

        double tiempoTotal = 20 + (1.5 * distanciaKm);
        System.out.println("Tiempo estimado de entrega: " + tiempoTotal + " minutos" );
    }

    @Override
    public void despachar() {

        System.out.println("Despachando pedido...");
        System.out.println("Pedido despachado correctamente.");
    }

    @Override
    public void verHistorial() {

        System.out.println("-PedidoEncomienda #" + idPedido + " - entregado por " + repartidor);
    }
}