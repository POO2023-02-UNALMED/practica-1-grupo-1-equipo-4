package gestorAplicacion.usuarios;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

import gestorAplicacion.Base;
import gestorAplicacion.hotel.Hotel;

public class Preferencias implements Serializable{
    private static final long serialVersionUID = 10L;
    private static ArrayList<String> ciudades = new ArrayList<>();
    private String ciudad;
    private String nombreHotel;
    private String tipoHabitacion;
    
    static{
        ArrayList<Hotel> hotelesBase = Base.getHoteles();
        Preferencias.ciudades = new ArrayList<>();
        for(Hotel hotel: hotelesBase){
            if(Preferencias.ciudades.indexOf(hotel.getCiudad())==-1){
               Preferencias.ciudades.add(hotel.getCiudad());
            }
        }
    }
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

    public static ArrayList<String> getCiudades() {
        return ciudades;
    }

}
