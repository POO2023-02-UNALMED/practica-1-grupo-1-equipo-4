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

/**
 *
 * @author david
 */
public class Reservar {
    public static void reservar(){
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
        int c = 0;
        switch (opcion){
            case 1:
                Hotel nomHotel = Base.filtrarPorNombre();
                while (true){
                    System.out.print("Este es el hotel que coincide con el nombre que ingresó."
                            + " Seleccione el hotel ingresando el número correspondiente: \n"
                            + "1: " + nomHotel.getNombre());
                    if (sc.nextInt() == 1){
                        chooseRoom(nomHotel);
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
                        Hotel selectedHotel = listaHoteles.get(opcionHotel);
                        chooseRoom(selectedHotel);
                        break;
                    }
                }
                
            case 3: System.exit(0);
            
            case 4:
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
                        Hotel selectedHotel = completeHotel.get(opcionHotel);
                        chooseRoom(selectedHotel);
                        break;
                    }
                }
            
            case 5:
        }   
        
    }
    
    public static void chooseRoom(Hotel hotel){
        Base.sortRooms(hotel);
        Scanner sc = new Scanner(System.in);
        System.out.println("Seleccione alguna de las siguientes opciones para buscar el hotel en el que se hospedará (Ingrese el número que corresponde a la opción deseada):\n"
                + "1: Buscar por id\n"
                + "2: Buscar por tipo\n"
                + "3: Mostrar todas las habitaciones\n"
                + "4: Volver al menu de reservación\n"
                + "5: Volver al menú principal\n");
        
        int opcion = sc.nextInt();
        switch (opcion){
            case 1: 
                Habitacion foundRoom = Base.filtrarRoomPorID(hotel);
                while(true){
                    System.out.print("Este es el hotel que coincide con el nombre que ingresó."
                        + " Seleccione el hotel ingresando el número correspondiente: \n"
                        + "1: id:" + foundRoom.getId() + ". Tipo: " + foundRoom.getTipo());
                if (sc.nextInt() == 1){
                    break;
                }else{
                    System.out.println("Error. Tiene que presionar el 1 para seleccionar el hotel: ");
                }
            }
                
            case 2:
                
            case 3:
            case 4:
            case 5:
        }
    }
}
