package Clases;

import java.time.LocalDate;
import java.util.ArrayList;

public class Venta {
    private String cliente;
    private LocalDate fecha;
    private boolean status;
    private ArrayList<DetalleVenta> arrayDetalleVenta;
    private float Total;

    public Venta(String cliente, LocalDate fecha, boolean status, ArrayList<DetalleVenta> detalleVenta) {
        this.cliente = cliente;
        this.fecha = fecha;
        this.status = status;
        this.arrayDetalleVenta=detalleVenta;
    }
    
    public Venta(String datos) {
        ArrayList<DetalleVenta> detalleVenta=new ArrayList<DetalleVenta>();
        DetalleVenta dv;
        String elementos[]=datos.split("@");
        String indicesVenta[]=elementos[0].split("~");
        this.cliente=indicesVenta[0];
        this.fecha=LocalDate.parse(indicesVenta[1]);
        this.status=Boolean.parseBoolean(indicesVenta[2]);
        this.Total=Float.parseFloat(indicesVenta[3]);
        System.out.println(elementos[1]);
        String indicesDetalleVenta[]=elementos[1].split(",");
        for(int i=0; i<indicesDetalleVenta.length; i++){
            String datosDetalleVenta[]=indicesDetalleVenta[i].split("~");
            int unidades=Integer.parseInt(datosDetalleVenta[0]);
            Producto p;
            String nombre=datosDetalleVenta[1];
            float precio=Float.parseFloat(datosDetalleVenta[2]);
            int existencias=Integer.parseInt(datosDetalleVenta[3]);
            p=new Producto(nombre,precio,existencias);
            String indicesUsuario[]=elementos[2].split("~");
            Usuario u;
            String nombreU=indicesUsuario[0];
            String usuario=indicesUsuario[1];
            String password=indicesUsuario[2];
            u=new Usuario(nombreU,usuario,password);
            dv=new DetalleVenta(unidades,p,u);
            detalleVenta.add(dv);
            
        }
        arrayDetalleVenta=detalleVenta;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getCliente() {
        return cliente;
    }
    
    public ArrayList<DetalleVenta> getDetalleVenta(){
        return arrayDetalleVenta;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    /**
     * Genera el total de la venta sumando todos los subTotales de cada producto
     * dentro del ArrayList.
     * @return 
     */
    public double generarTotalVenta(){
        double Total = 0;
        for (DetalleVenta venta : arrayDetalleVenta){
            Total += venta.generarSubTotal();
        }
        return Total;
    }
    
    @Override
    public String toString() {
        String parteUno = cliente + "~" + fecha + "~" + status + "~" 
                + generarTotalVenta() + "@";
        String parteDos = "";
        
        //Concatena todos los detalles de venta separados por ",".
        for (DetalleVenta ventita : arrayDetalleVenta) {
            String elementos[] = ventita.toString().split(",");
           String indiceDetalleVenta[]=elementos[0].split("~");
           parteDos += indiceDetalleVenta[0]+"~"+indiceDetalleVenta[1]+"~"+indiceDetalleVenta[2]+"~"+indiceDetalleVenta[3]+",";
        }
        
        return parteUno + parteDos+"@" + arrayDetalleVenta.get(0).getUsuario().toString();
    }
    
    public Object[] toArray(){
        return new Object[]{cliente,fecha,Total};
    }
    
}
