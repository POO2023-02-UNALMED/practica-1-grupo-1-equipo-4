/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uiMain;
import gestorAplicacion.Base;
import java.util.Scanner;
import gestorAplicacion.finanzas.*;
import gestorAplicacion.hotel.*;
import gestorAplicacion.usuarios.*;

/**
 *
 * @author david
 */
public class Signup {
    static void registerAdministrador(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nRegistro");
        System.out.println("-----------\n");
        String nombre = null;
        int telefono = 0;
        int id = 0;
        String username = null;
        String password = null;
        long numCB = 0;
        String banco = null;
        String nombreHotel = null;
        Hotel hotel = null;
        
        
        System.out.print("Ingrese su nombre completo: ");
        nombre = sc.nextLine();
        System.out.print("\nIngrese su número de teléfono: ");
        telefono = sc.nextInt();
        System.out.print("\nIngrese su número de identificación: ");
        id = sc.nextInt();
        System.out.print("\nIngrese un nombre de usuario: ");
        username = sc.nextLine();
        System.out.print("\nIngrese una contraseña: ");
        password = sc.nextLine();

        System.out.println("\nInformación de su cuenta bancaria:");
        System.out.println("------------------------------------\n");
        System.out.print("Ingrese el numero de su cuenta bancaria: ");
        numCB = sc.nextLong();
        System.out.print("\nIngrese el banco al que pertenece: ");
        banco = sc.nextLine();

        System.out.println("\nInformación del hotel que administra:");
        System.out.println("------------------------------------\n");
        System.out.print("Escoja el número del hotel que va a administrar");

        Hotel hotelAdmin;

        while(true){

            int contador =  1;

            for (Hotel hotelLista : Base.getHoteles()) {
                
                System.out.println(contador + ". " + hotelLista.getNombre());
                contador++;

            }

            int numeroHotel = sc.nextInt();

            if(numeroHotel <= Base.getHoteles().size()){

                hotelAdmin = Base.getHoteles().get(numeroHotel);
                break;

            }else{
                System.out.println("El número no hace referencia a ningún hotel, por favor escoja de nuevo");
            }

        }

        
/* 
        boolean correctName = false;
        while (true){
             for (Hotel hotelx : Base.getHoteles()){
                if(hotelx.getNombre().equals(nombreHotel)){
                    hotel = hotelx;
                    correctName = true;
                }
            }
            if (!correctName){
                System.out.println("El nombre que ingresaste es incorrecto, intente de nuevo\n");
            }
            else{
                break;
            }
        }  

        */

        Administrador admin = new Administrador(nombre, telefono, username, password, new CuentaBancaria(numCB, banco), hotelAdmin);
        Base.addAdministradores(admin);
        Menu.sistema(admin);
    }
        
    public static void registerEmpleado(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nRegistro");
        System.out.println("-----------\n");
        String nombre;
        int telefono;
        int id;
        String username;
        String password;
        long numCB;
        String banco;
        
        System.out.print("Ingrese su nombre completo: ");
        nombre = sc.nextLine();
        System.out.print("\nIngrese su número de teléfono: ");
        telefono = sc.nextInt();
        System.out.print("\nIngrese su número de identificación: ");
        id = sc.nextInt();
        System.out.print("\nIngrese un nombre de usuario: ");
        username = sc.nextLine();
        System.out.print("\nIngrese una contraseña: ");
        password = sc.nextLine();

        System.out.println("\nInformación de su cuenta bancaria:");
        System.out.println("------------------------------------\n");
        System.out.print("Ingrese el numero de su cuenta bancaria: ");
        numCB = sc.nextInt();
        System.out.print("\nIngrese el banco al que pertenece: ");
        banco = sc.nextLine();

        Empleado empleado = new Empleado(nombre, telefono, username, password, new CuentaBancaria(numCB, banco));
        Base.addEmpleados(empleado);
        System.out.println("\n ¿Deseas que se envíen publicidad a tu correo? Si es así se le otorgará un bono\n"
                + "Escriba Y(Sí) o N(No)");
        while (true){
            String answer = sc.nextLine();
            if (answer.equals("Y") && answer.equals("N")){
                System.out.print("Error. Tienes que ingresar los valore correspondientes.");
                continue;
            }
            switch (answer){
                case "Y":
                    empleado.ofrecerBono();
                    break;
                case "N":
                    break;
            }
            break;
        }
        Menu.sistema(empleado);
    }
            
         
    public static void register(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nRegistro");
        System.out.println("-----------\n");
        String nombre = null;
        int telefono = 0;
        int id = 0;
        String username = null;
        String password = null;
        long numCB = 0;
        String banco = null;
        String nombreHotel = null;
        Hotel hotel = null;
        
        System.out.print("Ingrese su nombre completo: ");
        nombre = sc.nextLine();
        System.out.print("\nIngrese su número de teléfono: ");
        telefono = sc.nextInt();
        System.out.print("\nIngrese su número de identificación: ");
        id = sc.nextInt();
        System.out.print("\nIngrese un nombre de usuario: ");
        username = sc.nextLine();
        System.out.print("\nIngrese una contraseña: ");
        password = sc.nextLine();

        System.out.println("\nInformación de su cuenta bancaria:");
        System.out.println("------------------------------------\n");
        System.out.print("Ingrese el numero de su cuenta bancaria: ");
        numCB = sc.nextInt();
        System.out.print("\nIngrese el banco al que pertenece: ");
        banco = sc.nextLine();

        boolean isVip = false;
        String vipOpcion;
        System.out.println("\nConfiguración inicial de su cuenta:");
        System.out.println("------------------------------------\n");
        System.out.print("¿Desea ser un huesped VIP? Presione Y(Sí) o N(No): ");
        
        
        while(true){
            vipOpcion = sc.nextLine();
            if (vipOpcion.equals("Y") && vipOpcion.equals("N")){
                System.out.print("Error. Tienes que ingresar los valore correspondientes.");
                continue;
            }
            switch(vipOpcion){
            case "Y": isVip=true; break;
            case "N": isVip=false; break;
            }
            break;
        }
        
        //Huesped huesped = new Huesped(nombre, telefono, username, password, new CuentaBancaria(numCB, banco));
    }
        
        
}
