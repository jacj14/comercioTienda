/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VistaVentasVendedor;

/**
 *
 * @author alexandercarrero
 */
public class ControladorVentasVendedor implements ActionListener{
    public VistaVentasVendedor VistaVentasVendedor;

    public ControladorVentasVendedor(VistaVentasVendedor VistaVentasVendedor) {
        this.VistaVentasVendedor = VistaVentasVendedor;
        this.VistaVentasVendedor.btn_buscarGestionVendedores.addActionListener(this);
        this.VistaVentasVendedor.btn_homeGestionVendedores.addActionListener(this);//Pendiente por determinar si se deja o no esta opción
        this.VistaVentasVendedor.setVisible(true);
    }
    
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
