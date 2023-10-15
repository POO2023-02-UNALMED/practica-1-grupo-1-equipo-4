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

    //Recomendaciones
    //A partir del historial reservas, acceder a las reservas y dependiendo de la ciudad que haya escogido el cliente
    //buscar las reservas por ciudad. De ahí buscar los hoteles donde haya tenido calificaciones por encima de 4, 
    //luego enviar esa lista de hoteles para devolver un HashMap con el hotel como key y un ArrayList con las habitaciones, 
    //ambos deben tener calificaciones por encima de 4.
    //TODO: trabajar en el performance
    public HashMap<Hotel,ArrayList<Habitacion>> recomendacion(String ciudad){
        HashMap<Hotel,ArrayList<Habitacion>> recomendaciones = new HashMap<>();
        recomendaciones = recomendacionHotelesPorCiudad(ciudad);
        return recomendaciones;
    }

    public HashMap<Hotel,ArrayList<Habitacion>> recomendacionPorSimilar(String ciudad){
        return null;
    }
    
    public HashMap<Hotel,ArrayList<Habitacion>> recomendacionHotelesPorCiudad(String ciudad){
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
            habitaciones = this.recomendacionHabitacion(hotel);
            recomendaciones.put(hotel,habitaciones);
        }
        return recomendaciones;
    }

    public ArrayList<Hotel> recomendacionHotelesPorSimilar(){
        return null;
    }

    public ArrayList<Habitacion> recomendacionHabitacion(Hotel hotel){
        ArrayList<Habitacion> habitacionesHotel = hotel.getHabitaciones();
        ArrayList<Habitacion> habitacionesRecomendadas = new ArrayList<Habitacion>();
        for(int i=0;i<habitacionesHotel.size();i++){
            Map<Huesped,Integer> calificaciones = new HashMap<Huesped,Integer>();
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
