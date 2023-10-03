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
    private static File temp = new File("baseDatos\\temp");
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
                    
                    Base.setHoteles((ArrayList<Estudiante>) ois.readObject());
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