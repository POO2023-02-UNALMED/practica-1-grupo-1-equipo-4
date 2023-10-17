package gestorAplicacion.usuarios;

public class Preferencias {
    private String ciudad;
    private String nombreHotel;
    private String tipoHabitacion;
    
    public Preferencias(String ciudad, String nombreHotel, String tipoHabitacion) {
        this.ciudad = ciudad;
        this.nombreHotel = nombreHotel;
        this.tipoHabitacion = tipoHabitacion;
    }

    public Preferencias() {
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getNombreHotel() {
        return nombreHotel;
    }

    public void setNombreHotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }
    
}
