/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uiMain;


import gestorAplicacion.Base;
import java.util.ArrayList;
import java.util.Scanner;
import gestorAplicacion.finanzas.*;
import gestorAplicacion.hotel.*;
import gestorAplicacion.usuarios.*;
import gestorAplicacion.Base;
import java.util.Map;

/**
 *
 * @author david
 */
public class Reservar {
    public static void reservar(Huesped huesped){
        Scanner sc = new Scanner(System.in);
        System.out.println("MENU DE RESERVACIÓN");
        System.out.println("---------------------\n");
        int opcion;
        System.out.println("Seleccione alguna de las siguientes opciones para buscar el hotel en el que se hospedará (Ingrese el número que corresponde a la opción deseada):\n"
                + "1: Buscar por nombre\n"
                + "2: Buscar por ciudad\n"
                + "3: Mostrar todos los hoteles\n"
                + "4: Volver al menú principal\n");
        opcion = sc.nextInt();
        ArrayList<Hotel> listaHoteles = new ArrayList<>();
        int opcionHotel;
        int c = 1;
        switch (opcion){
            case 1:
                Hotel nomHotel = Base.filtrarPorNombre();
                while (true){
                    System.out.print("Este es el hotel que coincide con el nombre que ingresó."
                            + " Seleccione el hotel ingresando el número correspondiente: \n"
                            + "1: " + nomHotel.getNombre());
                    if (sc.nextInt() == 1){
                        chooseRoom(nomHotel, huesped);
                        break;
                    }else{
                        System.out.println("Error. Tiene que presionar el 1 para seleccionar el hotel: ");
                    }
                }
                    
            
            
            case 2:
                listaHoteles = Base.filtrarPorCiudad();
                System.out.print("Estos son los hoteles que coinciden con la ciudad que ingresó: \n+"
                        + "Seleccione el hotel que desea (Ingrese el número que corresponde a la opción deseada): ");
                
                for (Hotel hotel: listaHoteles){
                    System.out.println(c+ ": "+ hotel.getNombre());
                    c++;
                }
                while (true){
                    opcionHotel = sc.nextInt();
                    if (opcionHotel<1 || opcionHotel > listaHoteles.size()){
                        System.out.print("Error. Debe ingresar uno de los número que se mostraron anteriormente. Intente de nuevo: ");
                    }
                    else{
                        Hotel selectedHotel = listaHoteles.get(opcionHotel-1);
                        chooseRoom(selectedHotel, huesped);
                        break;
                    }
                }
                
            
            case 3: 
                ArrayList<Hotel> completeHotel = Base.getHoteles();
                for (Hotel hotel: completeHotel){
                    System.out.println(c+ ": "+ hotel.getNombre());
                    c++;
                }
                while (true){
                    opcionHotel = sc.nextInt();
                    if (opcionHotel<1 || opcionHotel > completeHotel.size()){
                        System.out.print("Error. Debe ingresar uno de los número que se mostraron anteriormente. Intente de nuevo: ");
                    }
                    else{
                        Hotel selectedHotel = completeHotel.get(opcionHotel-1);
                        chooseRoom(selectedHotel, huesped);
                        break;
                    }
                }
                
                
            case 4:
                Menu.sistema(huesped);
            
        }   
        
    }
    
