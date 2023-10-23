package gestorAplicacion.hotel;

import java.util.ArrayList;
import java.util.Date;

import gestorAplicacion.usuarios.Huesped;
import gestorAplicacion.hotel.ServiciosExtra;
import java.io.Serializable;

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
        huesped.setReserva(this);
    }
        
        
        
	public Huesped getHuesped() {
		return huesped;
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
	
	public String eliminarReserva() {
            if (this.getHuesped().isEnReserva()){
                this.getHuesped().setEnReserva(false);
                this.getHabitacion().setReservada(false);
            }
            ArrayList<Reserva> listReservas = this.getHabitacion().getReservas();
            listReservas.remove(this);
            this.setHuesped(null);
            this.getHuesped().setReserva(null);
	    return "La reserva se ha eliminado correctamente";
            
	}
	
	public boolean modificarReserva() {
		return true;
		
	}
	
	public int confirmarDescuento() {
		return 0;
		
	}
}
