/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uiMain;
import uiMain.*;
import gestorAplicacion.finanzas.*;
import gestorAplicacion.hotel.*;
import gestorAplicacion.usuarios.*;
import gestorAplicacion.Base;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import baseDatos.*;

import java.util.Scanner;
/**
 *
 * @author David Restrepo Aguilar
 */
public class Menu {
    
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        Deserializador.deserializador();
        
//        System.out.println(Base.getHoteles().get(0).getHabitaciones().get(0).getReservas().get(0).getHuesped().getNombre());
        
        /*
         * Pruebas para administrador
         */

         
         
//        CuentaBancaria cbhotel = new CuentaBancaria(123456, "Bancolombia");
//        CuentaBancaria cbadministrador = new CuentaBancaria(6789, "Bancolombia");
//        CuentaBancaria cbempleado1 = new CuentaBancaria(6789, "Bancolombia");
//        CuentaBancaria cbempleado2 = new CuentaBancaria(6789, "Bancolombia");
//
//        Hotel hotel = new Hotel(cbhotel);
//        hotel.getCuentaBancaria().setSaldo(100);
//
//        Administrador administrador = new Administrador("Camilo", 12345, "kmi", "12345", cbadministrador, hotel);
//
//        Empleado empleado1 = new Empleado("Juan", 1234, "Juan", "12345", cbempleado1, 200);
//        Empleado empleado2 = new Empleado("Carlos", 1234, "Carlos", "12345", cbempleado2, 100);
//
//        hotel.agregarEmpleado(empleado1);
//        hotel.agregarEmpleado(empleado2);
//
//        Base.addHoteles(hotel);
//        Base.addAdministradores(administrador);
//        Base.addEmpleados(empleado1);
//        Base.addEmpleados(empleado2);

        
//        System.out.println(Base.getHuespedes().get(0).getNombre());
//        System.out.println(Base.getHuespedes().get(0).equals(Base.getHoteles().get(0).getHabitaciones().get(0).getReservas().get(0).getHuesped().getNombre()));
        
//        CuentaBancaria cb = new CuentaBancaria(1000000000, "d");
//        ArrayList<Empleado> emps = new ArrayList<>();
//        ArrayList<ServiciosExtra> servs = new ArrayList<>();
//        ArrayList<Habitacion> habs = new ArrayList<>();
//        Empleado emp1 = new Empleado("emp1");
//        Empleado emp2 = new Empleado("emp2");
//        Empleado emp3 = new Empleado("emp3");
//        emps.add(emp3);
//        emps.add(emp2);
//        emps.add(emp1);
//        Habitacion hab1 = new Habitacion(1, "simple", 1, 100000);
//        Habitacion hab2 = new Habitacion(2, "doble", 2, 300000);
//        Habitacion hab3 = new Habitacion(3, "familiar", 4, 500000);
//        Habitacion hab4 = new Habitacion(4, "simplevip", 1, 300000);
//        Habitacion hab5 = new Habitacion(5, "doblevip", 2, 700000);
//        Habitacion hab6 = new Habitacion(6, "familiarvip", 4, 1000000);
//        hab1.addCalificacion(new Huesped(), 0f);
//        hab2.addCalificacion(new Huesped(), 1f);
//        hab3.addCalificacion(new Huesped(), 2f);
//        hab4.addCalificacion(new Huesped(), 3f);
//        hab5.addCalificacion(new Huesped(), 4f);
//        hab6.addCalificacion(new Huesped(), 5f);
//        habs.add(hab1);
//        habs.add(hab2);
//        habs.add(hab3);
//        habs.add(hab4);
//        habs.add(hab5);
//        habs.add(hab6);
//        Hotel hot = new Hotel(cb, "Hotel1", "Medellin",servs, habs, emps);
//        Base.addHoteles(hot);
        
        
//        Preferencias pref = new Preferencias("Cali","Hotel2","SIMPLE");
//        ArrayList<Preferencias> prefs = new ArrayList<>();
//        Huesped hue = new Huesped(true, prefs, null, 0, "david", "1", null);
//        Base.addHuespedes(hue);

