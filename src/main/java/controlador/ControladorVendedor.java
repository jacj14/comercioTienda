package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.dao.VendedorDAO;
import modelo.dto.VendedorDTO;
import vista.VistaVendedor;

/**
 *
 * @author alexandercarrero
 */
public class ControladorVendedor implements ActionListener{
    public VistaVendedor VistaVendedor;
    public VendedorDAO vendedor;

    public ControladorVendedor(VistaVendedor VistaVendedor) {
        this.VistaVendedor = VistaVendedor;
        this.vendedor = new VendedorDAO();
        this.VistaVendedor.btn_actualizarVendedor.addActionListener(this);
        this.VistaVendedor.btn_borrarVendedor.addActionListener(this);
        this.VistaVendedor.btn_buscarVendedor.addActionListener(this);
        this.VistaVendedor.btn_guardarVendedor.addActionListener(this);
        this.VistaVendedor.btn_homeVendedor.addActionListener(this);//Pendiente por determinar si se deja o no esta opción
        this.VistaVendedor.setVisible(true);
    }

    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //Crear nuevo vendedor
        if(e.getSource().equals(this.VistaVendedor.btn_guardarVendedor)){
            VendedorDTO v = new VendedorDTO();
            v.setCod_vendedor(Integer.valueOf(this.VistaVendedor.tf_codigoVendedor.getText()));
            v.setNombre(this.VistaVendedor.tf_nombreVendedor.getText());
            v.setApellido(this.VistaVendedor.tf_apellidoVendedor.getText());
            v.setTelefono(Integer.valueOf(this.VistaVendedor.tf_telefonoVendedor.getText()));
            
            vendedor.create(v);
            JOptionPane.showMessageDialog(null, "Cliente guardado exitosamente");
        }
        
        //Actualizar vendedor
        if (e.getSource().equals(this.VistaVendedor.btn_actualizarVendedor)) {
            VendedorDTO v = new VendedorDTO();
            v.setCod_vendedor(Integer.valueOf(this.VistaVendedor.tf_codigoVendedor.getText()));
            v.setNombre(this.VistaVendedor.tf_nombreVendedor.getText());
            v.setApellido(this.VistaVendedor.tf_apellidoVendedor.getText());
            v.setTelefono(Integer.valueOf(this.VistaVendedor.tf_telefonoVendedor.getText()));
            
            vendedor.update(v);
            JOptionPane.showMessageDialog(null, "Cliente actualizado exitosamente");
        }
        
        //Borrar vendedor
        if (e.getSource().equals(this.VistaVendedor.btn_borrarVendedor)) {
            int codigo = Integer.valueOf(this.VistaVendedor.tf_codigoVendedor.getText());
            
            vendedor.delete(codigo);
            JOptionPane.showMessageDialog(null, "Cliente borrado exitosamente");
        }
        
        // Mostrar vendedor
        if (e.getSource().equals(this.VistaVendedor.btn_buscarVendedor)) {
            int codigo = Integer.valueOf(this.VistaVendedor.tf_codigoVendedor.getText());
            
            vendedor.read(codigo);
            //OJO ESTÁ PENDIENTE PODER MOSTRAR LA INFORMACIÓN EN FORULARIO
        }
    }
    
}