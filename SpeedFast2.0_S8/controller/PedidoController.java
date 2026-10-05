package controller;

import dao.PedidoDAO;
import dao.impl.PedidoDAOimpl;
import model.Pedido;

import java.sql.SQLException;
import java.util.List;

public class PedidoController {

    private final PedidoDAO pedidoDAO;

    public PedidoController() {
        this.pedidoDAO = new PedidoDAOimpl();
    }

    public boolean guardar(Pedido pedido) throws SQLException {
        if (pedido.getDireccionPedido().isEmpty() || pedido.getTipoPedido().isEmpty()) {
            return false;
        }
        return pedidoDAO.create(pedido);

    }

    public List<Pedido> listar() throws SQLException {
        return pedidoDAO.readAll();
    }

    public boolean actualizar(Pedido pedido) throws SQLException {
        if (pedido.getDireccionPedido().isEmpty() || pedido.getTipoPedido().isEmpty()) {
            return false;
        }

        return pedidoDAO.update(pedido);
    }

    public boolean eliminar(int id) throws SQLException {
        if (id > 0)  {
            return pedidoDAO.delete(id);
        }
        return false;
    }

}
