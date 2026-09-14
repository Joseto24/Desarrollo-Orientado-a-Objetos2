package Model;

import Util.EstadoPedido;

import java.util.concurrent.ThreadLocalRandom;

public class Repartidor implements Runnable{

    private final String nombre;
    private final ZonaDeCarga zonaDeCarga;


    public Repartidor(String nombre, ZonaDeCarga zonaDeCarga) {
        this.nombre = nombre;
        this.zonaDeCarga = zonaDeCarga;
    }

    @Override
    public void run() {

        while (true) {

            PedidoV2 pedidoV2 = zonaDeCarga.retirarPedido();

            if (pedidoV2 == null) {
                System.out.println("No hay pedidos para retirar");
                break;
            }

            System.out.println("[Repartidor - " + nombre +
                                "] Retirando pedido " +
                                pedidoV2.getPedidoId() + "...");

            pedidoV2.cambiarEstado(EstadoPedido.EN_REPARTO);

            System.out.println("[Repartidor - " +
                                nombre +
                                "] Estado: " +
                                pedidoV2.getEstado());

            System.out.println("Entregando pedido " +
                                pedidoV2.getPedidoId() + "...");

            try {
                Thread.sleep(
                        ThreadLocalRandom.current().nextInt(1000,2000)
                );
            }catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }

            pedidoV2.cambiarEstado(EstadoPedido.ENTREGADO);

            System.out.println("[Repartidor - " +
                                nombre +
                                "] Estado: " + pedidoV2.getEstado());

        }
    }
}
