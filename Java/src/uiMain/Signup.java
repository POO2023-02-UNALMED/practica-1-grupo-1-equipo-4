/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uiMain;
import java.util.Scanner;
import gestorAplicacion.finanzas.*;
import gestorAplicacion.hotel.*;
import gestorAplicacion.usuarios.*;

/**
 *
 * @author david
 */
public class Signup {
    static void register(String us){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nRegistro");
        System.out.println("-----------\n");
        String nombre = null;
        int telefono = 0;
        int id = 0;
        String username = null;
        String password = null;
        int numCB = 0;
        String banco = null;
        int saldo = 0;
        Usuario titular = null;
        CuentaBancaria cuenta = null;
        
        if(us.equals("adminsitrador")){
            System.out.print("Ingrese su nombre completo: ");
            nombre = sc.nextLine();
            System.out.print("\nIngrese su número de teléfono: ");
            telefono = sc.nextInt();
            System.out.print("\nIngrese su número de identificación: ");
            id = sc.nextInt();
            System.out.print("\nIngrese un nombre de usuario: ");
            username = sc.nextLine();
            System.out.print("\nIngrese una contraseña: ");
            password = sc.nextLine();
            System.out.println("\nInformación de su cuenta bancaria:");
            System.out.println("------------------------------------\n");
            System.out.print("Ingrese el numero de su cuenta bancaria: ");
            numCB = sc.nextInt();
            System.out.print("\nIngrese el banco al que pertenece: ");
            banco = sc.nextLine();
            System.out.print("\nIngrese el saldo actual de su cuenta: ");
            saldo = sc.nextInt();
            //Administrador admin = new Administrador(nombre, telefono, username, password, cuentaBancaria(numCB, banco, saldo, this), banco? );
            
        }else if(us.equals("empleado")){
            System.out.print("Ingrese su nombre completo: ");
            nombre = sc.nextLine();
            System.out.print("\nIngrese su número de teléfono: ");
            telefono = sc.nextInt();
            System.out.print("\nIngrese su número de identificación: ");
            id = sc.nextInt();
            System.out.print("\nIngrese un nombre de usuario: ");
            username = sc.nextLine();
            System.out.print("\nIngrese una contraseña: ");
            password = sc.nextLine();
            System.out.println("\nInformación de su cuenta bancaria:");
            System.out.println("------------------------------------\n");
            System.out.print("Ingrese el numero de su cuenta bancaria: ");
            numCB = sc.nextInt();
            System.out.print("\nIngrese el banco al que pertenece: ");
            banco = sc.nextLine();
            System.out.print("\nIngrese el saldo actual de su cuenta: ");
            saldo = sc.nextInt();
            //Administrador admin = new Administrador(nombre, telefono, id, username, password, cuentaBancaria(numCB, banco, saldo, this));
        }else if(us.equals("huesped")){
            System.out.print("Ingrese su nombre completo: ");
            nombre = sc.nextLine();
            System.out.print("\nIngrese su número de teléfono: ");
            telefono = sc.nextInt();
            System.out.print("\nIngrese su número de identificación: ");
            id = sc.nextInt();
            System.out.print("\nIngrese un nombre de usuario: ");
            username = sc.nextLine();
            System.out.print("\nIngrese una contraseña: ");
            password = sc.nextLine();
            System.out.println("\nInformación de su cuenta bancaria:");
            System.out.println("------------------------------------\n");
            System.out.print("Ingrese el numero de su cuenta bancaria: ");
            numCB = sc.nextInt();
            System.out.print("\nIngrese el banco al que pertenece: ");
            banco = sc.nextLine();
            System.out.print("\nIngrese el saldo actual de su cuenta: ");
            saldo = sc.nextInt();
            //Administrador admin = new Administrador(nombre, telefono, id, username, password, cuentaBancaria(numCB, banco, saldo, this));
        }
    }
}
