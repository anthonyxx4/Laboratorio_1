/*
Clase que representa los atributos y metodos de nuestras entidades 
en este caso carros
Autor 1: Anthony Brand Ramos - 2357831
Autor 2: Jhoon Edward Suarez - 2357574
Fecha act: 25-02-2024
Version: 1.2
 */
package laboratorio1;

import javax.swing.JOptionPane;

public class Carros {// se declaran los atributos
    String placa;
    String nombre;
    double horaEntrada, horaSalida;
    String[]caract = new String[3];//Color, Marca y Transmision 

    public Carros() {//constructor/se inicializan los atributos
        placa = "";
        nombre = "";
        horaEntrada = horaSalida = 0.0;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
    public void setPlaca() {
        placa = JOptionPane.showInputDialog("Ingrese el numero de la placa: ");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setNombre() {
        nombre = JOptionPane.showInputDialog("Ingrese su nombre: ");
    }

    public double getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(double horaEntrada) {
        this.horaEntrada = horaEntrada;
    }
    
    public void setHoraEntrada() {
        horaEntrada = Utilerias.leerDouble(
                "Ingrese la hora de entrada: ");//Se utiliza esta funcion de la clase utilerias
    }

    public double getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(double horaSalida) {
        this.horaSalida = horaSalida;
    }
    
    public void setHoraSalida() {
        horaSalida = Utilerias.leerDouble("Ingrese la hora de salida:");
    }

    public String[] getCaract() {
        return caract;
    }

    public void setCaract(String[] caract) {
        this.caract = caract;
    }
    
    public void setCaract() {//metodo para almacenar los datos del atributo tipo arreglo 
        String color, marca, transm;
        for(int i = 0; i <=2 ; i++){
            if(i == 0){
                color = JOptionPane.showInputDialog("Ingrese el color del auto: ");
                caract [i] = color;
            }
            
            if(i == 1){
                marca = JOptionPane.showInputDialog("Ingrese la marca del auto: ");
                caract [i] = marca;
            }
            
            if(i == 2){
                transm = JOptionPane.showInputDialog("Ingrese la transmicion del auto: ");
                caract [i] = transm;
            }
        }
    }
    

    @Override
    public String toString() {
        return "Datos del carro{" + "Placa: " + placa + ", Nombre de dueño: " + nombre + ", HoraEntrada: " + horaEntrada + ", HoraSalida: " + horaSalida + '}' + "\nCaracteristicas:\n" + "Color: " + caract[0] + "\nMarca: " + caract[1] + "\nTransmision: " + caract[2];
    }
      
}
