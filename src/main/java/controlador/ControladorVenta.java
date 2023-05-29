/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.dao.VentaDAO;
import modelo.dto.VentaDTO;
import vista.VistaVenta;

/**
 *
 * @author alexandercarrero
 */
public class ControladorVenta implements ActionListener{
    public VistaVenta VistaVenta;
    public VentaDAO venta;

    public ControladorVenta(VistaVenta VistaVenta) {
        this.VistaVenta = VistaVenta;
        this.venta = new VentaDAO();
        this.VistaVenta.btn_actualizarVentas.addActionListener(this);
        this.VistaVenta.btn_borrarVentas.addActionListener(this);
        this.VistaVenta.btn_buscarVenta.addActionListener(this);
        this.VistaVenta.btn_guardarVentas.addActionListener(this);
        this.VistaVenta.btn_homeVentas.addActionListener(this);//Pendiente por determinar si se deja o no esta opción
        this.VistaVenta.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Crear una nueva venta
        if(e.getSource().equals(this.VistaVenta.btn_guardarVentas)){
            VentaDTO vta = new VentaDTO();
            
            vta.setCod_venta(Integer.valueOf(this.VistaVenta.tf_codigoVenta.getText()));
            vta.setCant_vendida(Integer.valueOf(this.VistaVenta.tf_cantVentas.getText()));
            vta.setDia(Integer.valueOf(this.VistaVenta.tf_diaVentas.getText()));
            vta.setMes(Integer.valueOf(this.VistaVenta.tf_mesVentas.getText()));
            vta.setAnio(Integer.valueOf(this.VistaVenta.tf_anioVentas.getText()));
            vta.setId_cliente(Integer.valueOf(this.VistaVenta.tf_idCliente_ventas.getText()));
            vta.setId_vendedor(Integer.valueOf(this.VistaVenta.tf_idVendedorVentas.getText()));
            vta.setForm_pago(Integer.valueOf(this.VistaVenta.tf_pagoVentas.getText()));
            vta.setCod_prod_vendido(Integer.valueOf(this.VistaVenta.tf_codProdVentas.getText()));
            

            
            venta.create(vta);
        }
        
        //Actualizar una venta
        if (e.getSource().equals(this.VistaVenta.btn_actualizarVentas)) {
            VentaDTO vta = new VentaDTO();
            
            vta.setCod_venta(Integer.valueOf(this.VistaVenta.tf_codigoVenta.getText()));
            vta.setCant_vendida(Integer.valueOf(this.VistaVenta.tf_cantVentas.getText()));
            vta.setDia(Integer.valueOf(this.VistaVenta.tf_diaVentas.getText()));
            vta.setMes(Integer.valueOf(this.VistaVenta.tf_mesVentas.getText()));
            vta.setAnio(Integer.valueOf(this.VistaVenta.tf_anioVentas.getText()));
            vta.setId_cliente(Integer.valueOf(this.VistaVenta.tf_idCliente_ventas.getText()));
            vta.setId_vendedor(Integer.valueOf(this.VistaVenta.tf_idVendedorVentas.getText()));
            vta.setForm_pago(Integer.valueOf(this.VistaVenta.tf_pagoVentas.getText()));
            vta.setCod_prod_vendido(Integer.valueOf(this.VistaVenta.tf_codProdVentas.getText()));
            
            venta.update(vta);
        }
        
        //Borrar una venta
        if (e.getSource().equals(this.VistaVenta.btn_borrarVentas)) {
            int codigo = Integer.valueOf(this.VistaVenta.tf_codigoVenta.getText());
            
            venta.delete(codigo);
        }
        
        //Mostrar una venta
        if (e.getSource().equals(this.VistaVenta.btn_buscarVenta)) {
            int codigo = Integer.valueOf(this.VistaVenta.tf_codigoVenta.getText());
            
            venta.read(codigo);
            //OJO ESTÁ PENDIENTE PODER MOSTRAR LA INFORMACIÓN EN FORULARIO
            
        }
    }
    
    

    
    
}
