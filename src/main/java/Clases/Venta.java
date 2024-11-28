package Clases;

import java.time.LocalDate;
import java.util.ArrayList;

public class Venta {

    private String cliente;
    private LocalDate fecha;
    private boolean status;
    private DetalleVenta detalleVenta;
    private ArrayList<DetalleVenta> arrayDetalleVenta = new ArrayList<>();

    public void setCliente(String cliente) {
        if (cliente == null || cliente.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del cliente no puede ser nulo o vacío.");
        }
        this.cliente = cliente;
    }

    public String getCliente() {
        return cliente;
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
     *
     * @return
     */
    public double generarTotalVenta() {
        double Total = 0;
        for (DetalleVenta venta : arrayDetalleVenta) {
            Total += venta.generarSubTotal();
        }
        return Total;
    }

    @Override
    public String toString() {
        String parteUno = cliente + "~" + fecha + "~" + status + "~"
                + generarTotalVenta() + ",";
        String parteDos = "";

        //Concatena todos los detalles de venta separados por ",".
        for (DetalleVenta ventita : arrayDetalleVenta) {
            String elementos[] = ventita.toString().split(",");
            String indiceDetalleVenta[] = elementos[1].split("~");
            parteDos += indiceDetalleVenta[0] + "~" + indiceDetalleVenta[1] + "~" + indiceDetalleVenta[2] + "~" + indiceDetalleVenta[3];
        }

        return parteUno + parteDos + detalleVenta.getUsuario().toString();
    }

}
