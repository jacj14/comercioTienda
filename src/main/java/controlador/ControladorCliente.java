package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.dao.ClienteDAO;
import modelo.dto.ClienteDTO;
import vista.VistaCliente;

/**
 *
 * @author alexandercarrero
 */
public class ControladorCliente implements ActionListener{
    public VistaCliente VistaCliente;
    public ClienteDAO cliente;//ADICIONAR

    public ControladorCliente(VistaCliente VistaCliente) {
        this.VistaCliente = VistaCliente;
        this.cliente = new ClienteDAO(); //ADICIONAR 
        this.VistaCliente.btn_guardarCliente.addActionListener(this);
        this.VistaCliente.btn_actualizarCliente.addActionListener(this);
        this.VistaCliente.btn_borrarCliente.addActionListener(this);
        this.VistaCliente.btn_buscarCliente.addActionListener(this);
        this.VistaCliente.btn_homeCliente.addActionListener(this);//Pendiente por determinar si se deja o no esta opción
        this.VistaCliente.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Crear un nuevo cliente
        if(e.getSource().equals(this.VistaCliente.btn_guardarCliente)){
            ClienteDTO c = new ClienteDTO();
            c.setCod_cliente(Integer.valueOf(this.VistaCliente.tf_codigoCliente.getText()));
            c.setNombre(this.VistaCliente.tf_nombreCliente.getText());
            c.setApellido(this.VistaCliente.tf_apellidoCliente.getText());
            c.setTelefono(Integer.valueOf(this.VistaCliente.tf_telefonoCliente.getText()));
            
            cliente.create(c);
        }
        //Actualizar un cliente
        if (e.getSource().equals(this.VistaCliente.btn_actualizarCliente)) {
            ClienteDTO c = new ClienteDTO();
            c.setCod_cliente(Integer.valueOf(this.VistaCliente.tf_codigoCliente.getText()));
            c.setNombre(this.VistaCliente.tf_nombreCliente.getText());
            c.setApellido(this.VistaCliente.tf_apellidoCliente.getText());
            c.setTelefono(Integer.valueOf(this.VistaCliente.tf_telefonoCliente.getText()));
            
            cliente.update(c);
        }
        //Borrar un cliente
        if (e.getSource().equals(this.VistaCliente.btn_borrarCliente)) {
            int codigo = Integer.valueOf(this.VistaCliente.tf_codigoCliente.getText());
            
            cliente.delete(codigo);
        }
        //Mostrar un cliente
        if (e.getSource().equals(this.VistaCliente.btn_buscarCliente)) {
            int codigo = Integer.valueOf(this.VistaCliente.tf_codigoCliente.getText());
            
            cliente.read(codigo);
            //OJO ESTÁ PENDIENTE PODER MOSTRAR LA INFORMACIÓN EN FORULARIO
            
        }
    }

    
    
    
    
}
