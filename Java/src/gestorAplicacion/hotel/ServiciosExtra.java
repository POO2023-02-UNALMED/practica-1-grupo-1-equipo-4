package gestorAplicacion.hotel;

/*
 * 
 * 
 *  Clase ServiciosExtra:
 *  
 *      La clase servicios extra tiene la funcion de agregar
 *      un servicio específico a una reserva según se seleccione
 *      dentro del programa
 * 
 * 
 */
import java.util.*;

import gestorAplicacion.usuarios.Empleado;
import gestorAplicacion.usuarios.Huesped;
import gestorAplicacion.usuarios.Usuario;
import java.io.Serializable;

public class ServiciosExtra implements Serializable{
        private static final long serialVersionUID = 9L;   
	private int idServicio;
	private ArrayList<String> listaTipoServicio;
	private String tipoServicio;
	private ArrayList<Huesped> consumidores;
	private int tarifa;
	private Map<Usuario, Integer> calificaciones = new HashMap<Usuario,Integer>();

	public ServiciosExtra(int idServicio, String tipoServicio, int tarifa) {
        this.idServicio = idServicio;
        this.tipoServicio = tipoServicio;
        this.tarifa = tarifa;
        this.consumidores = new ArrayList<>();
        this.calificaciones = new HashMap<>();
    }

	 public static float promedioCalificaciones(ServiciosExtra servicio){
        float   total=0;
        for (Integer i : servicio.calificaciones.values()) {
                total  = total + i;
        }
        return total/servicio.calificaciones.values().size();
    }

	public void addCalificaciones(Usuario usuario, Integer calificacion){
		calificaciones.put(usuario, calificacion);
	}
	
	public static String agregarServicioTransporte(Huesped huesped){
		ServiciosExtra trasporte = new ServiciosExtra(0, "Transporte", 5000);
		huesped.getReserva().addServicios(trasporte);
		return "Servicio Transporte agregado";

    }

	public static String agregarServicioAlimentacion(Huesped huesped){
		ServiciosExtra alimentacion = new ServiciosExtra(1, "Alimentación", 5000);
		huesped.getReserva().addServicios(alimentacion);
		return "Servicio Alimentación agregado";
	}
	
	public static String agregarServicioLimpieza(Huesped huesped){
		ServiciosExtra limpieza = new ServiciosExtra(2, "Limpieza", 5000);
		huesped.getReserva().addServicios(limpieza);
		return "Servicio Limpieza agregado";
    }

	public static String eliminarServicio(ServiciosExtra servicio, Huesped huesped){
		huesped.getReserva().delServicios(servicio);
        return "Se ha añadido el servicio de transporte";
    }


	public int getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}

	public ArrayList<String> getListaTipoServicio() {
		return listaTipoServicio;
	}

	public void setListaTipoServicio(ArrayList<String> listaTipoServicio) {
		this.listaTipoServicio = listaTipoServicio;
	}

	public String getTipoServicio() {
		return tipoServicio;
	}

	public void setTipoServicio(String tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

	public ArrayList<Huesped> getConsumidores() {
		return consumidores;
	}

	public void setConsumidores(ArrayList<Huesped> consumidores) {
		this.consumidores = consumidores;
	}

	public int getTarifa() {
		return tarifa;
	}

	public void setTarifa(int tarifa) {
		this.tarifa = tarifa;
	}

	public Map<Usuario, Integer> getCalificaciones(){
		return calificaciones;
	}

	public void setCalificaciones(Map<Usuario, Integer> calificaciones) {
		this.calificaciones = calificaciones;
	}
}
