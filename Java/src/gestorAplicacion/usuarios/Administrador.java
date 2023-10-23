package gestorAplicacion.usuarios;

import java.util.ArrayList;
import java.util.Date;

//import gestorAplicacion.usuarios.Usuario;
import gestorAplicacion.finanzas.CuentaBancaria;
import gestorAplicacion.hotel.Habitacion;
import gestorAplicacion.hotel.Hotel;
import java.io.Serializable; 

public class Administrador extends Usuario implements Serializable{
    private static final long serialVersionUID = 3L;
    
    private static int totalAdministradores = 0;
    private long salario;
    private Date ultimoPago;
    private Hotel hotel;

    public Administrador(String nombre,int telefono,String username,String password, CuentaBancaria cuentaBancaria, Hotel hotel){
        super(nombre, telefono, Administrador.totalAdministradores + 1, username, password, cuentaBancaria);

        this.hotel = hotel;
        hotel.agregarAdministrador(this);
        Administrador.totalAdministradores += 1;
    }

    public Administrador crearAdministrador(String nombre,int telefono,String username,String password, CuentaBancaria cuentaBancaria, Hotel hotel){
        Administrador administrador = new Administrador(nombre, telefono, username, password, cuentaBancaria, hotel);

        return administrador;
    }

    public void premiarUsuario(){}

    public void hacerDescuento(){}

    public void cobrarZonas(){}

    public void agregarServicio(){}

    public void alterarServicio(){
        
    }

    public void calcularPromedio(){}

    public String administradorAgregaHabitacion(TipoHabitacion tipoEscogido){

        long id = ((this.getHotel()).getHabitaciones()).size() + 1;
        Habitacion nuevHabitacion = new Habitacion(id , tipoEscogido.obtenerNombre(), tipoEscogido.asignCamas(), tipoEscogido.asignPrecio(), this.getHotel());
        return "Habitación agregada al hotel correctamente"; 
        
    }

    public String listarAdministradores(){
        String administradores = "";
        int contador = 1;

        for (Administrador administrador: this.hotel.getAdministradores()){
            administradores += "    " + contador + ". " + administrador.getNombre() + "\n";
            contador++;
        }

        return administradores;
    }

    public Date ultimoMesPago(){
        return this.getCuentaBancaria().getUltimoPago();
    }

    public long dineroCuentaHotel(){
        return this.hotel.getCuentaBancaria().getSaldo();
    }

    public boolean puedePagarHotel(ArrayList<Empleado> empleados){

        long saldoAPagar = 0;
        
        for (Empleado empleado : empleados) {
            saldoAPagar += empleado.getSalario();
        }

        saldoAPagar += this.salario;

        return CuentaBancaria.puedePagarHotel(hotel, saldoAPagar);
    }

    public String pagarEmpleados(){
        ArrayList<Empleado> empleados = this.hotel.getEmpleados();

        Date ultimoPago = getUltimoPago();
        Date actual = new Date();

        long diferenciaEnMillis = actual.getTime() - ultimoPago.getTime();

        int diferenciaEnDias = (int) (diferenciaEnMillis / (1000 * 60 * 60 * 24));

        if(diferenciaEnDias < 30){
            return ("Ya se realizó un pago dentro de los últimos 30 días, espera que se cumpla el tiempo para volver a realizarlo");
        }else{

            if(puedePagarHotel(empleados)){

                for (Empleado empleado: empleados){
                    CuentaBancaria.transferencia(hotel.getCuentaBancaria(), empleado.getCuentaBancaria(), empleado.getSalario());
                }

                CuentaBancaria.transferencia(hotel.getCuentaBancaria(), this.getCuentaBancaria(), this.getSalario());
                return "El pago a los empleados ha sido exitoso";

            }else{
                return "Saldo en cuenta de hotel insuficiente para hacer el pago";
            }

        }

        
    }

    public static int getTotalAdministradores(){
        return Administrador.totalAdministradores;
    }

    public Hotel getHotel(){
        return this.hotel;
    }

    public void setHotel(Hotel hotel){
        this.hotel = hotel;
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

    public Date getUltimoPago(){
        return this.ultimoPago;
    }

    public void setUltimoPago(Date ultimoPago){
        this.ultimoPago = ultimoPago;
    }
}
