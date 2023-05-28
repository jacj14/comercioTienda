package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.dto.ClienteDTO;
import conexion.Conexion;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author alexandercarrero
 */
public class ClienteDAO {
    
    private Connection conectar;
    private PreparedStatement prepareStmt;
    private ResultSet resultSet;
    
    
    public ClienteDAO(){
        this.conectar = null;
        this.prepareStmt = null;
        this.resultSet = null;
    }
    
    public int create (ClienteDTO cliente){
        int resultado = 0;
        try {
            conectar = Conexion.establecerConexion();
            String insertSQL = "INSERT INTO cliente VALUES (?, ?, ?, ?)";
            prepareStmt = conectar.prepareStatement(insertSQL);
            prepareStmt.setInt(1, cliente.getCod_cliente());
            prepareStmt.setString(2, cliente.getNombre());
            prepareStmt.setString(3, cliente.getApellido());
            prepareStmt.setInt(4, cliente.getTelefono());
            
            resultado = prepareStmt.executeUpdate();
            conectar.close();
            prepareStmt.close();
            JOptionPane.showMessageDialog(null, "Cliente creado exitosamente");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error SQL creando el cliente");
        }
        return resultado;
        
    }
    
    public ClienteDTO read (int codigo){
        
        ClienteDTO cliente = new ClienteDTO();
                
        try {
            conectar = Conexion.establecerConexion();
            String selectSQL = "SELECT * FROM cliente WHERE cod_cliente = ? ";
            prepareStmt = conectar.prepareStatement(selectSQL);
            prepareStmt.setInt(1, codigo);
            resultSet = prepareStmt.executeQuery();
            
            while(resultSet.next()){
                cliente.setCod_cliente(resultSet.getInt("cod_cliente"));
                cliente.setNombre(resultSet.getString("nombre"));
                cliente.setApellido(resultSet.getString("apellido"));
                cliente.setTelefono(resultSet.getInt("telefono"));
                
            conectar.close();
            prepareStmt.close();
            
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error SQL buscando el cliente");
        }
        return cliente;
    
    }
    
    public int update (ClienteDTO cliente){
        int resultado = 0;
        try {
            conectar = Conexion.establecerConexion();
            String updateSQL = "UPDATE cliente SET nombre = ?, apellido = ?, telefono = ? WHERE cod_cliente = ? ";
            prepareStmt = conectar.prepareStatement(updateSQL);
            prepareStmt.setString(1, cliente.getNombre());
            prepareStmt.setString(2, cliente.getApellido());
            prepareStmt.setInt(3, cliente.getTelefono());
            prepareStmt.setInt(4, cliente.getCod_cliente());
            
            resultado = prepareStmt.executeUpdate();
            conectar.close();
            prepareStmt.close();
            JOptionPane.showMessageDialog(null, "Cliente actualizado exitosamente");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error SQL actualizando el cliente");
        }
        return resultado;
    }
     
    public int delete (int codigo){
        int resultado = 0;
        try {
            conectar = Conexion.establecerConexion();
            String deleteSQL = "DELETE FROM cliente WHERE cod_cliente = ? ";
            prepareStmt = conectar.prepareStatement(deleteSQL);
            prepareStmt.setInt(1, codigo);
            resultado = prepareStmt.executeUpdate();
            conectar.close();
            prepareStmt.close();
            JOptionPane.showMessageDialog(null, "Cliente borrado exitosamente");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error SQL borrando el cliente");
        }
        return resultado;
    
    }
    
    public List<ClienteDTO> readAll (){
        List<ClienteDTO> listaCliente = new ArrayList();
        
           try {
            conectar = Conexion.establecerConexion();
            String selectSQL = "SELECT * FROM cliente";
            prepareStmt = conectar.prepareStatement(selectSQL);
            resultSet = prepareStmt.executeQuery();
            ClienteDTO cliente;
                        
            while(resultSet.next()){
                cliente = new ClienteDTO();
                cliente.setCod_cliente(resultSet.getInt("cod_cliente"));
                cliente.setNombre(resultSet.getString("nombre"));
                cliente.setApellido(resultSet.getString("apellido"));
                cliente.setTelefono(resultSet.getInt("telefono"));
                listaCliente.add(cliente);
                
            conectar.close();
            prepareStmt.close();
            
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error SQL consultando los clientes");
        }
        return listaCliente;
    
    }
    
    
}