        //Calificar.seleccionar();
        // CuentaBancaria cb = new CuentaBancaria(1000000000, "d");
//       
        
        
        //  Pruebas recomendaciones    

//        ArrayList<Habitacion> habs = new ArrayList<>();
//        Habitacion hab1 = new Habitacion(1, "simple", 1, 100000);
//        Habitacion hab2 = new Habitacion(2, "doble", 2, 300000);
//        Habitacion hab3 = new Habitacion(3, "familiar", 4, 500000);
//        Habitacion hab4 = new Habitacion(4, "vipsimple", 1, 300000);
//        Habitacion hab5 = new Habitacion(5, "vipdoble", 2, 700000);
//        Habitacion hab6 = new Habitacion(6, "vipfamiliar", 4, 1000000);
//        hab1.addCalificacion(new Huesped(), 0f);
//        hab2.addCalificacion(new Huesped(), 1f);
//        hab3.addCalificacion(new Huesped(), 2f);
//        hab4.addCalificacion(new Huesped(), 3f);
//        hab5.addCalificacion(new Huesped(), 4f);
//        hab6.addCalificacion(new Huesped(), 5f);
//        habs.add(hab1);
//        habs.add(hab2);
//        habs.add(hab3);
//        habs.add(hab4);
//        habs.add(hab5);
//        habs.add(hab6);
//        ArrayList<Empleado> empleados = new ArrayList<>();
//        Empleado empleado = new Empleado(null, 0, null, null, null, 0);
//        empleados.add(empleado);
//        Hotel hotel = new Hotel(new CuentaBancaria(0, null), "Hotel", "Medellin", null, habs,empleados);
//        Hotel hotel2 = new Hotel(new CuentaBancaria(0, null), "Hotel2", "Cali", null, habs,empleados);
//        Hotel hotel3 = new Hotel(new CuentaBancaria(0, null), "Hotel3", "Medellin", null, habs,empleados);
//        Base.addHoteles(hotel);
//        Base.addHoteles(hotel2);
//        Base.addHoteles(hotel3);
//        ArrayList<Preferencias> preferencias = new ArrayList<>();
//        Preferencias preferencia = new Preferencias("Cali", "Hotel2", "vipsimple");
//        preferencias.add(preferencia);
//        Preferencias preferencia2 = new Preferencias("Medellin", "Hotel", "vipfamiliar");
//        preferencias.add(preferencia2);
//        Huesped huesped = new Huesped(false,preferencias, null, 0, "Alejandra", "1", null);
//        Base.addHuespedes(huesped);
//        Huesped huesped2 = new Huesped(false, preferencias, null, 0, null, null, null);
//        Reserva reserva = new Reserva(huesped, hab6, null, null, 0);
//        reserva.setCalificacionHotel(5);
//        reserva.setCiudad("Medellin");
//        reserva.setHotel(hotel);
//        huesped.addReserva(reserva);
//        huesped.setId(1);
//        Reserva reserva2 = new Reserva(huesped, hab5, null, null, 0);
//        reserva2.setCiudad("Medellin");
//        reserva2.setHotel(hotel3);
//        reserva2.setCalificacionHotel(5);
//        huesped.addReserva(reserva2);
//        hab6.addCalificacion(huesped, 5f); 
//        hab5.addCalificacion(huesped, 5f);
              
        

