package App;


import Model.*;
import Util.Rastreable;
import Util.Cancelable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        System.out.println("[ZONA DE CARGA INICIALIZADA]");

        ZonaDeCarga zona = new ZonaDeCarga();

        zona.agregarPedido(
                new PedidoV2(1, "Arturo Pratt 15")
        );

        zona.agregarPedido(
                new PedidoV2(2, "Manuel Montt 25")
        );

        zona.agregarPedido(
                new PedidoV2(3, "Las Rosas 244")
        );

        zona.agregarPedido(
                new PedidoV2(4, "Los Claveles 10")
        );

        zona.agregarPedido(
                new PedidoV2(5, "Los Robles 155")
        );

        zona.agregarPedido(
                new PedidoV2(6, "Los Alerces 106")
        );

        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.submit(new Repartidor("Ivette", zona));
        executor.submit(new Repartidor("Jose", zona));
        executor.submit(new Repartidor("Ragnar", zona));

        executor.shutdown();

        try {
            boolean entregados = executor.awaitTermination(30, TimeUnit.SECONDS);
            if (!entregados) {
                System.out.println("Se agoto el tiempo de espera");
            }else{
                System.out.println("\nTodos los Pedidos Fueron entregados correctamente");
            }
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            executor.shutdownNow();
        }


    }
}
