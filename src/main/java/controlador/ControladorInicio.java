/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VistaCliente;
import vista.VistaFormasPago;
import vista.VistaInicio;
import vista.VistaProducto;
import vista.VistaTiquete;
import vista.VistaVendedor;
import vista.VistaVenta;
import vista.VistaVentasTotales;
import vista.VistaVentasVendedor;

/**
 *
 * @author alexandercarrero
 */
public class ControladorInicio implements ActionListener {
    public VistaInicio VistaInicio;

    public ControladorInicio(VistaInicio VistaInicio) {
        this.VistaInicio = VistaInicio;
        this.VistaInicio.menu_clientes_inicio.addActionListener(this);
        this.VistaInicio.menu_facturas_inicio.addActionListener(this);
        this.VistaInicio.menu_gestionVendedores_inicio.addActionListener(this);
        this.VistaInicio.menu_productos_inicio.addActionListener(this);
        this.VistaInicio.menu_tipoPago_inicio.addActionListener(this);
        this.VistaInicio.menu_vendedores_inicio.addActionListener(this);
        this.VistaInicio.menu_ventasTotales_inicio.addActionListener(this);
        this.VistaInicio.menu_ventas_inicio.addActionListener(this);
        this.VistaInicio.salir_inicio.addActionListener(this);
        this.VistaInicio.setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource().equals(this.VistaInicio.menu_clientes_inicio)){
            ControladorCliente controladorCliente = new ControladorCliente(new VistaCliente());
        }
        if(e.getSource().equals(this.VistaInicio.menu_facturas_inicio)){
            ControladorTiquete controladorTiquete = new ControladorTiquete(new VistaTiquete());
        }
        if(e.getSource().equals(this.VistaInicio.menu_gestionVendedores_inicio)){
            ControladorVentasVendedor controladorVentasVendedor = new ControladorVentasVendedor(new VistaVentasVendedor());
        }
        if(e.getSource().equals(this.VistaInicio.menu_productos_inicio)){
            ControladorProducto controladorProducto = new ControladorProducto(new VistaProducto());
        }
        if(e.getSource().equals(this.VistaInicio.menu_tipoPago_inicio)){
            ControladorFormasPago controladorFormasPago = new ControladorFormasPago(new VistaFormasPago());
        }
        if(e.getSource().equals(this.VistaInicio.menu_vendedores_inicio)){
            ControladorVendedor controladorVendedor = new ControladorVendedor(new VistaVendedor());
        }
        if(e.getSource().equals(this.VistaInicio.menu_ventasTotales_inicio)){
            ControladorVentasTotales controladorVentasTotales = new ControladorVentasTotales(new VistaVentasTotales());
        }
        if(e.getSource().equals(this.VistaInicio.menu_ventas_inicio)){
            ControladorVenta controladorVenta = new ControladorVenta(new VistaVenta());
        }
        if(e.getSource().equals(this.VistaInicio.salir_inicio)){
            System.exit(0);
        }
    }
    
}