        Login.login();
    }
    
    //Se encarga de comprobar si la fecha actual concuerda con el inicio de reserva de alguna persona,
    //para que en caso positivo le avise que su reserva comenzó
    static boolean isIni(){
        Calendar fechaActual = Calendar.getInstance();
        String[] fIni;
        Calendar fechaIni;
        for (Hotel hotel : Base.getHoteles()){
            for (Habitacion habitacion : hotel.getHabitaciones()){
                if (!habitacion.isReservada()){
                    for (Reserva reserv : habitacion.getReservas()){
                        fIni = reserv.getFechaEntrada().split("/");
                        fechaIni = Calendar.getInstance();
                        fechaIni.set(Calendar.DATE, Integer.parseInt(fIni[0]));
                        fechaIni.set(Calendar.MONTH, Integer.parseInt(fIni[1])-1);
                        fechaIni.set(Calendar.YEAR, Integer.parseInt(fIni[2]));
                        if (fechaIni.get(Calendar.DAY_OF_YEAR) == fechaActual.get(Calendar.DAY_OF_YEAR)){
                            habitacion.setReservada(true);
                            reserv.getHuesped().setEnReserva(true);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    
    //Se encarga de comprobar si la fecha actual concuerda con el fin de reserva de alguna persona,
    //para que en caso positivo elimine la reserva y le avise a la persona, llevandolo luego al
    //menú de calificación
    static boolean isFinal(){
        Calendar fechaActual = Calendar.getInstance();
        String[] fFin;
        Calendar fechaFin;
        for (Hotel hotel : Base.getHoteles()){
            for (Habitacion habitacion : hotel.getHabitaciones()){
                if (habitacion.isReservada()){
                    System.out.println("hola");
                    for (Reserva reserv : habitacion.getReservas()){
                        fFin = reserv.getFechaSalida().split("/");
                        fechaFin = Calendar.getInstance();

                        fechaFin.set(Calendar.DATE, Integer.parseInt(fFin[0]));
                        fechaFin.set(Calendar.MONTH, Integer.parseInt(fFin[1])-1);
                        fechaFin.set(Calendar.YEAR, Integer.parseInt(fFin[2]));

                        if (fechaActual.get(Calendar.DAY_OF_YEAR) == fechaFin.get(Calendar.DAY_OF_YEAR)){
                            
                            return true;
                        }
                    }
                }
                
            }  
        }  
        return false;
    }
    
    static void sistema(Huesped huesped){               //Sobrecarga de método sistema
        //System.out.println(huesped.getPreferencias());
//        System.out.println(huesped.isEnReserva());
//        System.out.println(Base.getHoteles().get(0).getHabitaciones().get(0).getReservas().get(0).getHuesped().getNombre());
        if (isIni()){                      //Revisa si la reserva de un cliente comenzó
            System.out.println("\nAVISO");
            System.out.println("---------\n");
            System.out.println("Su estancia ha comenzado. Gracias por hospedarte en nuestro hotel");
        }
        if (isFinal()){                      //Revisa si la reserva de un cliente terminó
            System.out.println("\nAVISO");
            System.out.println("---------\n");
            System.out.println("Su estancia ha terminado. Gracias por hospedarte en nuestro hotel.\n\n"
                    + "A continuación se presentarán los servicios los que recurrió durante su instancia en orden:\n");
            for (ServiciosExtra servicio: huesped.getReserva().getServicios()){
                System.out.println(servicio.getTipoServicio());
            }
            System.out.println("\nCosto total de la estadía: "+huesped.getReserva().getCosto());
            System.out.println("----------------------------------\n");
            System.out.println("Se le direccionará al menú de calificaciones: ");
            // Ingresar aqui el metodo que lleva al menu de calificaciones
            Calificar.seleccionar(huesped);
        }
        
        Scanner sc = new Scanner(System.in);
        System.out.println("MENÚ PRINCIPAL");
        System.out.println("---------------");
        System.out.println("Seleccione alguna de las siguientes opciones (Ingrese el número que corresponde a la opción deseada):\n"
                + "1: Reservar una habitación\n"
                + "2: Agregar preferencias\n"
                + "3: Ver cuenta bancaria\n"
                + "4: Ver reserva\n"
                + "5: Ver recomendaciones\n"
                + "6: Agregar servicio\n"
                + "7: Salir\n");
        int opcion;
        while (true){
            opcion = sc.nextInt();
            if (opcion<1 || opcion>7){
                System.out.println("Error. Debe ingresar uno de los números correspondientes a una opcion");
                continue;
            }
            break;
        }
        
        switch (opcion){
            case 1: Reservar.reservar(huesped); break;
            case 2: agregarPreferencia(huesped); break; 
            case 3: adminCuenta(huesped); break;
            case 4: adminReserva(huesped); break;
            case 5: Recomendar.seleccionar(huesped); break;
            case 6: cicloMenuHuespedServicio(huesped); break;
            case 7: salir(); break;
        }
    }
    
    
    //Método con el cual se pretende darle al usuario una serie de listas de ciudades, hoteles y habitaciones
    //en las cuales deberá escoger sus preferencias para posteriormente agregarlas a su lista de preferencias. 
    public static void agregarPreferencia(Huesped huesped){
        Scanner sc = new Scanner(System.in);
        ArrayList<Hotel> hotelesBase = Base.getHoteles();
        ArrayList<String> ciudades = new ArrayList<>();
        for(Hotel hotel: hotelesBase){
            if(ciudades.indexOf(hotel.getCiudad())==-1){
               ciudades.add(hotel.getCiudad());
            }
        }
        System.out.println("LISTA DE CIUDADES:");
        for(String ciudad: ciudades){
            System.out.println(ciudad);
        }
        System.out.println("Ingrese la ciudad que desea agregar a sus preferencias:");
        String ciudad = sc.nextLine();
        while(ciudades.indexOf(ciudad)==-1){
            System.out.println("La ciudad no se encuentra en la lista de ciudades");
            ciudad = sc.nextLine();
        }
        System.out.println("LISTA DE HOTELES:");
        for(Hotel hotel:hotelesBase){
            System.out.println(hotel.getNombre());
        }
        System.out.println("Ingrese el hotel que desea agregar a sus preferencias:");
        String hotel = sc.nextLine();
        boolean verificador = false;
        while(verificador){
            for(Hotel hotelBase: hotelesBase){
                if(hotelBase.getNombre().equals(hotel)){
                    verificador = false;
                    break;
                }
            }
            if(verificador){
                System.out.println("El hotel no se encuentra en la lista de ciudades");
                hotel = sc.nextLine();
            }
        }
        TipoHabitacion[] habitaciones = TipoHabitacion.values();
        System.out.println("LISTA DE TIPOS DE HABITACIONES:");
        for(int i=0;i<habitaciones.length;i++){
            System.out.println(habitaciones[i]);
        }
        System.out.println("Ingrese el tipo de habitacion que desea agregar a sus preferencias:");
        String habitacion = sc.nextLine();
         boolean verificacion = false;
        while(verificacion){
            for(int i=0;i<habitaciones.length;i++){
                if(habitaciones[i].name().equals(habitacion)){
                   verificacion = false;
                   break; 
                }
            }
            if(verificacion){
                System.out.println("El tipo de habitación no se encuentra en la lista de habitaciones");
                habitacion = sc.nextLine();
            }
        }
        
        huesped.agregarPreferencias(ciudad, hotel, habitacion);
        System.out.println("\n------------------\n");
        System.out.println("La preferencia se agregó satisfactoriamente");
        System.out.println("\n----------------------\n");
        System.out.println("Seleccione alguna de las siguientes opciones:");
        System.out.println("1: Agregar nueva preferencia"+
        "\n2: Volver al menú principal");
        int opcion;
        opcion = sc.nextInt();
        while(opcion!=1 && opcion!=2){
            System.out.println("Ingrese una opción válida");
             System.out.println("Seleccione alguna de las siguientes opciones:");
            System.out.println("1: Agregar nueva preferencia"+
            "\n2: Volver al menú principal");
            opcion = sc.nextInt();
        }
        switch (opcion) {
            case 1:
                agregarPreferencia(huesped);
                break;
            case 2:
                sistema(huesped);
                break;
        }
    }
    
    public static void adminCuenta(Huesped huesped){        //administrar cuenta bancaria del huesped
        Scanner sc = new Scanner(System.in);
        CuentaBancaria cuenta = huesped.getCuentaBancaria();
        System.out.println("MENÚ CUENTA BANCARIA");
        System.out.println("--------------------\n");
        System.out.println("Información de la cuenta: \n");
        System.out.println("Número de cuenta"+ cuenta.getNumero()+ "\n"
                + "Banco: "+ cuenta.getBanco()+"\n"
                + "Saldo: "+ cuenta.getSaldo()+"\n");
        
        System.out.println("Seleccione algunas de las siguientes opciones:\n"
                + "1: Consignar\n"
                + "2: Volver al menú principal\n");
        int opcion;
        while (true){
            opcion = sc.nextInt();
            if (opcion<1 || opcion>2){
                System.out.println("Error. Debe ingresar un número correspondiente a las opciones dadas");
                continue;
            }
            break;
        }
        switch (opcion){
            case 1:
                System.out.print("¿Cuanto dinero quiere depositar?: ");
                int deposito;
                while (true){
                    deposito = sc.nextByte();
                    if (deposito<0){
                        System.out.println("Error. Debe ingresar un número adecuado");
                        continue;
                    }
                    break;
                }
                huesped.getCuentaBancaria().depositar(deposito);
                break; 
            case 2:
                sistema(huesped);
                break;
        }
    }
    
    public static void adminReserva(Huesped huesped){   //Administrar reserva
        Scanner sc = new Scanner(System.in);
        if (huesped.getReserva() == null){
            System.out.println("\nNo tiene una reserva");
            sistema(huesped);
        }
        Reserva reserva = huesped.getReserva();
        ArrayList<String> sE = new ArrayList<>();
        for (ServiciosExtra servs: reserva.getServicios()){
            sE.add(servs.getTipoServicio());
        }
        System.out.println("\nInformación de la reserva:\n"
                + "Hotel: "+reserva.getHotel().getNombre()+"\n"
                + "Ciudad: "+reserva.getCiudad()+"\n"
                + "Fecha de inicio: "+ reserva.getFechaEntrada()+ "\n"
                + "Fecha de fin: "+ reserva.getFechaSalida()+ "\n"
                + "Costo total: "+ reserva.getCosto()+ "\n"
                + "Servicios: "+ sE);
                
        
        System.out.println("Escoja alguna de las siguientes opciones:\n"
                + "1: Eliminar reserva\n"
                + "2: Volver al menú principal\n");
        int opcion;
        while (true){
            opcion = sc.nextInt();
            if(opcion<1 || opcion>2){
                System.out.println("Error. Debe ingresar un número correspondiente a una de las opciones");
                continue;
            }
            break;
        }
        switch(opcion){
            case 1: 
                System.out.println(huesped.getReserva().eliminarReserva());
                System.out.println("Su reserva ha sido eliminada. Será llevado al menú de calificación:\n");
                //Insertar metodo que lleva al menu de calificacion
            case 2: sistema(huesped);
        }
    }
    
    
    static void sistema(Empleado empleado){        //Sobrecarga de método sistema
        Scanner sc = new Scanner(System.in);
        System.out.println("MENÚ PRINCIPAL");
        System.out.println("---------------");
        System.out.println("Seleccione alguna de las siguientes opciones (Ingrese el número que corresponde a la opción deseada):\n"
                + "1: Ver cuenta bancaria\n"
                + "2: Salir\n");
        int opcion;
        while (true){
            opcion = sc.nextInt();
            if (opcion<1 || opcion>2){
                System.out.println("Error. Debe ingresar uno de los números correspondientes a una opcion");
                continue;
            }
            break;
        }
        
        switch (opcion){
            case 1: empleadoCB(empleado); break;
            case 2: salir(); break;
        }
        
    }
    
    static void empleadoCB(Empleado empleado){
        Scanner sc = new Scanner(System.in);
        CuentaBancaria cuenta = empleado.getCuentaBancaria();
        System.out.println("MENÚ CUENTA BANCARIA");
        System.out.println("--------------------\n");
        System.out.println("Información de la cuenta: \n");
        System.out.println("Número de cuenta"+ cuenta.getNumero()+ "\n"
                + "Banco: "+ cuenta.getBanco()+"\n"
                + "Saldo: "+ cuenta.getSaldo()+"\n"
                + "Ultimo pago: "+empleado.getUltimoPago());
        
        System.out.println("Seleccione algunas de las siguientes opciones:\n"
                + "1: Volver al menú principal\n");
        int opcion;
        while (true){
            opcion = sc.nextInt();
            if (opcion != 1){
                System.out.println("Error. Debe ingresar un número correspondiente a las opciones dadas");
                continue;
            }
            break;
        }
        switch (opcion){
            case 1:
                salir();
        }
    }
    
    static void sistema(Administrador administrador){       //Sobrecarga de método sistema
        System.out.println("MENÚ PRINCIPAL");
        System.out.println("---------------\n");
        
        cicloMenuAdmin(administrador);
        
    }


    //MENÚ ADMINISTRADOR

    /*
     * Método que lista el menú de opciones que tiene
     * un usuario administrador
     */

//    public static int textoMenuAdmin(){
//        String mensaje = "Por favor indica que funcionalidad quieres realizar \n" +
//                 
//                        "   1. Listar administradores\n"+
//                        "   2. Pagar empleados\n"+
//                        "   3. Agregar nueva habitación al hotel\n"+
//                        "   4. Ver tu saldo en cuenta\n"+
//                        "   5. Listar habitaciones\n"+
//                        "   6. Añadir saldo al hotel\n"+
//                        "   7. Aumentar saldo al hotel\n"+
//                        "   8. Salir\n";
//
//        System.out.println(mensaje);
//        System.out.print("Opcion: ");
//        int opcion = scanner.nextInt();
//
//
//        return opcion;
//    }

    /*
     * Método que llama un el ciclo del menú de opciones que tendrá
     * un usuario
     */

    public static void cicloMenuAdmin(Administrador administrador){

        int opcion;

        do {
            String mensaje = "Por favor indica que funcionalidad quieres realizar \n" +
                 
                        "   1. Listar administradores\n"+
                        "   2. Pagar empleados\n"+
                        "   3. Agregar nueva habitación al hotel\n"+
                        "   4. Ver tu saldo en cuenta\n"+
                        "   5. Listar habitaciones\n"+
                        "   6. Saldo cuenta del hotel\n"+
                        "   7. Añadir saldo al hotel\n"+
                        "   8. Salir\n";

            System.out.println(mensaje);
            System.out.print("Opcion: ");
            
            opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    // Lógica para la opción 1
                    System.out.println("Opción 1 seleccionada");
                    System.out.println("\n-------------------------------");
                    System.out.println("Administradores:");
                    System.out.println(administrador.listarAdministradores());
                    System.out.println("-------------------------------\n");
                    break;
                case 2:
                    // Lógica para la opción 2
                    System.out.println("Opción 2 seleccionada");
                    /*
                    * FUNCIONALIDAD DE PAGAR EMPLEADOS
                    * 
                    * Funcionalidad que un administrador llama para 
                    * pagarle a el y a sus empleados con el dinero que
                    * hay en la cuenta bancaria del hotel
                    * 
                    */
                    System.out.println("\n-------------------------------");
                    System.out.println(administrador.pagarEmpleados());
                    System.out.println("-------------------------------\n");
                    break;
                case 3:
                    System.out.println("Opción 3 seleccionada");
                    System.out.println("\n-------------------------------");
                    System.out.println(administradorAgregaHabitacion(administrador));
                    System.out.println("-------------------------------\n");
                    break;
                case 4:
                    System.out.println("Opción 4 seleccionada");
                    System.out.println("\n-------------------------------");
                    System.out.println("Tienes saldo de: "+administrador.getCuentaBancaria().getSaldo());
                    System.out.println("Ultimo día de pago: "+administrador.getUltimoPago());
                    System.out.println("-------------------------------\n");
                    break;
                case 5:
                    System.out.println("Opción 5 seleccionada");
                    
                    System.out.println("\n-------------------------------");
                    for(Habitacion habitacion: administrador.getHotel().getHabitaciones()){
                        System.out.println("Habitación de tipo: " + habitacion.getTipo());
                    }
                    System.out.println("-------------------------------\n");

                    break;
                case 6:
                    System.out.println("Opción 6 seleccionada");
                    System.out.println("\n-------------------------------");
                    System.out.println("Saldo hotel: "+administrador.getHotel().getCuentaBancaria().getSaldo());
                    System.out.println("-------------------------------\n");
                    break;
                case 7:
                    System.out.println("Opción 6 seleccionada");
                    System.out.println("\n-------------------------------");
                    System.out.print("Coloque el saldo que quiere asignarle a su hotel: ");
                    int saldo = scanner.nextInt();
                    administrador.getHotel().getCuentaBancaria().setSaldo(saldo);
                    System.out.println("\nSe ha añadido correctamente el saldo\n");
                    sistema(administrador);
                    break;
                case 8:
                    System.out.println("Opción 7 seleccionada");
                    System.out.println("\n-------------------------------");
                    salir();
                    System.out.println("-------------------------------\n");
                    break;
                default:
                    System.out.println("Opción no válida, vuelve a intentarlo");
                    break;
            }
        } while (opcion != 7);


        /*
        int opcion = textoMenuAdmin();
        switch(opcion) {
            case 1:
                System.out.println("Opción 1 seleccionada");
                System.out.println(administrador.listarAdministradores());
                opcion = textoMenuAdmin();
            case 2:
                System.out.println("Opción 2 seleccionada");
                /*
                 * FUNCIONALIDAD DE PAGAR EMPLEADOS
                 * 
                 * Funcionalidad que un administrador llama para 
                 * pagarle a el y a sus empleados con el dinero que
                 * hay en la cuenta bancaria del hotel
                 * 
                 */
                /* 
                System.out.println(administrador.pagarEmpleados());
                opcion = textoMenuAdmin();
            case 3:
                System.out.println("Opción 3 seleccionada");
                System.out.println(administradorAgregaHabitacion(administrador));
                opcion = textoMenuAdmin();
            
            case 4:
                System.out.println("Opción 4 seleccionada");
                System.out.println(administrador.getCuentaBancaria().getSaldo());
                opcion = textoMenuAdmin();
                
            case 5:
                System.out.println("Opción 5 seleccionada");
                System.out.println(administrador.getHotel().getHabitaciones());
                opcion = textoMenuAdmin();

            case 6:
                System.out.println("Opción 6 seleccionada");
                salir();
          
            default:
                System.out.println("Opción no válida, vuelve a intentarlo");
                opcion = textoMenuAdmin();

        }

    */
    }
    
    /*
     * Método que llama un el ciclo del menú de opciones que tendrá
     * un Huesped para poderle crear un servicio.
     */
    public static void cicloMenuHuespedServicio(Huesped huesped){
        int opcion;

        if (huesped.getReserva() != null){

            do {
            String mensaje = "Por favor indica que funcionalidad quieres realizar \n" +
                        
                        "   1. Agregar servicio de tipo Transporte\n"+
                        "   2. Agregar servicio de tipo Alimentacion\n"+
                        "   3. Agregar servicio de tipo Limpieza\n"+
                        "   4. Eliminar Servicio\n"+
                        "   5. Salir\n";

            System.out.println(mensaje);
            System.out.print("Opcion: ");
                
            opcion = scanner.nextInt();
                    
            switch (opcion) {
                case 1:
                    // Lógica para la opción 1 agrega un Servicio de tipo Transporte al huesped
                    System.out.println("Opción 1 seleccionada");
                    System.out.println("\n-------------------------------");
                    System.out.println(ServiciosExtra.agregarServicioTransporte(huesped));
                    System.out.println("-------------------------------\n");
                    break;
                case 2:
                    // Lógica para la opción 2 agrega un Servicio de tipo Alimentación al huesped
                    System.out.println("Opción 2 seleccionada");
                    System.out.println("\n-------------------------------");
                    System.out.println(ServiciosExtra.agregarServicioAlimentacion(huesped));
                    System.out.println("-------------------------------\n");
                    break;
                case 3:
                    // Lógica para la opción 3 agrega un Servicio de tipo Limpieza al huesped
                    System.out.println("Opción 3 seleccionada");
                    System.out.println("\n-------------------------------");
                    System.out.println(ServiciosExtra.agregarServicioLimpieza(huesped));
                    System.out.println("-------------------------------\n");
                    break;
                case 4:
                    // Lógica para la opción 4 Elimina el servicioExtra del huesped
                    System.out.println("Opción 4 seleccionada");
                    System.out.println("\n-------------------------------");
                    System.out.println("Escoge el número del servicio que quieres eliminar");
                    int count = 1;
                    for (ServiciosExtra serviciosExtra: huesped.getReserva().getServicios()){

                        System.out.println(count+". "+ serviciosExtra.getTipoServicio());
                        count++;
                    }
                    
                    if (huesped.getReserva().getServicios().isEmpty()){
                        System.out.println("No tiene servicios.");
                        Menu.sistema(huesped);
                        break;
                    }
                    
                    int servicio = scanner.nextInt();
                    
                    if ((servicio < 0) || (servicio > huesped.getReserva().getServicios().size())){
                        System.out.println("Número incorrecto");
                    }else{
                        ServiciosExtra.eliminarServicio(huesped.getReserva().getServicios().get(servicio-1), huesped);
                        System.out.println("Servicio eliminado de la reserva correctamente");
                    }

                    System.out.println("-------------------------------\n");
                    break;
                case 5:
                    System.out.println("Opción 5 seleccionada");
                    System.out.println("\n-------------------------------");
                    salir();
                    System.out.println("-------------------------------\n");
                    break;

                default:
                    System.out.println("Opción no válida, vuelve a intentarlo");
                    break;
            }
        } while (opcion != 5);

        }else{
            System.out.println("Nos ha hecho una reserva. Primero has una reserva para agregar algún servicio extra");
        }

        
    }
    /*
     * Método que lista los tipos de habitaciones posibles (Las de el enum)
     * para que el administrador escoja que tipo de habitación quiere generar
     * para el hotel al cual trabaja
     */

    public static String administradorAgregaHabitacion(Administrador administrador){
        TipoHabitacion tipoEscogido;


        while (true){

            System.out.println("¿Qué tipo de habitación quieres agregar al hotel?");

            int contador = 1;

            for (TipoHabitacion tipoHabitacion : TipoHabitacion.values()) {
            
                System.out.println(contador + ". " + tipoHabitacion);

                contador++;
            }

            int opcion = scanner.nextInt();

            if (opcion <= TipoHabitacion.values().length){

                tipoEscogido = TipoHabitacion.values()[opcion];
                break;

            }else{

              System.out.println("Número incorrecto, por favor vuelve a intentar");  

            }

        }

        
        return administrador.administradorAgregaHabitacion(tipoEscogido);

    }

    //Pruebas

    static{

        /* 
        CuentaBancaria cuenta1 = new CuentaBancaria(99999, "Bancolombia");
        CuentaBancaria cuenta2 = new CuentaBancaria(19999, "Bancolombia");
        CuentaBancaria cuenta3 = new CuentaBancaria(29999, "Bancolombia");
        CuentaBancaria cuenta4 = new CuentaBancaria(39999, "WesterUnion");

        Hotel hotel = new Hotel(cuenta4);

        Administrador administrador1 = new Administrador(
            "Camilo", 
            12345678, 
            "kmi_san", 
            "12345",
            cuenta1,
            hotel);

        */

        //Empleado empleado1 = new Empleado("Juan", 12340, "Juanito", "987654", cuenta2);
        //Empleado empleado2 = new Empleado("Valentina", 876543, "vale12", "yetr55", cuenta3);

        //hotel.agregarEmpleado(empleado1);
        //hotel.agregarEmpleado(empleado2);

        //System.out.println(empleado1.getCuentaBancaria().getSaldo());
        //System.out.println(empleado2.getCuentaBancaria().getSaldo());

        //hotel.getCuentaBancaria().setSaldo(20000);

        //System.out.println("Bienvenido administrador "+administrador1.getNombre());

        

        //System.out.println(empleado1.getCuentaBancaria().getSaldo());
        //System.out.println(empleado2.getCuentaBancaria().getSaldo());
    }
    
    public static void salir(){
        System.out.println("Saliendo");
        Serializador.serializador();
        System.exit(0);
    }
}
