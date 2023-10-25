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
import java.util.Calendar;
import java.util.Map;

/**
 *
 * @author david
 */
public class Reservar {
    //Se encarga de ingresar al huesped al menú de reserva
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
        while (true){
            opcion = sc.nextInt();
            if (opcion<1 || opcion>4){
                System.out.println("\nError. Seleccione uno de los números correspondientes a las opciones\n");
                continue;
            }
            break;
        }
        ArrayList<Hotel> listaHoteles = new ArrayList<>();
        int opcionHotel;
        int c = 1;
        switch (opcion){
            case 1:
                Hotel nomHotel = Base.filtrarPorNombre();
                while (true){
                    System.out.print("Este es el hotel que coincide con el nombre que ingresó."
                            + " Seleccione el hotel ingresando el número correspondiente: \n"
                            + "1: " + nomHotel.getNombre()+"\n");
                    if (sc.nextInt() == 1){
                        chooseRoom(nomHotel, huesped);
                        break;
                    }else{
                        System.out.println("Error. Tiene que presionar el 1 para seleccionar el hotel: ");
                    }
                }
                    
            
            
            case 2:
                listaHoteles = Base.filtrarPorCiudad();
                System.out.print("Estos son los hoteles que coinciden con la ciudad que ingresó: \n"
                        + "Seleccione el hotel que desea (Ingrese el número que corresponde a la opción deseada): \n");
                
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
                System.out.print("Estos son todos los hoteles:\n");
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
    //Se encarga de ingresar al huesped al menú de reserva de habitación luego de escoger hotel
    public static void chooseRoom(Hotel hotel, Huesped huesped){
        int cocuped = 0;
        
        ArrayList<ArrayList<Habitacion>> sortedRooms = Base.sortRooms(hotel);
        for (ArrayList<Habitacion> habitaciones : sortedRooms){
            for (Habitacion habitacion: habitaciones){
                if (habitacion.isReservada()){
                    cocuped++;
                }
            }
        }
        int unocuped = hotel.getHabitaciones().size()-cocuped;
        System.out.println("INFORMACIÓN DEL HOTEL");
        System.out.println("-----------------------\n");
        System.out.println("Nombre: " +hotel.getNombre() + "\n"
                + "Ciudad: "+hotel.getCiudad()+ "\n"
                + "Habitaciones ocupadas: "+ cocuped +"\n"
                + "Habitaciones desocupadas: " +unocuped +"\nn"
                + "Servicios" + hotel.getServicios());
        Scanner sc = new Scanner(System.in);
        System.out.println("Seleccione alguna de las siguientes opciones para buscar el hotel en el que se hospedará (Ingrese el número que corresponde a la opción deseada):\n"
                + "1: Buscar por id\n"
                + "2: Buscar por tipo\n"
                + "3: Mostrar todas las habitaciones\n"
                + "4: Volver al menu de reservación\n"
                + "5: Volver al menú principal\n");
        
        int opcion;
        while (true){
            opcion = sc.nextInt();
            if (opcion<1 || opcion>5){
                System.out.println("\nError. Seleccione uno de los números correspondientes a las opciones\n");
                continue;
            }
            break;
        }
        
        int c = 1;
        int opcionRoom;
        switch (opcion){
            case 1: 
                Habitacion foundRoom = Base.filtrarRoomPorID(hotel, huesped);
                while(true){
                    System.out.print("Esta es la habitación que coincide con el id que ingresó."
                        + " Seleccione la habitación ingresando el número correspondiente: \n"
                        + "1: id:" + foundRoom.getId() + ". Tipo: " + foundRoom.getTipo()+"\n");
                if (sc.nextInt() == 1){
                    menuReserva(foundRoom, huesped);
                    break;
                }else{
                    System.out.println("Error. Tiene que presionar el 1 para seleccionar el hotel: ");
                }
            }
                
            case 2:
                ArrayList<Habitacion> foundRooms = Base.filtrarRoomPorTipo(hotel, huesped);
                System.out.print("Estas son las habitaciones que coinciden con el tipo que ingresó."
                        + " Seleccione la habitación ingresando el número correspondiente: \n");
                for (Habitacion habitacion: foundRooms){
                    System.out.println(c+ ":  id:" + habitacion.getId() + ". Tipo: " + habitacion.getTipo());
                    c++;
                }
                System.out.println();
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
                System.out.print("Estas son todas las habitaciones : \n");
                for (ArrayList<Habitacion> habitaciones: sortedRooms){
                    for (Habitacion habitacion: habitaciones){
                        if (habitacion.getTipo().contains("vip") && !huesped.isVip()){
                            
                        }else{
                            System.out.println(c+ ":  id:" + habitacion.getId() + ". Tipo: " + habitacion.getTipo());
                            foundRooms1.add(habitacion);
                            c++;
                        }
                    }
                }
                System.out.println();
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
    //Se encarga de ingresar al huesped al menú de reserva luego de escoger la habitación
    public static void menuReserva(Habitacion habitacion, Huesped huesped){
        Scanner sc = new Scanner(System.in);
        Map<Huesped, Float> calificaciones = habitacion.getCalificaciones();
        Reserva proxReserva;
        float s = 0;
        for (Map.Entry y: calificaciones.entrySet()){                 
            float i = (float) y.getValue();
            s = i+s;
        }
        float prom = s/calificaciones.size();
        System.out.println("INFORMACIÓN DE LA HABITACIÓN");
        System.out.println("-----------------------------\n");
        System.out.println("ID: " + habitacion.getId() +"\n"
                + "Número de camas: " + habitacion.getNumeroCamas() + "\n"
                + "Precio: " + habitacion.getPrecio() +" por día\n" 
                + "Calificación promedio: "+ prom + "\n");
        if (habitacion.isReservada()){
            System.out.println("Reservada: Sí \n");
            proxReserva = Habitacion.compararReservas(habitacion);
            System.out.println("La reserva más cercana tiene como fechas:\n"
                    + "fecha de inicio:" + proxReserva.getFechaEntrada() + "\n"
                    + "fecha de fin:" + proxReserva.getFechaSalida());
        }
        else{
            System.out.println("Reservada: No \n");
            proxReserva = Habitacion.compararReservas(habitacion);
            if (proxReserva != null){
                System.out.println("La reserva más cercana tiene como fechas:\n"
                + "fecha de inicio:" + proxReserva.getFechaEntrada() + "\n"
                + "fecha de fin:" + proxReserva.getFechaSalida() + "\n");
            }else{
                System.out.println("Esta habitacion no tiene reservas");
            }
        }
        
        System.out.println("Seleccione alguna de las siguientes opciones:\n"
                + "1: Reservar habitación\n"
                + "2: Volver al menú de búsqueda de habitaciones\n"
                + "3: Volver al menú principal\n");
        int opcion;
        while(true){
            opcion = sc.nextInt();
            switch (opcion){
                case 1: bookRoom(habitacion, huesped);
                
                case 2: chooseRoom(habitacion.getHotel(), huesped);
                
                case 3: Menu.sistema(huesped);
            }
        } 
    }
    //Se encarga de administrar las fechas que ingresa el usuario para su reserva, y la confirmación de la misma
    public static void bookRoom(Habitacion habitacion, Huesped huesped){
        Scanner sc = new Scanner(System.in);
        
        Calendar fechaReIni = Calendar.getInstance();
        Calendar fechaReFin = Calendar.getInstance();
        Calendar fechaIni = Calendar.getInstance();
        Calendar fechaFin = Calendar.getInstance();
        Calendar fechaActual = Calendar.getInstance();
        String fIni;
        String fFin;
        long cobroHabitacion;
        int ac = 0;
        
        int dia;
        int mes;
        int anio;
        
        while (true){
            while (true){
                System.out.print("Selecciones las fechas en las que se hospedará:\n");
                System.out.print("Seleccione el día en el que se hospedará: ");
                dia = sc.nextInt();
                if (dia<1 || dia>31){
                    System.out.println("Error. Debe ingrsar una fecha correcta");
                    continue;
                }
                else{
                    System.out.print("\nSeleccione el mes en el que se hospedará: ");
                    mes = sc.nextInt();
                    mes = mes-1;
                    if (mes<0 || mes>11){
                        System.out.println("Error. Debe ingrsar una fecha correcta");
                        continue;
                    }
                    else{
                        System.out.print("\nSeleccione el año en el que se hospedará: ");
                        anio = sc.nextInt();
                    }
                }
                fechaIni.set(Calendar.DATE, dia);
                fechaIni.set(Calendar.MONTH, mes);
                fechaIni.set(Calendar.YEAR, anio);
                
                if (fechaActual.compareTo(fechaIni) == 1){
                    System.out.println("Error. Debe ingrsar una fecha correcta");
                }
                else{
                    break;
                }
            }
            mes = mes+1;
            fIni = dia+"/"+mes+"/"+anio;
        
            while (true){
                System.out.print("Selecciones la fecha en la que finalizará su estadía:\n");
                System.out.print("Seleccione el día en el finalizará su estadía: ");
                dia = sc.nextInt();
                if (dia<1 || dia>31){
                    System.out.println("Error. Debe ingrsar una fecha correcta");
                    continue;
                }
                else{
                    System.out.print("\nSeleccione el mes en el que finalizará su estadía: ");
                    mes = sc.nextInt();
                    mes = mes-1;
                    if (mes<0 || mes>11){
                        System.out.println("Error. Debe ingrsar una fecha correcta");
                        continue;
                    }
                    else{
                        System.out.print("\nSeleccione el año en el que finalizará su estadía: ");
                        anio = sc.nextInt();
                    }
                }
                fechaFin.set(Calendar.DATE, dia);
                fechaFin.set(Calendar.MONTH, mes);
                fechaFin.set(Calendar.YEAR, anio);

                if (fechaActual.compareTo(fechaIni) == 1 || fechaIni.compareTo(fechaFin) != -1 || fechaIni.compareTo(fechaFin) == 0){
                    System.out.println("Error. Debe ingrsar una fecha correcta");
                }
                else{
                    break;
                }
            }
            mes = mes+1;
            fFin = dia+"/"+mes+"/"+anio;
            
            for (Reserva x : habitacion.getReservas()){
                String[] fReIni = x.getFechaEntrada().split("/");
                String[] fReFin = x.getFechaSalida().split("/");
                
                fechaReIni.set(Calendar.DATE, Integer.parseInt(fReIni[0]));
                fechaReIni.set(Calendar.MONTH, Integer.parseInt(fReIni[1])-1);
                fechaReIni.set(Calendar.YEAR, Integer.parseInt(fReIni[2]));
                
                fechaReFin.set(Calendar.DATE, Integer.parseInt(fReFin[0]));
                fechaReFin.set(Calendar.MONTH, Integer.parseInt(fReFin[1])-1);
                fechaReFin.set(Calendar.YEAR, Integer.parseInt(fReFin[2]));
                
                if (fechaReIni.compareTo(fechaIni) == 0 || fechaReFin.compareTo(fechaFin) == 0 || fechaReIni.compareTo(fechaFin) == 0 || fechaReFin.compareTo(fechaIni) == 0
                    || ((fechaReIni.compareTo(fechaIni) == -1 && fechaReFin.compareTo(fechaFin) == 1) && fechaReFin.compareTo(fechaFin) == -1) 
                    || (fechaReIni.compareTo(fechaIni) == 1 && (fechaReFin.compareTo(fechaFin) == -1 && fechaReFin.compareTo(fechaFin) == 1))
                    || (fechaReIni.compareTo(fechaIni) == -1 && fechaReFin.compareTo(fechaFin) == 1)
                    || (fechaReIni.compareTo(fechaIni) == 1 && fechaReFin.compareTo(fechaFin) == -1))
                {
                    System.out.println("Error. Su fecha se esta intersecando con las fechas de la siguiente reserva:\n"
                        + "Fecha de inicio: " + x.getFechaEntrada() +"\n"
                        + "Fecha de fin: " + x.getFechaSalida() + "\n");
                    
                    bookRoom(habitacion, huesped);
                    break;
                        
                }
                  
            }
            
            if (huesped.getReserva() != null){
                System.out.println("Ya tiene una reserva en nuestra cadena de hoteles. No puede realizar otra");
                menuReserva(habitacion, huesped);
            }
            else{
                cobroHabitacion = (fechaFin.get(Calendar.DAY_OF_YEAR)-fechaIni.get(Calendar.DAY_OF_YEAR))*habitacion.getPrecio();
                if (huesped.getCuentaBancaria().getSaldo() < cobroHabitacion){
                    System.out.println("No tiene el saldo suficiente para pagar la reserva. Intente de nuevo");
                    menuReserva(habitacion, huesped);
                    break;
                }
                else{
                    break;
                }
            }
            
        }
        
        
        System.out.print("¿Seguro que quiere reservar la habitacion? Y(Sí) o N(No): ");
        String choose;
        while (true){
            choose = sc.nextLine();
            if (!choose.equals("Y") && !choose.equals("N")){
                System.out.println("Debe ingresar una de las opciones dadas");
                continue;
            }
            switch (choose){
                case "Y":
                   for (Hotel x : Base.getHoteles()){
                       for (Habitacion y: x.getHabitaciones()){
                           if (habitacion.getId() == y.getId()){
                               if (y.getHotel().getHistorialClientes().contains(huesped)){
                                    System.out.println("Como ya ha reservado habitaciones en este hotel, se le hará un descuento de 80000$");
                                    cobroHabitacion = cobroHabitacion-80000;
                                }
                                habitacion.getHotel().addHistorialClientes(huesped);
                           }
                       }
                   }
                   huesped.getCuentaBancaria().transferencia(habitacion.getHotel().getCuentaBancaria(), cobroHabitacion);
                   System.out.println("Se le han descontado "+ cobroHabitacion +"$ de su cuenta bancaria");
                   Reserva reserva = huesped.generarReserva(huesped, habitacion, fIni, fFin, cobroHabitacion);
                   huesped.setReserva(reserva);
                   reservaConfirmada(huesped, habitacion, reserva);
                   break;
                case "N":
                    menuReserva(habitacion, huesped);
                    break;
            }
            break;
        }
            
    }
    //Se encarga de confirmar la reserva e imprimir un resumen
    public static void reservaConfirmada(Huesped huesped, Habitacion habitacion, Reserva reserva){
        huesped.setEnReserva(true);
        String fIni = reserva.getFechaEntrada();
        String[] splitfIni = fIni.split("/");
        Calendar fechaActual = Calendar.getInstance();
        Calendar fechaIni = Calendar.getInstance();
        
        fechaIni.set(Calendar.DATE, Integer.parseInt(splitfIni[0]));
        fechaIni.set(Calendar.MONTH, Integer.parseInt(splitfIni[1])-1);
        fechaIni.set(Calendar.YEAR, Integer.parseInt(splitfIni[2]));
        
        if (fechaIni.get(Calendar.DAY_OF_YEAR) == fechaActual.get(Calendar.DAY_OF_YEAR)){
            System.out.println("Hoy mismo comienza su estadía. Disfrute.");
            habitacion.setReservada(true);
        }
            
        habitacion.getReservas().add(reserva);
        System.out.println("\n-----------------------------------");
        System.out.println("Su reserva fue hecha exitosamente.");
        System.out.println("-----------------------------------");
        System.out.println("\nInformación de la reserva:\n"
                + "Hotel: "+reserva.getHotel().getNombre()+"\n"
                + "Ciudad: "+reserva.getCiudad()+"\n"
                + "Fecha de inicio: "+ reserva.getFechaEntrada()+ "\n"
                + "Fecha de fin: "+ reserva.getFechaSalida()+ "\n"
                + "Costo total: "+ reserva.getCosto()+ "\n");
        System.out.println("Intentar "+reserva.getHuesped());
        Menu.sistema(huesped);
    }
}
