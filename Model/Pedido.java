package Model;

/**
 * Esta es una clase abstracta que
 * se extiende a las clases PedidoComida,
 * PedidoEncomienda y PedidoExpress.
 */

public abstract class Pedido {

    // Definimos atributos en comun.

    protected int idPedido;
    protected String direccionEntrega;
    protected int distanciaKm;
    protected String repartidor;


    /**
     * Constructor de la clase Pedido
     *
     * @param idPedido Es el numero de pedido.
     * @param direccionEntrega Es la direccion donde se entregara el pedido.
     * @param distanciaKm Es la distancia que hay desde el lugar que sale el pedido hasta el punto de entrega.
     */

    public Pedido(int idPedido, String direccionEntrega, int distanciaKm) {
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.distanciaKm = distanciaKm;
    }

    public void asignarRepartidor(){
        System.out.println("Asignando Repartidor...");
    }

    public void asignarRepartidor(String nombre){
        this.repartidor = nombre;
    }

    public void mostrarResumen(){
        System.out.println("\nDETALLES DEL PEDIDO");
    }

    public abstract void calcularTiempoEntrega();

}
