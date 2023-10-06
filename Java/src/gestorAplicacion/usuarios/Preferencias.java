package gestorAplicacion.usuarios;

public class Preferencias {
    private Boolean ciudad;
    private Boolean nombreHotel;
    private Boolean tipoHabitacion;
    
    public Preferencias(Boolean ciudad, Boolean nombreHotel, Boolean tipoHabitacion) {
        this.ciudad = ciudad;
        this.nombreHotel = nombreHotel;
        this.tipoHabitacion = tipoHabitacion;
    }

    public Preferencias() {
    }

    public Boolean getCiudad() {
        return ciudad;
    }

    public void setCiudad(Boolean ciudad) {
        this.ciudad = ciudad;
    }

    public Boolean getNombreHotel() {
        return nombreHotel;
    }

    public void setNombreHotel(Boolean nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

    public Boolean getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(Boolean tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }
    
}
