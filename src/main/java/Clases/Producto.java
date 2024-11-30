package Clases;

public class Producto {

    private String nombre;
    private float precio;
    private int existencias;

    public Producto(String nombre, float precio, int existencias) {
        setNombre(nombre);
        setPrecio(precio);
        setExistencias(existencias);
    }

    public Producto(String datos) {
        if (datos == null || datos.trim().isEmpty()) {
            throw new IllegalArgumentException("Los datos no pueden ser nulos o vacíos.");
        }
        String[] elementos = datos.split("~");

        String nombreTemp = elementos[0];
        float precioTemp = Float.parseFloat(elementos[1]);
        int existenciasTemp = Integer.parseInt(elementos[2]);

        setNombre(nombreTemp);
        setPrecio(precioTemp);
        setExistencias(existenciasTemp);

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del producto no puede ser nulo o vacío.");
        }
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        if (precio <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a cero.");
        }
        this.precio = precio;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        if (existencias < 0) {
            throw new IllegalArgumentException("Las existencias no pueden ser negativas.");
        }
        this.existencias = existencias;
    }

    /**
     * Regresa la concatenacion de todos lso atributos de Producto separados por
     * "~" incluyendolo al principio y al final. Ejemplo
     * ~Clave~Nombre~Precio~Existencias~ ~13~Pan~16.90~13~
     *
     * @return
     */
    @Override
    public String toString() {
        return nombre + "~" + precio + "~" + existencias + "~";
    }
    
    public Object[] toArray(){
        return new Object[]{nombre,precio,existencias};
    }

}
