/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestorAplicacion;

import gestorAplicacion.hotel.*;
import gestorAplicacion.usuarios.*;
import gestorAplicacion.finanzas.*;
import java.util.ArrayList;
import java.io.Serializable;

import java.util.ArrayList;


public class Base implements Serializable{
    private static final long serialVersionUID = 1L;
    private static ArrayList<Administrador> _administradores = new ArrayList<>();
    private static ArrayList<Hotel> _hoteles = new ArrayList<>();
    
    
    public static void setAdministradores(ArrayList<Administrador> administradores){
        Base._administradores = administradores;
    }
    
    public static ArrayList<Administrador> getAdministradores(){
        return Base._administradores;
    }
    
    public static void addAdministradores(Administrador administrador){
        Base._administradores.add(administrador);;
    }
    
    
    
    public static void setHoteles(ArrayList<Hotel> hoteles){
        Base._hoteles = hoteles;
    }
    
    public static ArrayList<Hotel> getHoteles(){
        return Base._hoteles;
    }
    
    public static void addHoteles(Hotel hotel){
        Base._hoteles.add(hotel);
    }
}
