package conexion;

import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.DriverManager;


public class Conexion {
    
    private static Connection conectar = null;
    
    private static String username = "root";
    private static String password = "admin12345";
    private static String bd = "bd_comercio";
    private static String url = "localhost";
    private static String port = "3306"; //Tener presente en que computadora se esta haciendo para cambiar el puerto correspondiente
    private static String driver = "com.mysql.jdbc.Driver";
    
    private static String cadena = "jdbc:mysql://" + url + ":" + port + "/" + bd;
    
    public static Connection establecerConexion(){ 
        try {
            Class.forName(driver);
            conectar = DriverManager.getConnection(cadena, username, password); 
            //JOptionPane.showMessageDialog(null, "Conexión Exitosa " );
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la conexión a la base de datos " + e.toString());
        }
        
        return conectar;
    
    }
    
}
