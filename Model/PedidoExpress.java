package Model;

import Util.Cancelable;
import Util.Rastreable;

public class PedidoExpress extends Pedido implements Cancelable, Rastreable {


    /**
     * Constructor de la clase Pedido
     *
     * @param idPedido         Es el numero de pedido.
     * @param direccionEntrega Es la direccion donde se entregara el pedido.
     * @param distanciaKm      Es la distancia que hay desde el lugar que sale el pedido hasta el punto de entrega.
     */
    public PedidoExpress(int idPedido, String direccionEntrega, int distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }


    @Override
    public void asignarRepartidor() {
        this.repartidor = "Neymar JR";
        System.out.println("\n[Pedido Express]");
        super.asignarRepartidor();
        System.out.println("Repartidor mas cercano con disponibilidad inmediata encontrado");
        System.out.println("Pedido asignado a " + repartidor);
    }


    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("\n[Pedido Express]");
        super.asignarRepartidor();
        System.out.println("Repartidor mas cercano con disponibilidad inmediata encontrado");
        System.out.println("Pedido asignado a " + repartidor);
    }

    @Override
    public void mostrarResumen() {
        super.mostrarResumen();
        System.out.println("Tipo de Pedido: Express");
        System.out.println("Numero de Pedido: #" + idPedido);
        System.out.println("Direccion de Entrega: " + direccionEntrega);
        System.out.println("Distancia: " + distanciaKm + " KM");
    }

    @Override
    public void calcularTiempoEntrega() {

        double tiempoTotal;

        if (distanciaKm > 5){
            tiempoTotal = 15;
            System.out.println("Tiempo estimado de entrega: " + tiempoTotal + " minutos" );
        } else {
            tiempoTotal = 10;
            System.out.println("Tiempo estimado de entrega: " + tiempoTotal + " minutos" );
        }

    }

    @Override
    public void cancelar() {

        System.out.println("Cancelando pedido express...");
        System.out.println("Pedido cancelado exitosamente.");
    }

    @Override
    public void verHistorial() {

        System.out.println("-PedidoExpress #" + idPedido + " - entregado por " + repartidor);
    }
}
