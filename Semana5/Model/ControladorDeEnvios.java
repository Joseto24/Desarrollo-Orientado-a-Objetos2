package Model;

import Util.Rastreable;

import java.util.ArrayList;

public class ControladorDeEnvios {

    private static ArrayList<Rastreable> pedidos = new ArrayList<>();

    public void registrarPedido(Rastreable pedido) {
        pedidos.add(pedido);
    }


    public void verHistorial() {
        System.out.println("\nHistorial de Pedidos:");

        for (Rastreable pedido : pedidos) {
            pedido.verHistorial();
        }
    }
}
