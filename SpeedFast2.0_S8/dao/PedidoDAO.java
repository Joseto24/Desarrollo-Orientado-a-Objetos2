package dao;

import model.Pedido;

import java.sql.SQLException;
import java.util.List;

public interface PedidoDAO {

    // Operaciones para realizar sobre PEDIDO.

    // CRUD --> CREATE, READ, UPDATE Y DELETE.

    // CREATE
    boolean create(Pedido pedido) throws SQLException;

    // READ
    List<Pedido> readAll() throws SQLException;

    // UPDATE
    boolean update(Pedido pedido) throws SQLException;

    // DELETE
    boolean delete(int id) throws SQLException;
}
