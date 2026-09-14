package Model;

import java.util.ArrayDeque;
import java.util.Queue;


public class ZonaDeCarga {

    private final Queue<PedidoV2> pedidos = new ArrayDeque<>();

    public synchronized void agregarPedido(PedidoV2 pedido){
        pedidos.offer(pedido);
    }

    public synchronized PedidoV2 retirarPedido() {
        return pedidos.poll();
    }
}
