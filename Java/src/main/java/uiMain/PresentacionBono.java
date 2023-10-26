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
public interface PresentacionBono {             //Interfaz
    final int BONOHUESPED = 50000;              //Uso de constante
    final int BONOEMPLEADO = 10000;             //Uso de constante
    
    public static String recogerDatos(Usuario usuario){
        String nombre = usuario.getNombre();
        int id = usuario.getId();
        int tel = usuario.getTelefono();
        String intro = "Mi nombre es " +nombre +" , mi id es "+ id + " y mi telefono es "+tel;
        return intro;
    }
    
    public abstract void ofrecerBono();
}
