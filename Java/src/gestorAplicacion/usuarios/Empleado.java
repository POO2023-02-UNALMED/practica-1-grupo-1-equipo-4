package gestorAplicacion.usuarios;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Empleado{
    private String estadoEmpleado;
    private Map<String,Integer>motivosCalificacion;
    private Map<String,Integer>sugerencias;
    private Map<Usuario,Integer>calificaciones;
    private Date ultimoPago;

    public Empleado(String estadoEmpleado){
        this.estadoEmpleado = estadoEmpleado;
        this.motivosCalificacion = new HashMap<>();
        this.sugerencias = new HashMap<>();
        this.calificaciones = new HashMap<>();
        this.ultimoPago = null;
    }

    public String getEstadoEmpleado(){
        return this.estadoEmpleado;
    }

    public void setEstadoEmpleado(String estadoEmpleado){
        this.estadoEmpleado = estadoEmpleado;
    }

    public Map<String,Integer>getMotivosCalificacion(){
        return motivosCalificacion;
    }

    public void setMotivosCalificacion(Map<String,Integer>motivosCalificacion){
        this.motivosCalificacion = motivosCalificacion;
    }

    public Map<String,Integer>getSugerencias(){
        return sugerencias;
    }

    public void setSugerencias(Map<String,Integer>sugerencias){
        this.sugerencias = sugerencias;
    }

    public Map<Usuario,Integer>getCalificaciones(){
        return calificaciones;
    }

    public void setCalificaciones(Map<Usuario,Integer>calificaciones) {
        this.calificaciones = calificaciones;
    }

    public Date getUltimoPago(){
        return this.ultimoPago;
    }

    public void setUltimoPago(Date ultimoPago){
        this.ultimoPago = ultimoPago;
    }

    public int buenasCalificaciones(){
        int buenasCalificaciones =0;
    
        for (Integer calificacion:calificaciones.values()){
            if(calificacion>=3){
                buenasCalificaciones++;
            }
        }
        return buenasCalificaciones;
    }    
}