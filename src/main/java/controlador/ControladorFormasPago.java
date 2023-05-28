/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VistaFormasPago;

/**
 *
 * @author alexandercarrero
 */
public class ControladorFormasPago implements ActionListener{
    public VistaFormasPago vistaFormasPago;

    public ControladorFormasPago(VistaFormasPago vistaFormasPago) {
        this.vistaFormasPago = vistaFormasPago;
        this.vistaFormasPago.btn_home_formaPago.addActionListener(this);//Pendiente por determinar si se deja o no esta opción
        this.vistaFormasPago.cmb_formasPago.addActionListener(this);
        this.vistaFormasPago.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
