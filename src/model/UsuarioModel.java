package model;

public class UsuarioModel {
    private int idUsuario;
    private String nombre;
    private String email;
    private String contrasena;

    // Constructor por defecto
    public UsuarioModel() {
        this.idUsuario = 0;
        this.nombre = "";
        this.email = "";
        this.contrasena = "";
    }

    // Constructor con parámetros
    public UsuarioModel(int idUsuario, String nombre, String email, String contrasena) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
    }

    // Getters y Setters
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
