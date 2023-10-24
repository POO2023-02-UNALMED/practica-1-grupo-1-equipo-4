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
 * @author david
 */
public class Menu {
    
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        Deserializador.deserializador();
        
        
        /*
         * Pruebas para administrador
         */

        
         /* 
        CuentaBancaria cbhotel = new CuentaBancaria(123456, "Bancolombia");
        CuentaBancaria cbadministrador = new CuentaBancaria(6789, "Bancolombia");
        CuentaBancaria cbempleado1 = new CuentaBancaria(6789, "Bancolombia");
        CuentaBancaria cbempleado2 = new CuentaBancaria(6789, "Bancolombia");

        Hotel hotel = new Hotel(cbhotel);
        hotel.getCuentaBancaria().setSaldo(100);

        Administrador administrador = new Administrador("Camilo", 12345, "kmi", "12345", cbadministrador, hotel);

        Empleado empleado1 = new Empleado("Juan", 1234, "Juan", "12345", cbempleado1, 200);
        Empleado empleado2 = new Empleado("Carlos", 1234, "Carlos", "12345", cbempleado2, 100);

        hotel.agregarEmpleado(empleado1);
        hotel.agregarEmpleado(empleado2);

        Base.addHoteles(hotel);
        Base.addAdministradores(administrador);
        Base.addEmpleados(empleado1);
        Base.addEmpleados(empleado2);
        */

//        System.out.println(Base.getHuespedes().get(0).getNombre());
//        System.out.println(Base.getHuespedes().get(0).equals(Base.getHoteles().get(0).getHabitaciones().get(0).getReservas().get(0).getHuesped().getNombre()));
        
//        CuentaBancaria cb = new CuentaBancaria(1000000000, "d");
//        ArrayList<Empleado> emps = new ArrayList<>();
//        ArrayList<ServiciosExtra> servs = new ArrayList<>();
//        ArrayList<Habitacion> habs = new ArrayList<>();
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

        //Calificar.seleccionar();
//        Administrador administradorinicial = new Administrador("Juan", 12234, "juank", "12345678", new CuentaBancaria(1234, "Bancolombia"), new Hotel());
//        Administrador administradorinicial2 = new Administrador("Juan", 12234, "juank", "12345678", new CuentaBancaria(1234, "Bancolombia"), new Hotel());
//        Administrador administradorinicial3 = new Administrador("Juan", 12234, "juank", "12345678", new CuentaBancaria(1234, "Bancolombia"), new Hotel());
//        Base.addAdministradores(administradorinicial);
//        Base.addAdministradores(administradorinicial2);
//        //Base.addAdministradores(administradorinicial3);
//        for (Administrador ad : Base.getAdministradores()) {
//            System.out.println(ad.getNombre());
//        }
//  Pruebas recomendaciones        

