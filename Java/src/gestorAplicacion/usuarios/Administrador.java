package gestorAplicacion.usuarios;

import gestorAplicacion.usuarios.Usuario;
import gestorAplicacion.finanzas.CuentaBancaria;

public class Administrador extends Usuario{
    
    private static int totalAdministradores = 0;

    public Administrador(String nombre,int telefono,String username,String password,CuentaBancaria cuentaBancaria){
        super(nombre, telefono, Administrador.totalAdministradores + 1, username, password, cuentaBancaria);

        Administrador.totalAdministradores += 1;
    }

    public void crearAdministrador(){}

    public void premiarUsuario(){}

    public void hacerDescuento(){}

    public void cobrarZonas(){}

    public void agregarServicio(){}

    public void alterarServicio(){}

    public void calcularPromedio(){}

    public void ultimoMesPago(){}

    public void dineroCuentaHotel(){}

    public void pagarEmpleado(){}
}
