package gestorAplicacion.hotel;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import gestorAplicacion.usuarios.*;

public class Habitacion implements Serializable{
    private static final long serialVersionUID = 5L;

    private long id;
    private Hotel hotel;
    private String tipo;
    private int  numeroCamas;
    private long precio;
    private Reserva reserva;
    private Map<Huesped,Float> calificaciones = new HashMap<Huesped,Float>();
    private Boolean reservada = false;
    private Map<String,Integer> motivosCalificacion = new HashMap<String,Integer>();
    private Map<String,Integer> sugerencias = new HashMap<String,Integer>();

    

    //Atributos propios de funcionamiento
    private float promedio;
    private static Map<Long,ArrayList<String>> sugerenciasPendientes = new HashMap<Long,ArrayList<String>>();
    
    public Habitacion(long id, String tipo, int numeroCamas, long precio) {
        this.calificaciones.put(new Huesped(), (float)5.0);
        this.id = id;
        this.tipo = tipo;
        this.numeroCamas = numeroCamas;
        this.precio = precio;

    }

    public Habitacion(long id, String tipo, int numeroCamas, long precio, Hotel hotel) {
        this.calificaciones.put(new Huesped(), (float)5.0);
        this.id = id;
        this.tipo = tipo;
        this.numeroCamas = numeroCamas;
        this.precio = precio;
        this.hotel = hotel;

        hotel.agregarHabitacion(this);

    }

    public Habitacion() {
    }

    public float calcularPromedio(){
        float prom = 0;
        int cont = 0;
        for(Map.Entry<Huesped,  Float> i : this.calificaciones.entrySet()){
            prom = prom + i.getValue();
            cont++;
        }
        return prom/cont;
    }

    

    public void addCalificacion(Huesped huesped, Float calificacion){
        calificaciones.put(huesped, calificacion);
    }
    //Agrega los motivos por los cuales la calificacion  de  una habitacion  es buena o mala
    public void  addMotivos(String motivo){
        if(motivosCalificacion.get(motivo)!=null)motivosCalificacion.put(motivo, motivosCalificacion.get(motivo)+1);
        else motivosCalificacion.put(motivo, 1);
    }

    //Devuelve las  habitaciones  que estan a un rango  de 10 unidades monetarias de diferencia
    public ArrayList<Habitacion> rangoPrecio(ArrayList<Habitacion> totalHabitaciones){
        ArrayList<Habitacion> rango = new ArrayList<>();
        for (Habitacion habitacion : totalHabitaciones) {
            if(Math.abs(habitacion.getPrecio()-this.precio)<10){
                rango.add(habitacion);
            }
        }
        return rango;
    }

    public  ArrayList<Habitacion>  mejorCalificadas(ArrayList<Habitacion>  habitaciones){
        ArrayList<Habitacion> rango = new ArrayList<>();
        for (Habitacion habitacion : habitaciones) {
            //Collection<Float>values =  habitacion.getCalificaciones().values();
            //ArrayList<Float> calificaciones = new ArrayList<>(values);
            //float suma = 0;
            //for (Float habitacion2 : calificaciones) {
            //    suma = suma + habitacion2;
            //}
            //float promedio = suma/habitacion.getCalificaciones().size();
            if(habitacion.calcularPromedio()>=3){
                rango.add(habitacion);
            }
        }
        return rango;
    }

    public ArrayList<String> totalSugerencias(ArrayList<Habitacion> habitaciones){
        ArrayList<String> resultado = new ArrayList<>();
        for(Habitacion i :  habitaciones){
            for (Map.Entry<String,Integer> j: i.getSugerencias().entrySet()) {
                resultado.add(j.getKey());
            }
        }
        return resultado;
    }

    public void addSugerenciasPendientes(ArrayList<String>  sugerencias){
        this.sugerenciasPendientes.put(this.getId(), sugerencias);
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

    public Map<Huesped, Float> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(Map<Huesped, Float> calificaciones) {
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
