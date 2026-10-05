package dao.impl;

import dao.PedidoDAO;
import model.Pedido;
import util.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAOimpl implements PedidoDAO {
    @Override
    public boolean create(Pedido pedido) throws SQLException {

        String sql = "INSERT INTO pedido(tipo, direccion, estado) VALUES (?, ?, ?)";


        try (Connection con = ConexionBD.getInstance().conectar()){
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, pedido.getTipoPedido());
            ps.setString(2, pedido.getDireccionPedido());
            ps.setString(3, pedido.getEstadoPedido());

            return   ps.executeUpdate() > 0;
        }

    }

    @Override
    public List<Pedido> readAll() throws SQLException {

        String sql = "SELECT id, tipo, direccion, estado FROM pedido ORDER BY id";

        List<Pedido> pedidos = new ArrayList<>();

        try (Connection con = ConexionBD.getInstance().conectar()){
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Pedido pedido = new Pedido(
                        rs.getInt("id"),
                        rs.getString("tipo"),
                        rs.getString("direccion"),
                        rs.getString("estado")
                );

                pedidos.add(pedido);
            }
        }

        return pedidos;
    }

    @Override
    public boolean update(Pedido pedido) throws SQLException {

        String sql = "UPDATE pedido SET tipo=?, direccion=?, estado=? WHERE id=?";

        try (Connection con = ConexionBD.getInstance().conectar()){
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, pedido.getTipoPedido());
            ps.setString(2, pedido.getDireccionPedido());
            ps.setString(3, pedido.getEstadoPedido());
            ps.setInt(4, pedido.getIdPedido());

            return   ps.executeUpdate() > 0;

        }
    }

    @Override
    public boolean delete(int id) throws SQLException {

        String sql = "DELETE FROM pedido WHERE id=?";

        try (Connection con = ConexionBD.getInstance().conectar()){
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            return   ps.executeUpdate() > 0;
        }
    }
}
