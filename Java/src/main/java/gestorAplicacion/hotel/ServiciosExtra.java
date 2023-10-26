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
	
 	        //Se tendran en cuenta los  siguientes criterios para el promedio de las calificaciones: servicio
			//El método realiza un promedio de las calificaciones de los servicios extras que fueron agregados
	 public static float promedioCalificaciones(ServiciosExtra servicio){
        float   total=0;
        for (Integer i : servicio.calificaciones.values()) {
                total  = total + i;
        }
        return total/servicio.calificaciones.values().size();
    }

 	        //Se tendran en cuenta los  siguientes criterios para  agregar el servicio de alimentación: usuario y calificación de tipo entero
			//El método le agrega asocia la calificación al usuario
	public void addCalificaciones(Usuario usuario, Integer calificacion){
		calificaciones.put(usuario, calificacion);
	}

	 	    //Se tendran en cuenta los  siguientes criterios para  agregar el servicio de transporte: huesped
			//El método le crea un Servicio de transporte al Huesped que lo solicite
	public static String agregarServicioTransporte(Huesped huesped){
		ServiciosExtra trasporte = new ServiciosExtra(0, "Transporte", 10000);
		huesped.getReserva().addServicios(trasporte);
		return "Servicio Transporte agregado";

    }

 	        //Se tendran en cuenta los  siguientes criterios para  agregar el servicio de alimentación: huesped
			//El método le crea un Servicio de aLimentación al Huesped que lo solicite

	public static String agregarServicioAlimentacion(Huesped huesped){
		ServiciosExtra alimentacion = new ServiciosExtra(1, "Alimentación", 12000);
		huesped.getReserva().addServicios(alimentacion);
		return "Servicio Alimentación agregado";
	}

	 	    //Se tendran en cuenta los  siguientes criterios para  agregar el servicio de limpieza: huesped
			//El método le crea un Servicio de limpieza al Huesped que lo solicite
	public static String agregarServicioLimpieza(Huesped huesped){
		ServiciosExtra limpieza = new ServiciosExtra(2, "Limpieza", 7500);
		huesped.getReserva().addServicios(limpieza);
		return "Servicio Limpieza agregado";
    }

 	        //Se tendran en cuenta los  siguientes criterios para  eliminar el servicio del huesped: servicio, huesped
			//El método le quita el Servicio que le fue agregado al huesped
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
