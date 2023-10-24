package gestorAplicacion.usuarios;
import gestorAplicacion.Base;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.io.Serializable; 
import java.util.Date;

import gestorAplicacion.finanzas.CuentaBancaria;
import gestorAplicacion.hotel.Habitacion;
import gestorAplicacion.hotel.Hotel;
import uiMain.PresentacionBono;

public class Empleado extends Usuario implements Serializable, PresentacionBono{
    private static final long serialVersionUID = 4L;
    
    private Boolean estadoEmpleado = false;
    private Map<String,Integer>motivosCalificacion = new HashMap<>();
    private Map<String,Integer>sugerencias = new HashMap<>();
    private Map<Usuario,Integer>calificaciones = new HashMap<>();
    private Date ultimoPago;
    private Hotel hotel;
    private long salario = 5000;

    private static int totalEmpleados = 0;
    private static Map<Integer,ArrayList<String>> sugerenciasPendientes = new HashMap<Integer,ArrayList<String>>();

    public Empleado(String nombre,int telefono,String username,String password,CuentaBancaria cuentaBancaria){
        super(nombre, telefono, username, password, cuentaBancaria);
    }

    public Empleado(String nombre,int telefono,String username,String password,CuentaBancaria cuentaBancaria, long salario){
        super(nombre, telefono, username, password, cuentaBancaria);
        this.salario = salario;
    }

    
    public ArrayList<Empleado> mejorCalificaciones(ArrayList<Empleado>  empleados){
        ArrayList<Empleado> rango = new ArrayList<Empleado>();
        for(Empleado i : empleados){
            if(promedioCalificaciones(i)>3){
                rango.add(i);
            }
        }
        return rango;
    }

    public  void addCalificacion(Usuario usuario, Integer calificacion){
        this.calificaciones.put(usuario, calificacion);
    }

    public boolean mereceBono(){
        if(buenasCalificaciones()>=2) return true;
        else return false;
    }

    public void  addMotivos(String motivo){
        if(motivosCalificacion.get(motivo)!=null)motivosCalificacion.put(motivo, motivosCalificacion.get(motivo)+1);
        else motivosCalificacion.put(motivo, 1);
    }

    public static float promedioCalificaciones(Empleado empleado){
        float   total=0;
        for (Integer i : empleado.calificaciones.values()) {
                total  = total + i;
        }
        return total/empleado.calificaciones.values().size();
    }

    //Se  seleccionan los empleadosque estan con un puntaje de  0.5 a la redonda
    public ArrayList<Empleado> rangoCalificacion(ArrayList<Empleado> empleados){
        ArrayList<Empleado> rangoCalificacion  = new ArrayList<>();
        //int  total = 0;
        //for(Integer i : calificaciones.values()){
        //        total = total + i;
        //    }
        for (Empleado empleado : empleados) {
            if(Math.abs(promedioCalificaciones(empleado)-promedioCalificaciones(this))<0.5){
                rangoCalificacion.add(empleado);
            }
        }
        return rangoCalificacion;
    }

    public ArrayList<String> totalSugerencias(ArrayList<Empleado> empleados){
        ArrayList<String> resultado = new ArrayList<>();
        for(Empleado i :  empleados){
            for (Map.Entry<String,Integer> j: i.getSugerencias().entrySet()) {
                resultado.add(j.getKey());
            }
        }
        return resultado;
    }

    public void addSugerenciasPendientes(ArrayList<String> sugerencias){
        sugerenciasPendientes.put(this.getId(), sugerencias);
    }

    public  void addSugerencias(String sugerencia){
        if(sugerencias.get(sugerencia)!=null)sugerencias.put(sugerencia, sugerencias.get(sugerencia)+1);
        else sugerencias.put(sugerencia, 1);
    }
    
    public Date ultimoMesPago(){
        return this.getCuentaBancaria().getUltimoPago();
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
    
    public void aumentoSalario(long salario){
        this.salario += salario;
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

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public void ofrecerBono() {
        System.out.println("Se le han añadido "+ BONOEMPLEADO + "$ a su cuenta bancaria");
        this.setSalario(this.getSalario()+BONOEMPLEADO);
    } 
    
    @Override
    public String presentacion(){
        String intro = PresentacionBono.recogerDatos(this);
        return "Soy un empleado. "+intro ;
    }
    
}