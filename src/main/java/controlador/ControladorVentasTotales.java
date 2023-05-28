package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VistaVentasTotales;

/**
 *
 * @author alexandercarrero
 */
public class ControladorVentasTotales implements ActionListener{
    public VistaVentasTotales VistaVentasTotales;

    public ControladorVentasTotales(VistaVentasTotales VistaVentasTotales) {
        this.VistaVentasTotales = VistaVentasTotales;
        this.VistaVentasTotales.btn_buscar_ventasTotales.addActionListener(this);
        this.VistaVentasTotales.btn_homeVentasTotales.addActionListener(this); //Pendiente por determinar si se deja o no esta opción
        this.VistaVentasTotales.setVisible(true);
    }
    
    
    
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
