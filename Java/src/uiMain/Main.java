package uiMain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import gestorAplicacion.Base;
import gestorAplicacion.finanzas.CuentaBancaria;
import gestorAplicacion.hotel.Habitacion;
import gestorAplicacion.hotel.Hotel;
import gestorAplicacion.hotel.Reserva;
import gestorAplicacion.usuarios.Empleado;
import gestorAplicacion.usuarios.Huesped;
import gestorAplicacion.usuarios.Preferencias;
import gestorAplicacion.usuarios.TipoHabitacion;

public class Main {
    public static void main(String[] args) {
        ArrayList<Habitacion> habs = new ArrayList<>();
        Habitacion hab1 = new Habitacion(1, "simple", 1, 100000);
        Habitacion hab2 = new Habitacion(2, "doble", 2, 300000);
        Habitacion hab3 = new Habitacion(3, "familiar", 4, 500000);
        Habitacion hab4 = new Habitacion(4, "simplevip", 1, 300000);
        Habitacion hab5 = new Habitacion(5, "doblevip", 2, 700000);
        Habitacion hab6 = new Habitacion(6, "familiarvip", 4, 1000000);
        hab1.addCalificacion(new Huesped(), 0f);
        hab2.addCalificacion(new Huesped(), 1f);
        hab3.addCalificacion(new Huesped(), 2f);
        hab4.addCalificacion(new Huesped(), 3f);
        hab5.addCalificacion(new Huesped(), 4f);
        hab6.addCalificacion(new Huesped(), 5f);
        habs.add(hab1);
        habs.add(hab2);
        habs.add(hab3);
        habs.add(hab4);
        habs.add(hab5);
        habs.add(hab6);
        ArrayList<Empleado> empleados = new ArrayList<>();
        Empleado empleado = new Empleado(null, 0, null, null, null, 0);
        empleados.add(empleado);
        Hotel hotel = new Hotel(new CuentaBancaria(0, null), "Montreal", "Medellin", null, habs,empleados);
        Base.addHoteles(hotel);
        ArrayList<Preferencias> preferencias = new ArrayList<>();
        Preferencias preferencia = new Preferencias("Medellin", "Montreal", (String) TipoHabitacion.VIPFAMILIAR.name());
        preferencias.add(preferencia);
        ArrayList<Preferencias> preferencias2 = new ArrayList<>();
        Preferencias preferencia2 = new Preferencias("Medellin", "Montreal", (String) TipoHabitacion.VIPFAMILIAR.name());
        preferencias2.add(preferencia2);
        Huesped huesped = new Huesped(false,preferencias, null, 0, null, null, null);
        Huesped huesped2 = new Huesped(false, preferencias, null, 0, null, null, null);
        Reserva reserva = new Reserva(huesped, hab6, null, null, 0);
        reserva.setCalificacionHotel(5);
        reserva.setCiudad("Medellin");
        reserva.setHotel(hotel);
        huesped.addReserva(reserva);
        huesped.setId(1);
        hab6.addCalificacion(huesped, 5f);
        seleccionar(huesped);
        
    }
     
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
