package gestorAplicacion.hotel;

import gestorAplicacion.Base;
import java.util.ArrayList;
import java.util.Date;

import gestorAplicacion.usuarios.Huesped;
import gestorAplicacion.hotel.ServiciosExtra;
import java.io.Serializable;

/*
    Author David Restrepo Aguilar
*/

//Esta clase se encarga de mantener datos visibles sobre la reserva de un huesped en el hotel
public class Reserva implements Serializable{
    private static final long serialVersionUID = 8L;   
    private Huesped huesped;
    private Hotel hotel;
    private Habitacion habitacion;
    private String fechaEntrada;
    private String fechaSalida;
    private String tipoPago;
    private long costo;
    private ArrayList<ServiciosExtra> servicios = new ArrayList<>();
    private String ciudad;
    private int calificacionHotel=0;
    private int calificacionHabitacion=0;

    public Reserva(Huesped huesped, Habitacion habitacion, String fechaEntrada, String fechaSalida, long costo) {
        this.huesped = huesped;
        this.habitacion = habitacion;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.costo = costo;
        this.hotel = habitacion.getHotel();
        this.ciudad = hotel.getCiudad();
    }
        
        
        
	public Huesped getHuesped() {
            return this.huesped;
	}
	public void setHuesped(Huesped huesped) {
		this.huesped = huesped;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public Habitacion getHabitacion() {
		return habitacion;
	}
	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}
	public String getFechaEntrada() {
		return fechaEntrada;
	}
	public void setFechaEntrada(String fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}
	public String getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public String getTipoPago() {
		return tipoPago;
	}
	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}
	public long getCosto() {
		return costo;
	}
	public void setCosto(int costo) {
		this.costo = costo;
	}
	public ArrayList<ServiciosExtra> getServicios() {
		return servicios;
	}
	public void addServicios(ServiciosExtra servicio) {
		this.servicios.add(servicio);
                this.costo += servicio.getTarifa();
	}
	public void delServicios(ServiciosExtra servicio){
		this.servicios.remove(servicio);
			this.costo -= servicio.getTarifa();
	}
        public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public int getCalificacionHabitacion() {
		return calificacionHabitacion;
	}
	public void setCalificacionHabitacion(int calificacionHabitacion) {
		this.calificacionHabitacion = calificacionHabitacion;
	}
	public int getCalificacionHotel() {
		return calificacionHotel;
	}
	public void setCalificacionHotel(int calificacionHotel) {
		this.calificacionHotel = calificacionHotel;
	}
	
	public boolean crearReserva() {
		return true;
		
	}
	
        //Se encarga de eliminar la reserva
	public String eliminarReserva() {
            if (this.getHuesped().isEnReserva()){
                System.out.println("Elmininando reserva full");
                this.getHuesped().setEnReserva(false);
                for(Hotel hotel: Base.getHoteles()){
                    if (hotel.getNombre().equals(this.getHotel().getNombre())){
                        for (Habitacion habitacion: hotel.getHabitaciones()){
                            if (habitacion.getId() == this.getHabitacion().getId()){
                                habitacion.setReservada(false);
                            }
                        }
                    }
                }
                
            }
            for(Hotel hotel: Base.getHoteles()){
                if (hotel.getNombre().equals(this.getHotel().getNombre())){
                    for (Habitacion habitacion: hotel.getHabitaciones()){
                        if (habitacion.getId() == this.getHabitacion().getId()){
                            ArrayList<Reserva> listReservas = habitacion.getReservas();
                            listReservas.remove(this);
            
                            this.getHuesped().setReserva(null);
                            return "La reserva se ha eliminado correctamente";
                        }
                    }
                }
            }
            
            return "La reserva no se ha eliminado correctamente";
	}
	
}
