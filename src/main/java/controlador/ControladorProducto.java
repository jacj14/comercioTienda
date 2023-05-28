package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.dao.ProductoDAO;
import modelo.dto.ProductoDTO;
import vista.VistaProducto;

/**
 *
 * @author alexandercarrero
 */
public class ControladorProducto implements ActionListener {
    public VistaProducto VistaProducto;
    public ProductoDAO producto;

    public ControladorProducto(VistaProducto VistaProducto) {
        this.VistaProducto = VistaProducto;
        this.producto = new ProductoDAO();
        this.VistaProducto.btn_guardarProducto.addActionListener(this);
        this.VistaProducto.btn_actualizarProducto.addActionListener(this);
        this.VistaProducto.btn_buscarProducto.addActionListener(this);
        this.VistaProducto.btn_borrarProducto.addActionListener(this);
        this.VistaProducto.btn_homeProductos.addActionListener(this);//Pendiente por determinar si se deja o no esta opción
        this.VistaProducto.setVisible(true);
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Crear un producto🤣
        if(e.getSource().equals(this.VistaProducto.btn_guardarProducto)){
            ProductoDTO p = new ProductoDTO();
            
            p.setCod_producto(Integer.valueOf(this.VistaProducto.tf_codigoProducto.getText()));
            p.setNombre(this.VistaProducto.tf_nombreProducto.getText());
            p.setDescripcion(this.VistaProducto.tf_descProducto.getText());
            p.setCan_actual(Integer.valueOf(this.VistaProducto.tf_cantProducto.getText()));
            p.setPrecio_u(Float.valueOf(this.VistaProducto.tf_precioProducto.getText()));
            
            producto.create(p);
            
        }
        
        //Actualizar producto
        if (e.getSource().equals(this.VistaProducto.btn_actualizarProducto)) {
            ProductoDTO p = new ProductoDTO();
            p.setCod_producto(Integer.valueOf(this.VistaProducto.tf_codigoProducto.getText()));
            p.setNombre(this.VistaProducto.tf_nombreProducto.getText());
            p.setDescripcion(this.VistaProducto.tf_descProducto.getText());
            p.setCan_actual(Integer.valueOf(this.VistaProducto.tf_cantProducto.getText()));
            p.setPrecio_u(Float.valueOf(this.VistaProducto.tf_precioProducto.getText()));
            
            producto.update(p);
        }
        
        //Borrar un producto
        if (e.getSource().equals(this.VistaProducto.btn_borrarProducto)) {
            int codigo = Integer.valueOf(this.VistaProducto.tf_codigoProducto.getText());
            
            producto.delete(codigo);
        }
        
        //Mostrar producto
        if (e.getSource().equals(this.VistaProducto.btn_buscarProducto)) {
            int codigo = Integer.valueOf(this.VistaProducto.tf_codigoProducto.getText());
            
            producto.read(codigo);
            //OJO ESTÁ PENDIENTE PODER MOSTRAR LA INFORMACIÓN EN FORULARIO
        }
    }
    
            
    
    
    
    
}
