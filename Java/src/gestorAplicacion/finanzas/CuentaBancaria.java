package gestorAplicacion.finanzas;

import gestorAplicacion.usuarios.Usuario;
public class CuentaBancaria {

    private long numero;
    private String banco;
    private long saldo = 0;

    public CuentaBancaria(){}

    public CuentaBancaria(long numero, String banco){

        this.numero = numero;
        this.banco = banco;

    }

    public void transferencia(CuentaBancaria cuenta){}

    public void depositar(long dinero){}

    public void retirar(long dinero){}
    
}
