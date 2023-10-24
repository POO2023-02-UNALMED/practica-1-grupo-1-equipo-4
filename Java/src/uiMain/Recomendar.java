package uiMain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import gestorAplicacion.Base;
import gestorAplicacion.hotel.Habitacion;
import gestorAplicacion.hotel.Hotel;
import gestorAplicacion.usuarios.Huesped;
import gestorAplicacion.usuarios.Preferencias;

//Menú en el cual se hace uso de los métodos para recomendar hoteles y habitaciones por medio de la ciudad donde el usuario
//se desea hospedar.
//Aquí se le preguntará al usuario la ciudad donde desea hospedarse y este valor se le enviará como parametro a los métodos que se encuentran huesped
//ya sea recomendacionHotelesPorHistorial() donde se recomienda un hotel y habitacion basada en estancias anteriores. O 
//recomendacionHotelesPorSimilar() donde se recomienda un hotel y habitación basada en las preferencias que el usuario anteriormente debió llenar.
//En caso de no haber recomendaciones se imprime que no hay recomendaciones disponibles.
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
        if(hoteles.isEmpty()){
            System.out.println("No hay recomendaciones disponibles");
        }
        for(Hotel hotel : hoteles.keySet()){
            System.out.println("Hotel:"+hotel.getNombre());
            for(Habitacion habitacion:hoteles.get(hotel)){
                System.out.println("Habitacion:"+habitacion.getTipo());
            }
        }
        System.out.println("Presione 1 para volver al menú principal");
        int salida = sc.nextInt();
        while(salida!=1){
           System.out.println("Presione 1 para volver al menú principal"); 
           salida = sc.nextInt();
        }
        if(salida == 1){
            Menu.sistema(huesped);
        }
    }
}
