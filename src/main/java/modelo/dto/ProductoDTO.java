package modelo.dto;

import java.io.Serializable;

/**
 *
 * @author alexandercarrero
 */
public class ProductoDTO implements Serializable{
    
    private int cod_producto;
    private String nombre;
    private String descripcion;
    private int can_actual;
    private float precio_u;

    public int getCod_producto() {
        return cod_producto;
    }

    public void setCod_producto(int cod_producto) {
        this.cod_producto = cod_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCan_actual() {
        return can_actual;
    }

    public void setCan_actual(int can_actual) {
        this.can_actual = can_actual;
    }

    public float getPrecio_u() {
        return precio_u;
    }

    public void setPrecio_u(float precio_u) {
        this.precio_u = precio_u;
    }

    
    
    
    
    
}
