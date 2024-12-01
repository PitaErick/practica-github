package model;

public class Cliente {
    private String nombre;
    private String apellidos;
    private String cedula;
    private String correoElectronico;
    private String numeroTelefono;
    private String direccion;
    private String sexo;
    private String nombreUsuario;
    private String contrasena;

    // Constructor
    public Cliente(String nombre, String apellidos, String cedula, String correoElectronico, String numeroTelefono,
            String direccion, String sexo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.correoElectronico = correoElectronico;
        this.numeroTelefono = numeroTelefono;
        this.direccion = direccion;
        this.sexo = sexo;
        this.nombreUsuario = generarNombreUsuario();
        this.contrasena = generarContrasenaTemporal();
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCedula() {
        return this.cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreoElectronico() {
        return this.correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getNumeroTelefono() {
        return this.numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getSexo() {
        return this.sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNombreUsuario() {
        return this.nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return this.contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    // Métodos para generar nombre de usuario y contraseña temporal
    private String generarNombreUsuario() {
        // String[] splitApellido = getApellidos().split(" ");
        return String.valueOf(getNombre().charAt(0)).toLowerCase() + '_' + getApellidos().split(" ")[0].toLowerCase()
                + getCedula().substring(8);
    }

    private String generarContrasenaTemporal() {
        return "temp1234"; // Aquí puedes implementar una lógica más compleja para generar contraseñas
    }

    @Override
    public String toString() {
        return "{" +
                " nombre='" + getNombre() + "'" +
                ", apellidos='" + getApellidos() + "'" +
                ", cedula='" + getCedula() + "'" +
                ", correoElectronico='" + getCorreoElectronico() + "'" +
                ", numeroTelefono='" + getNumeroTelefono() + "'" +
                ", direccion='" + getDireccion() + "'" +
                ", sexo='" + getSexo() + "'" +
                ", nombreUsuario='" + getNombreUsuario() + "'" +
                ", contrasena='" + getContrasena() + "'" +
                "}";
    }

}
