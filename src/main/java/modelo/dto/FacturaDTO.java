package modelo.dto;

import java.io.Serializable;

/**
 *
 * @author alexandercarrero
 */
public class FacturaDTO implements Serializable{
    
    private int cod_factura;
    private int cantidad;
    private String producto;
    private double precio_total;

    public int getCod_factura() {
        return cod_factura;
    }

    public void setCod_factura(int cod_factura) {
        this.cod_factura = cod_factura;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public double getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(double precio_total) {
        this.precio_total = precio_total;
    }
    
    
    
}
