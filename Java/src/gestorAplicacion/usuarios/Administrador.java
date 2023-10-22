package gestorAplicacion.usuarios;

import java.util.ArrayList;
import java.util.Date;

//import gestorAplicacion.usuarios.Usuario;
import gestorAplicacion.finanzas.CuentaBancaria;
import gestorAplicacion.hotel.Hotel;
import java.io.Serializable; 

public class Administrador extends Usuario implements Serializable{
    private static final long serialVersionUID = 3L;
    
    private static int totalAdministradores = 0;
    private Hotel hotel;

    public Administrador(String nombre,int telefono,String username,String password, CuentaBancaria cuentaBancaria, Hotel hotel){
        super(nombre, telefono, Administrador.totalAdministradores + 1, username, password, cuentaBancaria);

        this.hotel = hotel;
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

    public Date ultimoMesPago(){
        return this.getCuentaBancaria().getUltimoPago();
    }

    public long dineroCuentaHotel(){
        return this.hotel.getCuentaBancaria().getSaldo();
    }

    public boolean puedePagarHotel(ArrayList<Empleado> empleados){

        long salgoAPagar = 0;
        
        for (Empleado empleado : empleados) {
            salgoAPagar += empleado.getSalario();
        }

        return CuentaBancaria.puedePagarHotel(hotel, salgoAPagar);
    }

    public String pagarEmpleados(){
        ArrayList<Empleado> empleados = this.hotel.getEmpleados();

        if(puedePagarHotel(empleados)){

            for (Empleado empleado: empleados){
                CuentaBancaria.transferencia(hotel.getCuentaBancaria(), empleado.getCuentaBancaria(), empleado.getSalario());
            }
            return "El pago a los empleados ha sido exitoso";

        }else{
            return "Saldo en cuenta de hotel insuficiente para hacer el pago";
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
}
