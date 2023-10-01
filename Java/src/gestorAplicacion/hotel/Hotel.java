package gestorAplicacion.hotel;
import java.util.ArrayList;

import gestorAplicacion.finanzas.CuentaBancaria;
import gestorAplicacion.usuarios.Huesped;

class Hotel{

    private CuentaBancaria cuentaBancaria;

    private ArrayList<ServiciosExtra> cars = new ArrayList<ServiciosExtra>();

    private ArrayList<Huesped> cars1 = new ArrayList<Huesped>();

    public Hotel(CuentaBancaria cuentaBancaria, ArrayList<ServiciosExtra> cars, ArrayList<Huesped> cars1) {
        this.cuentaBancaria = cuentaBancaria;
        this.cars = cars;
        this.cars1 = cars1;
    }

    public Hotel() {

    }

    public CuentaBancaria getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    public ArrayList<ServiciosExtra> getCars() {
        return cars;
    }

    public void setCars(ArrayList<ServiciosExtra> cars) {
        this.cars = cars;
    }
}