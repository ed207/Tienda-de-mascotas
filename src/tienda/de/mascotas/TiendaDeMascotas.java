package tienda.de.mascotas;

import java.util.Scanner;

public class TiendaDeMascotas {

    public static void main(String[] args) {
        mascota datos[] = new mascota[15];
        int op = 0;
        Scanner teclado = new Scanner(System.in);
        Scanner letras = new Scanner(System.in);
        while(op != 5) {
            System.out.println("Menu");
            System.out.println("1.Guardar");
            System.out.println("2.Buscar mascota");
            System.out.println("3.Ver todos");
            System.out.println("4.Modificar mascota");
            System.out.println("5.Salir");
            op=teclado.nextInt();
            System.out.println("---------------------------");
            if (op == 1) {
                System.out.println("Ingrese ID");
                int ID = teclado.nextInt();
                System.out.println("Ingrese el nombre su mascota");
                String nombre = letras.nextLine();
                System.out.println("Ingrese la raza de su mascota");
                String raza = letras.nextLine();
                System.out.println(nuevamascota(ID, nombre, raza, datos));
            } else if (op == 3) {
                System.out.println(imprimirdatos(datos));
                
            }
            if (op==2) {
                System.out.println("Ingrese el ID de su mascota "); 
                int ID=teclado.nextInt();
                System.out.println(buscarMascota(ID,datos));
            }
            if (op==4) {
                System.out.println("Ingrese ID ");
                int ID=teclado.nextInt();
                if (buscarMascotaBoolean(ID,datos)) {
                    System.out.println("Ingrese el nuevo nombre de su mascota");
                    String nombre=letras.nextLine();
                    System.out.println("Ingrese la raza de su mascota");
                    String raza=letras.nextLine();
                    System.out.println(modificarMascota(ID,nombre,raza,datos));
                }else{
                    System.out.println("La clave no eciste ");
                }
                
            }
        }

    }

    public static String nuevamascota(int ID, String nombre, String raza, mascota arreglo[]) {
        boolean lleno = true;
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == null) {
                arreglo[i] = new mascota(ID, nombre, raza);
                lleno = false;
                break;
            } else if (arreglo[i].getID() == ID) {
                return "ID ya existente";
            }

        }
        if (!lleno) {
            return "Se guardo con exito";
        } else {
            return "Ya no hay espacio";

        }
    }

    public static String imprimirdatos(mascota arreglo[]) {
        String cadena = "";
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null) {
                cadena = cadena +"Su ID es"+ arreglo[i].getID() + "| El nombre de su mascota es " + arreglo[i].getNombre() + "| La raza de su mascota es " + arreglo[i].getRaza() + "\n";

            }

        }
        return cadena;
    }
    public static String buscarMascota(int ID,mascota arreglo[]){
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i]!=null && arreglo[i].getID()==ID) {
              return "Los datos \n nombre: "+arreglo[i].getNombre()+" raza "+arreglo[i].getRaza();
            }
        }
        return "El ID ingresado no existe";
    }
    public static boolean buscarMascotaBoolean(int ID,mascota arreglo[]){
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i]!=null && arreglo[i].getID()==ID) {
                return true;
            }
            
        }
        return false;
    }
    public static String modificarMascota(int ID, String nombre, String raza, mascota arreglo[]){
        for (int i = 0; i < arreglo.length ; i++) {
            if (arreglo[i]!=null && arreglo[i].getID()==ID) {
             arreglo[i].setNombre(nombre);
             arreglo[i].setRaza(raza);
             return "Se modifico con exito";
            }
        }
        return "";
    }
    
}
