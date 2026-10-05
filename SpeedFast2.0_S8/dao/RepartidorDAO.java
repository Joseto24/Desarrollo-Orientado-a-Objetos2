package dao;

import model.Repartidor;

import java.sql.SQLException;
import java.util.List;

public interface RepartidorDAO {

    // Operaciones para realizar sobre REPARTIDOR.

    // CRUD --> CREATE, READ, UPDATE Y DELETE.

    // CREATE
    boolean create(Repartidor repartidor) throws SQLException;

    // READ
    List<Repartidor> readAll() throws SQLException;

    // UPDATE
    boolean update(Repartidor repartidor) throws SQLException;

    // DELETE
    boolean delete(int id) throws SQLException;
}
