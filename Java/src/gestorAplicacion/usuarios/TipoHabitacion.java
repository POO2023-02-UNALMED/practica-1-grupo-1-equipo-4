package gestorAplicacion.usuarios;

public enum TipoHabitacion {        //Caso de Enumeración
    FAMILIAR(4,500000), DOBLE(2,300000), SIMPLE(1,100000), VIPFAMILIAR(4,1000000), VIPDOBLE(2,700000), VIPSIMPLE(1,300000);
    
    private int camas;
    private long precio;
    
    TipoHabitacion(int camas, int precio){
        this.camas = camas;
        this.precio = precio;
    }
    
    public int asignCamas(){
        return camas;
    }
    
    public String obtenerNombre() {
        return this.name();
    }
    
    public long asignPrecio(){
        return precio;
    }
}
