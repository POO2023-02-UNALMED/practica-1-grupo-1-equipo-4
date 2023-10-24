package uiMain;

import java.lang.reflect.Array;
import java.util.*;

import gestorAplicacion.hotel.Habitacion;
import gestorAplicacion.hotel.ServiciosExtra;
import gestorAplicacion.usuarios.*;


public class Calificar {

    private static Scanner sc = new Scanner(System.in);
    
    public static void seleccionar(Huesped huesped){
        System.out.println("-----A CONTINUACION SE  DESPLEGARAN 3 ENCUESTAS PARA CALIFICAR AL HOTEL EN EL SIGUIENTE  ORDEN-----");
        System.out.println("*****CALIFICAR  HABITACION*****");
        System.out.println("*****CALIFICAR  EMPLEADO*****");    
        System.out.println("*****CALIFICAR  SERVICIOS*****");
        calificarHabitacion(huesped);    
        calificarEmpleado(huesped);
        calificarServicios(huesped);
        if(huesped.getReserva().getHotel().calcularPromedio()<2.5){
            System.out.println("Gracias  a los datos aportado  el  hotel sera  eliminado");
        }else{
            System.out.println("Gracias por diligenciar la encuesta");
        }
    }

    public  static int calificarServicios(Huesped huesped){
        int  opcion = 0;
        System.out.println("*****CALIFICAR  SERVICIOS*****");
        System.out.println("A continuacion debe calificar los servicios del hotel");
        for (ServiciosExtra servicio : huesped.getReserva().getHotel().getServicios()) {
            System.out.println("Servicio: "+servicio.getTipoServicio());
            System.out.println("Ingrese un entero del  1 al 5, donde 1 es muy  insatisfecho y 5 es muy satisfecho con el empleado");        
            opcion = sc.nextInt();
            while(opcion<1||opcion>5){
                System.out.println("INGRESE UN  NUMERO VALIDO");
                System.out.println("Ingrese un entero del  1 al 5, donde 1 es muy  insatisfecho y 5 es muy satisfecho con el empleado");        
                opcion = sc.nextInt();
            }
            servicio.addCalificaciones(huesped, opcion);
        }
        return opcion;
    }

    public static int calificarEmpleado(Huesped huesped){
        System.out.println("*****CALIFICAR  EMPLEADO*****");   
        System.out.println("SELECCIONE EL NUMERO DEL EMPLEADO A CALIFICAR");
        int  contador = 1;
        for (Empleado empleado : huesped.getReserva().getHotel().getEmpleados()) {
            System.out.println(empleado.getNombre()+" : "+contador);
            contador++;
        }
        int opcion = sc.nextInt();
        while(opcion<1||opcion>huesped.getReserva().getHotel().getEmpleados().size()){
            System.out.println("SELECCIONE UNA OPCION  VALIDA");
            System.out.println("SELECCIONE EL NUMERO DEL EMPLEADO A CALIFICAR");
            contador = 1;
            for (Empleado empleado : huesped.getReserva().getHotel().getEmpleados()) {
                System.out.println(empleado.getNombre()+" : "+contador);
                contador++;
            }
            opcion = sc.nextInt();
        }
        Empleado empleado = huesped.getReserva().getHotel().getEmpleados().get(opcion-1);
        System.out.println("Ingrese un entero del  1 al 5, donde 1 es muy  insatisfecho y 5 es muy satisfecho con el empleado");        
        opcion = sc.nextInt();
        while(opcion > 5 || opcion < 1){
            System.out.println("Ingrese una  opcion valida");
            System.out.println("Ingrese un entero del  1 al 5, donde 1 es muy  insatisfecho y 5 es muy satisfecho");
            opcion = sc.nextInt();
        }
        empleado.addCalificacion(huesped, opcion);
        if(empleado.mereceBono()){
            System.out.println("POR EL BUEN TRABAJO, ESE EMPLEADO ES MERECEDOR DE UN BONO");
        }
        if(opcion<3){
            System.out.println("Seleccione entre las siguiente opciones cual pudo haber sido  el  motivo de su mala experiencia::\n"
                + "1: Falta de respeto\n"
                + "2: Falta  de  Puntualidad\n"
                + "3: Poca Eficiencia\n"
                + "4: Mala Presentación personal  \n");
            int opcion2 =  sc.nextInt();
            while(opcion2>4||opcion2<1){
                System.out.println("INGRESE UNA OPCION VALIDA");
                System.out.println("Seleccione entre las siguiente opciones cual pudo haber sido  el  motivo de su mala experiencia::\n"
                + "1: Falta de respeto\n"
                + "2: Falta  de  Puntualidad\n"
                + "3: Poca Eficiencia\n"
                + "4: Mala Presentación personal  \n");
                opcion2 = sc.nextInt();
            }
            switch(opcion2){
                case 1:
                    empleado.addMotivos("Falta de respeto");
                    break;
                case 2:
                    empleado.addMotivos("Falta  de  Puntualidad");
                    break;
                case 3:
                    empleado.addMotivos("Poca Eficiencia");
                    break;
                case 4:
                    empleado.addMotivos("Mala Presentación personal");
                    break;
            }
            ArrayList<String> sugerencias = empleado.totalSugerencias(empleado.mejorCalificaciones(empleado.rangoCalificacion(huesped.getReserva().getHotel().getEmpleados())));
            empleado.addSugerenciasPendientes(sugerencias);
            System.out.println("SE HAN ENVIADO TODAS LAS  SUGERENCIAS, GRACIAS POR SU  DILIGENCIA");
        }else{
            System.out.println("Como su exxperiencia fue favorable, lo invitamos a llenar el siguiente formulario con  aspectos a mejorar:\n"
                + "1: Mejorar el respeto\n"
                + "2: Mejorar  puntualidad\n"
                + "3: Mejorar  eficiencia\n"
                + "4: Mejorar presentación personal\n"
                + "5: Sin sugerencias  \n");
            int opcion2 = sc.nextInt();
            while(opcion2>5||opcion2<1){
                System.out.println("INGRESE UNA OPCION VALIDA");
                System.out.println("Como su exxperiencia fue favorable, lo invitamos a llenar el siguiente formulario con  aspectos a mejorar:\n"
                + "1: Mejorar el respeto\n"
                + "2: Mejorar  puntualidad\n"
                + "3: Mejorar  eficiencia\n"
                + "4: Mejorar presentación personal\n"
                + "5: Sin sugerencias  \n");
                opcion2 = sc.nextInt();
            }
            switch(opcion2){
                case 1:
                    empleado.addSugerencias("Mejorar el  respeto");
                    break;
                case 2:
                    empleado.addSugerencias("Mejorar  puntualidad");
                    break;
                case 3:
                    empleado.addSugerencias("Mejorar  eficiencia");
                    break;
                case 4: 
                   empleado.addSugerencias("Mejorar presentación personal");
                    break;
                case 5: 
                    empleado.addSugerencias("Sin sugerencias");
                    break;
            }
        }
        return opcion;
    }

