package gestorAplicacion.usuarios;
import gestorAplicacion.finanzas.CuentaBancaria;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import gestorAplicacion.hotel.Reserva;
import gestorAplicacion.hotel.Habitacion;
import gestorAplicacion.hotel.Hotel;
import java.io.Serializable;
import uiMain.PresentacionBono;
import gestorAplicacion.Base;

public class Huesped extends Usuario implements Serializable, PresentacionBono{
    private static final long serialVersionUID = 5L;
    

    private boolean vip;
    private Reserva reserva;
    private Habitacion habitacion;
    private ArrayList<Preferencias> preferencias;
    private ArrayList<Reserva> historialReservas;
    //David: Eliminé reserva, historial de reservas y habitacion, pues el usuario de huesped se debe crear primero sin necesidad de reservar
    

    public Huesped(boolean vip, ArrayList<Preferencias> preferencias, String nombre, int telefono, int id, String username, String password, CuentaBancaria cuentaBancaria) {
        super(nombre, telefono, id, username, password, cuentaBancaria);
        this.vip = vip;
        this.reserva = reserva;
        this.habitacion = habitacion;
        this.preferencias = preferencias;
        this.historialReservas = historialReservas;
    }

    
    public boolean isVip(){
        return this.vip;
    }
    
    public void setVip(boolean vip){
        this.vip = vip;
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

    //Las recomendaciones funcionan a partir de dos criterios. 
    //1. Si el usuario tiene historial de reservas, se buscan los hoteles que cumplen con la ciudad y tienen mejores
    //calificaciones por parte del cliente, y a partir de ahí se buscan las habitaciones en ese hotel que tienen mejores calificaciones.
    //2. Si el usuario aún no tiene historial de reservas, al registrarse se le pide sus preferencias. Entonces a partir de estas
    //preferencias se hace la lógica para devolver los hoteles y habitaciones que cumplan con estas. 


    //Para recomendar hoteles basado en las preferencias del huesped
    public HashMap<Hotel,ArrayList<Habitacion>> recomendacionHotelesPorSimilar(String ciudad){
        HashMap<Hotel,ArrayList<Habitacion>> recomendaciones = new HashMap<Hotel,ArrayList<Habitacion>>();
        ArrayList<Hotel> hotelesBase = Base.getHoteles();
        for(Hotel hotel:hotelesBase){
            if(hotel.getCiudad().equals(ciudad)){
                for(Preferencias preferencia : preferencias){
                    if(hotel.getNombre().equals(preferencia.getNombreHotel())){
                        ArrayList<Habitacion> habitaciones = new ArrayList<Habitacion>();
                        habitaciones = recomendacionHabitacionPorSimilar(hotel, preferencia);
                        if(habitaciones!=null){
                            recomendaciones.put(hotel, habitaciones);
                        }
                    }
                }
                
            }
        }
        return recomendaciones;
    }
    //Método que se usa en recomendacionHotelesPorSimilar(). Para que basada en la preferencia y en el hotel buscar las habitaciones que 
    //satisfacen.
    public ArrayList<Habitacion> recomendacionHabitacionPorSimilar(Hotel hotel,Preferencias preferencia){
        ArrayList<Habitacion> habitaciones = new ArrayList<Habitacion>();
        habitaciones = hotel.getHabitaciones();
        for(Habitacion habitacion : habitaciones){
            if(habitacion.getTipo().equals(preferencia.getTipoHabitacion())){
                habitaciones.add(habitacion);
            }
        }
        return habitaciones;
    }
    
    //Para recomendar hoteles basada en el historial de las reservas que tiene el huesped
    public HashMap<Hotel,ArrayList<Habitacion>> recomendacionHotelesPorHistorial(String ciudad){
        HashMap<Hotel,ArrayList<Habitacion>> recomendaciones = new HashMap<Hotel,ArrayList<Habitacion>>();
        ArrayList<Hotel> hoteles = new ArrayList<Hotel>();
        
        for(int i=0;i<historialReservas.size();i++){
            if(historialReservas.get(i).getCiudad().equals(ciudad)){
                int calificacion = historialReservas.get(i).getCalificacionHotel();
                if(calificacion>=4){
                    hoteles.add(historialReservas.get(i).getHotel());
                }  
                break;     
            }
        }
        for(Hotel hotel: hoteles){
            ArrayList<Habitacion> habitaciones = new ArrayList<Habitacion>();
            habitaciones = this.recomendacionHabitacionPorHistorial(hotel);
            recomendaciones.put(hotel,habitaciones);
        }
        return recomendaciones;
    }

    //Método que se usa en recomendacionHotelesPorHistorial() para buscar las habitaciones en el hotel que cumplen con una calificación por encima
    //o igual a 4
    public ArrayList<Habitacion> recomendacionHabitacionPorHistorial(Hotel hotel){
        ArrayList<Habitacion> habitacionesHotel = hotel.getHabitaciones();
        ArrayList<Habitacion> habitacionesRecomendadas = new ArrayList<Habitacion>();
        for(int i=0;i<habitacionesHotel.size();i++){
            Map<Huesped,Float> calificaciones = new HashMap<Huesped,Float>();
            calificaciones = habitacionesHotel.get(i).getCalificaciones();
            for(Huesped huesped : calificaciones.keySet()){
                if(huesped.getId()==this.getId()){
                    if(calificaciones.get(huesped)>=4){
                        habitacionesRecomendadas.add(habitacionesHotel.get(i));
                        break;
                    }
                }
            }
        }
        return habitacionesRecomendadas;
    }

    @Override
    public void ofrecerBono() {
         this.getCuentaBancaria().depositar(BONOHUESPED);
    }
    
    @Override
    public String presentacion(){
        String intro = PresentacionBono.recogerDatos(this);
        return "Soy un huesped. "+intro ;
    }
}
