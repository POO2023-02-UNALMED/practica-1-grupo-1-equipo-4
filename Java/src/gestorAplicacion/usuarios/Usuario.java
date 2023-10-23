package gestorAplicacion.usuarios;

import java.io.Serializable;

import gestorAplicacion.finanzas.CuentaBancaria;

public abstract class Usuario implements Serializable{
    private static final long serialVersionUID = 11L;
    private String nombre;
    private int telefono;
    private static int numUser; 
    private int id;
    private String username;
    private String password;
    private CuentaBancaria cuentaBancaria;
    
    public Usuario(){}

    public Usuario(String nombre,int telefono,String username,String password,CuentaBancaria cuentaBancaria){
        this.nombre = nombre;
        this.telefono = telefono;
        this.username = username;
        this.password = password;
        this.cuentaBancaria = cuentaBancaria;
        Usuario.numUser++;
        this.id = Usuario.numUser;
    }
    

    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public int getTelefono(){
        return this.telefono;
    }

    public void setTelefono(int telefono){
        this.telefono = telefono;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getUsername(){
        return this.username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return this.password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public CuentaBancaria getCuentaBancaria(){
        return this.cuentaBancaria;
    }

    public void setCuentaBancaria(CuentaBancaria cuentaBancaria){
        this.cuentaBancaria = cuentaBancaria;
    }
    
    public abstract String presentacion();
}