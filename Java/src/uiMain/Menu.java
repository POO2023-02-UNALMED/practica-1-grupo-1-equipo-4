/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uiMain;
import uiMain.*;
import gestorAplicacion.finanzas.*;
import gestorAplicacion.hotel.*;
import gestorAplicacion.usuarios.*;
/**
 *
 * @author david
 */
public class Menu {
    public static void main(String[] args){
        Login.login();
    }
    
    static void sistema(Huesped huesped){
        System.out.println("MENÚ PRINCIPAL");
        System.out.println("---------------\n");
        
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
