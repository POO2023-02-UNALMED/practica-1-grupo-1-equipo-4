package gestorAplicacion.hotel;

import java.util.ArrayList;
import java.util.Date;

public class Reserva {
	private Huesped huesped;
	private Hotel hotel;
	private Habitacion habitacion;
	private Date fechaEntrada;
	private Date fechaSalida;
	private String tipoPago;
	private int costo;
	private ArrayList<Servicios> servicios;
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
	public ArrayList<Servicios> getServicios() {
		return servicios;
	}
	public void setServicios(ArrayList<Servicios> servicios) {
		this.servicios = servicios;
	}
	
	public boolean crearReserva() {
		
	}
	
	public boolean eliminarReserva() {
		
	}
	
	public boolean modificarReserva() {
		
	}
	
	public int confirmarDescuento() {
		
	}
}
