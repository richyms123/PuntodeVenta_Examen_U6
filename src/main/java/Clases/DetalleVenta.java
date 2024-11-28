package Clases;

public class DetalleVenta {

    private int unidades;
    private Producto producto;
    private Usuario usuario;

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        if (unidades <= 0) {
            throw new IllegalArgumentException("Las unidades deben ser mayores a cero.");
        }
        this.unidades = unidades;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        if (producto == null) {
            throw new IllegalArgumentException("El producto no puede ser nulo.");
        }
        this.producto = producto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException("El usuario no puede ser nulo.");
        }
        this.usuario = usuario;
    }

    /**
     * Genera el subTotal de un solo producto. Multiplica la cantidad de
     * unidades * precio del producto.
     *
     * @return
     */
    public double generarSubTotal() {
        return getProducto().getPrecio() * unidades;
    }

    @Override
    public String toString() {
        return unidades + "~" + producto.toString() + ",";
    }

}
