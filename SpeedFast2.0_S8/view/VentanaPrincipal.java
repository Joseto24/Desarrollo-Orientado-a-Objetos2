package view;

import controller.PedidoController;
import controller.RepartidorController;
import controller.EntregaController;
import model.Pedido;
import model.Repartidor;
import model.Entrega;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class VentanaPrincipal extends JFrame {

    private final PedidoController pedidoController;
    private final RepartidorController repartidorController;
    private final EntregaController entregaController;

    private JTable tablaPedidos;
    private JTable tablaEntregas;

    public VentanaPrincipal() {
        pedidoController = new PedidoController();
        repartidorController = new RepartidorController();
        entregaController = new EntregaController();

        setTitle("SpeedFast - Gestión de Pedidos y Entregas");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        // Botones principales
        JPanel panelBotones = new JPanel();
        JButton btnRegistrarPedido = new JButton("Registrar Pedido");
        JButton btnListarPedidos = new JButton("Listar Pedidos");
        JButton btnRegistrarRepartidor = new JButton("Registrar Repartidor");
        JButton btnAsignarEntrega = new JButton("Asignar Entrega");
        JButton btnListarEntregas = new JButton("Listar Entregas");

        panelBotones.add(btnRegistrarPedido);
        panelBotones.add(btnListarPedidos);
        panelBotones.add(btnRegistrarRepartidor);
        panelBotones.add(btnAsignarEntrega);
        panelBotones.add(btnListarEntregas);

        panel.add(panelBotones, BorderLayout.NORTH);

        // Tablas
        tablaPedidos = new JTable();
        tablaEntregas = new JTable();

        JTabbedPane pestañas = new JTabbedPane();
        pestañas.addTab("Pedidos", new JScrollPane(tablaPedidos));
        pestañas.addTab("Entregas", new JScrollPane(tablaEntregas));

        panel.add(pestañas, BorderLayout.CENTER);

        // Eventos
        btnRegistrarPedido.addActionListener(e -> registrarPedido());
        btnListarPedidos.addActionListener(e -> listarPedidos());
        btnRegistrarRepartidor.addActionListener(e -> registrarRepartidor());
        btnAsignarEntrega.addActionListener(e -> asignarEntrega());
        btnListarEntregas.addActionListener(e -> listarEntregas());

        setContentPane(panel);
        setVisible(true);
    }

    private void registrarPedido() {
        String direccion = JOptionPane.showInputDialog(this, "Dirección del pedido:");
        String tipo = JOptionPane.showInputDialog(this, "Tipo de pedido:");
        String estado = "PENDIENTE";

        try {
            Pedido pedido = new Pedido(direccion, tipo, estado);
            if (pedidoController.guardar(pedido)) {
                JOptionPane.showMessageDialog(this, "Pedido registrado con éxito");
            } else {
                JOptionPane.showMessageDialog(this, "Error: datos inválidos");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error BD: " + ex.getMessage());
        }
    }

    private void listarPedidos() {
        try {
            var pedidos = pedidoController.listar();
            String[] columnas = {"ID", "Dirección", "Tipo", "Estado"};
            Object[][] datos = new Object[pedidos.size()][4];
            for (int i = 0; i < pedidos.size(); i++) {
                datos[i][0] = pedidos.get(i).getIdPedido();
                datos[i][1] = pedidos.get(i).getDireccionPedido();
                datos[i][2] = pedidos.get(i).getTipoPedido();
                datos[i][3] = pedidos.get(i).getEstadoPedido();
            }
            tablaPedidos.setModel(new javax.swing.table.DefaultTableModel(datos, columnas));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error BD: " + ex.getMessage());
        }
    }

    private void registrarRepartidor() {
        String nombre = JOptionPane.showInputDialog(this, "Nombre del repartidor:");
        try {
            Repartidor r = new Repartidor(nombre);
            if (repartidorController.guardar(r)) {
                JOptionPane.showMessageDialog(this, "Repartidor registrado con éxito");
            } else {
                JOptionPane.showMessageDialog(this, "Error: nombre inválido");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error BD: " + ex.getMessage());
        }
    }

    private void asignarEntrega() {
        try {
            JComboBox<Pedido> comboPedidos = new JComboBox<>(pedidoController.listar().toArray(new Pedido[0]));
            JComboBox<Repartidor> comboRepartidores = new JComboBox<>(repartidorController.listar().toArray(new Repartidor[0]));

            JPanel panel = new JPanel(new GridLayout(2, 2));
            panel.add(new JLabel("Pedido:"));
            panel.add(comboPedidos);
            panel.add(new JLabel("Repartidor:"));
            panel.add(comboRepartidores);

            int result = JOptionPane.showConfirmDialog(this, panel, "Asignar Entrega", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                Pedido pedido = (Pedido) comboPedidos.getSelectedItem();
                Repartidor repartidor = (Repartidor) comboRepartidores.getSelectedItem();

                if (entregaController.guardar(pedido, repartidor)) {
                    JOptionPane.showMessageDialog(this, "Entrega asignada con éxito");
                } else {
                    JOptionPane.showMessageDialog(this, "Error al asignar entrega");
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error BD: " + ex.getMessage());
        }
    }

    private void listarEntregas() {
        try {
            var entregas = entregaController.listar();
            String[] columnas = {"ID", "Pedido", "Repartidor", "Fecha", "Hora"};
            Object[][] datos = new Object[entregas.size()][5];
            for (int i = 0; i < entregas.size(); i++) {
                datos[i][0] = entregas.get(i).getIdEntrega();
                datos[i][1] = entregas.get(i).getIdPedido();
                datos[i][2] = entregas.get(i).getIdRepartidor();
                datos[i][3] = entregas.get(i).getFechaEntrega();
                datos[i][4] = entregas.get(i).getHoraEntrega();
            }
            tablaEntregas.setModel(new javax.swing.table.DefaultTableModel(datos, columnas));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error BD: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(VentanaPrincipal::new);
    }
}
