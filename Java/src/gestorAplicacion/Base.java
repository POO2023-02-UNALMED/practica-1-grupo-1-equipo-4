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
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import uiMain.Reservar;

/*
    Author David Restrepo Aguilar
*/

// Esta clase se encarga de administrar la base de datos del programa y realizar los filtros que implementa
//la aplicación
public class Base implements Serializable{
    private static final long serialVersionUID = 1L;
    private static ArrayList<Administrador> _administradores = new ArrayList<>();
    private static ArrayList<Hotel> _hoteles = new ArrayList<>();
    private static ArrayList<Huesped> huespedes = new ArrayList<>();
    private static ArrayList<Empleado> empleados = new ArrayList<>();
    
    public static void setAdministradores(ArrayList<Administrador> administradores){
        Base._administradores = administradores;
    }
    
    public static ArrayList<Administrador> getAdministradores(){
        return Base._administradores;
    }
    
    public static void addAdministradores(Administrador administrador){
        Base._administradores.add(administrador);
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

    public static ArrayList<Huesped> getHuespedes() {
        return huespedes;
    }

    public static void setHuespedes(ArrayList<Huesped> huespedes) {
        Base.huespedes = huespedes;
    }
    
    public static void addHuespedes(Huesped huesped){
        Base.huespedes.add(huesped);
    }

    public static ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public static void setEmpleados(ArrayList<Empleado> empleados) {
        Base.empleados = empleados;
    }
    
    public static void addEmpleados(Empleado empleado){
        Base.empleados.add(empleado);
    }
    
    
    //Se encarga de filtrar lo hoteles por ciudades ingresadas
    public static ArrayList<Hotel> filtrarPorCiudad(){
        ArrayList<Hotel> hotelesFiltrados = new ArrayList<>();
        String ciudad;
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre de la ciudad en la que desea hospedarse: ");
        while (true){
            ciudad = sc.nextLine();
            for(Hotel hotel: _hoteles){
                if (hotel.getCiudad().equals(ciudad)){
                    hotelesFiltrados.add(hotel);
                }
            }
            if (hotelesFiltrados.isEmpty()){
                System.out.print("El nombre de la ciudad que ingresaste no se encuentra en la base de datos, intente de nuevo: ");
            }
            else{
                break;
            }
        }
        return hotelesFiltrados;   
    }
    
    
    //Se encarga de filtrar por nombre del hotel
    public static Hotel filtrarPorNombre(){
        Hotel hotelNombre = null;
        boolean foundHotel = false;
        String nombre;
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre del hotel en el que desea hospedarse: ");
        while (true){
            nombre = sc.nextLine();
            for(Hotel hotel: _hoteles){
                if (hotel.getNombre().equals(nombre)){
                    hotelNombre = hotel;
                    foundHotel = true;
                }
            }
            if (!foundHotel){
                System.out.print("El nombre del hotel que ingresó no se encuentra en la base de datos, intente de nuevo: ");
            }
            else{
                break;
            }
        }
        return hotelNombre;
    }
    
    //Se encarga de filtrar las habitaciones por su id
    public static Habitacion filtrarRoomPorID(Hotel hotel, Huesped huesped){
        Scanner sc = new Scanner(System.in);
        boolean found = false;
        boolean reservada = false;
        Habitacion foundRoom = null;
        System.out.print("\nIngrese el id de la habitación que desea reservar: ");
        while (true){
            int id = sc.nextInt();
            for (Habitacion habitacion: hotel.getHabitaciones()){
                if (habitacion.getId() == id){
                    foundRoom = habitacion;
                    found = true;
                    break;
                }
            }
            if (found){
                return foundRoom;
            }
        }
    }
    
    //Se encarga de filtrar las habitaciones por su tipo
    public static ArrayList<Habitacion> filtrarRoomPorTipo(Hotel hotel, Huesped huesped){
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Habitacion>> sortedRooms = sortRooms(hotel);
        
        System.out.print("Seleccione el tipo de habitación en la que se desea hospedar (Ingrese el número que corresponde a la opción deseada):\n"
                + "1: Familiar vip\n"
                + "2: Doble vip\n"
                + "3: Simple vip\n"
                + "4: Familiar\n"
                + "5: Doble\n"
                + "6: Simple\n");
        
        String [] tipo = {"familiarvip","doblevip","simplevip", "familiar", "doble", "simple"};
        List<String> tipos = Arrays.asList(tipo);
        
        ArrayList<Habitacion> sortedVIPRooms = new ArrayList<>();
        int opcion;
        while (true){
            opcion = sc.nextInt();
            if (opcion<0 || opcion>6){
                System.out.println("Error. Debe seleccionar alguno de los números correspondientes a las opciones: \n");
                continue;
            }
            if (!huesped.isVip() && tipos.get(opcion-1).contains("vip")){
                System.out.println("No puede acceder a habitaciones VIP, dado a que usted no es VIP. Intente de nuevo: \n");
                continue;
            }
            else{
                for (ArrayList<Habitacion> listhabitacion: sortedRooms){
                    for (Habitacion habitacion : listhabitacion){
                        if (habitacion.getTipo().equals(tipos.get(opcion-1))){
                            sortedVIPRooms.add(habitacion);
                        }
                    }
                }
                break;
            }
            
        }
        return sortedVIPRooms;
        
        
    }
                
    //Se encarga de organizar las habitaciones de acuerdo a su promedio
    public static ArrayList<ArrayList<Habitacion>> sortRooms(Hotel selectedHotel){
        TreeMap<Float, ArrayList<Habitacion>> sortedMap = new TreeMap<>();
        ArrayList<Float> promedios = new ArrayList<>();
        ArrayList<ArrayList<Habitacion>> rooms = new ArrayList<>();
        int c = 0;
        for (Hotel hotel: _hoteles){
            if (hotel.equals(selectedHotel)){
                ArrayList<Habitacion> habitaciones = hotel.getHabitaciones();
                for (Habitacion x: habitaciones){
                    Map<Huesped, Float> calificaciones = x.getCalificaciones();
                    float prom = 0;
                    float s = 0;
                    for (Map.Entry y: calificaciones.entrySet()){                 //Obteniendo promedio de calificacion de una habitacion
                        float i = (float) y.getValue();
                        s = i+s;
                    }
                    prom = s/calificaciones.size();
                    if (!promedios.contains(prom)){
                        promedios.add(prom);
                        ArrayList<Habitacion> random  = new ArrayList<>();
                        random.add(x);
                        rooms.add(random);
                    }
                    else{
                        int i = promedios.indexOf(prom);
                        rooms.get(i).add(x);
                    }
                }
                break;
            }
        }
        
        for (float z: promedios){
                sortedMap.put(z, rooms.get(c));
                c++;
            }
        ArrayList<ArrayList<Habitacion>> sortedRooms = new ArrayList<>(sortedMap.values()); 
        Collections.reverse(sortedRooms);
        return sortedRooms;
        }
}
