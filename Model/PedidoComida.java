package Model;


import Util.Despachable;
import Util.Rastreable;

import java.util.ArrayList;

public class PedidoComida extends Pedido implements Despachable, Rastreable {

    private ArrayList<String> historial = new ArrayList<>();

    /**
     * Constructor de la clase Pedido
     *
     * @param idPedido         Es el numero de pedido.
     * @param direccionEntrega Es la direccion donde se entregara el pedido.
     * @param distanciaKm      Es la distancia que hay desde el lugar que sale el pedido hasta el punto de entrega.
     */
    public PedidoComida(int idPedido, String direccionEntrega, int distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    @Override
    public void asignarRepartidor() {
        this.repartidor = "Luis Suarez";
        System.out.println("\n[Pedido Comida]");
        super.asignarRepartidor();
        System.out.println("Verificando Mochila Termica...");
        System.out.println("Mochila Termica OK");
        System.out.println("Pedido asignado a " + repartidor);
    }

    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        this.repartidor = nombreRepartidor;
        System.out.println("\n[Pedido Comida]");
        super.asignarRepartidor();
        System.out.println("Verificando Mochila Termica...");
        System.out.println("Mochila Termica OK");
        System.out.println("Pedido asignado a " + repartidor);
    }


    @Override
    public void mostrarResumen() {
        super.mostrarResumen();
        System.out.println("Tipo de Pedido: Comida");
        System.out.println("Numero de Pedido: #" + idPedido);
        System.out.println("Direccion de Entrega: " + direccionEntrega);
        System.out.println("Distancia: " + distanciaKm + " KM");
    }

    @Override
    public void calcularTiempoEntrega() {

        double tiempoTotal = 15 + (2 * distanciaKm);
        System.out.println("Tiempo estimado de entrega: " + tiempoTotal + " minutos");
    }

    @Override
    public void despachar() {

        System.out.println("Recogiendo tu pedido...");
        System.out.println("Tu pedido va en camino.");
    }

    @Override
    public void verHistorial() {

        System.out.println("-PedidoComida #" + idPedido + " - entregado por " + repartidor);
    }
}


