package gestorAplicacion.usuarios;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import gestorAplicacion.finanzas.CuentaBancaria;

public class Empleado extends Usuario{
    private Boolean estadoEmpleado = false;
    private Map<String,Integer>motivosCalificacion = new HashMap<>();
    private Map<String,Integer>sugerencias = new HashMap<>();
    private Map<Usuario,Integer>calificaciones = new HashMap<>();
    private Date ultimoPago;

    private long salario = 5000;

    private static int totalEmpleados = 0;

    public Empleado(String nombre,int telefono,String username,String password,CuentaBancaria cuentaBancaria){
        super(nombre, telefono, Empleado.totalEmpleados + 1, username, password, cuentaBancaria);
    }

    public Empleado(String nombre,int telefono,String username,String password,CuentaBancaria cuentaBancaria, long salario){
        super(nombre, telefono, Empleado.totalEmpleados + 1, username, password, cuentaBancaria);

        this.salario = salario;
    }

    public Boolean getEstadoEmpleado(){
        return this.estadoEmpleado;
    }

    public void setEstadoEmpleado(Boolean estadoEmpleado){
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

    public long getSalario(){
        return this.salario;
    }

    public void setSalario(long salario){
        this.salario = salario;
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