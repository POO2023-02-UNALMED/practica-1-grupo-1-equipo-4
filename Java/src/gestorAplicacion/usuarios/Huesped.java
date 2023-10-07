package gestorAplicacion.usuarios;
import java.util.ArrayList;
import java.util.HashMap;

import gestorAplicacion.hotel.Reserva;
import gestorAplicacion.hotel.Habitacion;
import gestorAplicacion.hotel.Hotel;

public class Huesped{
    private boolean vip;
    private Reserva reserva;
    private Habitacion habitacion;
    private ArrayList<Preferencias> preferencias;
    private ArrayList<Reserva> historialReservas;

    public Huesped(boolean vip,Habitacion habitacion){
        this.vip = vip;
        this.habitacion = habitacion;
        this.preferencias = new ArrayList<>();
        this.historialReservas = new ArrayList<>();
    }

    public boolean isVip(){
        return this.vip;
    }

    public Reserva getReserva(){
        return this.reserva;
    }

    public void setReserva(Reserva reserva){
        this.reserva = reserva;
    }

    public Habitacion getHabitacion(){
        return this.habitacion;
    }

    public void setHabitacion(Habitacion habitacion){
        this.habitacion = habitacion;
    }

    public ArrayList<Preferencias>getPreferencias(){
        return preferencias;
    }

    public void setPreferencias(ArrayList<Preferencias>preferencias){
        this.preferencias = preferencias;
    }

    public ArrayList<Reserva>getHistorialReservas(){
        return historialReservas;
    }
//Falta llenar
    public Reserva generarReserva(){
        return new Reserva();
    }

    public void calcularServicios(){
    }
//Mientras
    public boolean consultarVip(){
        if(vip == true){
            return true;
        } 
        return false;
    }

    public void consultarDiasDeEstadia(){
    }

    public void cambiarPreferencias(ArrayList<Preferencias>nuevasPreferencias){
        this.preferencias = nuevasPreferencias;
    }

    //Recomendaciones
    //Con los dos primeros método la idea es tomar lo que devuelve los últimos dos métodos, para así analizar las habitaciones mejores calificadas. 
    //Y devolver el HashMap que tenga como key el Hotel y el ArrayList con las habitaciones como value
    public HashMap<Hotel,ArrayList<Habitacion>> recomendacion(ArrayList<Hotel> hoteles){
        return null;
    }

    public HashMap<Hotel,ArrayList<Habitacion>> recomendacionPorSimilar(ArrayList<Hotel> hoteles){
        return null;
    }
    
    public ArrayList<Hotel> recomendacionHoteles(){
        return null;
    }

    public ArrayList<Hotel> recomendacionHotelesPorSimilar(){
        return null;
    }


}