        Login.login();
    }
    
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
    
    static boolean isFinal(){
        Calendar fechaActual = Calendar.getInstance();
        String[] fFin;
        Calendar fechaFin;
        for (Hotel hotel : Base.getHoteles()){
            for (Habitacion habitacion : hotel.getHabitaciones()){
                if (habitacion.isReservada()){
                    for (Reserva reserv : habitacion.getReservas()){
                        fFin = reserv.getFechaSalida().split("/");
                        fechaFin = Calendar.getInstance();

                        fechaFin.set(Calendar.DATE, Integer.parseInt(fFin[0]));
                        fechaFin.set(Calendar.MONTH, Integer.parseInt(fFin[1])-1);
                        fechaFin.set(Calendar.YEAR, Integer.parseInt(fFin[2]));

                        if (fechaActual.get(Calendar.DAY_OF_YEAR) == fechaFin.get(Calendar.DAY_OF_YEAR)){
                            reserv.getHuesped().getReserva().eliminarReserva();
                            return true;
                        }
                    }
                }
                
            }  
        }  
        return false;
    }
    
    static void sistema(Huesped huesped){
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
                System.out.println(servicio.getNombre());
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
                + "2: Cambiar preferencias\n"
                + "3: Ver cuenta bancaria\n"
                + "4: Ver reserva\n"
                + "5: Ver recomendaciones\n"
                + "6: Salir\n");
        int opcion;
        while (true){
            opcion = sc.nextInt();
            if (opcion<1 || opcion>6){
                System.out.println("Error. Debe ingresar uno de los números correspondientes a una opcion");
                continue;
            }
            break;
        }
        
        switch (opcion){
            case 1: Reservar.reservar(huesped); break;
            case 2: agregarPreferencia(huesped); break;    //Ingresar aquí el metodo que lleva al cambio de preferencia
            case 3: adminCuenta(huesped); break;
            case 4: adminReserva(huesped); break;
            case 5: Recomendar.seleccionar(huesped); break;
            case 6: salir(); break;
        }
    }
    
    public static void agregarPreferencia(Huesped huesped){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> ciudades = Preferencias.getCiudades();
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
        ArrayList<Hotel> hotelesBase = Base.getHoteles();
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
                    verificador = true;
                    break;
                }
            }
            System.out.println("El hotel no se encuentra en la lista de ciudades");
            hotel = sc.nextLine();
        }
        TipoHabitacion[] habitaciones = TipoHabitacion.values();
        System.out.println("LISTA DE TIPOS DE HABITACIONES:");
        for(int i=0;i<habitaciones.length;i++){
            System.out.println(habitaciones[i]);
        }
        System.out.println("Ingrese el tipo de habitacion que desea agregar a sus preferencias:");
        String habitacion = sc.nextLine();
        while(!Arrays.asList(habitaciones).contains(habitacion)){
            System.out.println("El tipo de habitación no se encuentra en la lista de habitaciones");
            habitacion = sc.nextLine();
        }
        
        huesped.agregarPreferencias(ciudad, hotel, habitacion);
        int opcion = sc.nextInt();
        System.out.println("Seleccione alguna de las siguientes opciones:");
        System.out.println("1: Agregar nueva preferencia"+
        "\n2: Volver al menú principal");
        while(opcion!=1 || opcion!=2){
            System.out.println("Ingrese una opción válida");
             System.out.println("Seleccione alguna de las siguientes opciones:");
            System.out.println("1: Agregar nueva preferencia"+
            "\n2: Volver al menú principal");
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
        System.out.println("\nInformación de la reserva:\n"
                + "Hotel: "+reserva.getHotel().getNombre()+"\n"
                + "Ciudad: "+reserva.getCiudad()+"\n"
                + "Fecha de inicio: "+ reserva.getFechaEntrada()+ "\n"
                + "Fecha de fin: "+ reserva.getFechaSalida()+ "\n"
                + "Costo total: "+ reserva.getCosto()+ "\n");
        
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
    
    
    static void sistema(Empleado empleado){
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
    
    static void sistema(Administrador administrador){
        System.out.println("MENÚ PRINCIPAL");
        System.out.println("---------------\n");
        
        cicloMenuAdmin(administrador);
        
    }


    //MENÚ ADMINISTRADOR

    /*
     * Método que lista el menú de opciones que tiene
     * un usuario administrador
     */

    public static int textoMenuAdmin(){
        String mensaje = "Por favor indica que funcionalidad quieres realizar \n" +
                 
                        "   1. Listar administradores\n"+
                        "   2. Pagar empleados\n"+
                        "   3. Agregar nueva habitación al hotel\n"+
                        "   4. Ver tu saldo en cuenta\n"+
                        "   5. Listar habitaciones\n"+
                        "   6. Salir\n";

        System.out.println(mensaje);
        System.out.print("Opcion: ");
        int opcion = scanner.nextInt();


        return opcion;
    }

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
                        "   7. Salir\n";

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
                    System.out.println("Opción 7 seleccionada");
                    System.out.println("\n-------------------------------");
                    salir();
                    System.out.println("-------------------------------\n");
                    break;
                default:
                    System.out.println("Opción no válida, vuelve a intentarlo");
                    break;
            }
        } while (opcion != 3);


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
