/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author rickp
 */
public class Producto {
    private int clave;
    private String nombre;
    private float precio;
    private int existencias;
    private int nVentas;
    
     public Producto(int clave, String nombre, float precio, int existencias) {
        this.clave = clave;
        this.nombre = nombre;
        this.precio = precio;
        this.existencias = existencias;
    }

    public Producto(String datos) {
        String[] elementos=datos.split("°");
        clave=Integer.parseInt(elementos[0]);
        nombre=elementos[1];
        precio=Float.parseFloat(elementos[2]);
        existencias=Integer.parseInt(elementos[3]);
        
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }
    
    
}
