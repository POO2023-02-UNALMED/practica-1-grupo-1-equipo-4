package uiMain;

import java.util.Scanner;

import gestorAplicacion.hotel.Habitacion;
import gestorAplicacion.usuarios.Huesped;

public class Calificar {

    private static Scanner sc = new Scanner(System.in);
    
    public static void seleccionar(){
        System.out.println("SELECCIONE LA CATEGORIA  QUE QUIERE CALIFICAR");
        System.out.println("Seleccione alguna de las siguientes opciones para buscar el hotel en el que se hospedará (Ingrese el número que corresponde a la opción deseada):\n"
                + "1: Calificar Habitacion\n"
                + "2: Calificar empleado\n"
                + "3: Calificar servicios\n");
        int opcion = sc.nextInt();
        while(opcion != 1 && opcion != 2 && opcion != 3){
            System.out.println("INSERTE UNA OPCION  VALIDA");
            System.out.println("SELECCIONE LA CATEGORIA  QUE QUIERE CALIFICAR");
            System.out.println("Seleccione alguna de las siguientes opciones para buscar el hotel en el que se hospedará (Ingrese el número que corresponde a la opción deseada):\n"
                + "1: Calificar Habitacion\n"
                + "2: Calificar empleado\n"
                + "3: Calificar servicios\n");
            opcion = sc.nextInt();
        }
        if(opcion == 1){
            calificarHabitacion();
        }
    }

    //public static Boolean validarEntero(Object n){
    //    if(n.getClass().getSimpleName().equals("Integer")){
      //      return true;
        //}else{
          //  return false;
        //}
    //}
    public static int obtenerEntero(){
        int opcion;
        try{
            opcion = sc.nextInt();
            return opcion;
        }catch(Exception e){
                System.out.println("Debe ingresar  un entero");
                obtenerEntero();   
        }
        return 1;
        
    }

    public static void calificarHabitacion(){
        
        System.out.println("Inserte un numero entre 1  y 5 donde 1 es  muy insatisfecho\n"
            +"y 5 es  muy satisfecho");
        float  opcion =  sc.nextFloat();
        

    }
}
