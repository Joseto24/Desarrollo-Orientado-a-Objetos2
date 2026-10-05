package dao;

import model.Entrega;

import java.sql.SQLException;
import java.util.List;

public interface EntregaDAO {

    // Operaciones para realizar sobre una ENTREGA.

    // CRUD --> CREATE, READ, UPDATE Y DELETE.

    // CREATE
    boolean create(Entrega entrega) throws SQLException;

    // READ
    List<Entrega> readAll() throws SQLException;

    // UPDATE
    boolean update(Entrega entrega) throws SQLException;

    // DELETE
    boolean delete(int id) throws SQLException;
}
