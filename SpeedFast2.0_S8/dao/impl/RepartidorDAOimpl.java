package dao.impl;

import dao.RepartidorDAO;
import model.Repartidor;
import util.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepartidorDAOimpl implements RepartidorDAO {
    @Override
    public boolean create(Repartidor repartidor) throws SQLException {

        String sql = "INSERT INTO repartidores(nombre) VALUES (?)";

        try (Connection con = ConexionBD.getInstance().conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, repartidor.getNombreRepartidor());

            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public List<Repartidor> readAll() throws SQLException {

        String sql = "SELECT id, nombre FROM repartidores ORDER BY id";

        List<Repartidor> repartidores = new ArrayList<>();

        try (Connection con = ConexionBD.getInstance().conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Repartidor repartidor = new Repartidor(
                        rs.getInt("id"),
                        rs.getString("nombre")
                );

                repartidores.add(repartidor);
            }
        }
        return repartidores;
    }

    @Override
    public boolean update(Repartidor repartidor) throws SQLException {

        String sql = "UPDATE repartidores SET nombre = ? WHERE id = ?";

        try (Connection con = ConexionBD.getInstance().conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, repartidor.getNombreRepartidor());
            ps.setInt(2, repartidor.getIdRepartidor());
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public boolean delete(int id) throws SQLException {

        String sql = "DELETE FROM repartidores WHERE id = ?";

        try (Connection con = ConexionBD.getInstance().conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }
}
