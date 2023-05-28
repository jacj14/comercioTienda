package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import conexion.Conexion;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.dto.ProductoDTO;

public class ProductoDAO {
    
    private Connection conectar;
    private PreparedStatement prepareStmt;
    private ResultSet resultSet;
    
    public ProductoDAO(){
        this.conectar = null;
        this.prepareStmt = null;
        this.resultSet = null;
    }
    
    public int create (ProductoDTO producto){
        int resultado = 0;
        try {
            conectar = Conexion.establecerConexion();
            String insertSQL = "INSERT INTO producto VALUES (?, ?, ?, ?, ?)";
            prepareStmt = conectar.prepareStatement(insertSQL);
            prepareStmt.setInt(1, producto.getCod_producto());
            prepareStmt.setString(2, producto.getNombre());
            prepareStmt.setString(3, producto.getDescripcion());
            prepareStmt.setInt(4, producto.getCan_actual());
            prepareStmt.setFloat(5, producto.getPrecio_u());
            
            resultado = prepareStmt.executeUpdate();
            conectar.close();
            prepareStmt.close();
            JOptionPane.showMessageDialog(null, "Producto guardado exitosamente");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error SQL creando el producto");
        }
        return resultado;
    }
    
    public ProductoDTO read (int codigo){
        
        ProductoDTO producto = new ProductoDTO();
                
        try {
            conectar = Conexion.establecerConexion();
            String selectSQL = "SELECT * FROM producto WHERE cod_producto = ? ";
            prepareStmt = conectar.prepareStatement(selectSQL);
            prepareStmt.setInt(1, codigo);
            resultSet = prepareStmt.executeQuery();
            
            while(resultSet.next()){
                producto.setCod_producto(resultSet.getInt("cod_producto"));
                producto.setNombre(resultSet.getString("nombre"));
                producto.setDescripcion(resultSet.getString("descripcion"));
                producto.setCan_actual(resultSet.getInt("can_actual"));
                producto.setPrecio_u(resultSet.getFloat("precio"));
                
            conectar.close();
            prepareStmt.close();
            
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error SQL buscando el producto");
        }
        return producto;
    
    }
    
    public int update (ProductoDTO producto){
        int resultado = 0;
        try {
            conectar = Conexion.establecerConexion();
            String updateSQL = "UPDATE producto SET nombre = ?, descripcion = ?, can_actual = ?, precio_u = ? WHERE cod_producto = ? ";
            prepareStmt = conectar.prepareStatement(updateSQL);
            prepareStmt.setString(1, producto.getNombre());
            prepareStmt.setString(2, producto.getDescripcion());
            prepareStmt.setInt(3, producto.getCan_actual());
            prepareStmt.setFloat(4, producto.getPrecio_u());
            prepareStmt.setInt(5, producto.getCod_producto());
            
            resultado = prepareStmt.executeUpdate();
            conectar.close();
            prepareStmt.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error SQL modificando el producto");
        }
        return resultado;
    }
    
    public int delete (int codigo){
        int resultado = 0;
        try {
            conectar = Conexion.establecerConexion();
            String deleteSQL = "DELETE FROM producto WHERE cod_producto = ? ";
            prepareStmt = conectar.prepareStatement(deleteSQL);
            prepareStmt.setInt(1, codigo);
            resultado = prepareStmt.executeUpdate();
            conectar.close();
            prepareStmt.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error SQL eliminando el producto");
        }
        return resultado;
    
    }
    
    public List<ProductoDTO> readAll (){
        List<ProductoDTO> listaProducto = new ArrayList();
        
           try {
            conectar = Conexion.establecerConexion();
            String selectSQL = "SELECT * FROM producto";
            prepareStmt = conectar.prepareStatement(selectSQL);
            resultSet = prepareStmt.executeQuery();
            ProductoDTO producto;
                        
            while(resultSet.next()){
                producto = new ProductoDTO();
                producto.setCod_producto(resultSet.getInt("cod_producto"));
                producto.setNombre(resultSet.getString("nombre"));
                producto.setDescripcion(resultSet.getString("descripcion"));
                producto.setCan_actual(resultSet.getInt("can_actual"));
                producto.setPrecio_u(resultSet.getFloat("precio"));
                listaProducto.add(producto);
                
            conectar.close();
            prepareStmt.close();
            
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error SQL consultando el producto");
        }
        return listaProducto;
    
    }
        
        
        
        
    
    
}
