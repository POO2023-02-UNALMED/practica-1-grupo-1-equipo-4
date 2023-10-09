package gestorAplicacion.hotel;

import java.util.HashMap;
import java.util.Map;

import gestorAplicacion.usuarios.Huesped;

public class Habitacion {

    private long id;
    private Hotel hotel;
    private String tipo;
    private int  numeroCamas;
    private long precio;
    private Reserva reserva;
    private Map<Huesped,Integer> calificaciones = new HashMap<Huesped,Integer>();
    private Boolean reservada = false;
    private Map<String,Integer> motivosCalificacion = new HashMap<String,Integer>();
    private Map<String,Integer> sugerencias = new HashMap<String,Integer>();

    //Atributos propios de funcionamiento
    private float promedio;
    
    public Habitacion(long id, Hotel hotel, String tipo, int numeroCamas, long precio, Reserva reserva,
            Map<Huesped, Integer> calificaciones, Boolean reservada, Map<String, Integer> motivosCalificacion,
            Map<String, Integer> sugerencias) {
        this.id = id;
        this.hotel = hotel;
        this.tipo = tipo;
        this.numeroCamas = numeroCamas;
        this.precio = precio;
        this.reserva = reserva;
        this.calificaciones = calificaciones;
        this.reservada = reservada;
        this.motivosCalificacion = motivosCalificacion;
        this.sugerencias = sugerencias;
    }

    public Habitacion() {
    }

    public float calcularPromedio(){
        float prom = 0;
        int cont = 0;
        for(Map.Entry<Huesped,Integer> i : this.calificaciones.entrySet()){
            prom = prom + i.getValue();
            cont++;
        }
        return prom/cont;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNumeroCamas() {
        return numeroCamas;
    }

    public void setNumeroCamas(int numeroCamas) {
        this.numeroCamas = numeroCamas;
    }

    public long getPrecio() {
        return precio;
    }

    public void setPrecio(long precio) {
        this.precio = precio;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Map<Huesped, Integer> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(Map<Huesped, Integer> calificaciones) {
        this.calificaciones = calificaciones;
    }

    public Boolean getReservada() {
        return reservada;
    }

    public void setReservada(Boolean reservada) {
        this.reservada = reservada;
    }

    public Map<String, Integer> getMotivosCalificacion() {
        return motivosCalificacion;
    }

    public void setMotivosCalificacion(Map<String, Integer> motivosCalificacion) {
        this.motivosCalificacion = motivosCalificacion;
    }

    public Map<String, Integer> getSugerencias() {
        return sugerencias;
    }

    public void setSugerencias(Map<String, Integer> sugerencias) {
        this.sugerencias = sugerencias;
    } 

}
