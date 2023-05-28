package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.dto.VendedorDTO;
import conexion.Conexion;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class VendedorDAO {
    
    private Connection conectar;
    private PreparedStatement prepareStmt;
    private ResultSet resultSet;
    
    public VendedorDAO(){
        this.conectar = null;
        this.prepareStmt = null;
        this.resultSet = null;
    }
    
    public int create (VendedorDTO vendedor){
        int resultado = 0;
        try {
            conectar = Conexion.establecerConexion();
            String insertSQL = "INSERT INTO vendedor VALUES (?, ?, ?, ?)";
            prepareStmt = conectar.prepareStatement(insertSQL);
            prepareStmt.setInt(1, vendedor.getCod_vendedor());
            prepareStmt.setString(2, vendedor.getNombre());
            prepareStmt.setString(3, vendedor.getApellido());
            prepareStmt.setInt(4, vendedor.getTelefono());
            
            resultado = prepareStmt.executeUpdate();
            conectar.close();
            prepareStmt.close();
            JOptionPane.showMessageDialog(null, "Vendedor creado exitosamente");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error SQL creando el vendedor");
        }
        return resultado;
    }
    
    public VendedorDTO read (int codigo){
        
        VendedorDTO vendedor = new VendedorDTO();
                
        try {
            conectar = Conexion.establecerConexion();
            String selectSQL = "SELECT * FROM vendedor WHERE cod_vendedor = ? ";
            prepareStmt = conectar.prepareStatement(selectSQL);
            prepareStmt.setInt(1, codigo);
            resultSet = prepareStmt.executeQuery();
            
            while(resultSet.next()){
                vendedor.setCod_vendedor(resultSet.getInt("cod_vendedor"));
                vendedor.setNombre(resultSet.getString("nombre"));
                vendedor.setApellido(resultSet.getString("apellido"));
                vendedor.setTelefono(resultSet.getInt("telefono"));
                
            conectar.close();
            prepareStmt.close();
            
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error SQL buscando el vendedor");
        }
        return vendedor;
    
    }
    
    public int update (VendedorDTO vendedor){
        int resultado = 0;
        try {
            conectar = Conexion.establecerConexion();
            String updateSQL = "UPDATE vendedor SET nombre = ?, apellido = ?, telefono = ? WHERE cod_vendedor = ? ";
            prepareStmt = conectar.prepareStatement(updateSQL);
            prepareStmt.setString(1, vendedor.getNombre());
            prepareStmt.setString(2, vendedor.getApellido());
            prepareStmt.setInt(3, vendedor.getTelefono());
            prepareStmt.setInt(4, vendedor.getCod_vendedor());
            
            resultado = prepareStmt.executeUpdate();
            conectar.close();
            prepareStmt.close();
            JOptionPane.showMessageDialog(null, "Vendedor actualizado exitosamente");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error SQL actualizando el vendedor");
        }
        return resultado;
    }
    
    public int delete (int codigo){
        int resultado = 0;
        try {
            conectar = Conexion.establecerConexion();
            String deleteSQL = "DELETE FROM vendedor WHERE cod_vendedor = ? ";
            prepareStmt = conectar.prepareStatement(deleteSQL);
            prepareStmt.setInt(1, codigo);
            resultado = prepareStmt.executeUpdate();
            conectar.close();
            prepareStmt.close();
            JOptionPane.showMessageDialog(null, "Vendedor borrado exitosamente");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error SQL borrando el vendedor");
        }
        return resultado;
    
    }
    
    public List<VendedorDTO> readAll (){
        List<VendedorDTO> listaVendedor = new ArrayList();
        
           try {
            conectar = Conexion.establecerConexion();
            String selectSQL = "SELECT * FROM vendedor";
            prepareStmt = conectar.prepareStatement(selectSQL);
            resultSet = prepareStmt.executeQuery();
            VendedorDTO vendedor;
                        
            while(resultSet.next()){
                vendedor = new VendedorDTO();
                vendedor.setCod_vendedor(resultSet.getInt("cod_vendedor"));
                vendedor.setNombre(resultSet.getString("nombre"));
                vendedor.setApellido(resultSet.getString("apellido"));
                vendedor.setTelefono(resultSet.getInt("telefono"));
                listaVendedor.add(vendedor);
                
            conectar.close();
            prepareStmt.close();
            
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error SQL consultando los vendedores");
        }
        return listaVendedor;
    
    }
    
    
    
}
