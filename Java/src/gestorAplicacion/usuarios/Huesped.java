package gestorAplicacion.usuarios;
import java.util.ArrayList;

public class Huesped{
    private boolean vip;
    private Reserva reserva;
    private Habitacion habitacion;
    private ArrayList<Preferencias> preferencias;
    private ArrayList<Reserva> historialReservas;

    public Huesped(boolean vip,Habitacion habitacion){
        this.vip = vip;
        this.habitacion = habitacion;
        this.preferencias = new ArrayList<>();
        this.historialReservas = new ArrayList<>();
    }

    public boolean isVip(){
        return this.vip;
    }

    public Reserva getReserva(){
        return this.reserva;
    }

    public void setReserva(Reserva reserva){
        this.reserva = reserva;
    }

    public Habitacion getHabitacion(){
        return this.habitacion;
    }

    public void setHabitacion(Habitacion habitacion){
        this.habitacion = habitacion;
    }

    public ArrayList<Preferencias>getPreferencias(){
        return preferencias;
    }

    public void setPreferencias(ArrayList<Preferencias>preferencias){
        this.preferencias = preferencias;
    }

    public ArrayList<Reserva>getHistorialReservas(){
        return historialReservas;
    }
//Falta llenar
    public Reserva generarReserva(){
        return new Reserva();
    }

    public void calcularServicios(){
    }
//Mientras
    public boolean consultarVip(){
        if(vip == true){
            return vip;
        } 
    }

    public int consultarDiasDeEstadia(){
    }

    public void cambiarPreferencias(ArrayList<Preferencias>nuevasPreferencias){
        this.preferencias = nuevasPreferencias;
    }
}
