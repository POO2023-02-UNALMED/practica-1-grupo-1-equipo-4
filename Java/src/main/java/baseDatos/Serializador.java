package baseDatos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import gestorAplicacion.Base;

/*
    Author David Restrepo Aguilar
*/
public class Serializador {
    //Cada uno  debe revisar  su  ruta y estructura correspondiente y luego cambiar
    private static File temp = new File("src\\main\\java\\baseDatos\\temp");
    
    public static void serializador(){
        FileOutputStream fos;
        ObjectOutputStream oos;
        File[] docs = temp.listFiles();
        PrintWriter pw;
        
        for(File f : docs){
            
            try{
                pw = new PrintWriter(f);
            }
            catch (FileNotFoundException e){
                e.printStackTrace();
            }      
        }
        for(File f : docs){
            
            if(f.getAbsolutePath().contains("administradores")){
                try{
                    fos = new FileOutputStream(f);
                    oos = new ObjectOutputStream(fos);
                    oos.writeObject(Base.getAdministradores());
                }
                catch (FileNotFoundException e){
                    e.printStackTrace();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
            else if(f.getAbsolutePath().contains("hoteles")){
                try{
                    fos = new FileOutputStream(f);
                    oos = new ObjectOutputStream(fos);
                    oos.writeObject(Base.getHoteles());
                }
                catch (FileNotFoundException e){
                    e.printStackTrace();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
            else if(f.getAbsolutePath().contains("empleados")){
                try{
                    fos = new FileOutputStream(f);
                    oos = new ObjectOutputStream(fos);
                    oos.writeObject(Base.getEmpleados());
                }
                catch (FileNotFoundException e){
                    e.printStackTrace();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
            else if(f.getAbsolutePath().contains("huespedes")){
                try{
                    fos = new FileOutputStream(f);
                    oos = new ObjectOutputStream(fos);
                    oos.writeObject(Base.getHuespedes());
                }
                catch (FileNotFoundException e){
                    e.printStackTrace();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
