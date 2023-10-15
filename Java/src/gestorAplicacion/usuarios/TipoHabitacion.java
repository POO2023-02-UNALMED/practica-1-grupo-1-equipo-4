package gestorAplicacion.usuarios;

public enum TipoHabitacion {
    VIP(4,500000), DOBLE(2,300000), SIMPLE(1,100000);
    
    private int camas;
    private int precio;
    
    TipoHabitacion(int camas, int precio){
        this.camas = camas;
        this.precio = precio;
    }
    
    public int asignCamas(){
        return camas;
    }
    
    public int asignPrecio(){
        return precio;
    }
}