    //public static Boolean validarEntero(Object n){
    //    if(n.getClass().getSimpleName().equals("Integer")){
      //      return true;
        //}else{
          //  return false;
        //}
    //}
    public static int calificarHabitacion(Huesped huesped){
        System.out.println("*****CALIFICAR  HABITACION*****");
        System.out.println("Ingrese un entero del  1 al 5, donde 1 es muy  insatisfecho y 5 es muy satisfecho");
        int opcion = sc.nextInt();
        while(opcion > 5 || opcion < 1){
            System.out.println("Ingrese una  opcion valida");
            System.out.println("Ingrese un entero del  1 al 5, donde 1 es muy  insatisfecho y 5 es muy satisfecho");
            opcion = sc.nextInt();
        }
        huesped.getReserva().getHabitacion().addCalificacion(huesped, (float)opcion);
        //pasar datos  a hotel
        if(opcion<3){
             System.out.println("Seleccione entre las siguiente opciones cual pudo haber sido  el  motivo de su mala experiencia::\n"
                + "1: Aseo Habitacion\n"
                + "2: Iluminacion empleado\n"
                + "3: Estado de los elementos de la habitacion\n"
                + "4: Seguridad  \n");
            int opcion2 =  sc.nextInt();
            while(opcion2>4||opcion2<1){
                System.out.println("INGRESE UNA OPCION VALIDA");
                System.out.println("Seleccione entre las siguiente opciones cual pudo haber sido  el  motivo de su mala experiencia::\n"
                + "1: Aseo Habitacion\n"
                + "2: Iluminacion\n"
                + "3: Estado de los elementos de la habitacion\n"
                + "4: Seguridad  \n");
                opcion2 = sc.nextInt();
            }
            switch(opcion2){
                case 1:
                    huesped.getReserva().getHabitacion().addMotivos("Aseo Habitacion");
                    break;
                case 2:
                    huesped.getReserva().getHabitacion().addMotivos("Iluminacion");
                    break;
                case 3:
                    huesped.getReserva().getHabitacion().addMotivos("Estado de los elementos de la habitacion");
                    break;
                case 4: 
                    huesped.getReserva().getHabitacion().addMotivos("Seguridad");
                    break;
            }
            ArrayList<String> sugerenciasMejorar = huesped.getReserva().getHabitacion().totalSugerencias(huesped.getReserva().getHabitacion().mejorCalificadas(huesped.getReserva().getHabitacion().rangoPrecio(huesped.getReserva().getHotel().getHabitaciones())));
            huesped.getReserva().getHabitacion().addSugerenciasPendientes(sugerenciasMejorar);
            System.out.println("SE HAN ENVIADO TODAS LAS  SUGERENCIAS, GRACIAS POR SU  DILIGENCIA");
        }else{
            System.out.println("Como su exxperiencia fue favorable, lo invitamos a llenar el siguiente formulario con  aspectos a mejorar:\n"
                + "1: Mejorar el  aseo\n"
                + "2: Mejorar iluminacion\n"
                + "3: Mejorar  elementos\n"
                + "4: Mejorar seguridad\n"
                + "5: Sin sugerencias  \n");
            int opcion2 = sc.nextInt();
            while(opcion2>5||opcion2<1){
                System.out.println("INGRESE UNA OPCION VALIDA");
                 System.out.println("Como su exxperiencia fue favorable, lo invitamos a llenar el siguiente formulario con  aspectos a mejorar:\n"
                + "1: Mejorar el  aseo\n"
                + "2: Mejorar iluminacion\n"
                + "3: Mejorar  elementos\n"
                + "4: Mejorar seguridad\n"
                + "5: Sin sugerencias  \n");
                opcion2 = sc.nextInt();
            }
            switch(opcion2){
                case 1:
                    huesped.getReserva().getHabitacion().addSugerencias("Mejorar el  aseo");
                    break;
                case 2:
                    huesped.getReserva().getHabitacion().addSugerencias("Mejorar iluminacion");
                    break;
                case 3:
                    huesped.getReserva().getHabitacion().addSugerencias("Mejorar  elementos");
                    break;
                case 4: 
                    huesped.getReserva().getHabitacion().addSugerencias("Mejorar seguridad");
                    break;
                case 5: 
                    huesped.getReserva().getHabitacion().addSugerencias("Sin sugerencias");
                    break;
            }
        }
        return opcion;
    }
}
