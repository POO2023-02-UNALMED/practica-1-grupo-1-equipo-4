package baseDatos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import gestorAplicacion.Base;

public class Serializador {
    private static File temp = new File("baseDatos\\temp");
    
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
            
        }
    }
}