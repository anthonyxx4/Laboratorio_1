/*
Clase donde tendremos las utilerias para la conversión de datos 
enteros a Strings
Autor 1: Anthony Brand Ramos - 2357831
Autor 2: Jhoon Edward Suarez - 2357574
Fecha act: 25-02-2024
Version: 1.2
 */
package laboratorio1;

import javax.swing.JOptionPane;

public class Utilerias {
    
    public static int leerInt(String mensaje){//se lee la informacion de un entero y se convierte a String
        String entrada = JOptionPane.showInputDialog(mensaje);
        return Integer.parseInt(entrada);
    }
    
    public static double leerDouble(String mensaje){//se lee la informacion de un dato double y se convierte a String
        String entrada = 
            JOptionPane.showInputDialog(mensaje);
        return Double.parseDouble(entrada);
    }
    
    public static void mensajeError(String mensaje){//se muestra un mensaje de error 
        JOptionPane.showMessageDialog(
                null, 
                mensaje, 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
    }
    
    public static void mensajeAdvertencia(String mensaje){//se muestra un mensaje de advertencia
        JOptionPane.showMessageDialog(
                null, 
                mensaje, 
                "Error", 
                JOptionPane.WARNING_MESSAGE);
    }
}
