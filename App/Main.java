package App;


import Model.*;
import Util.Rastreable;
import Util.Cancelable;

public class Main {

    public static void main(String[] args) {

        ControladorDeEnvios controlador = new ControladorDeEnvios();

        PedidoComida comida1 = new PedidoComida(101, "Santa Juana 123", 6);
        PedidoComida comida2 = new PedidoComida(102, "Los alerces 15", 8);
        PedidoEncomienda encomienda1 = new PedidoEncomienda(103, "Las rosas 175", 12);
        PedidoExpress express1 = new PedidoExpress(104, "Los claveles 105", 9);


        comida1.asignarRepartidor("José Cornejo");
        comida1.calcularTiempoEntrega();
        comida1.despachar();


        comida2.asignarRepartidor();
        comida2.calcularTiempoEntrega();
        comida2.despachar();

        encomienda1.asignarRepartidor();
        encomienda1.calcularTiempoEntrega();
        encomienda1.despachar();

        express1.asignarRepartidor();
        express1.calcularTiempoEntrega();
        express1.cancelar();

        controlador.registrarPedido(comida1);
        controlador.registrarPedido(comida2);
        controlador.registrarPedido(encomienda1);

        controlador.verHistorial();


    }
}
