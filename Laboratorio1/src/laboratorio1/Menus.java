/*
Clase que representa los menus de nuestra de nuestra 
aplicación y metodos de submenus
Autor 1: Anthony Brand Ramos - 2357831
Autor 2: Jhoon Edward Suarez - 2357574
Fecha act: 25-02-2024
Version: 1.2
 */
package laboratorio1;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Menus {

    ArrayList<Carros> array = new ArrayList<>();
    
    public void nuevaEntidad(){//funcion para agregar nuevas entidades
        Carros carr = new Carros();
        carr.setPlaca();
        if(!existente(carr.getPlaca())){
            carr.setNombre();
            carr.setHoraEntrada();
            carr.setHoraSalida();
            carr.setCaract();
            array.add(carr);
        }else{
            Utilerias.mensajeError("Carro con placa " + carr.getPlaca() + " ya existe.");
        }
    }
    
    public void consultar(){//funcion para consultar etidades
        String plac = JOptionPane.showInputDialog("Ingrese la placa a buscar: ");
        boolean existente = false;
        for (Carros carr : array){
            if(plac.equals(carr.getPlaca())){
                existente = true;
                JOptionPane.showMessageDialog(null, carr); break;
            }
        }
        if(!existente){
            Utilerias.mensajeAdvertencia("Carro no existe!");
        }
    }
    
    public void modificar(){//funcion para modificar atributos de las entidades
        String plac = JOptionPane.showInputDialog("Ingrese la placa para su modificacion: ");
        boolean existe = false;
        for (Carros carr : array){
            if (plac.equals(carr.getPlaca())){
                existe = true;
                int opc = Utilerias.leerInt(carr + "\n1. Nombre\n2. Hora entrada\n3. Hora salida\n0. Salir");
                switch(opc){
                    case 1: carr.setNombre(); break;
                    case 2: carr.setHoraEntrada(); break;
                    case 3: carr.setHoraSalida(); break;
                    case 0: break;
                }
                break;
            }
        }
        if(!existe){
            Utilerias.mensajeAdvertencia("Carro no existente.");
        }
    }
    
    public void eliminar(){//funcion para eliminar entidades
        String plac = JOptionPane.showInputDialog("Ingrese la placa a buscar: ");
        boolean existente = false;
        for (Carros carros : array) {
            if(plac.equals(carros.getPlaca())){
                existente = true;
                JOptionPane.showMessageDialog(null, "Se eliminara\n" + carros);
                array.remove(carros); 
                break;
            }
        }
        if(!existente){
            Utilerias.mensajeAdvertencia("Carro no existe!");
        }
    }
    
    public boolean existente(String plac){//metodo para validacion de existencia de los carros
        for ( Carros carr : array){
            if(carr.getPlaca().equals(plac)) return true;     
        }
        return false;    
    }
    
    public void listaAtributos(){//metodo que muestra listado por atributos
        String clor = "", marc =  "";
        int opc = 0;
        opc = JOptionPane.showOptionDialog(null,
                "Seleccione tipo de consulta",
                "///CONSULTA POR ATRIBUTOS",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[] {"Color de carro", "Marca de carro"},
                "Color de carro");
        int colors = 0, marcas = 0;
        if (opc == 0){// a partir de aqui se hace la busqueda de coincidencias en el color
            clor = JOptionPane.showInputDialog("Que color desea buscar:");
            for (Carros carros : array) {
                if(clor.equalsIgnoreCase(carros.caract[0])){
                    colors+=1;
                }
            }
        }
        if(opc == 1){// a partir de aqui se hace la busqueda de coincidencias en la marca
            marc = JOptionPane.showInputDialog("Que marca desea buscar:");
            for (Carros carros : array) {
                if(marc.equalsIgnoreCase(carros.caract[1])){
                    marcas+=1;
                }
            }
        }
        if(opc == 0){
            System.out.println("Hay " + colors + " carros de color " + clor);
        }else{
            System.out.println("Hay " + marcas + " carros de la marca " + marc);
        } 
    }
    
    public void listaGeneral(){//lista general de las entidades guardadas
        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i));   
        }
    }
    
    public void tiempoPromedio(){//funcion para sacar el promedio de tiempo de los carros
        double pro, cont = 0;
        double resta = 0;
        for (Carros carros : array) {
            resta += carros.getHoraSalida() - carros.getHoraEntrada();
            cont+=1;
        }
        pro = resta / cont;
        JOptionPane.showMessageDialog(null, "El promedio de tiempo de los carros almacenados es de: " + pro);
    }
    
    public void totalCarros(){// se hace una suma de las placas almacenadas para conocer el total de carros 
        int cont = 0;
        int suma = 0;
        for (Carros carros : array) {
            if(carros.getPlaca() != null){
                suma += 1;
            } 
        }
        JOptionPane.showMessageDialog(null, "Totall de carros almacenados: " + suma);
    }
    
    public void totalCarrosEntrada(){//se hace la sumatoria de carros que ingresaron a una misma hora
        double cont = 0;
        double hora = Utilerias.leerDouble("Ingrese una hora para verificar si ingresaron mas autos a esta hora:");
        for (Carros carros : array) {
            if(hora == carros.getHoraEntrada()){
                cont+=1;
            }
        }
        JOptionPane.showMessageDialog(null, cont + " carros ingresaron a las: "  + hora);
    }
    
    public void estadistica(){//submenu de las estadisticas
        int opc = 0;
        do{
            opc = JOptionPane.showOptionDialog(
                    null, 
                    "Seleccione una opcion",
                    "///ESTADISTICAS",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, 
                    new Object[] {"Tiempo promedio de los carros", "Total de carros almacenados", "Total de carros que ingresaron a una misma hora", "Regresar"}, 
                    "Tiempo promedio de los carros");
            switch (opc) {
                case 0: tiempoPromedio(); break;
                case 1: totalCarros(); break;
                case 2: totalCarrosEntrada(); break;
                case 3: break;
            }
        }while(opc != 3);
    }
    
    public void listados() {//submenu de listados
        int opc = 0;
        do{
            opc = JOptionPane.showOptionDialog(
                   null, 
                   "Seleccione una opcion", 
                   "///LISTADOS", 
                   JOptionPane.YES_NO_CANCEL_OPTION, 
                   JOptionPane.QUESTION_MESSAGE,
                   null, 
                   new Object[] {"Listado general", "Listado por atributos", "Regresar"},
                   "Listado general");
            switch(opc){
                case 0: listaGeneral(); break;
                case 1: listaAtributos(); break;
                case 2: break;
            }
        }while(opc != 2);
    }
    
    public void gestion(){//submenu de gestion de entidades
        int opc = 0;
        do{
           opc = JOptionPane.showOptionDialog(
                   null, 
                   "Seleccione una opcion", 
                   "///GESTION DE ENTIDADES", 
                   JOptionPane.YES_NO_CANCEL_OPTION, 
                   JOptionPane.QUESTION_MESSAGE,
                   null, 
                   new Object[] {"Nueva entidad", "Consultar entidad", "Modificar entidad", "Eliminar entidad", "Regresar"},
                   "Nueva entidad");
            switch(opc){
                case 0: nuevaEntidad(); break; //Llama a la funcion para ingresar nuevas entidades
                case 1: consultar(); break; //Llama a la funcion consultar  
                case 2: modificar(); break;//Llama a la funcion modificar
                case 3: eliminar(); break;//llama a la funcion eliminar
                case 4: break;
            }
        }while(opc != 4);   
    } 
    
    public void menuPrincipal(){ //funcion del menu principal
        int opc = 0;
        do{
            opc = Utilerias.leerInt(
                "///Menu principal///\n\n" + 
                "1. Gestion de la entidad\n" +
                "2. Listados\n" + 
                "3. Estadistica\n" + 
                "4. Acerca de...\n" + 
                "5. Salir");
            switch (opc) {
                case 1: gestion(); break;
                case 2: listados(); break;
                case 3: estadistica(); break;
                case 4:  
                    JOptionPane.showMessageDialog(null, 
                        "Programador 1: Anthony Brand Ramos - 2357831\n" +
                        "Programador 2: Jhoon Edward Suarez - 2357574"); 
                    break;
                case 5: break;
                default:
                    Utilerias.mensajeError("Opcion incorrecta!");
            }
        }while(opc != 5);
    }
    
            
    public static void main(String[] args) {
        Menus me = new Menus();
        me.menuPrincipal();
    }  
}
