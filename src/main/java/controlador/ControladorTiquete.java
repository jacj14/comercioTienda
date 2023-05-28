package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VistaTiquete;

/**
 *
 * @author alexandercarrero
 */
public class ControladorTiquete implements ActionListener{
    public VistaTiquete vistaTiquete;

    public ControladorTiquete(VistaTiquete vistaTiquete) {
        this.vistaTiquete = vistaTiquete;
        this.vistaTiquete.btn_buscarTiquete.addActionListener(this);
        this.vistaTiquete.btn_homeTiquete.addActionListener(this);//Pendiente por determinar si se deja o no esta opción
        this.vistaTiquete.setVisible(true);
    }

    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {

    }
    
    
    
}
