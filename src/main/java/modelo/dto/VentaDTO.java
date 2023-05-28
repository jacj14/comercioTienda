package modelo.dto;

import java.io.Serializable;

/**
 *
 * @author alexandercarrero
 */
public class VentaDTO implements Serializable{
    
    private int cod_venta;
    private int id_vendedor;
    private int id_cliente;
    private int cod_prod_vendido;
    private int cant_vendida;
    private int form_pago;
    private int dia;
    private int mes;
    private int anio;

    public int getCod_venta() {
        return cod_venta;
    }

    public void setCod_venta(int cod_venta) {
        this.cod_venta = cod_venta;
    }

    public int getId_vendedor() {
        return id_vendedor;
    }

    public void setId_vendedor(int id_vendedor) {
        this.id_vendedor = id_vendedor;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getCod_prod_vendido() {
        return cod_prod_vendido;
    }

    public void setCod_prod_vendido(int cod_prod_vendido) {
        this.cod_prod_vendido = cod_prod_vendido;
    }

    public int getCant_vendida() {
        return cant_vendida;
    }

    public void setCant_vendida(int cant_vendida) {
        this.cant_vendida = cant_vendida;
    }

    public int getForm_pago() {
        return form_pago;
    }

    public void setForm_pago(int form_pago) {
        this.form_pago = form_pago;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    

    
    
    
    
}
