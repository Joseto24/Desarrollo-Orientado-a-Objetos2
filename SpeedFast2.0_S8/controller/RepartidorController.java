package controller;

import dao.RepartidorDAO;
import dao.impl.RepartidorDAOimpl;
import model.Repartidor;

import java.sql.SQLException;
import java.util.List;

public class RepartidorController {

    private final RepartidorDAO repartidorDAO;

    public RepartidorController() {
        this.repartidorDAO = new RepartidorDAOimpl();
    }

    public boolean guardar(Repartidor repartidor) throws SQLException {
        if (repartidor.getNombreRepartidor().isEmpty()) {
            return false;
        }
        return repartidorDAO.create(repartidor);
    }

    public List<Repartidor> listar() throws SQLException {
        return repartidorDAO.readAll();
    }

    public boolean actualizar(Repartidor repartidor) throws SQLException {
        if (repartidor.getNombreRepartidor().isEmpty()) {
            return false;
        }
        return repartidorDAO.update(repartidor);
    }

    public boolean eliminar(int id) throws SQLException {
        if (id > 0) {
            return repartidorDAO.delete(id);
        }
        return false;
    }
}
