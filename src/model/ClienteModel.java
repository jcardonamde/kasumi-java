package model;

public class ClienteModel {
    private int idCliente;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    
    // Constructor por defecto
    public ClienteModel() {
        this.idCliente = 0;
        this.nombre = "";
        this.apellido = "";
        this.email = "";
        this.telefono = "";
    }
    
    // Constructor con parámetros
    public ClienteModel(int idCliente, String nombre, String apellido, String email, String telefono) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
    }

    // Getters y Setters
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
