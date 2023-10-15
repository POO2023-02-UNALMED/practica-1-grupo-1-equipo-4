package gestorAplicacion.finanzas;

import java.io.Serializable;
import java.util.ArrayList;

import gestorAplicacion.usuarios.Empleado;
import gestorAplicacion.usuarios.Usuario;
import gestorAplicacion.hotel.Hotel;
public class CuentaBancaria{

    private long numero;
    private String banco;
    private long saldo = 0;

    public CuentaBancaria(){}

    public CuentaBancaria(long numero, String banco){

        this.numero = numero;
        this.banco = banco;

    }

    public void transferencia(CuentaBancaria cuenta, long valor){
        this.retirar(valor);
        cuenta.depositar(valor);
    }

    public static void transferencia(CuentaBancaria cuenta1, CuentaBancaria cuenta2, long valor){
        cuenta1.retirar(valor);
        cuenta2.depositar(valor);
    }

    public void depositar(long dinero){
        this.saldo += dinero;
    }

    public void retirar(long dinero){
        this.saldo -= dinero;
    }

    public static boolean puedePagarHotel(Hotel hotel, long pago){
        if(hotel.getCuentaBancaria().getSaldo() >= pago){
            return true;
        }
        return false;
    }

    public long getNumero(){
        return this.numero;
    }

    public String getBanco(){
        return this.banco;
    }

    public void getBanco(String banco){
        this.banco = banco;
    }

    public long getSaldo(){
        return this.saldo;
    }

    public void setSaldo(int saldo){
        this.saldo = saldo;
    }
    
}
