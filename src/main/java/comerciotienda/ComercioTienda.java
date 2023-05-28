/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package comerciotienda;

import conexion.Conexion;
import controlador.ControladorInicio;
import vista.VistaInicio;

/**
 *
 * @author alexandercarrero
 */
public class ComercioTienda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ControladorInicio controladorInicio = new ControladorInicio(new VistaInicio());
        
        Conexion objetoConexion = new Conexion();
        objetoConexion.establecerConexion();
    }
    
}
