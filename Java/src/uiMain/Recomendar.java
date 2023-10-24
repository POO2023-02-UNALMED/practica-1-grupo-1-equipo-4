package uiMain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import gestorAplicacion.Base;
import gestorAplicacion.hotel.Habitacion;
import gestorAplicacion.hotel.Hotel;
import gestorAplicacion.usuarios.Huesped;
import gestorAplicacion.usuarios.Preferencias;

public class Recomendar {
    private static Scanner sc = new Scanner(System.in);

    public static void seleccionar(Huesped huesped){
        HashMap<Hotel,ArrayList<Habitacion>> hoteles = new HashMap<>();
        ArrayList<String> ciudades = Preferencias.getCiudades();
        System.out.println("LISTA DE CIUDADES:");
        for(String ciudad: ciudades){
            System.out.println(ciudad);
        }
        System.out.println("INGRESE LA CIUDAD DONDE DESEA HOSPEDARSE");
        String ciudad = sc.nextLine();
        while(ciudades.indexOf(ciudad)==-1){
            System.out.println("La ciudad no se encuentra en la lista de ciudades");
            ciudad = sc.nextLine();
        }
        System.out.println("SELECCIONE QUÉ TIPO DE RECOMENDACIÓN DESEA");
        System.out.println("1:Recomendación basada en experiencias anteriores\n"+
        "2:Recomendación basada en preferencias\n");
        int opcion = sc.nextInt();
        while(opcion!=1 && opcion!=2){
            System.out.println("INSERTE UNA OPCION VALIDA");
            System.out.println("SELECCIONE QUÉ TIPO DE RECOMENDACIÓN DESEA");
            System.out.println("1:Recomendación basada en experiencias anteriores\n"+
            "2:Recomendación basada en preferencias\n");
            opcion = sc.nextInt();
        }

        switch (opcion) {
            case 1:
                hoteles = huesped.recomendacionHotelesPorHistorial(ciudad);
                break;
            case 2:
                hoteles = huesped.recomendacionHotelesPorSimilar(ciudad);
                break;
            default:
                break;
        }
    
        for(Hotel hotel : hoteles.keySet()){
            System.out.println("Hotel:"+hotel.getNombre());
            for(Habitacion habitacion:hoteles.get(hotel)){
                System.out.println("\nHabitacion:"+habitacion.getTipo());
            }
        }
        
    }
}
