package baseDatos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import gestorAplicacion.hotel.*;
import gestorAplicacion.usuarios.*;
import gestorAplicacion.finanzas.*;
import gestorAplicacion.Base;
import java.util.ArrayList;

public class Deserializador {
    //Cada uno  debe revisar  su  ruta y estructura correspondiente y luego cambiar
    private static File temp = new File("/home/juan/Documents/practica-1-grupo-1-equipo-4/Java/src/baseDatos/temp/");
    public static void deserializador(){
        File[] docs = temp.listFiles();
        FileInputStream fis;
        ObjectInputStream ois;
        
        for(File f : docs){
            if(f.getAbsolutePath().contains("administradores")){
                try{
                    fis = new FileInputStream(f);
                    ois = new ObjectInputStream(fis);
                    
                    Base.setAdministradores((ArrayList<Administrador>) ois.readObject());
                }
                catch (FileNotFoundException e){
                    e.printStackTrace();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
                catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
            else if(f.getAbsolutePath().contains("hoteles")){
                try{
                    fis = new FileInputStream(f);
                    ois = new ObjectInputStream(fis);
                    
                    Base.setHoteles((ArrayList<Hotel>) ois.readObject());
                }
                catch (FileNotFoundException e){
                    e.printStackTrace();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
                catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
            else if(f.getAbsolutePath().contains("empleados")){
                try{
                    fis = new FileInputStream(f);
                    ois = new ObjectInputStream(fis);
                    
                    Base.setEmpleados((ArrayList<Empleado>) ois.readObject());
                }
                catch (FileNotFoundException e){
                    e.printStackTrace();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
                catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
            else if(f.getAbsolutePath().contains("huespedes")){
                try{
                    fis = new FileInputStream(f);
                    ois = new ObjectInputStream(fis);
                    
                    Base.setHuespedes((ArrayList<Huesped>) ois.readObject());
                }
                catch (FileNotFoundException e){
                    e.printStackTrace();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
                catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
