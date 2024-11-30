package Clases;

public class DetalleVenta {
    private int unidades;
    private Producto producto;
    private Usuario usuario;

    public DetalleVenta(int unidades, Producto producto, Usuario usuario) {
        this.unidades = unidades;
        this.producto = producto;
        this.usuario = usuario;
    }

    
    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Genera el subTotal de un solo producto.
     * Multiplica la cantidad de unidades * precio del producto.
     * @return 
     */
    public float generarSubTotal(){
        return getProducto().getPrecio() * unidades;
    }
    
    @Override
    public String toString() {
        return unidades + "~" + producto.toString() + ",";
    }
    
}
