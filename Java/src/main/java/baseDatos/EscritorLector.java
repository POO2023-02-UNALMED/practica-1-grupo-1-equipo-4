package baseDatos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;


import gestorAplicacion.usuarios.Administrador;
//import gestorAplicacion.usuarios.Usuario;
import gestorAplicacion.finanzas.CuentaBancaria;
public class EscritorLector {

    static File archivo = new File("");

    public EscritorLector(){

        CuentaBancaria cuenta = new CuentaBancaria(123456789, "Bancolombia");
        Administrador admin1 = new Administrador(null, 0, null, null, cuenta, null);
        

        try {
            FileOutputStream fadm = new FileOutputStream(new File(archivo.getAbsolutePath()+"\\temp\\Administradores.txt"));
            ObjectOutputStream oadm = new ObjectOutputStream(fadm);

            FileOutputStream fcuen = new FileOutputStream(new File(archivo.getAbsolutePath()+"\\temp\\Cuentas.txt"));
            ObjectOutputStream ocuen = new ObjectOutputStream(fcuen);

            ocuen.writeObject(cuenta);
            oadm.writeObject(admin1);

            oadm.close();
            fadm.close();
            ocuen.close();
            fcuen.close();

            FileInputStream fiadm = new FileInputStream(new File(archivo.getAbsolutePath()+"\\temp\\Administradores.txt"));
            ObjectInputStream oiadm = new ObjectInputStream(fiadm);

            FileInputStream ficuen = new FileInputStream(new File(archivo.getAbsolutePath()+"\\temp\\Administradores.txt"));
            ObjectInputStream oicuen = new ObjectInputStream(fiadm);
                // Leer objectos
            CuentaBancaria cuentaR = (CuentaBancaria) oicuen.readObject();
            Administrador administrador1r = (Administrador) oiadm.readObject();
            System.out.println(cuentaR.toString());
            System.out.println(administrador1r.toString());
            // Cerrar conexiones abiertas
            oiadm.close();
            fiadm.close();

            oicuen.close();
            ficuen.close();

        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra archivo");
            }
        catch (IOException e) {
            System.out.println("Error flujo de inicialización");
            }
        catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            }
        
        
    }
    
}
