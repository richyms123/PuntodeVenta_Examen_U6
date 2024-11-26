/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author rickp
 */
public class Usuario {
    private String nombre;
    private String usuario;
    private String password;
    private int numero;
    

    public Usuario(String datos) {
        String[] elementos=datos.split("°");
        nombre=elementos[0];
        usuario=elementos[1];
        password= elementos[2];
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

}
