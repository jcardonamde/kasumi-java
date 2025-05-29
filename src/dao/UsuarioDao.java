package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.UsuarioModel;
import data.ConexionWorkbench;

public class UsuarioDao {

    public static UsuarioModel validarLogin(String email, String contrasena) {
        UsuarioModel usuario = null;

        String sql = "SELECT * FROM usuario WHERE email = ? AND contrasena = ?";

        try (Connection con = ConexionWorkbench.Conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setString(2, contrasena);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                usuario = new UsuarioModel();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setEmail(rs.getString("email"));
                usuario.setContrasena(rs.getString("contrasena"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al validar el login: " + e.getMessage());
        }

        return usuario; // Si es null, el login falló
    }
}
