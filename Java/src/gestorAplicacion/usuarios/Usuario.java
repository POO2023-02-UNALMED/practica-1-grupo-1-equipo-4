package gestorAplicacion.usuarios;

import java.io.Serializable;

import gestorAplicacion.finanzas.CuentaBancaria;

/*
    Author David Restrepo Aguilar
*/

//Esta clase se encarga de almacenar los atriburos básicos de un huesped, empleado o administrador
public abstract class Usuario implements Serializable{      //Clase abstracta. Clase padre de Administrador, Huesped, Empleado (Herencia)
    private static final long serialVersionUID = 11L;
    private String nombre;
    private int telefono;
    private static int numUser;             //Atributo de clase
    private int id;                         //Encapsulamiento private
    protected String username;              //Encapsulamiento protected
    protected String password;              //Encapsulamiento protected
    private CuentaBancaria cuentaBancaria;
    
    public Usuario(){}

    public Usuario(String nombre,int telefono,String username,String password,CuentaBancaria cuentaBancaria){
        this.nombre = nombre;
        this.telefono = telefono;                   //Uso de this para desambiguar
        this.username = username;
        this.password = password;
        this.cuentaBancaria = cuentaBancaria;
        Usuario.numUser++;
        this.id = Usuario.numUser;
    }
    
    public Usuario(String nombre){
        this.nombre = nombre;
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

    public static int getNumUser() {                //Método de clase
        return numUser;
    }

    public static void setNumUser(int numUser) {        //Método de clase       //Desambiguación por nombre de clase
        Usuario.numUser = numUser;
    }
    
    public abstract String entrando();          //Método abstracto
    
    public abstract String presentacion();      //Método abstracto    //Encapsulamiento public
    
}