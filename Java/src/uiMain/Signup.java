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
import java.util.ArrayList;

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
        String hotelname;
        Hotel belongHotel = null;
        String banco;
        
        System.out.print("Ingrese su nombre completo: ");
        nombre = sc.nextLine();
        System.out.print("\nIngrese su número de teléfono: ");
        telefono = sc.nextInt();
        sc.nextLine();
        System.out.print("\nIngrese un nombre de usuario: ");
        while (true){
            boolean rNom = false;
            username = sc.nextLine();
            for (Empleado x :Base.getEmpleados()){      //Revisar que no tenga el mismo nombre de usuario
                if (x.getUsername().equals(username)){
                    System.out.println("\nEste nombre ya está en uso. Intente de nuevo\n");
                    rNom = true;
                    break;
                }
            }
            if (!rNom){
                break;
            }
        }
        
        System.out.print("\nIngrese una contraseña: ");
        password = sc.nextLine();

        System.out.println("\nInformación de su cuenta bancaria:");
        System.out.println("------------------------------------\n");
        System.out.print("Ingrese el saldo de su cuenta: ");
        numCB = sc.nextLong();
        sc.nextLine();
        System.out.print("\nIngrese el banco al que pertenece: ");
        banco = sc.nextLine();
        
        System.out.println("\nInformación hotel:");
        System.out.println("------------------------------------\n");
        System.out.print("Ingrese el hotel en el que trabajará: ");
        while (true){
            boolean fHotel = false;
            hotelname = sc.nextLine();
            for (Hotel hotel: Base.getHoteles()){
                if (hotelname.equals(hotel.getNombre())){
                    belongHotel = hotel;
                    fHotel = true;
                    break;
                }
            }
            if (fHotel){
                break;
            }
            else{
                System.out.print("El nombre del hotel que ingresó no se encontró. Intente de nuevo: ");
            }
        }    
            
        Empleado empleado = new Empleado(nombre, telefono, username, password, new CuentaBancaria(numCB, banco));
        empleado.setHotel(belongHotel);
        Base.addEmpleados(empleado);
        System.out.println("\n¿Deseas que se envíen publicidad a tu correo? Si es así se le otorgará un bono\n"
                + "Escriba Y(Sí) o N(No)\n");
        sc.nextLine();
        while (true){
            String answer = sc.nextLine();
            if (!answer.equals("Y") && !answer.equals("N")){
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
        intro(empleado);
        Menu.sistema(empleado);
    }
            
         
    public static void register(){
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
        String nombreHotel;
        Hotel hotel;
        String selectedCity;
        String selectedHotel;
        String selectedType;
        
        System.out.print("Ingrese su nombre completo: ");
        nombre = sc.nextLine();
        System.out.print("\nIngrese su número de teléfono: ");
        telefono = sc.nextInt();
        sc.nextLine();
        System.out.print("\nIngrese un nombre de usuario: ");
        while (true){
            boolean rNom = false;
            username = sc.nextLine();
            for (Huesped x :Base.getHuespedes()){      //Revisar que no tenga el mismo nombre de usuario
                if (x.getUsername().equals(username)){
                    System.out.println("\nEste nombre ya está en uso. Intente de nuevo\n");
                    rNom = true;
                    break;
                }
            }
            if (!rNom){
                break;
            }
        }
                
        System.out.print("\nIngrese una contraseña: ");
        password = sc.nextLine();

        System.out.println("\nInformación de su cuenta bancaria:");
        System.out.println("------------------------------------\n");
        System.out.print("Ingrese el saldo de su cuenta: ");
        numCB = sc.nextLong();
        sc.nextLine();
        System.out.print("\nIngrese el banco al que pertenece: ");
        banco = sc.nextLine();

        boolean isVip = false;
        String vipOpcion;
        System.out.println("\nConfiguración inicial de su cuenta:");
        System.out.println("------------------------------------\n");
        System.out.print("¿Desea ser un huesped VIP? Presione Y(Sí) o N(No): ");
        while(true){
            vipOpcion = sc.nextLine();
            if (!vipOpcion.equals("Y") && !vipOpcion.equals("N")){
                System.out.println("Error. Tienes que ingresar los valore correspondientes.\n");
                continue;
            }
            switch(vipOpcion){
            case "Y": isVip=true; break;
            case "N": isVip=false; break;
            }
            break;
        }
        
        System.out.print("\nElija la cuál de las siguientes ciudades prefiere: \n");
        int cc = 1;
        ArrayList<String> listCities = new ArrayList<>();
        for (Hotel favHotel: Base.getHoteles()){
            if (!listCities.contains(favHotel.getCiudad())){
                listCities.add(favHotel.getCiudad());
                System.out.println(cc+": "+favHotel.getCiudad()+"\n");
                cc++;
            }
        }
        while (true){
            int prefCity = sc.nextInt();
            if (prefCity < 1 || prefCity > cc){
                System.out.println("Error. Debe ingresar un número correspondiente al de las opciones\n");
                continue;
            }
            selectedCity = Base.getHoteles().get(prefCity-1).getCiudad();
            break;
        }
        
        System.out.print("\nElija el hotel que prefiere en nuestra cadena: \n");
        int ch = 1;
        for (Hotel favHotel: Base.getHoteles()){
            System.out.println(ch+": "+favHotel.getNombre()+"\n");
            ch++;
        }
        while (true){
            int prefHotel = sc.nextInt();
            if (prefHotel < 1 || prefHotel > ch){
                System.out.println("Error. Debe ingresar un número correspondiente al de las opciones\n");
                continue;
            }
            selectedHotel = Base.getHoteles().get(prefHotel-1).getNombre();
            break;
        }
        
        
        System.out.println("\nElija el tipo de habitación que prefiere de la siguiente lista: \n"
                + "1: Simple\n"
                + "2: Doble\n"
                + "3: Familiar\n");
        
        ArrayList<String> tipos = new ArrayList<>();
        tipos.add("simple");
        tipos.add("Doble");
        tipos.add("Familiar");
        while (true){
            int prefTipo = sc.nextInt();
            if (prefTipo != 1 && prefTipo != 2 && prefTipo != 3){
                System.out.println("Error. Debe ingresar un número correspondiente al de las opciones");
                continue;
            }
            selectedType = tipos.get(prefTipo);
            break;
        }
        
        ArrayList<Preferencias> pref = new ArrayList<>();
        pref.add(new Preferencias(selectedCity, selectedHotel, selectedType));
        Huesped huesped = new Huesped(isVip, pref, nombre, telefono, username, password, new CuentaBancaria(numCB, banco));
        Base.addHuespedes(huesped);
        System.out.println("\n¿Deseas que se envíe publicidad a tu correo? Si es así se le otorgará un bono\n"
                + "Escriba Y(Sí) o N(No)");
        sc.nextLine();
        while (true){
            String answer = sc.nextLine();
            if (!answer.equals("Y") && !answer.equals("N")){
                System.out.print("Error. Tienes que ingresar los valore correspondientes.");
                continue;
            }
            switch (answer){
                case "Y":
                    huesped.ofrecerBono();
                    break;
                case "N":
                    break;
            }
            break;
        }
        intro(huesped);
        Menu.sistema(huesped);
        
    }
      
    
    public static void intro(Usuario us){
        System.out.println("\n"+us.presentacion()+"\n");
    }
}
