package model;

public class Pedido {

    private int idPedido;
    private String direccionPedido;
    private String tipoPedido;
    private String estadoPedido;


    // Constructor para CREAR un Pedido.
    public Pedido(String direccionPedido, String tipoPedido, String estadoPedido) {
        this.direccionPedido = direccionPedido;
        this.tipoPedido = tipoPedido;
        this.estadoPedido = estadoPedido;
    }

    // Constructor para LEER o ACTUALIZAR Pedido.


    public Pedido(int idPedido, String direccionPedido, String tipoPedido, String estadoPedido) {
        this.idPedido = idPedido;
        this.direccionPedido = direccionPedido;
        this.tipoPedido = tipoPedido;
        this.estadoPedido = estadoPedido;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public String getDireccionPedido() {
        return direccionPedido;
    }

    public void setDireccionPedido(String direccionPedido) {
        this.direccionPedido = direccionPedido;
    }

    public String getTipoPedido() {
        return tipoPedido;
    }

    public void setTipoPedido(String tipoPedido) {
        this.tipoPedido = tipoPedido;
    }

    public String getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(String estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    @Override
    public String toString() {
        return "Pedido #" + idPedido + " - " + direccionPedido + " (" + tipoPedido + ")";
    }
}
