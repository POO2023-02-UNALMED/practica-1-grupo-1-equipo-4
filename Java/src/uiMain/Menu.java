/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uiMain;
import uiMain.*;
import gestorAplicacion.finanzas.*;
import gestorAplicacion.hotel.*;
import gestorAplicacion.usuarios.*;
import java.util.Scanner;
/**
 *
 * @author david
 */
public class Menu {
    public static void main(String[] args){
        Login.login();
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
        
    }
}
