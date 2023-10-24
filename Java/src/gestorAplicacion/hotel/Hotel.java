package gestorAplicacion.hotel;
import java.util.ArrayList;

import gestorAplicacion.finanzas.CuentaBancaria;
import gestorAplicacion.usuarios.Administrador;
import gestorAplicacion.usuarios.Empleado;
import gestorAplicacion.usuarios.Huesped;
import gestorAplicacion.usuarios.Preferencias;
import java.io.Serializable;


public class Hotel implements Serializable{
    private static final long serialVersionUID = 2L;
    //Atributos  definidos en el UML

    private CuentaBancaria cuentaBancaria;

    private ArrayList<ServiciosExtra> servicios = new ArrayList<ServiciosExtra>();
    

    private ArrayList<Huesped> historialClientes = new ArrayList<Huesped>();

    //Atributos no  definidos propios del funcionamiento de las funcionalidades

    private static ArrayList<Hotel>  totalHoteles = new  ArrayList<Hotel>();
    private String nombre;
    private String ciudad;
    private ArrayList<Habitacion> habitaciones = new ArrayList<Habitacion>();
    private ArrayList<Empleado> empleados = new ArrayList<Empleado>();
    private ArrayList<Administrador>  administradores = new  ArrayList<Administrador>();

    public Hotel(CuentaBancaria cuentaBancaria){
        this.cuentaBancaria = cuentaBancaria;
    }

    public Hotel(CuentaBancaria cuentaBancaria, ArrayList<ServiciosExtra> servicios, ArrayList<Huesped> historialClientes) {
        this.cuentaBancaria = cuentaBancaria;
        this.servicios = servicios;
        this.historialClientes = historialClientes;
    }

    public Hotel() {

    }

    public Hotel(CuentaBancaria cb, String nombre, String ciudad, ArrayList<ServiciosExtra> servicios, ArrayList<Habitacion> habitaciones, ArrayList<Empleado> empleados) {
        this.cuentaBancaria = cb;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.servicios = servicios;
        this.habitaciones = habitaciones;
        this.empleados = empleados;
        
        for (Habitacion habitacion : habitaciones){
            habitacion.setHotel(this);
        }
        
        for (Empleado empleado : empleados){
            empleado.setHotel(this);
        }
    }

    public void agregarServicioHotel(ServiciosExtra servicio){
        this.servicios.add(servicio);
    }

    public ArrayList<Hotel>  filtrarHoteles(Preferencias filtro, ArrayList<String> info){
        //Se tendran en cuenta los  siguientes criterios para  filtrar: Nombre, Ciudad.
        //El ArrayList info debe estar compuesto  por 2 elementos, el  primero es el nombre 
        //de la ciudad, si es que este va a ser un parametro de busqueda, y el segundo el  
        //nombre de la  ciudad, si alguno de las opciones  no va a  ser usada
        //se debe llenar con un '0'
        ArrayList<Hotel> respuesta = new  ArrayList<Hotel>();
        for (Hotel i : this.totalHoteles){
            if(filtro.getNombreHotel() != null &&  i.getNombre() == info.get(0)){
              respuesta.add(i);  
            }else if(filtro.getCiudad() != null && i.getCiudad() == info.get(1)){
              respuesta.add(i);  
              
            }
        }
        return respuesta;
    }

    public ArrayList<Habitacion>  filtrarHabitaciones(Preferencias filtro, ArrayList<String> info){
        //Se tendran en cuenta los  siguientes criterios para  filtrar: nombreHotel y tipo
        //El ArrayList info debe estar compuesto  por 2 elementos, el  primero es el nombre 
        //de la hotel, si es que este va a ser un parametro de busqueda, y el segundo el  
        //tipo de la  Habitacion, si alguno de las opciones  no va a  ser usada
        //se debe llenar con un '0'
        ArrayList<Habitacion> respuesta = new  ArrayList<Habitacion>();
        for (Habitacion i : this.habitaciones){
           if(i.isReservada() == false){
            if(filtro.getNombreHotel() != null &&  i.getHotel().getNombre() == info.get(0)){
              respuesta.add(i);  
            }else if(filtro.getTipoHabitacion() != null && i.getTipo() == info.get(1)){
              respuesta.add(i);  
            }
           
          }
        }
        return respuesta;
    }

    public float calcularPromedio(){
        float prom = 0;
        for (Habitacion i: this.habitaciones){
            prom = prom + i.calcularPromedio();
        }
        return prom/this.habitaciones.size();
    }

    public static ArrayList<Hotel> getTotalHoteles() {
        return totalHoteles;
    }

    public static void setTotalHoteles(ArrayList<Hotel> totalHoteles) {
        Hotel.totalHoteles = totalHoteles;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public CuentaBancaria getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    public ArrayList<ServiciosExtra> getServicios() {
        return servicios;
    }

    public void setServicios(ArrayList<ServiciosExtra> servicios) {
        this.servicios = servicios;
    }

    public ArrayList<Huesped> getHistorialClientes() {
        return historialClientes;
    }

    public void addHistorialClientes(Huesped huesped) {
        this.historialClientes.add(huesped);
    }

    public ArrayList<Empleado> getEmpleados(){
        return this.empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados){
        this.empleados = empleados;
    }

    public void agregarEmpleado( Empleado empleado){
        this.empleados.add(empleado);
    }
    
    public ArrayList<Habitacion> getHabitaciones() {
        return habitaciones;
    }
    public void setHabitaciones(ArrayList<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }

    public void agregarHabitacion( Habitacion habitacion){
        this.habitaciones.add(habitacion);
    }

    public ArrayList<Administrador> getAdministradores() {
        return this.administradores;
    }
    
    public void setAdministradores(ArrayList<Administrador> administradores) {
        this.administradores = administradores;
    }

    public void agregarAdministrador( Administrador administrador){
        this.administradores.add(administrador);
    }
    
}
