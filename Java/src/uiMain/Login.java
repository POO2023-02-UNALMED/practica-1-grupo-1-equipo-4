/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uiMain;
import java.util.Scanner;
import gestorAplicacion.finanzas.*;
import gestorAplicacion.hotel.*;
import gestorAplicacion.usuarios.*;
import gestorAplicacion.Base;
/**
 *
 * @author david
 */
public class Login {
    static void login(){
        Scanner sc = new Scanner(System.in);
        int opcion;
        String us = null;
        
        System.out.println("CosmoReserve-Gestión Hotelera");
        System.out.println("-----------------------------\n");
        System.out.println("Ingrese su tipo de usuario (Ingrese el número que corresponde a la opción deseada):\n"
                + "1: Administrador\n"
                + "2: Empleado\n"
                + "3: Huesped\n");
        while(true){
            opcion = sc.nextInt();
            if (opcion != 1 && opcion != 2 && opcion != 3){
               System.out.println("Error: tiene que ingresar uno de los siguientes números: 1, 2 o 3");
               continue;
            }
            switch (opcion){
                case 1 : us = "administrador"; opcion = 0;break;
                case 2 : us = "empleado"; opcion = 0;break;
                case 3 : us = "huesped"; opcion = 0;break;
            }
            break;
        }    
        
        System.out.println("\nIngreso de usuario (Ingrese el número que corresponde a la opción deseada):\n"
                  + "1: Iniciar sesión"
                  + "2: Resgistrarse\n");  
        while (true){
            opcion = sc.nextInt();
            if (opcion != 1 && opcion != 2){
                System.out.println("Error: tiene que ingresar uno de los siguientes números: 1 o 2"); 
                continue;
            }else if (opcion == 2){
                if (us.equals("empleado") ||  us.equals("administrador")){
                    System.out.println("Error. El administrador del hotel es el que debe registrarlo. Si ya tiene una cuenta inicie sesión");
                    continue;
                }
            }
            switch (opcion){
                case 1 : Login.loginNext(us); break;
                case 2 : Signup.register(); break;
            }
            break;
        }
            
        
    }
    
    static void loginNext(String us){
        String nombre;
        String contrasena;
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------------\n");
        while (true){
            boolean correctRegist = false;
            System.out.println("Ingrese su nombre de usuario:");
            nombre = sc.nextLine();
            System.out.println("Ingrese su contraseña");
            contrasena = sc.nextLine();
            if (us.equals("administrador")){
                for (Administrador administrador: Base.getAdministradores()){
                    if (administrador.getUsername().equals(nombre) && administrador.getPassword().equals(contrasena)){
                        Menu.sistema(administrador);
                        correctRegist = true;
                        break;
                    }
                }
                if (!correctRegist){
                    System.out.println("\nContraseña o nombre de usuario incorrecto, intente de nuevo\n");
                }else{
                    break;
                }
                
                
            }else if (us.equals("empleado")){
                for (Empleado empleado: Base.getEmpleados()){
                    if (empleado.getUsername().equals(nombre) && empleado.getPassword().equals(contrasena)){
                        Menu.sistema(empleado);
                        break;
                    }
                    else{
                        System.out.println("\nContraseña o nombre de usuario incorrecto, intente de nuevo");
                    }
                }
                if (!correctRegist){
                    System.out.println("\nContraseña o nombre de usuario incorrecto, intente de nuevo\n");
                }else{
                    break;
                }
            }
            
            else if (us.equals("huesped")){
                for (Huesped huesped: Base.getHuespedes()){
                    if (huesped.getUsername().equals(nombre) && huesped.getPassword().equals(contrasena)){
                        Menu.sistema(huesped);
                        break;
                    }
                    else{
                        System.out.println("\nContraseña o nombre de usuario incorrecto, intente de nuevo");
                    }
                }
                if (!correctRegist){
                    System.out.println("\nContraseña o nombre de usuario incorrecto, intente de nuevo\n");
                }else{
                    break;
                }
            }
            
        }
    }
}

