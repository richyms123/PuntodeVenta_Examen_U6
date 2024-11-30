package Clases;

public class Usuario {

    private String nombre;
    private String usuario;
    private String password;

    public Usuario(String datos) {
        String[] elementos = datos.split("~");
        nombre = elementos[0];
        usuario = elementos[1];
        password = elementos[2];
    }

    public Usuario(String nombre, String usuario, String contrasena) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.password = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return password;
    }

    public void setContrasena(String password) {
        //metodo de incrptacion
        this.password = password;
    }

    /**
     * Regresa la concatenacion de todos lso atributos de Producto separados por
     * "~" incluyendolo al principio y al final. Ejemplo
     * ~Nombre~Usuario~Password~ 
     * ~Juan Garcia~JuaGr~2a5f233~
     *
     * @return
     */
    @Override
    public String toString() {
        return nombre + "~" + usuario + "~" + password/*Debe de ir una contrasena encriptada*/;
    }

}
