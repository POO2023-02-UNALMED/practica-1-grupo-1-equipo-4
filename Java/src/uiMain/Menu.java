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


import java.util.Scanner;
/**
 *
 * @author david
 */
public class Menu {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        
        //Calificar.seleccionar();
        Administrador administradorinicial = new Administrador("Juan", 12234, "juank", "12345678", new CuentaBancaria(1234, "Bancolombia"), new Hotel());
        Administrador administradorinicial2 = new Administrador("Juan", 12234, "juank", "12345678", new CuentaBancaria(1234, "Bancolombia"), new Hotel());
        Administrador administradorinicial3 = new Administrador("Juan", 12234, "juank", "12345678", new CuentaBancaria(1234, "Bancolombia"), new Hotel());
        Base.addAdministradores(administradorinicial);
        Base.addAdministradores(administradorinicial2);
        //Base.addAdministradores(administradorinicial3);
        for (Administrador ad : Base.getAdministradores()) {
            System.out.println(ad.getNombre());
        }
        //Login.login();
    }
    
    static void sistema(Huesped huesped){
        Scanner sc = new Scanner(System.in);
        System.out.println("MENÚ PRINCIPAL");
        System.out.println("---------------\n");
        System.out.println("Seleccione alguna de las siguientes opciones (Ingrese el número que corresponde a la opción deseada):\n"
                + "1: Reservar una habitación\n"
                + "2: Cambiar preferencias\n"
                + "3: Salir");
        int opcion;
        opcion = sc.nextInt();
        switch (opcion){
//          case 1: Reservar.reservar();
            case 2: System.out.println("");
            case 3: System.exit(0);
        }
    }
    static void sistema(Empleado empleado){
        System.out.println("MENÚ PRINCIPAL");
        System.out.println("---------------\n");
        
        
    }
    static void sistema(Administrador administrador){
        System.out.println("MENÚ PRINCIPAL");
        System.out.println("---------------\n");

        cicloMenuAdmin(administrador);;
        
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
                        "   3. Agregar nueva habitación al hotel"+
                        "   4. Salir\n";

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
                System.out.println(administrador.pagarEmpleados());
                opcion = textoMenuAdmin();
            case 3:
                System.out.println("Opción 3 seleccionada");
                System.out.println(administradorAgregaHabitacion(administrador));
                
            case 4:
                System.out.println("Opción 4 seleccionada");
                opcion = textoMenuAdmin();
            default:
                System.out.println("Opción no válida, vuelve a intentarlo");
                opcion = textoMenuAdmin();

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
}
