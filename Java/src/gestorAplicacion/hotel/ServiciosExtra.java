package gestorAplicacion.hotel;

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
	private String nombre;
	private int tarifa;
	private Map<Usuario, Integer> calificaciones = new HashMap<Usuario,Integer>();

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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTarifa() {
		return tarifa;
	}

	public void setTarifa(int tarifa) {
		this.tarifa = tarifa;
	}

	public Map<Usuario, Integer> getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(Map<Usuario, Integer> calificaciones) {
		this.calificaciones = calificaciones;
	}

	public void transportar() {
		
	}
	
	public void escogerLimpiador() {
		
	}
}
