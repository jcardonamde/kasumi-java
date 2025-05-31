package dao;

import data.ConexionWorkbench;
import model.ClienteModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDao {
    public static String mensaje = "";
    
    public static boolean guardar(ClienteModel c) {
        try {
            String sql = "INSERT INTO cliente(nombre, apellido, email, telefono) VALUES(?, ?, ?, ?)";
            Connection con = ConexionWorkbench.Conectar();
            PreparedStatement sentencia = con.prepareStatement(sql);
            sentencia.setString(1, c.getNombre());
            sentencia.setString(2, c.getApellido());
            sentencia.setString(3, c.getEmail());
            sentencia.setString(4, c.getTelefono());
            int filas = sentencia.executeUpdate();
            
            if(filas > 0) {
                mensaje = "Cliente guardado con exito!";
                return true;
            }
            mensaje = "No se logro guardar el cliente.";
            return false;
        } catch(SQLException ex) {
            mensaje = ex.getMessage();
            return false;
        }
    }
    
    
    public static ResultSet listar() {
        try {
            String sql = "SELECT * FROM cliente";
            Connection con = ConexionWorkbench.Conectar();
            PreparedStatement sentencia = con.prepareStatement(sql);

            ResultSet datos = sentencia.executeQuery();
            
            return datos;
        } catch(SQLException ex) {
            mensaje = ex.getMessage();
            return null;
        }
    }
    
    public static ClienteModel consultar(int codigoCliente) {
        try {
            String sql = "SELECT * FROM cliente WHERE idCliente=?";
            Connection con = ConexionWorkbench.Conectar();
            PreparedStatement sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, codigoCliente);
            ResultSet datos = sentencia.executeQuery();
            
            if(datos.next()) {
                ClienteModel cli = new ClienteModel();
                cli.setIdCliente(datos.getInt("IdCliente"));
                cli.setNombre(datos.getString("nombre"));
                cli.setApellido(datos.getString("apellido"));
                cli.setEmail(datos.getString("email"));
                cli.setTelefono(datos.getString("telefono"));
                
                return cli;
            }
            return null;
        } catch(SQLException ex) {
            mensaje = ex.getMessage();
            return null;
        }
    }
    
    public static boolean actualizar(ClienteModel c) {
        try {
            String sql = "UPDATE cliente SET nombre=?, apellido=?, email=?, telefono=? WHERE idCliente = ?";
            Connection con = ConexionWorkbench.Conectar();
            PreparedStatement sentencia = con.prepareStatement(sql);
            sentencia.setString(1, c.getNombre());
            sentencia.setString(2, c.getApellido());
            sentencia.setString(3, c.getEmail());
            sentencia.setString(4, c.getTelefono());
            sentencia.setInt(6, c.getIdCliente());
            int filas = sentencia.executeUpdate();
            
            if(filas > 0) {
                mensaje = "Cliente actualizado/a con exito!";
                return true;
            }
            mensaje = "No se logro actualizar el/la cliente.";
            return false;
        } catch(SQLException ex) {
            mensaje = ex.getMessage();
            return false;
        }
    }
    
    public static boolean eliminar(int codigo) {
        try {
            String sql = "DELETE FROM cliente WHERE idCliente = ?";
            Connection con = ConexionWorkbench.Conectar();
            PreparedStatement sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, codigo);
            int filas = sentencia.executeUpdate();
            
            if(filas > 0) {
                mensaje = "Cliente eliminado/a con exito!";
                return true;
            }
            mensaje = "No se logro eliminar el/la cliente.";
            return false;
        } catch(SQLException ex) {
            mensaje = ex.getMessage();
            return false;
        }
    }
}