    public static void chooseRoom(Hotel hotel, Huesped huesped){
        int cocuped = 0;
        
        ArrayList<ArrayList<Habitacion>> sortedRooms = Base.sortRooms(hotel);
        for (ArrayList<Habitacion> habitaciones : sortedRooms){
            for (Habitacion habitacion: habitaciones){
                if (habitacion.getReservada()){
                    cocuped++;
                }
            }
        }
        int unocuped = cocuped-hotel.getHabitaciones().size();
        System.out.println("INFORMACIÓN DEL HOTEL");
        System.out.println("-----------------------\n");
        System.out.println("Nombre: " +hotel.getNombre() + "\n"
                + "Ciudad: "+hotel.getCiudad()+ "\n"
                + "Habitaciones ocupadas: "+ cocuped +"\n"
                + "Habitaciones desocupadas: " +unocuped +"n"
                + "Servicios" + hotel.getServicios());
        Scanner sc = new Scanner(System.in);
        System.out.println("Seleccione alguna de las siguientes opciones para buscar el hotel en el que se hospedará (Ingrese el número que corresponde a la opción deseada):\n"
                + "1: Buscar por id\n"
                + "2: Buscar por tipo\n"
                + "3: Mostrar todas las habitaciones\n"
                + "4: Volver al menu de reservación\n"
                + "5: Volver al menú principal\n");
        
        int opcion = sc.nextInt();
        int c = 1;
        int opcionRoom;
        switch (opcion){
            case 1: 
                Habitacion foundRoom = Base.filtrarRoomPorID(hotel, huesped);
                while(true){
                    System.out.print("Este es el hotel que coincide con el nombre que ingresó."
                        + " Seleccione el hotel ingresando el número correspondiente: \n"
                        + "1: id:" + foundRoom.getId() + ". Tipo: " + foundRoom.getTipo());
                if (sc.nextInt() == 1){
                    menuReserva(foundRoom, huesped);
                }else{
                    System.out.println("Error. Tiene que presionar el 1 para seleccionar el hotel: ");
                }
            }
                
            case 2:
                ArrayList<Habitacion> foundRooms = Base.filtrarRoomPorTipo(hotel, huesped);
                
                for (Habitacion habitacion: foundRooms){
                    System.out.println(c+ ":  id:" + habitacion.getId() + ". Tipo: " + habitacion.getTipo());
                    c++;
                }
                while (true){
                    opcionRoom = sc.nextInt();
                    if (opcionRoom<1 || opcionRoom > foundRooms.size()){
                        System.out.print("Error. Debe ingresar uno de los número que se mostraron anteriormente. Intente de nuevo: ");
                    }
                    else{
                        Habitacion selectedRoom = foundRooms.get(opcionRoom-1);
                        menuReserva(selectedRoom, huesped);
                        break;
                    }
                }
                
            case 3:
                ArrayList<Habitacion> foundRooms1 = new ArrayList<>();
                for (ArrayList<Habitacion> habitaciones: sortedRooms){
                    for (Habitacion habitacion: habitaciones){
                        System.out.println(c+ ":  id:" + habitacion.getId() + ". Tipo: " + habitacion.getTipo());
                        foundRooms1.add(habitacion);
                        c++;
                    }
                }
                while (true){
                    opcionRoom = sc.nextInt();
                    if (opcionRoom<1 || opcionRoom > foundRooms1.size()){
                        System.out.print("Error. Debe ingresar uno de los número que se mostraron anteriormente. Intente de nuevo: ");
                    }
                    else{
                        Habitacion selectedRoom = foundRooms1.get(opcionRoom-1);
                        menuReserva(selectedRoom, huesped);
                        break;
                    }
                }
            
            
            case 4:
                reservar(huesped);
                
            case 5:
                Menu.sistema(huesped);
        }
    }
    
    public static void menuReserva(Habitacion habitacion, Huesped huesped){
        Map<Huesped, Integer> calificaciones = habitacion.getCalificaciones();
        int s = 0;
        for (Map.Entry y: calificaciones.entrySet()){                 
            int i = (int) y.getValue();
            s = i+s;
        }
        float prom = s/calificaciones.size();
        System.out.println("INFORMACIÓN DE LA HABITACIÓN");
        System.out.println("-----------------------------\n");
        System.out.println("ID: " + habitacion.getId() +"\n"
                + "Número de camas: " + habitacion.getNumeroCamas() + "\n"
                + "Precio: " + habitacion.getPrecio() +"\n" 
                + "Calificación promedio: "+ prom);
    }
}
