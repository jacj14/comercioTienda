package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.dto.VentaDTO;
import conexion.Conexion;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class VentaDAO {
    
    private Connection conectar;
    private PreparedStatement prepareStmt;
    private ResultSet resultSet;
    
    public VentaDAO(){
        this.conectar = null;
        this.prepareStmt = null;
        this.resultSet = null;
    }
    
    public int create (VentaDTO venta){
        int resultado = 0;
        try {
            conectar = Conexion.establecerConexion();
            String insertSQL = "INSERT INTO venta VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            prepareStmt = conectar.prepareStatement(insertSQL);
            prepareStmt.setInt(1, venta.getCod_prod_vendido());
            prepareStmt.setInt(2, venta.getCant_vendida());
            prepareStmt.setInt(3, venta.getDia());
            prepareStmt.setInt(4, venta.getMes());
            prepareStmt.setInt(5, venta.getAnio());
            prepareStmt.setInt(6, venta.getId_vendedor());
            prepareStmt.setInt(7, venta.getId_cliente());
            prepareStmt.setInt(8, venta.getCod_prod_vendido());
            prepareStmt.setInt(9, venta.getForm_pago());
            
            
            resultado = prepareStmt.executeUpdate();
            conectar.close();
            prepareStmt.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error SQL creando la venta");
        }
        return resultado;
    }
    
    public VentaDTO read (int codigo){
        
        VentaDTO venta = new VentaDTO();
                
        try {
            conectar = Conexion.establecerConexion();
            String selectSQL = "SELECT * FROM venta WHERE cod_venta = ? ";
            prepareStmt = conectar.prepareStatement(selectSQL);
            prepareStmt.setInt(1, codigo);
            resultSet = prepareStmt.executeQuery();
            
            while(resultSet.next()){
                venta.setCod_venta(resultSet.getInt("cod_venta"));
                venta.setId_vendedor(resultSet.getInt("id_vendedor"));
                venta.setCod_prod_vendido(resultSet.getInt("cod_prod_vendido"));
                venta.setCant_vendida(resultSet.getInt("cant_vend"));
                venta.setForm_pago(resultSet.getInt("form_pago"));
                venta.setDia(resultSet.getInt("dia"));
                venta.setMes(resultSet.getInt("mes"));
                venta.setAnio(resultSet.getInt("anio"));
                venta.setId_cliente(resultSet.getInt("id_cliente"));

                
            conectar.close();
            prepareStmt.close();
            
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error SQL buscando l;a venta");
        }
        return venta;
    
    }
    
    public int update (VentaDTO venta){
        int resultado = 0;
        try {
            conectar = Conexion.establecerConexion();
            String updateSQL = "UPDATE venta SET id_vendedor = ?, cod_prod_vendido = ?, cant_vend = ?, form_pago = ?, dia = ?, mes = ?, anio = ? , id_cliente = ? WHERE cod_venta = ? ";
            prepareStmt = conectar.prepareStatement(updateSQL);
            prepareStmt.setInt(1, venta.getId_vendedor());
            prepareStmt.setInt(2, venta.getCod_prod_vendido());
            prepareStmt.setInt(3, venta.getCant_vendida());
            prepareStmt.setInt(4, venta.getForm_pago());
            prepareStmt.setInt(5, venta.getDia());
            prepareStmt.setInt(6, venta.getMes());
            prepareStmt.setInt(7, venta.getAnio());
            prepareStmt.setInt(8, venta.getId_cliente());
            prepareStmt.setInt(9, venta.getCod_venta());
            
            resultado = prepareStmt.executeUpdate();
            conectar.close();
            prepareStmt.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error SQL modificando la venta");
        }
        return resultado;
    }
    
    public int delete (int codigo){
        int resultado = 0;
        try {
            conectar = Conexion.establecerConexion();
            String deleteSQL = "DELETE FROM venta WHERE cod_venta = ? ";
            prepareStmt = conectar.prepareStatement(deleteSQL);
            prepareStmt.setInt(1, codigo);
            resultado = prepareStmt.executeUpdate();
            conectar.close();
            prepareStmt.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error SQL eliminando la venta");
        }
        return resultado;
    
    }
    
    public List<VentaDTO> readAll (){
        List<VentaDTO> listaVenta = new ArrayList();
        
           try {
            conectar = Conexion.establecerConexion();
            String selectSQL = "SELECT * FROM venta";
            prepareStmt = conectar.prepareStatement(selectSQL);
            resultSet = prepareStmt.executeQuery();
            VentaDTO venta;
                        
            while(resultSet.next()){
                venta = new VentaDTO();
                venta.setCod_venta(resultSet.getInt("cod_venta"));
                venta.setId_vendedor(resultSet.getInt("id_vendedor"));
                venta.setCod_prod_vendido(resultSet.getInt("cod_prod_vendido"));
                venta.setCant_vendida(resultSet.getInt("cant_vend"));
                venta.setForm_pago(resultSet.getInt("form_pago"));
                venta.setDia(resultSet.getInt("dia"));
                venta.setMes(resultSet.getInt("mes"));
                venta.setAnio(resultSet.getInt("anio"));
                venta.setId_cliente(resultSet.getInt("id_cliente"));
                listaVenta.add(venta);
                
            conectar.close();
            prepareStmt.close();
            
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error SQL consultando el cliente");
        }
        return listaVenta;
    
    }
    
    
    
    
    
    
}
