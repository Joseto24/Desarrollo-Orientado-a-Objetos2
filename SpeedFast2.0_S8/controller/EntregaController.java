package controller;

import dao.EntregaDAO;
import dao.impl.EntregaDAOimpl;
import model.Entrega;
import model.Pedido;
import model.Repartidor;

import java.sql.SQLException;
import java.util.List;

public class EntregaController {

    private final EntregaDAO entregaDAO;

    public EntregaController() {
        this.entregaDAO = new EntregaDAOimpl();
    }

    public boolean guardar(Pedido pedido, Repartidor repartidor) throws SQLException {
        if (pedido == null || repartidor == null) {
            return false;
        }
        Entrega entrega = new Entrega(pedido.getIdPedido(),  repartidor.getIdRepartidor());
        return entregaDAO.create(entrega);
    }

    public List<Entrega>  listar() throws SQLException {
        return entregaDAO.readAll();
    }

    public boolean actualizar(Entrega entrega) throws SQLException {
        if (entrega.getIdPedido() <= 0 || entrega.getIdRepartidor() <= 0) {
            return false;
        }
        return entregaDAO.update(entrega);
    }

    public boolean eliminar(int id) throws SQLException {
        if (id > 0) {
            return entregaDAO.delete(id);
        }
        return false;
    }






}
