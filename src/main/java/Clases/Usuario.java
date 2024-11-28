/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author rickp
 */
public class Usuario {
    private String nombre;
    private String usuario;
    private String password;
    

    public Usuario(String datos) {
        if (datos == null || datos.trim().isEmpty()) {
        throw new IllegalArgumentException("Los datos no pueden ser nulos o vacíos.");
    }
        String[] elementos = datos.split("°");
        
        String nombreTemp = elementos[0];
        String usuarioTemp = elementos[1];
        String passwordTemp = elementos[2];
        
        setNombre(nombreTemp);
        setUsuario(usuarioTemp);
        setPassword(passwordTemp);
    }
    
    public Usuario(String nombre, String usuario, String contrasena) {
        setNombre(nombre);
        setUsuario(usuario);
        setPassword(contrasena);
    }
    
     public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío.");
        }
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        if (usuario == null || usuario.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de usuario no puede ser nulo o vacío.");
        }
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("La contraseña no puede ser nula o vacía.");
        }
        if (password.length() < 8) {
            throw new IllegalArgumentException("La contraseña debe tener al menos 8 caracteres.");
        }
        this.password = password;
    }


    @Override
    public String toString() {
        return nombre + "~" + usuario + "~" + password/*Debe de ir una contrasena encriptada*/;
    }

    public String hashcontracena(String contracena){
        try{
            MessageDigest digest=MessageDigest.getInstance("SHA-256");
            byte[] hash=digest.digest(contracena.getBytes());
            StringBuilder hexString=new StringBuilder();
            for(byte b:hash){
                String hex=Integer.toHexString(0xff & b);
                if(hex.length()==1){
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        }
        catch(NoSuchAlgorithmException e){
            throw new RuntimeException("Error al generar el hash");
        }
    }
    public boolean verificarCintacena(String contracenaU, String hash){
        return hashcontracena(contracenaU).equals(hash);
    }
        
    public Object[] toArray(){
        return new Object[]{nombre, usuario};
    }
}
