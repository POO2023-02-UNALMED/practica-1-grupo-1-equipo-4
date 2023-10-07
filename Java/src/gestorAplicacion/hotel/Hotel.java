package gestorAplicacion.hotel;
import java.util.ArrayList;

import gestorAplicacion.finanzas.CuentaBancaria;
import gestorAplicacion.usuarios.Empleado;
import gestorAplicacion.usuarios.Huesped;
import gestorAplicacion.usuarios.Preferencias;


public class Hotel{

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
            if(filtro.getNombreHotel() &&  i.getNombre() == info.get(0)){
              respuesta.add(i);  
            }else if(filtro.getCiudad() && i.getCiudad() == info.get(1)){
              respuesta.add(i);  
            }
        }
        return respuesta;
    }

    public ArrayList<Habitacion>  filtrarHabitaciones(String filtro, String info){
        //Se tendran en cuenta los  siguientes criterios para  filtrar: Tipo, Numero de camas, precio Proximamente calificaciones.
        ArrayList<Habitacion> respuesta = new  ArrayList<Habitacion>();
        for (Habitacion i : this.habitaciones){
           if(i.getReservada() == false){
                if(String.valueOf(i.getNumeroCamas()) == filtro){
                    respuesta.add(i);
                }
                if(i.getTipo() == filtro){
                    respuesta.add(i);
                }
                if(String.valueOf(i.getPrecio()) == filtro){
                    respuesta.add(i);
                }
                if(i.getPrecio() == Integer.parseInt(filtro)){
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

    public void setHistorialClientes(ArrayList<Huesped> historialClientes) {
        this.historialClientes = historialClientes;
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
    
}
