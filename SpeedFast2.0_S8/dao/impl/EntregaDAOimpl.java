package dao.impl;

import dao.EntregaDAO;
import model.Entrega;
import util.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EntregaDAOimpl implements EntregaDAO {
    @Override
    public boolean create(Entrega entrega) throws SQLException {

        String sql = "INSERT INTO entregas(id_pedido, id_repartidor, fecha, hora) VALUES (?, ?, ?, ?)";

        try (Connection con = ConexionBD.getInstance().conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, entrega.getIdPedido());
            ps.setInt(2, entrega.getIdRepartidor());
            ps.setDate(3, Date.valueOf(entrega.getFechaEntrega()));
            ps.setTime(4, Time.valueOf(entrega.getHoraEntrega()));

            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public List<Entrega> readAll() throws SQLException {

        String sql = "SELECT id_entrega, id_pedido, id_repartidor, fecha, hora FROM entregas ORDER BY id_entrega";

        List<Entrega> entregas = new ArrayList<>();

        try (Connection con = ConexionBD.getInstance().conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Entrega entrega = new Entrega(
                        rs.getInt("id_entrega"),
                        rs.getInt("id_pedido"),
                        rs.getInt("id_repartidor"),
                        rs.getDate("fecha").toLocalDate(),
                        rs.getTime("hora").toLocalTime()
                );

                entregas.add(entrega);
            }
        }

        return entregas;
    }

    @Override
    public boolean update(Entrega entrega) throws SQLException {

        String sql = "UPDATE entregas SET id_pedido=?, id_repartidor=?, fecha=?, hora=? WHERE id_entrega=?";

        try (Connection con = ConexionBD.getInstance().conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, entrega.getIdPedido());
            ps.setInt(2, entrega.getIdRepartidor());
            ps.setDate(3, Date.valueOf(entrega.getFechaEntrega()));
            ps.setTime(4, Time.valueOf(entrega.getHoraEntrega()));
            ps.setInt(5, entrega.getIdEntrega());

            return ps.executeUpdate() > 0;

        }
    }

    @Override
    public boolean delete(int id) throws SQLException {

        String sql = "DELETE FROM entregas WHERE id_entrega=?";

        try (Connection con = ConexionBD.getInstance().conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }
}
