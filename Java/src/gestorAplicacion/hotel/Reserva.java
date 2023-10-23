package gestorAplicacion.hotel;

import java.util.ArrayList;
import java.util.Date;

import gestorAplicacion.usuarios.Huesped;
import gestorAplicacion.hotel.ServiciosExtra;

public class Reserva {
	private Huesped huesped;
	private Hotel hotel;
	private Habitacion habitacion;
	private Date fechaEntrada;
	private Date fechaSalida;
	private String tipoPago;
	private int costo;
	private ArrayList<ServiciosExtra> servicios;
	private String ciudad;
	private int calificacionHotel=0;
	private int calificacionHabitacion=0;

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
	public Date getFechaEntrada() {
		return fechaEntrada;
	}
	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}
	public Date getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public String getTipoPago() {
		return tipoPago;
	}
	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}
	public int getCosto() {
		return costo;
	}
	public void setCosto(int costo) {
		this.costo = costo;
	}
	public ArrayList<ServiciosExtra> getServicios() {
		return servicios;
	}
	public void setServicios(ArrayList<ServiciosExtra> servicios) {
		this.servicios = servicios;
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
	
	public boolean eliminarReserva() {
		return true;
		
	}
	
	public boolean modificarReserva() {
		return true;
		
	}
	
	public int confirmarDescuento() {
		return 0;
		
	}
}
